package com.jason.qccore.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.po.Notice2;
import com.jason.qcdao.domain.vo.BannelItem;
import com.jason.qcdao.domain.vo.HomeData;
import com.jason.qcdao.domain.vo.Notice2Item;
import com.jason.qcdao.domain.vo.NoticeItem;
import com.jason.qcdao.domain.vo.Page;

@Controller 
@RequestMapping("/public/home")
public class HomeController extends BaseServiceSupport{

	
	@ResponseBody
	@RequestMapping(value="/data", method=RequestMethod.GET)
	public Result data() {
		// 1.获取bannle
		List<BannelItem> bannelItems = systemService.getBannels();
		// 2.获取notice
		List<NoticeItem> noticeItems = systemService.getNotices();
		
		HomeData homeData = new HomeData();
		homeData.setBannelItems(bannelItems);
		homeData.setNoticeItems(noticeItems);
		
		DataResult<HomeData> result = new DataResult<HomeData>();
		result.setData(homeData);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@RequestMapping(value="/desc", method=RequestMethod.GET)
	public String desc() {
		return "home_desc";
	}
	
	@RequestMapping(value="/question", method=RequestMethod.GET)
	public String question() {
		return "home_question";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/notice", method=RequestMethod.GET)
	public Result notice() {
		Notice2 notice2 = systemService.getNotice2();
		DataResult<Notice2> result = new DataResult<Notice2>();
		result.setData(notice2);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/notices", method=RequestMethod.GET)
	public Result notices(Integer index, Integer size) {
		index = index == null || index < 1 || index < 1 ? 1 : index;
		size = size == null ? Page.DEFAULT_PAGE_SIZE : size;// 保留字段
		
		Page<Notice2Item> page = systemService.getNotice2Page(index, size);
		DataResult<Page<Notice2Item>> result = new DataResult<Page<Notice2Item>>();
		result.setData(page);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
} 
