package com.jason.qccore.service;

import java.util.List;

import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.po.UserPacket2;
import com.jason.qcdao.domain.vo.DetailItem;
import com.jason.qcdao.domain.vo.EarnDataItem;
import com.jason.qcdao.domain.vo.MyEarn;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.RankingItem;
import com.jason.qcdao.domain.vo.ShareInvite;



/**
* @ClassName: UserService
* @Description: TODO(用户业务逻辑接口)
* @author jason.peng
* @date 2016年1月6日 上午11:07:09
 */
public interface UserService {
	/**
	* @Title: isExistUser
	* @Description: TODO(通过ID判断用户是否存在)
	* @param id
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午4:42:33
	 */
	public boolean isExistUser(Integer id);
	/**
	* @Title: isExistUser
	* @Description: TODO(通过手机号码判断用户是否存在)
	* @param cellphone
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午4:42:47
	 */
	public boolean isExistUser(String account);
	/**
	* @Title: getHashIdByOpenId
	* @Description: TODO(通过openId获取用户的HashId)
	* @param openId
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午5:51:38
	 */
	public User getUserByOpenId(String openId);
	/**
	* @Title: asyncSaveUser
	* @Description: TODO(保存用户)
	* @param user
	* @author jason.peng
	* @date 2016年1月6日 下午5:47:11
	 */
	public void saveUser(User user);
	/**
	* @Title: asyncUpdateUser
	* @Description: TODO(异步更新用户)
	* @param user
	* @author jason.peng
	* @date 2016年1月6日 下午5:58:16
	 */
	public void asyncUpdateUser(User user);
	/**
	* @Title: getUserByAccount
	* @Description: TODO(通过用户账号获取用户)
	* @param account
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午6:04:54
	 */
	public User getUserByAccount(String account);
	/**
	* @Title: getUserByHashId
	* @Description: TODO(通过hashId获取用户)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午8:01:45
	 */
	public User getUserByHashId(String hashId);
	/**
	* @Title: doPacket
	* @Description: TODO(用户领取红包)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午10:22:10
	 */
	public Integer doPacket(String hashId);
	/**
	* @Title: updateInfo
	* @Description: TODO(更新用户新)
	* @param user
	* @author jason.peng
	* @date 2016年1月7日 上午11:09:26
	 */
	public void asyncUpdateInfo(User user);
	/**
	* @Title: getDetailPage
	* @Description: TODO(获取详情分页)
	* @param hashId
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午11:25:24
	 */
	public Page<DetailItem> getDetailPage(String hashId, Integer index,
			Integer size);
	/**
	* @Title: getMayPoint
	* @Description: TODO(获取用户的可用积分)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午3:35:11
	 */
	public Integer getMayPoint(String hashId);
	/**
	* @Title: getRankingPage
	* @Description: TODO(获取排行榜)
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月8日 下午1:53:03
	 */
	public Page<RankingItem> getRankingPage(Integer index, Integer size);
	/**
	* @Title: updatePassword
	* @Description: TODO(修改用户密码)
	* @param account
	* @param password
	* @param salt
	* @author jason.peng
	* @date 2016年1月11日 下午1:56:27
	 */
	public void updatePassword(String account, String password, String salt);
	/**
	* @Title: getMyEarn
	* @Description: TODO(获取我的收益)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月11日 下午4:22:37
	 */
	public MyEarn getMyEarn(String hashId);
	/**
	* @Title: getEarnDatas
	* @Description: TODO(获取收益数据表格)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月11日 下午4:34:15
	 */
	public List<EarnDataItem> getEarnDatas(String hashId);
	/**
	* @Title: getShareInvite
	* @Description: TODO(获取分享邀请数据)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 上午9:05:07
	 */
	public ShareInvite getShareInvite(String hashId);
	/**
	* @Title: getHashIdById
	* @Description: TODO(通过ID获取hashId)
	* @param inviteId
	* @return
	* @author jason.peng
	* @date 2016年1月13日 下午2:45:32
	 */
	public String getHashIdById(Integer id);
	/**
	* @Title: doInvite
	* @Description: TODO(处理要求)
	* @param byHashId
	* @param hashId
	* @author jason.peng
	* @date 2016年1月13日 下午2:47:46
	 */
	public void doInvite(String byHashId, String hashId);
	/**
	* @Title: doLock
	* @Description: TODO(锁定用户)
	* @param id
	* @author jason.peng
	* @date 2016年2月22日 上午10:48:22
	 */
	public void doLock(Integer userId);
	/**
	* @Title: doPacket
	* @Description: TODO(抢红包)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年3月14日 下午4:45:15
	 */
	public void doPacket(UserPacket2 userPacket2);
	/**
	* @Title: getPacket2Count
	* @Description: TODO(获取抢红包的次数)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年3月15日 上午8:44:03
	 */
	public Integer getPacket2Count(String hashId);
	
}
