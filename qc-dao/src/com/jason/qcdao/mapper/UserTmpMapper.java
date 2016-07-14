package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserTmp;
import com.jason.qcdao.domain.vo.MyEarn;

/**
* @ClassName: UserTmpMapper
* @Description: TODO(用户临时实体数据库访问接口)
* @author jason.peng
* @date 2016年1月8日 上午10:41:17
 */
public interface UserTmpMapper {
	/**
	* @Title: saveUserTmp
	* @Description: TODO(保存一条用户临时记录)
	* @param userTmp
	* @author jason.peng
	* @date 2016年1月8日 下午5:27:06
	 */
	public void saveUserTmp(UserTmp userTmp);
	/**
	* @Title: getMyEarn
	* @Description: TODO(获取我的收益)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月11日 下午4:23:31
	 */
	public MyEarn getMyEarn(@Param("hashId")String hashId);
	/**
	* @Title: getUserTmp
	* @Description: TODO(获取一个人的临时数据)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月11日 下午4:35:20
	 */
	public UserTmp getUserTmp(@Param("hashId")String hashId);
	/**
	* @Title: updateTaskCount
	* @Description: TODO(更新用户次数)
	* @param hashId
	* @author jason.peng
	* @date 2016年1月13日 上午8:54:38
	 */
	public void updateUserTmpForShare(@Param("hashId")String hashId);
	
	/**
	* @Title: updateTaskCount
	* @Description: TODO(更新用户次数)
	* @param hashId
	* @author jason.peng
	* @date 2016年1月13日 上午8:54:38
	 */
	public void updateUserTmpForShare2(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: updateUserTmpForRead
	* @Description: TODO(更新用户临时记录作为阅读)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年1月13日 上午8:59:14
	 */
	public void updateUserTmpForRead(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: updateUserTmpForDaily
	* @Description: TODO(用户临时记录定时更新)
	* @author jason.peng
	* @date 2016年1月13日 上午9:13:44
	 */
	public void updateUserTmpForDaily();
	/**
	* @Title: updateUserTmpForPacket
	* @Description: TODO(更新用户临时记录作为红包)
	* @param hashId
	* @param point
	* @author jason.peng
	* @date 2016年1月25日 下午3:20:47
	 */
	public void updateUserTmpForPacket(@Param("hashId")String hashId, @Param("point")Integer point);
	/**
	* @Title: getUserTmpForDetail
	* @Description: TODO(获取临时记录作为明细)
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年2月26日 上午9:50:50
	 */
	public List<UserTmp> getUserTmpForDetail(@Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: getRandHashId
	* @Description: TODO(随机获取若干条用户hashId)
	* @return
	* @author jason.peng
	* @date 2016年3月14日 下午4:00:36
	 */
	public List<String> getRandHashIds(@Param("size")Integer size);
	/**
	* @Title: getRandHashId
	* @Description: TODO(获取一条用户hashId)
	* @param hashIds
	* @return
	* @author jason.peng
	* @date 2016年3月14日 下午8:11:36
	 */
	public String getRandHashId(@Param("hashIds")List<String> hashIds);

}
