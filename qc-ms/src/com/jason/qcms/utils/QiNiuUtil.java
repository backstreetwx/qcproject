package com.jason.qcms.utils;

import com.qiniu.util.Auth;

public final class QiNiuUtil {

	private static final String ACCESS_KEY = "x_hUIKP0c9hn5vD5LV21OZaN-2NbArhuka2MNyRd";
	
	private static final String SECRET_KEY = "strQUp75FunCkh5PRffO6_Tg1mKqum3_5s9fmDg5";
	
	private static final Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
	
	/**
	* @Title: getToken
	* @Description: TODO(获取令牌)
	* @return
	* @author jason.peng
	* @date 2015年11月19日 上午5:28:06
	 */
	public static String getToken() {
		 return auth.uploadToken("yabao");
	}
	
}
