package com.jason.qcserver.jms;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.po.UserAccount;
import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserInvite;
import com.jason.qcdao.domain.po.UserTmp;
import com.jason.qcserver.base.BaseServiceSupport;
/**
* @ClassName: UserMessageListener
* @Description: TODO(用户消息监听，主要是用户的注册监听)
* @author jason.peng
* @date 2016年1月7日 上午7:21:18
 */
@Component
public class UserMessageListener extends BaseServiceSupport{

	public void handleMessage(final User user) {
		// 判断注册的用户是否有重复
		if(User.UNKNOWN_TYPE.equals(user.getType())) { // 判断账号重复
			
			if(userMapper.isExistUserByAccount(user.getAccount()) == 1) {
				logger.info("find a repeat reg, user info is {}", user);
				return ;
			} else if(user.getInviteId() != null){ // 异步保存邀请记录，加快用户注册的时间
				taskExecutor.execute(new Runnable() {
					@Override
					public void run() {
						String byHashId = userMapper.getHashId(user.getInviteId());
						if(StringUtils.isBlank(byHashId)) {
							return ;
						}
						
						Date current = new Date();
						// 获取邀请人账号信息，如果邀请大于20就不给
						Integer inviteCount = userAccountMapper.getInviteCount(byHashId);
						if(inviteCount > 12) {
							String hashId = user.getHashId();
							UserInvite userInvite = new UserInvite();
							userInvite.setByHashId(byHashId);
							userInvite.setHashId(hashId);
							userInvite.setCreateTime(current);
							userInvite.setPoint(0);
							userInviteMapper.saveUserInvite(userInvite);
							return ;
						}
						
						Integer point = 2 * UserAccount.RATE;
						String hashId = user.getHashId();
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
		} else { // 判断微信重复
			if(userMapper.isExistUserByOpenId(user.getOpenId()) == 1) {
				logger.info("find a repeat auth, user info is {}", user);
				return ;
			}
		}
		// 保存用户
		userMapper.saveUser(user);
		// 创建用户的账号
		UserAccount userAccount = new UserAccount();
		userAccount.setHashId(user.getHashId());
		userAccount.setCreateTime(user.getCreateTime());
		userAccountMapper.saveUserAccount(userAccount);
		// 创建用户临时记录
		UserTmp userTmp = new UserTmp();
		userTmp.setHashId(user.getHashId());
		userTmp.setCreateTime(user.getCreateTime());
		userTmpMapper.saveUserTmp(userTmp);
		
		logger.info("用户注册成功：{}", user);
	}
}
