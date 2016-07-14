package com.jason.qccore.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Random;

import com.cloopen.rest.sdk.CCPRestSDK;

/**
 * @ClassName: CCPUtils
 * @Description: TODO(云通信工具类)
 * @author jason.peng
 * @date 2016年1月6日 下午1:28:15
 */
public final class CCPUtils {

	private static final String ACCOUNT_SID = "aaf98f894b0b8616014b11c8d76903ae";

	private static final String AUTH_TOKEN = "40916a7c75b24b15ba7eb404068bbf80";

	private static final String APP_ID = "8a48b55152114d540152151dd0fd06cd";

	private static final String PRODUCTION_SERVER_IP = "app.cloopen.com";

	private static final String SEVER_PORT = "8883";

	private static final String TEMPLATE_ID = "60474";

	private static final Integer VALIDATE_CODE_LENGTH = 6;

	/**
	 * @Title: init
	 * @Description: TODO(初始化CCP)
	 * @return
	 * @author jason.peng
	 * @date 2016年1月6日 下午1:54:00
	 */
	private static CCPRestSDK init() {
		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init(PRODUCTION_SERVER_IP, SEVER_PORT);
		restAPI.setAccount(ACCOUNT_SID, AUTH_TOKEN);
		restAPI.setAppId(APP_ID);
		return restAPI;
	}

	/**
	 * @Title: createSerial
	 * @Description: TODO(创建一个随机序列)
	 * @param num
	 * @param chars
	 * @return
	 * @author jason.peng
	 * @date 2015年7月21日 下午3:04:55
	 */
	private static String createSerial(int num, char[] chars) {
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < num; i++) {
			sb.append(chars[random.nextInt(chars.length)]);
		}
		return sb.toString();
	}

	/**
	 * @Title: createNumberSerial
	 * @Description: TODO(创建一个数字序列)
	 * @param num
	 * @return
	 * @author jason.peng
	 * @date 2015年7月21日 下午3:08:01
	 */
	private static String createNumberSerial(int num) {
		// 字符数组
		char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		// 随机数
		return createSerial(num, chars);
	}

	/**
	 * @Title: sendSMS
	 * @Description: TODO(发送SMS)
	 * @param to
	 * @param templateId
	 * @param datas
	 * @return
	 * @author jason.peng
	 * @date 2016年1月6日 下午1:54:15
	 */
	public static CCPResult sendSMS(String to) {
		HashMap<String, Object> hashMap = null;
		String code = createNumberSerial(VALIDATE_CODE_LENGTH);
		hashMap = init().sendTemplateSMS(to, TEMPLATE_ID, new String[] { code });
		CCPResult result = new CCPResult();
		if ("000000".equals(hashMap.get("statusCode"))) {
			result.setStatus(true);
			result.setMsg(code);
		} else {
			result.setStatus(false);
			result.setMsg(hashMap.get("statusMsg").toString());
		}
		return result;
	}

	/**
	 * @ClassName: CCPResult
	 * @Description: TODO(SMS返回的接口)
	 * @author jason.peng
	 * @date 2016年1月6日 下午2:14:55
	 */
	public static class CCPResult implements Serializable {

		private static final long serialVersionUID = 1L;

		private boolean status;

		private String msg;

		public boolean isStatus() {
			return status;
		}

		public void setStatus(boolean status) {
			this.status = status;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		@Override
		public String toString() {
			return "CCPResult [status=" + status + ", msg=" + msg + "]";
		}

	}
}
