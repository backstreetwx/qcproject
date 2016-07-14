package com.jason.qcms.dao.mapper;

import org.apache.ibatis.annotations.Param;

import com.jason.qcms.domain.po.TaskContent;

public interface TaskContentMapper {
	/**
	* @Title: saveTaskContent
	* @Description: TODO(保存任务内容)
	* @param taskContent
	* @author jason.peng
	* @date 2016年2月28日 下午3:37:47
	 */
	public void saveTaskContent(TaskContent taskContent);
	/**
	* @Title: getTaskContentVoByTaskId
	* @Description: TODO(获取任务内容)
	* @param id
	* @author jason.peng
	* @date 2016年3月1日 上午10:52:21
	 */
	public TaskContent getTaskContentByTaskId(@Param("taskId")Integer taskId);

}
