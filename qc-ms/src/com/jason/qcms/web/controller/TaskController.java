package com.jason.qcms.web.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qcms.domain.po.Task;
import com.jason.qcms.domain.po.TaskContent;
import com.jason.qcms.domain.qo.TaskQo;
import com.jason.qcms.domain.vo.PageBean;
import com.jason.qcms.domain.vo.TaskVo;
import com.jason.qcms.service.base.BaseServiceSupport;
import com.jason.qcms.utils.CharsetUtil;

/**
* @ClassName: TaskController
* @Description: TODO(任务控制器)
* @author jason.peng
* @date 2016年2月27日 上午10:29:53
 */
@Controller 
@RequestMapping("/admin/task")
public class TaskController extends BaseServiceSupport{

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String gotoIndex(@ModelAttribute("qo")TaskQo qo, Model model) {
		PageBean<TaskVo> pageBean = taskService.getTaskPage(qo);
		model.addAttribute("pageBean", pageBean);
		return "task/index";
	}
	
	@RequestMapping(value="/gotoSequence", method=RequestMethod.GET)
	public String gotoSequence(@ModelAttribute("qo")TaskQo qo, Model model) {
		PageBean<TaskVo> pageBean = taskService.getTaskPage2(qo);
		model.addAttribute("pageBean", pageBean);
		return "task/sequence";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeType", method=RequestMethod.GET)
	public String changeType(Integer id, Integer type) {
		taskService.updateType(id, type);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeStatus", method=RequestMethod.GET)
	public String changeStatus(Integer id, Integer status) {
		taskService.updateStatus(id, status);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value="/changePoint", method=RequestMethod.GET)
	public String changePoint(Integer id, Integer point) {
		taskService.updatePoint(id, point);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeLimitRead", method=RequestMethod.GET)
	public String changeLimitRead(Integer id, Integer limitRead) {
		taskService.updateLimitRead(id, limitRead);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeSubTitle", method=RequestMethod.GET)
	public String changeSubTitle(Integer id, String subTitle) {
		subTitle = CharsetUtil.convert(subTitle);
		taskService.updateSubTitle(id, subTitle);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeTitle", method=RequestMethod.GET)
	public String changeTitle(Integer id, String title) {
		title = CharsetUtil.convert(title);
		taskService.updateTitle(id, title);
		return "ok";
	}
	
	@ResponseBody
	@RequestMapping(value="/changeSequence", method=RequestMethod.GET)
	public String changeSequence(Integer firstId, Integer firstSequence, 
			Integer secondId, Integer secondSequence) {
		taskService.updateSequence(firstId, firstSequence, secondId, secondSequence);
		return "ok";
	}
	
	@RequestMapping(value="/gotoSave", method=RequestMethod.GET)
	public String gotoSave(Model model) {
		// 获取最大序列
		Integer sequence = taskService.getMaxSequence();
		model.addAttribute("sequence", sequence);
		return "task/save";
	}
	
	@ResponseBody
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(Task task, Integer ctype, String curl, String ccontent) {
		Date current = new Date();
		task.setCreateTime(current);
		
		TaskContent taskContent = new TaskContent();
		taskContent.setType(ctype);
		taskContent.setUrl(curl);
		taskContent.setContent(ccontent);
		taskContent.setCreateTime(current);
		
		taskService.doSave(task, taskContent);
		return "ok";
	}
	
	@RequestMapping(value="/gotoCopy", method=RequestMethod.GET)
	public String gotoCopy(Integer taskId, Model model) {
		Integer sequence = taskService.getMaxSequence();
		model.addAttribute("sequence", sequence);
		
		TaskVo taskVo = taskService.getTaskVoByTaskId(taskId);
		model.addAttribute("taskVo", taskVo);
		return "task/copy";
	}
	
	@ResponseBody
	@RequestMapping(value="/copy", method=RequestMethod.POST)
	public String copy(Task task) {
		taskService.doCopy(task);
		return "ok";
	}
}
