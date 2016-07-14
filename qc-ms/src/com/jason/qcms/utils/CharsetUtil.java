package com.jason.qcms.utils;

import java.io.UnsupportedEncodingException;

/**
* @ClassName: CodedUtil
* @Description: TODO(编码工具)
* @author jason.peng
* @date 2015年8月25日 上午8:27:16
*
 */
public final class CharsetUtil {
	/**
	* @Title: convert
	* @Description: TODO(字符编码转换)
	* @param src
	* @param charsetName1
	* @param charsetName2
	* @return
	* @author jason.peng
	* @date 2015年8月25日 上午8:30:25
	 */
	public static String convert(String src, String charsetName1, String charsetName2){
		if(src == null){
			return null;
		}
		
		String str = null;
		try {
			str = new String(src.getBytes(charsetName1), charsetName2);
		} catch (UnsupportedEncodingException e) {
			str = null;
		}
		return str;
	}
	/**
	* @Title: convert
	* @Description: TODO(字符编码转换)
	* @param src
	* @return
	* @author jason.peng
	* @date 2015年8月25日 上午8:36:14
	 */
	public static String convert(String src){
		return convert(src, "ISO-8859-1", "UTF-8");
	}
}
