package com.jason.qcms.web.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qcms.domain.po.SysUser;
import com.jason.qcms.service.base.BaseServiceSupport;
import com.jason.qcms.utils.Md5Util;
import com.jason.qcms.utils.Md5Util.CaseStrategy;
import com.jason.qcms.utils.Md5Util.EncodeStrategy;
import com.jason.qcms.utils.QiNiuUtil;

/**
* @ClassName: SystemController
* @Description: TODO(系统控制器)
* @author jason.peng
* @date 2016年2月27日 上午8:32:01
 */
@Controller 
@RequestMapping("/admin/system")
public class SystemController extends BaseServiceSupport{
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String gotoIndex() {
		return "system/index";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(String username, String password, Model model, HttpSession session) {
		if(StringUtils.isBlank(username)) {
			model.addAttribute("error", "用户名不能为空");
			return "login";
		}
		
		if(StringUtils.isBlank(password)) {
			model.addAttribute("error", "密码不能为空");
			return "login";
		}
		
		SysUser sysUser = userService.getSysUserByUsername(username);
		if(sysUser == null) {
			model.addAttribute("error", "用户名获取密码错误");
			return "login";
		}
		
		String md5 = Md5Util.encrypt(password + sysUser.getSalt(), EncodeStrategy.ENCODE_HEX, CaseStrategy.LOWER_CASE);
		if(!md5.equals(sysUser.getPassword())) {
			model.addAttribute("error", "用户名获取密码错误");
			return "login";
		}
		
		if(sysUser.getLocked()){
			model.addAttribute("error", "用户已锁定");
			return "admin/sys/login";
		}
		
		session.setAttribute("sysUser", sysUser);
		return "redirect:/admin/home";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("sysUser");
		return "redirect:/admin/login";
	}
	
	@ResponseBody
	@RequestMapping(value="/token", method=RequestMethod.GET)
	public String token() {
		String str = "{\"uptoken\": \""+QiNiuUtil.getToken()+"\"}";
		return str;
	}

}
