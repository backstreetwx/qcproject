package com.jason.qcms.job;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jason.qcms.dao.mapper.TaskMapper;
import com.jason.qcms.domain.po.Task;

@Component
public class TaskJob {
	
	private Logger logger = LoggerFactory.getLogger(TaskJob.class);
	
	@Autowired
	private TaskMapper taskMapper;

	public void doWork() {
		// 获取
		List<Integer> ids = taskMapper.getStartTasks();
		
		logger.info("开始任务的ID：" + ArrayUtils.toString(ids));
		
		if(ids == null || ids.size() == 0) {
			return ;
		}
		
		for(Integer id : ids) {
			taskMapper.updateStatus(id, Task.RUNNING_STATUS);
		}
	}
}
