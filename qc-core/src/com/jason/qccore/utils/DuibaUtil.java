package com.jason.qccore.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.jason.qcdao.domain.vo.DuiBaDeducted;
import com.jason.qcdao.domain.vo.DuiBaNotice;

import cn.com.duiba.credits.sdk.CreditConsumeParams;
import cn.com.duiba.credits.sdk.CreditNotifyParams;
import cn.com.duiba.credits.sdk.CreditTool;

public final class DuibaUtil {
	
	private static CreditTool tool = null;
	
	static {
		tool = new CreditTool("xbgipQzcn2FgKKzN8QwkmDXdkxX", "2C3rTAkLnyVESJQ4gRM5Zw4baJch");
	}

	public static String getUrl(String id, String mayPoint, String redirect) {
		Map<String, String> params=new HashMap<String, String>();
		params.put("uid",id);
		params.put("credits",mayPoint);
		if(redirect != null){
		    //redirect是目标页面地址，默认积分商城首页是：http://www.duiba.com.cn/chome/index
		    //此处请设置成一个外部传进来的参数，方便运营灵活配置
		    params.put("redirect",redirect);
		}
		return tool.buildUrlWithSign("http://www.duiba.com.cn/autoLogin/autologin?",params);
	}
	/**
	* @Title: getDuiBaDeducted
	* @Description: TODO(获取扣积分参数)
	* @param request
	* @return
	* @author jason.peng
	* @date 2016年2月19日 上午9:37:23
	 */
	public static DuiBaDeducted getDuiBaDeducted(HttpServletRequest request) {
		 DuiBaDeducted deducted = null;
		 
		 try {
			 CreditConsumeParams params= tool.parseCreditConsume(request);//利用tool来解析这个请求
			 deducted = new DuiBaDeducted();
			 deducted.setUid(params.getUid());
			 deducted.setCredits(params.getCredits());
			 deducted.setAppKey(params.getAppKey());
			 deducted.setTimestamp(params.getTimestamp().getTime() + "");
			 deducted.setDescription(new String(params.getDescription().getBytes("ISO-8859-1"), "UTF-8"));
			 deducted.setOrderNum(params.getOrderNum());
			 deducted.setType(params.getType());
			 deducted.setFacePrice(params.getFacePrice());
			 deducted.setActualPrice(params.getActualPrice());
			 deducted.setIp(params.getIp());
			 if(StringUtils.isEmpty(params.getParams())) {
				 deducted.setParams(";");
			 } else {
				 deducted.setParams(params.getParams());
			 }
			 deducted.setWaitAudit(params.isWaitAudit());
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 
		 return deducted;
	}
	/**
	* @Title: getDuiBaNotice
	* @Description: TODO(获取兑吧兑换通知)
	* @param request
	* @return
	* @author jason.peng
	* @date 2016年2月19日 上午10:44:36
	 */
	public static DuiBaNotice getDuiBaNotice(HttpServletRequest request) {
		DuiBaNotice notice = null;
		 try {
			CreditNotifyParams params= tool.parseCreditNotify(request);
			notice = new DuiBaNotice();
			notice.setAppKey(params.getAppKey());
			notice.setTimestamp(params.getTimestamp().getTime());
			notice.setSuccess(params.isSuccess());
			notice.setErrorMessage(new String(params.getErrorMessage().getBytes("ISO-8859-1"), "UTF-8"));
			notice.setOrderNum(params.getOrderNum());
			notice.setBizId(params.getBizId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return notice;
	}
	/**
	* @Title: getSuccess
	* @Description: TODO(获取成功字符串)
	* @param param
	* @return
	* @author jason.peng
	* @date 2016年2月19日 上午9:41:28
	 */
	public static String getSuccess(String param) {
		return "{'status': 'ok','errorMessage': '','bizId': '"+ param +"','credits': '100'}";
	}
	/**
	* @Title: getFailed
	* @Description: TODO(获取失败字符串)
	* @param param
	* @return
	* @author jason.peng
	* @date 2016年2月19日 上午9:41:30
	 */
	public static String getFailed(String param) {
		return "{'status': 'fail','errorMessage': '" + param + "','credits': '100'}";
	}
	
	public static void main(String[] args) {
		System.out.println(getUrl(1 + "", 1000 + "", null));
	}
}
