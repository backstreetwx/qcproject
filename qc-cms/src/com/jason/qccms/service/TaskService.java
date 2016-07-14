package com.jason.qccms.service;

import com.jason.qccms.domain.po.Task;
import com.jason.qccms.domain.qo.TaskQo;
import com.jason.qccms.domain.vo.PageBean;
import com.jason.qccms.domain.vo.TaskVo;

public interface TaskService {
	/**
	* @Title: doSaveTask
	* @Description: TODO(保存任务)
	* @param id
	* @param task
	* @param ctype
	* @param curl
	* @author jason.peng
	* @date 2016年3月8日 下午2:48:56
	 */
	public void doSaveTask(Integer sysUserId, Task task, Integer ctype, String curl);
	/**
	* @Title: getTaskPage
	* @Description: TODO(获取任务分页)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年3月8日 下午3:41:27
	 */
	public PageBean<TaskVo> getTaskPage(Integer sysUserId, TaskQo qo);

}
