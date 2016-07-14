package com.jason.qccore.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.vo.ShareInvite;
import com.jason.qcdao.domain.vo.ShareUrl;

/**
* @ClassName: ShareController
* @Description: TODO(分享控制器)
* @author jason.peng
* @date 2016年1月12日 上午8:56:48
 */
@Controller 
@RequestMapping("/public/share")
public class ShareController extends BaseServiceSupport{

	@RequestMapping(value="/invite", method=RequestMethod.GET)
	public String invite(@CookieValue("hashId")String hashId, Model model) {
		ShareInvite shareInvite = userService.getShareInvite(hashId);
		model.addAttribute("shareInvite", shareInvite);
		return "share_invite";
	}
	
	@ResponseBody
	@RequestMapping(value="/url", method=RequestMethod.GET)
	public Result url(@CookieValue("hashId")String hashId) {
		ShareUrl shareUrl = systemService.getShareUrl(hashId);
		DataResult<ShareUrl> result = new DataResult<ShareUrl>();
		result.setData(shareUrl);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value="/down", method=RequestMethod.GET)
	public String down() {
		return "share_down";
	}
	
}
