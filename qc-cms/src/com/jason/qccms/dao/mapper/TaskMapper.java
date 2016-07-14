package com.jason.qccms.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qccms.domain.po.Task;
import com.jason.qccms.domain.vo.TaskVo;

public interface TaskMapper {
	/**
	* @Title: getMaxSequence
	* @Description: TODO(获取最大序列)
	* @return
	* @author jason.peng
	* @date 2016年3月8日 下午2:51:55
	 */
	public Integer getMaxSequence();
	/**
	* @Title: saveTask
	* @Description: TODO(保存任务)
	* @param task
	* @author jason.peng
	* @date 2016年3月8日 下午2:53:14
	 */
	public void saveTask(Task task);
	/**
	* @Title: getTaskVos
	* @Description: TODO(获取任务列表)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年3月8日 下午3:43:48
	 */
	public List<TaskVo> getTaskVos(@Param("sysUserId")Integer sysUserId, 
			@Param("start")Integer start, @Param("offset")Integer offset);
	/**
	* @Title: getTaskVoCount
	* @Description: TODO(获取任务列表计数)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年3月8日 下午3:44:04
	 */
	public Integer getTaskVoCount(@Param("sysUserId")Integer sysUserId);

}
