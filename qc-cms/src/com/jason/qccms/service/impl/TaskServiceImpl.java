package com.jason.qccms.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jason.qccms.dao.base.BaseDaoSupport;
import com.jason.qccms.domain.po.SysUserTask;
import com.jason.qccms.domain.po.Task;
import com.jason.qccms.domain.po.TaskContent;
import com.jason.qccms.domain.qo.TaskQo;
import com.jason.qccms.domain.vo.PageBean;
import com.jason.qccms.domain.vo.TaskVo;
import com.jason.qccms.service.TaskService;

@Service
public class TaskServiceImpl extends BaseDaoSupport implements TaskService {

	@Override
	public void doSaveTask(Integer sysUserId, Task task, Integer ctype, String curl) {
		Date current = new Date();
		// 获取最大序列
		Integer sequence = taskMapper.getMaxSequence();
		// 保存任务
		task.setSequence(sequence);
		task.setType(Task.CUSTOM_TYPE);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			task.setFinishTime(format.parse("2016-12-31"));
		} catch (ParseException e) {
			
		}
		task.setStatus(Task.NONE_STATUS);
		task.setCreateTime(current);
		taskMapper.saveTask(task);
		// 保存任务内容
		TaskContent taskContent = new TaskContent();
		taskContent.setTaskId(task.getId());
		taskContent.setType(ctype);
		taskContent.setUrl(curl);
		taskContent.setCreateTime(current);
		taskContentMapper.saveTaskContent(taskContent);
		// 保存用户任务关系
		SysUserTask sysUserTask = new SysUserTask();
		sysUserTask.setSysUserId(sysUserId);
		sysUserTask.setTaskId(task.getId());
		sysUserTask.setCreateTime(current);
		sysUserTaskMapper.saveSysUserTask(sysUserTask);
	}

	@Override
	public PageBean<TaskVo> getTaskPage(Integer sysUserId, TaskQo qo) {
		List<TaskVo> taskVos = taskMapper.getTaskVos(sysUserId, qo.getStart(), qo.getOffset());
		Integer count = taskMapper.getTaskVoCount(sysUserId);
		return new PageBean<TaskVo>(qo.getPageIndex(), qo.getPageSize(), count, taskVos);
	}

}
