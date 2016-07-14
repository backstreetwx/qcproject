package com.jason.qccore.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jason.qccore.base.BaseServiceSupport;
import com.jason.qccore.web.result.DataResult;
import com.jason.qccore.web.result.Result;
import com.jason.qcdao.domain.vo.EarnDataItem;
import com.jason.qcdao.domain.vo.MyEarn;
/**
* @ClassName: ProfitController
* @Description: TODO(收益控制器)
* @author jason.peng
* @date 2016年1月11日 下午4:07:56
 */
@Controller 
@RequestMapping("/public/profit")
public class ProfitController extends BaseServiceSupport{

	@ResponseBody
	@RequestMapping(value="/myEarn", method=RequestMethod.GET)
	public Result myEarn(@CookieValue("hashId")String hashId) {
		MyEarn myEarn = userService.getMyEarn(hashId);
		DataResult<MyEarn> result = new DataResult<MyEarn>();
		result.setData(myEarn);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value="/earnData", method=RequestMethod.GET)
	public Result earnData(@CookieValue("hashId")String hashId) {
		List<EarnDataItem> earnDataItems = userService.getEarnDatas(hashId);
		DataResult<List<EarnDataItem>> result = new DataResult<List<EarnDataItem>>();
		result.setData(earnDataItems);
		result.setCode(DataResult.CODE_SUCCESS);
		return result;
	}
}
