package com.jason.qccore.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.jason.qccore.service.UserService;
import com.jason.qccore.utils.DateUtil;
import com.jason.qccore.utils.RandomUtil;
import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.po.UserAccount;
import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserInvite;
import com.jason.qcdao.domain.po.UserPacket;
import com.jason.qcdao.domain.po.UserPacket2;
import com.jason.qcdao.domain.po.UserTmp;
import com.jason.qcdao.domain.vo.DetailItem;
import com.jason.qcdao.domain.vo.EarnDataItem;
import com.jason.qcdao.domain.vo.MyEarn;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.RankingItem;
import com.jason.qcdao.domain.vo.ShareInvite;
/**
* @ClassName: UserServiceImpl
* @Description: TODO(用户业务逻辑接口实现类)
* @author jason.peng
* @date 2016年1月6日 上午11:07:48
 */
@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService{

	@Override
	public boolean isExistUser(Integer id) {
		if(userMapper.isExistUserById(id) == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isExistUser(String account) {
		if(userMapper.isExistUserByAccount(account) == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public User getUserByOpenId(String openId) {
		return userMapper.getUserByOpenId(openId);
	}
	

	@Override
	public User getUserByAccount(String account) {
		return userMapper.getUserByAccount(account);
	}
	
	@Override
	public User getUserByHashId(String hashId) {
		User user = (User) userCache.opsForValue().get(hashId);
		if(user == null) {
			user = userMapper.getUserByHashId(hashId);
			if(user != null) {
				userCache.opsForValue().set(hashId, user, 1, TimeUnit.DAYS);
			}
		}
		return user;
	}
	
	@Override
	public void saveUser(User user) {
		// 新建策略（比例给积分）
		user.setRate(6.0f);
		JmsTemplate.convertAndSend(userDestination, user);
	}

	@Override
	public void asyncUpdateUser(final User user) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// 1.更新缓存中的用户信息
				User oldUser = (User) userCache.opsForValue().get(user.getHashId());
				if(oldUser != null) {
					oldUser.setHeadimg(user.getHeadimg());
					oldUser.setNickname(user.getNickname());
					oldUser.setSex(user.getSex());
					userCache.opsForValue().set(user.getHashId(), oldUser, 1, TimeUnit.DAYS);
				}
				
				// 2.更新数据库中的用户信息
				userMapper.updateUser(user);
			}
		});
	}

	@Override
	public Integer doPacket(final String hashId) {
		Integer point = null;
		// 获取用户红包的次数
		Integer packetCount = userAccountMapper.getPacketCount(hashId);
		if(packetCount == 0) {
			point = (RandomUtil.getRandom().nextInt(5) + 1) * 100;
		}  else {
			// 概率计算
			Integer factor = RandomUtil.getRandom().nextInt(10000);
			if(factor < 9900) {
				point = (RandomUtil.getRandom().nextInt(10) + 1 );
			} else if(factor < 9990){
				point = (RandomUtil.getRandom().nextInt(50) + 1 );
			} else {
				point = (RandomUtil.getRandom().nextInt(100) + 1 );
			}
		}
		// 异步去执行红包的其他操作
		final UserPacket userPacket = new UserPacket();
		userPacket.setHashId(hashId);
		userPacket.setPoint(point);
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				otherCache.opsForSet().add("packet", new String[]{hashId });
				
				Date current = new Date();
				userPacket.setCreateTime(current);
				// 保存红包记录
				userPacketMapper.saveUserPacket(userPacket);
				// 更新用户账号红包信息
				userAccountMapper.updatePointForPacket(userPacket.getHashId(), userPacket.getPoint());
				// 保存详情信息
				UserDetail userDetail = new UserDetail();
				userDetail.setHashId(userPacket.getHashId());
				userDetail.setType(UserDetail.PACKET_TYPE);
				userDetail.setIcon(UserDetail.PACKET_ICON);
				userDetail.setTitle("每日红包");
				userDetail.setPoint(userPacket.getPoint());
				userDetail.setCreateTime(current);
				userDetailMapper.saveUserDetail(userDetail);
				// 更新今日收益
				userTmpMapper.updateUserTmpForPacket(userPacket.getHashId(),  userPacket.getPoint());
			}
		});
		return point;
	}

	@Override
	public void asyncUpdateInfo(final User user) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				User oldUser = (User) userCache.opsForValue().get(user.getHashId());
				if(oldUser != null) {
					if(StringUtils.isNotBlank(user.getHeadimg())) {
						oldUser.setHeadimg(user.getHeadimg());
					}
					if(StringUtils.isNotBlank(user.getNickname())) {
						oldUser.setNickname(user.getNickname());
					}
					if(user.getInviteId() != null) {
						oldUser.setInviteId(user.getInviteId());
					}
					if(user.getSex() != null) {
						oldUser.setSex(user.getSex());
					}
					userCache.opsForValue().set(user.getHashId(), oldUser, 1, TimeUnit.DAYS);
				}
				userMapper.updateInfo(user);
			}
		});
	}

	@Override
	public Page<DetailItem> getDetailPage(String hashId, Integer index,
			Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		List<DetailItem> items = userDetailMapper.getDetails(hashId, start, len);
		return new Page<DetailItem>(size, items);
	}

	@Override
	public Integer getMayPoint(String hashId) {
		return userAccountMapper.getMayPoint(hashId);
	}

	@Override
	public Page<RankingItem> getRankingPage(Integer index, Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		List<RankingItem> items = userAccountMapper.getRankings(start, len);
		
		for (int i=0;i<items.size();i++) {
			RankingItem item = items.get(i);
			item.setIndex(i + 1);
			if(StringUtils.isEmpty(item.getHeadimg())) {
				item.setHeadimg(User.HEADIMG_DEFAULT);
			}
			if(StringUtils.isEmpty(item.getNickname())) {
				item.setNickname("");
			}
		}
		return new Page<RankingItem>(size, items);
	}

	@Override
	public void updatePassword(String account, String password, String salt) {
		userMapper.updatePassword(account, password, salt);
	}

	@Override
	public MyEarn getMyEarn(String hashId) {
		return userTmpMapper.getMyEarn(hashId);
	}

	@Override
	public List<EarnDataItem> getEarnDatas(String hashId) {
		List<EarnDataItem> earnDataItems = null;
		UserTmp userTmp = userTmpMapper.getUserTmp(hashId);
		
		Date current = new Date();
		if(userTmp != null) {
			earnDataItems = new ArrayList<EarnDataItem>();
			for(int i=0;i<7;i++) {
				EarnDataItem earnDataItem = new EarnDataItem();
				earnDataItem.setDate(DateUtil.minusDate(current, i));
				switch (i) {
				case 0:
					earnDataItem.setPoint(userTmp.getOnePoint());
					break;
				case 1:
					earnDataItem.setPoint(userTmp.getTwoPoint());
					break;
				case 2:
					earnDataItem.setPoint(userTmp.getThreePoint());
					break;
				case 3:
					earnDataItem.setPoint(userTmp.getFourPoint());
					break;
				case 4:
					earnDataItem.setPoint(userTmp.getFivePoint());
					break;
				case 5:
					earnDataItem.setPoint(userTmp.getSixPoint());
					break;
				case 6:
					earnDataItem.setPoint(userTmp.getSeverPoint());
					break;
				}
				earnDataItems.add(earnDataItem);
			}
		}
		return earnDataItems;
	}

	@Override
	public ShareInvite getShareInvite(String hashId) {
		ShareInvite shareInvite = userAccountMapper.getShareInvite(hashId);
		shareInvite.setInviteId(getUserByHashId(hashId).getId());
		shareInvite.setInvitePointF((float)shareInvite.getInvitePoint() / (float)UserAccount.RATE);;
		return shareInvite;
	}

	@Override
	public String getHashIdById(Integer id) {
		return userMapper.getHashId(id);
	}

	@Override
	public void doInvite(final String byHashId, final String hashId) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				
				Date current = new Date();
				// 获取邀请人账号信息，如果邀请大于20就不给
				try {
					Integer inviteCount = userAccountMapper.getInviteCount(byHashId);
					if(inviteCount > 20) {
						UserInvite userInvite = new UserInvite();
						userInvite.setByHashId(byHashId);
						userInvite.setHashId(hashId);
						userInvite.setCreateTime(current);
						userInvite.setPoint(0);
						userInviteMapper.saveUserInvite(userInvite);
						logger.info("邀请不给分---->" + byHashId);
						return ;
					}
				} catch (Exception e) {
					
				}
				
				Integer point = 1 * UserAccount.RATE;
				
				
				UserInvite userInvite = new UserInvite();
				userInvite.setByHashId(byHashId);
				userInvite.setHashId(hashId);
				userInvite.setCreateTime(current);
				userInvite.setPoint(point);
				userInviteMapper.saveUserInvite(userInvite);
				
				// 更新用户账号的邀请次数
				userAccountMapper.updatePointForInvite(byHashId, point);
				// 保存一个邀请明细
				UserDetail userDetail = new UserDetail();
				userDetail.setHashId(byHashId);
				userDetail.setType(UserDetail.INVITE_TYPE);
				userDetail.setIcon(UserDetail.INVITE_ICON);
				userDetail.setTitle("邀请好友");
				userDetail.setPoint(point);
				userDetail.setCreateTime(current);
				userDetailMapper.saveUserDetail(userDetail);
			}
		});
	}

	@Override
	public void doLock(Integer userId) {
		// 清除缓存
		String hashId = userMapper.getHashId(userId);
		userCache.delete(hashId);
		// 更新用户状态
		userMapper.updateStatus(hashId, User.LOCKED_STATUS);
	}

	@Override
	public void doPacket(UserPacket2 userPacket2) {
		JmsTemplate.convertAndSend(packet2Destination, userPacket2);
	}

	@Override
	public Integer getPacket2Count(String hashId) {
		return userAccountMapper.getPacket2Count(hashId);
	}
}
