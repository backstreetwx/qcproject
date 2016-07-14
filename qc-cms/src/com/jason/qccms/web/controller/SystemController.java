package com.jason.qccms.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccms.domain.po.SysUser;
import com.jason.qccms.domain.qo.TaskQo;
import com.jason.qccms.domain.vo.PageBean;
import com.jason.qccms.domain.vo.TaskVo;
import com.jason.qccms.service.base.BaseServiceSupport;
import com.jason.qccms.utils.QiNiuUtil;
import com.jason.qccms.web.resolver.annotation.CurrentUser;

@Controller 
@RequestMapping("/admin/system")
public class SystemController extends BaseServiceSupport{
	
	private Logger logger = LoggerFactory.getLogger(SystemController.class);

	@RequestMapping(value="/gotoLogin", method=RequestMethod.GET)
	public String gotoLogin() {
		return "system/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, 
			Model model, HttpSession session) {
		
		if(StringUtils.isBlank(username)) {
			model.addAttribute("eusername", "* 用户名不能为空");
			return "system/login";
		}
		
		if(StringUtils.isBlank(password)) {
			model.addAttribute("epassword", "* 密码不能为空");
			return "system/login";
		}
		
		SysUser sysUser = userService.getSysUserByUsername(username);
		if(sysUser == null) {
			model.addAttribute("eusername", "* 用户名不存在");
			return "system/login";
		}
		
		if(sysUser.getLock() == SysUser.LOCK_YES) {
			model.addAttribute("eusername", "* 用户被锁定，联系工作人员");
			return "system/login";
		}
		
		if(!StringUtils.equals(sysUser.getPassword(), password)) {
			model.addAttribute("epassword", "* 密码错误");
			return "system/login";
		}
		
		session.setAttribute("sysUser", sysUser);
		return "redirect:/admin/system/gotoHome";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("sysUser");
		return "redirect:/admin/system/gotoLogin";
	}
	
	@RequestMapping(value="/gotoHome", method=RequestMethod.GET)
	public String gotoHome(@CurrentUser SysUser sysUser, @ModelAttribute("qo")TaskQo qo, 
			Model model) {
		PageBean<TaskVo> pageBean = taskService.getTaskPage(sysUser.getId(), qo);
		model.addAttribute("pageBean", pageBean);
		return "system/home";
	}
	
	@RequestMapping(value="/gotoData", method=RequestMethod.GET)
	public String gotoData(@CurrentUser SysUser sysUser, @ModelAttribute("qo")TaskQo qo, 
			Model model) {
		PageBean<TaskVo> pageBean = taskService.getTaskPage(sysUser.getId(), qo);
		model.addAttribute("pageBean", pageBean);
		return "system/data";
	}
	
	@ResponseBody
	@RequestMapping(value="/token", method=RequestMethod.GET)
	public String token(@CurrentUser SysUser sysUser) {
		String str = "{\"uptoken\": \""+QiNiuUtil.getToken()+"\"}";
		logger.info("curren user is {}, token is {}", sysUser, str);
		return str;
	}

}
