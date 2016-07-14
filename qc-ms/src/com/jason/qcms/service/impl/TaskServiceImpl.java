package com.jason.qcms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jason.qcms.dao.base.BaseDaoSupport;
import com.jason.qcms.domain.po.Task;
import com.jason.qcms.domain.po.TaskContent;
import com.jason.qcms.domain.qo.TaskQo;
import com.jason.qcms.domain.vo.PageBean;
import com.jason.qcms.domain.vo.TaskVo;
import com.jason.qcms.service.TaskService;

@Service
public class TaskServiceImpl extends BaseDaoSupport implements TaskService{

	@Override
	public void doSave(Task task, TaskContent taskContent) {
		// 保存任务
		taskMapper.saveTask(task);
		taskContent.setTaskId(task.getId());
		taskContentMapper.saveTaskContent(taskContent);
	}

	@Override
	public PageBean<TaskVo> getTaskPage(TaskQo qo) {
		List<TaskVo> taskVos = taskMapper.getTaskVos(qo);
		Integer count = taskMapper.getTaskVoCount(qo);
		return new PageBean<TaskVo>(qo.getPageIndex(), qo.getPageSize(), count, taskVos);
	}
	
	@Override
	public PageBean<TaskVo> getTaskPage2(TaskQo qo) {
		List<TaskVo> taskVos = taskMapper.getTaskVos2(qo);
		Integer count = taskMapper.getTaskVoCount2(qo);
		return new PageBean<TaskVo>(qo.getPageIndex(), qo.getPageSize(), count, taskVos);
	}

	@Override
	public void updateType(Integer id, Integer type) {
		taskMapper.updateType(id, type);
	}

	@Override
	public void updateStatus(Integer id, Integer status) {
		taskMapper.updateStatus(id, status);
	}

	@Override
	public TaskVo getTaskVoByTaskId(Integer taskId) {
		return taskMapper.getTaskVoByTaskId(taskId);
	}

	@Override
	public void doCopy(Task task) {
		Date current = new Date();
		
		// 获取任务内容
		TaskContent taskContent = taskContentMapper.getTaskContentByTaskId(task.getId());
		// 保存任务
		task.setId(null);
		task.setCreateTime(current);
		taskMapper.saveTask(task);
		// 获取任务内容
		taskContent.setTaskId(task.getId());
		taskContent.setCreateTime(current);
		taskContentMapper.saveTaskContent(taskContent);
	}

	@Override
	public void updateLimitRead(Integer id, Integer limitRead) {
		taskMapper.updateLimitRead(id, limitRead);
	}

	@Override
	public void updatePoint(Integer id, Integer point) {
		taskMapper.updatePoint(id, point);
	}

	@Override
	public void updateSubTitle(Integer id, String subTitle) {
		taskMapper.updateSubTitle(id, subTitle);
	}

	@Override
	public void updateTitle(Integer id, String title) {
		taskMapper.updateTitle(id, title);
	}

	@Override
	public Integer getMaxSequence() {
		return taskMapper.getMaxSequence();
	}

	@Override
	public void updateSequence(Integer firstId, Integer firstSequence,
			Integer secondId, Integer secondSequence) {
		taskMapper.updateSequence(firstId, firstSequence);
		taskMapper.updateSequence(secondId, secondSequence);
	}

}
