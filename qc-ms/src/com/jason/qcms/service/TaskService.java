package com.jason.qcms.service;

import com.jason.qcms.domain.po.Task;
import com.jason.qcms.domain.po.TaskContent;
import com.jason.qcms.domain.qo.TaskQo;
import com.jason.qcms.domain.vo.PageBean;
import com.jason.qcms.domain.vo.TaskVo;

public interface TaskService {
	/**
	* @Title: doSave
	* @Description: TODO(保存任务)
	* @param task
	* @param taskContent
	* @author jason.peng
	* @date 2016年2月28日 下午3:34:01
	 */
	public void doSave(Task task, TaskContent taskContent);
	/**
	* @Title: getTaskPage
	* @Description: TODO(获取任务列表)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年2月29日 上午10:14:05
	 */
	public PageBean<TaskVo> getTaskPage(TaskQo qo);
	/**
	* @Title: getTaskPage2
	* @Description: TODO(获取任务列表)
	* @param qo
	* @return
	* @author jason.peng
	* @date 2016年3月2日 下午4:26:00
	 */
	public PageBean<TaskVo> getTaskPage2(TaskQo qo);
	/**
	* @Title: updateType
	* @Description: TODO(更新任务类型)
	* @param id
	* @param type
	* @author jason.peng
	* @date 2016年2月29日 下午2:07:31
	 */
	public void updateType(Integer id, Integer type);
	/**
	* @Title: changeStatus
	* @Description: TODO(改变任务状态)
	* @param id
	* @param status
	* @author jason.peng
	* @date 2016年2月29日 下午2:27:26
	 */
	public void updateStatus(Integer id, Integer status);
	/**
	* @Title: getTaskVoByTaskId
	* @Description: TODO(获取任务)
	* @param taskId
	* @return
	* @author jason.peng
	* @date 2016年3月1日 上午10:36:43
	 */
	public TaskVo getTaskVoByTaskId(Integer taskId);
	/**
	* @Title: doCopy
	* @Description: TODO(处理复杂)
	* @param task
	* @author jason.peng
	* @date 2016年3月1日 上午10:48:33
	 */
	public void doCopy(Task task);
	/**
	* @Title: updateLimitRead
	* @Description: TODO(更新阅读限制)
	* @param id
	* @param limitRead
	* @author jason.peng
	* @date 2016年3月1日 下午1:53:40
	 */
	public void updateLimitRead(Integer id, Integer limitRead);
	/**
	* @Title: updatePoint
	* @Description: TODO(更新任务积分)
	* @param id
	* @param point
	* @author jason.peng
	* @date 2016年3月1日 下午2:05:54
	 */
	public void updatePoint(Integer id, Integer point);
	/**
	* @Title: updateSubTitle
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param id
	* @param subTitle
	* @author jason.peng
	* @date 2016年3月1日 下午2:26:45
	 */
	public void updateSubTitle(Integer id, String subTitle);
	/**
	* @Title: updateTitle
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @param id
	* @param title
	* @author jason.peng
	* @date 2016年3月1日 下午2:29:28
	 */
	public void updateTitle(Integer id, String title);
	/**
	* @Title: getSequence
	* @Description: TODO(获取任务最大序列)
	* @return
	* @author jason.peng
	* @date 2016年3月2日 下午3:16:24
	 */
	public Integer getMaxSequence();
	/**
	* @Title: updateSequence
	* @Description: TODO(改变任务序列)
	* @param firstId
	* @param firstSequence
	* @param secondId
	* @param secondSequence
	* @author jason.peng
	* @date 2016年3月2日 下午3:51:51
	 */
	public void updateSequence(Integer firstId, Integer firstSequence,
			Integer secondId, Integer secondSequence);

}
