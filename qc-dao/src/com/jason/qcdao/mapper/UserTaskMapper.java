package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserTask;
import com.jason.qcdao.domain.vo.UserTaskItem;

/**
* @ClassName: UserTaskMapper
* @Description: TODO(用户任务记录实体数据库访问接口)
* @author jason.peng
* @date 2016年1月8日 上午10:37:23
 */
public interface UserTaskMapper {
	/**
	* @Title: getUserTasks
	* @Description: TODO(获取用户任务记录列表)
	* @param hashId
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月8日 上午11:56:01
	 */
	public List<UserTaskItem> getUserTasks(@Param("hashId")String hashId, @Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: isExistUserTask
	* @Description: TODO(判断用户是否做过该任务)
	* @param orderId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午4:44:46
	 */
	public Integer isExistUserTask(@Param("orderId")String orderId);
	/**
	* @Title: saveUserTask
	* @Description: TODO(保存用户任务)
	* @param userTask
	* @author jason.peng
	* @date 2016年1月12日 下午4:47:12
	 */
	public void saveUserTask(UserTask userTask);
	/**
	* @Title: updateUserTaskForRead
	* @Description: TODO(更新用户任务作为阅读)
	* @param orderId
	* @param point
	* @author jason.peng
	* @date 2016年1月13日 上午9:05:37
	 */
	public void updateUserTaskForRead(@Param("orderId")String orderId, @Param("point")Integer point);
	
}
