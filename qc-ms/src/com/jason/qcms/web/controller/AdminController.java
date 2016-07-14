package com.jason.qcms.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jason.qcms.domain.po.SysUser;
import com.jason.qcms.service.base.BaseServiceSupport;
import com.jason.qcms.web.resolver.annotation.CurrentUser;

/**
* @ClassName: AdminController
* @Description: TODO(后台控制器)
* @author jason.peng
* @date 2016年2月27日 上午10:37:16
*
 */
@Controller 
@RequestMapping("/admin")
public class AdminController extends BaseServiceSupport{

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String gotoHome(@CurrentUser SysUser sysUser, Model model) {
		model.addAttribute("sysUser", sysUser);
		return "home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String gotoLogin() {
		return "login";
	}
}
