package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserAccount;
import com.jason.qcdao.domain.vo.RankingItem;
import com.jason.qcdao.domain.vo.ShareInvite;

/**
* @ClassName: UserAccountMapper
* @Description: TODO(用户账号数据库访问接口)
* @author jason.peng
* @date 2016年1月6日 下午3:34:12
 */
public interface UserAccountMapper {
	/**
	* @Title: saveUserAccount
	* @Description: TODO(保存用户账号)
	* @param userAccount
	* @author jason.peng
	* @date 2016年1月6日 下午7:25:18
	 */
	public void saveUserAccount(UserAccount userAccount);
	/**
	* @Title: updateInviteCount
	* @Description: TODO(更新用户的邀请次数)
	* @param byHashId
	* @author jason.peng
	* @date 2016年1月7日 上午9:24:18
	 */
	public void updatePointForInvite(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: updatePointForPacket
	* @Description: TODO(更新用户账号红包信息)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年1月7日 上午10:33:53
	 */
	public void updatePointForPacket(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: getMayPoint
	* @Description: TODO(获取用户的可用积分)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午3:35:50
	 */
	public Integer getMayPoint(@Param("hashId")String hashId);
	/**
	* @Title: updatePointForUserOrder
	* @Description: TODO(更新用户的积分作为订单)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年1月8日 上午8:04:36
	 */
	public void updatePointForUserOrder(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: updatePointForUserOrder2
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年2月19日 上午11:09:28
	 */
	public void updatePointForUserOrder2(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: getRankings
	* @Description: TODO(获取排行榜)
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月8日 下午1:55:25
	 */
	public List<RankingItem> getRankings(@Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: getShareInvite
	* @Description: TODO(获取分享邀请数据)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 上午9:05:59
	 */
	public ShareInvite getShareInvite(@Param("hashId")String hashId);
	/**
	* @Title: updateUserAccountForRead
	* @Description: TODO(更新用户账号作为任务)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年1月13日 上午9:01:59
	 */
	public void updatePointForTask(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: updatePointForTask2
	* @Description: TODO(更新用户的积分作为任务)
	* @author jason.peng
	* @date 2016年1月13日 上午9:46:44
	 */
	public void updatePointForTask2();
	/**
	* @Title: updatePointForTask2
	* @Description: TODO(更新用户的积分作为任务)
	* @author jason.peng
	* @date 2016年1月13日 上午9:46:44
	 */
	public void updatePointForTask3(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: updatePointForTask4
	* @Description: TODO(更新用户的积分作为任务)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年3月19日 下午4:07:54
	 */
	public void updatePointForTask4(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: getPacketCount
	* @Description: TODO(获取红包的次数)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年2月24日 上午1:35:38
	 */
	public Integer getPacketCount(@Param("hashId")String hashId);
	/**
	* @Title: updateShareCount
	* @Description: TODO(更新用户的分享次数)
	* @param hashId
	* @author jason.peng
	* @date 2016年2月26日 下午4:53:03
	 */
	public void updateShareCount(@Param("hashId")String hashId);
	/**
	* @Title: getShareCount
	* @Description: TODO(获取用户的分享次数)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年2月26日 下午4:58:42
	 */
	public Integer getShareCount(@Param("hashId")String hashId);
	/**
	* @Title: updatePointForShare
	* @Description: TODO(更新用户积分作为分享)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年2月26日 下午5:01:56
	 */
	public void updatePointForShare(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: getInviteCount
	* @Description: TODO(获取邀请人数量)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年3月7日 上午10:55:23
	 */
	public Integer getInviteCount(@Param("hashId")String hashId);
	/**
	* @Title: updatePointForUserPacket2
	* @Description: TODO(更新用户积分作为抢红包)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年3月15日 上午8:33:22
	 */
	public void updatePointForUserPacket2(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: getPacket2Count
	* @Description: TODO(获取用户抢红包的次数)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年3月15日 上午8:44:50
	 */
	public Integer getPacket2Count(String hashId);
	

}
