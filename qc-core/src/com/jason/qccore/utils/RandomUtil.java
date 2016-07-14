package com.jason.qccore.utils;

import java.util.Random;
/**
* @ClassName: RandomUtil
* @Description: TODO(随机序列工具)
* @author jason.peng
* @date 2015年7月21日 下午3:09:44
*/
public final class RandomUtil {
	/**
	 * 全局的Random对象
	 */
	private static final Random random = new Random();
	/**
	* @Title: getRandom
	* @Description: TODO(获取一个Random对象)
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午10:24:58
	 */
	public static Random getRandom() {
		return random;
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
	public static String createNumberSerial(int num){
		// 字符数组
		char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		// 随机数
		return createSerial(num, chars);
	}

	/**
	* @Title: createCharacterSerial
	* @Description: TODO(创建一个字符串序列)
	* @param num
	* @return
	* @author jason.peng
	* @date 2015年7月21日 下午3:08:18
	*/
	public static String createCharacterSerial(int num){
		// 字符数组
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 
						 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
						 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
						 'y', 'z' };
		// 随机数
		return createSerial(num, chars);
	}
	/**
	* @Title: createMergeSerial
	* @Description: TODO(创建一个混合序列)
	* @param num
	* @return
	* @author jason.peng
	* @date 2015年7月21日 下午3:08:39
	*/
	public static String createMergeSerial(int num){
		// 字符数组
		char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a',
				'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
				'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		// 随机数
		return createSerial(num, chars);
	}
}
