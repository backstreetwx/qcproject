package com.jason.qcms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcms.domain.po.Task;
import com.jason.qcms.domain.qo.TaskQo;
import com.jason.qcms.domain.vo.TaskVo;

public interface TaskMapper {
	/**
	* @Title: saveTask
	* @Description: TODO(保存任务)
	* @param task
	* @author jason.peng
	* @date 2016年2月28日 下午3:37:06
	 */
	public void saveTask(Task task);
	/**
	* @Title: getTaskVos
	* @Description: TODO(获取任务值对象列表)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年2月29日 上午10:16:36
	 */
	public List<TaskVo> getTaskVos(TaskQo qo);
	/**
	* @Title: getTaskVoCount
	* @Description: TODO(获取任务值对象计数)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年2月29日 上午10:17:05
	 */
	public Integer getTaskVoCount(TaskQo qo);
	/**
	* @Title: updateType
	* @Description: TODO(更新任务的类型)
	* @param id
	* @param type
	* @author jason.peng
	* @date 2016年2月29日 下午2:08:02
	 */
	public void updateType(@Param("id")Integer id, @Param("type")Integer type);
	/**
	* @Title: updateStatus
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param id
	* @param status
	* @author jason.peng
	* @date 2016年2月29日 下午2:28:17
	 */
	public void updateStatus(@Param("id")Integer id, @Param("status")Integer status);
	/**
	* @Title: getTaskVoByTaskId
	* @Description: TODO(获取任务)
	* @param taskId
	* @return
	* @author jason.peng
	* @date 2016年3月1日 上午10:37:18
	 */
	public TaskVo getTaskVoByTaskId(@Param("id")Integer id);
	/**
	* @Title: updateLimitRead
	* @Description: TODO(更新阅读限制)
	* @param id
	* @param limitRead
	* @author jason.peng
	* @date 2016年3月1日 下午1:54:16
	 */
	public void updateLimitRead(@Param("id")Integer id, @Param("limitRead")Integer limitRead);
	/**
	* @Title: updatePoint
	* @Description: TODO(更新任务积分)
	* @param id
	* @param point
	* @author jason.peng
	* @date 2016年3月1日 下午2:06:26
	 */
	public void updatePoint(@Param("id")Integer id, @Param("point")Integer point);
	/**
	* @Title: updateSubTitle
	* @Description: TODO(更新子标题)
	* @param id
	* @param subTitle
	* @author jason.peng
	* @date 2016年3月1日 下午2:27:23
	 */
	public void updateSubTitle(@Param("id")Integer id, @Param("subTitle")String subTitle);
	/**
	* @Title: updateTitle
	* @Description: TODO(更新标题)
	* @param id
	* @param subTitle
	* @author jason.peng
	* @date 2016年3月1日 下午2:27:47
	 */
	public void updateTitle(@Param("id")Integer id, @Param("title")String title);
	/**
	* @Title: getStartTasks
	* @Description: TODO(获取开始任务的ID)
	* @return
	* @author jason.peng
	* @date 2016年3月2日 上午9:57:45
	 */
	public List<Integer> getStartTasks();
	/**
	* @Title: getMaxSequence
	* @Description: TODO(获取最大序列)
	* @return
	* @author jason.peng
	* @date 2016年3月2日 下午3:17:03
	 */
	public Integer getMaxSequence();
	/**
	* @Title: updateSequence
	* @Description: TODO(更新任务序列)
	* @param firstId
	* @param firstSequence
	* @param secondId
	* @param secondSequence
	* @author jason.peng
	* @date 2016年3月2日 下午3:52:36
	 */
	public void updateSequence(@Param("id")Integer id, @Param("sequence")Integer sequence);
	/**
	* @Title: getTaskVos2
	* @Description: TODO(获取任务列表)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年3月2日 下午4:26:50
	 */
	public List<TaskVo> getTaskVos2(TaskQo qo);
	/**
	* @Title: getTaskVoCount2
	* @Description: TODO(获取任务列表计数)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年3月2日 下午4:26:57
	 */
	public Integer getTaskVoCount2(TaskQo qo);

}
