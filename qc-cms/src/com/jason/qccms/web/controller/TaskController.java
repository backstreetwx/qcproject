package com.jason.qccms.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jason.qccms.domain.po.SysUser;
import com.jason.qccms.domain.po.Task;
import com.jason.qccms.service.base.BaseServiceSupport;
import com.jason.qccms.web.resolver.annotation.CurrentUser;

@Controller 
@RequestMapping("/admin/task")
public class TaskController extends BaseServiceSupport{

	@RequestMapping(value="/gotoSave", method=RequestMethod.GET)
	public String gotoSave() {
		return "task/save";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String save(@CurrentUser SysUser sysUser, Task task, Integer ctype, String curl, Model model) {
		if(StringUtils.isBlank(task.getTitle())) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("etitle", "* 标题不能为空");
			return "task/save";
		}
		
		if(task.getTitle().length() > 100) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("etitle", "* 标题长度不能超过100个字符");
			return "task/save";
		}
		 
		if(StringUtils.isBlank(task.getSubTitle())) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("esubTitle", "* 子标题不能为空");
			return "task/save";
		}
		
		if(task.getSubTitle().length() > 100) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("esubTitle", "* 子标题长度不能超过100个字符");
			return "task/save";
		}
		
		if(StringUtils.isBlank(task.getIcon())) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("eicon", "* 图标不能为空");
			return "task/save";
		}
		
		if(task.getPoint() == null) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("epoint", "* 单价不能为空");
			return "task/save";
		}
		
		if(task.getLimitRead() == null) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("elimitRead", "* 限量不能为空");
			return "task/save";
		}
		
		if(ctype == null) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("ectype", "* 类型不能为空");
			return "task/save";
		}
		
		if(StringUtils.isBlank(curl)) {
			model.addAttribute("task", task);
			model.addAttribute("ctype", ctype);
			model.addAttribute("curl", curl);
			model.addAttribute("ecurl", "* 地址不能为空");
			return "task/save";
		}
		
		taskService.doSaveTask(sysUser.getId(), task, ctype, curl);
		
		return "redirect:/admin/system/gotoHome";
	}
}
