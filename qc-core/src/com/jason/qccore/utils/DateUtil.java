package com.jason.qccore.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
* @ClassName: DateUtil
* @Description: TODO(日期工具类)
* @author jason.peng
* @date 2015年7月20日 下午6:10:58
*/
public final class DateUtil {
	/**
	* @ClassName: direction
	* @Description: TODO(方向枚举)
	* @author jason.peng
	* @date 2015年7月20日 下午6:26:28
	*/
	public enum Direction {
		/**
		 * 正向
		 */
		plus(1),
		/**
		 * 负向
		 */
		minus(-1);
		
		public final Integer value;
		
		private Direction(Integer value){
			this.value = value;
		}
	}
	
	public enum DateTime {
		/**
		 * 年
		 */
		YEAR(1),
		/**
		 * 月
		 */
		MONTH(2),
		/**
		 * 日
		 */
		DAY(3),
		/**
		 * 时
		 */
		HOUR(4),
		/**
		 * 分
		 */
		MINUTE(5),
		/**
		 * 秒
		 */
		SECOND(6);
		
		public final Integer value;
		
		private DateTime(Integer value){
			this.value = value;
		}
	}
	/**
	* @Title: OffsetDate
	* @Description: TODO(偏移日期)
	* @param current
	* @param direction
	* @param offset
	* @return
	* @author jason.peng
	* @date 2015年7月20日 下午6:28:30
	*/
	public static Date OffsetDate(Date current,Direction direction, Integer offset){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(current);
		calendar.add(Calendar.DAY_OF_MONTH, direction.value * offset);
		return calendar.getTime(); 
	}
	/**
	* @Title: plusDate
	* @Description: TODO(正向偏移日期)
	* @param current
	* @param offset
	* @return
	* @author jason.peng
	* @date 2015年7月20日 下午6:28:52
	*/
	public static Date plusDate(Date current, Integer offset){
		return OffsetDate(current, Direction.plus, offset);
	}
	/**
	* @Title: minusDate
	* @Description: TODO(负向偏移日期)
	* @param current
	* @param offset
	* @return
	* @author jason.peng
	* @date 2015年7月20日 下午6:29:13
	*/
	public static Date minusDate(Date current, Integer offset){
		return OffsetDate(current, Direction.minus, offset);
	}
	/**
	* @Title: DateToString
	* @Description: TODO(日期转换成指定格式的字符串)
	* @param date
	* @param pattern
	* @return
	* @author jason.peng
	* @date 2015年7月20日 下午6:32:05
	 */
	public static String DateToString(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}
	/**
	* @Title: DateToString
	* @Description: TODO(日期转换成yyyy-MM-dd格式的字符串)
	* @param date
	* @return
	* @author jason.peng
	* @date 2015年7月20日 下午6:32:57
	*/
	public static String DateToString(Date date){
		return DateToString(date, "yyyy-MM-dd");
	}
	/**
	* @Title: DateToDate
	* @Description: TODO(将日期转换为一定格式的日期)
	* @param date
	* @param pattern
	* @return
	* @author jason.peng
	* @date 2015年8月17日 上午11:02:56
	 */
	public static Date DateToDate(Date date, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			
		}
		return null;
	}
	/**
	* @Title: DateToDate
	* @Description: TODO(将日期转换为yyyy-MM-dd的日期)
	* @param date
	* @return
	* @author jason.peng
	* @date 2015年8月17日 上午11:04:36
	 */
	public static Date DateToDate(Date date){
		return DateToDate(date, "yyyy-MM-dd");
	}
	/**
	* @Title: StringToDate
	* @Description: TODO(将字符串转化成日期)
	* @param str
	* @param pattern
	* @return
	* @author jason.peng
	* @date 2015年8月14日 下午4:16:09
	*/
	public static Date stringToDate(String str, String pattern){
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(str);
		} catch (ParseException e) {
			
		}
		return null;
	}
	/**
	* @Title: StringToDate
	* @Description: TODO(将字符串转化成yyyy-MM-dd格式日期)
	* @param str
	* @return
	* @author jason.peng
	* @date 2015年8月14日 下午4:16:55
	*/
	public static Date stringToDate(String str){
		return stringToDate(str, "yyyy-MM-dd");
	}
	
	/**
	* @Title: equalsDate
	* @Description: TODO(判断两个日期是否相等，不包含时间对比)
	* @param date1
	* @param date2
	* @return
	* @author jason.peng
	* @date 2015年8月14日 上午9:45:08
	*/
	public static Boolean equalsDate(Date date1, Date date2){
		return DateToString(date1).equals(DateToString(date2));
	}
	/**
	* @Title: DateDiff
	* @Description: TODO(计算两个日期相差多少天)
	* @param date1
	* @param date2
	* @return
	* @author jason.peng
	* @date 2015年8月14日 下午4:26:28
	*/
	public static Integer dateDiffOfDay(Date date1, Date date2){
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			date1 = sdf.parse(sdf.format(date1)); 
			date2 = sdf.parse(sdf.format(date2)); 
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(date1); 
			long time1 = cal.getTimeInMillis(); 
			cal.setTime(date2); 
			long time2 = cal.getTimeInMillis(); 
			return (int) ((time1-time2)/(1000*3600*24)); 
		} catch (Exception e) {
			
		} 
		return null;
	}
	/**
	* @Title: DateDiffSecond
	* @Description: TODO(计算两个日期相差多少毫秒)
	* @param date1
	* @param date2
	* @return
	* @author jason.peng
	* @date 2015年9月3日 下午9:13:24
	 */
	public static Integer dateDiffMillis(Date date1, Date date2) {
		try {
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(date1); 
			long time1 = cal.getTimeInMillis(); 
			cal.setTime(date2); 
			long time2 = cal.getTimeInMillis(); 
			return (int) (time1-time2);
		} catch (Exception e) {
			
		} 
		return null;
	}
	/**
	* @Title: TimeScope
	* @Description: TODO(判断某个时间是否在某个区间内)
	* @param start
	* @param end
	* @param date
	* @return
	* @author jason.peng
	* @date 2015年9月2日 下午12:16:57
	 */
	public static Boolean timeScope(String start, String end, Date date){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			Long startTime = sdf.parse(start).getTime();
			Long endTime = sdf.parse(end).getTime();
			Long time = sdf.parse(sdf.format(date)).getTime();
			if(time >= startTime && time <= endTime){
				return true;
			}
		} catch (Exception e) {
			
		}
		return false;
	}
	
	public static Integer get(Date date, DateTime dateTime){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if(DateTime.YEAR == dateTime){
			return c.get(Calendar.YEAR);
		}
		if(DateTime.MONTH == dateTime){
			return c.get(Calendar.MONTH);
		}
		if(DateTime.DAY == dateTime){
			return c.get(Calendar.DATE);
		}
		if(DateTime.HOUR == dateTime){
			return c.get(Calendar.HOUR_OF_DAY);
		}
		if(DateTime.MINUTE == dateTime){
			return c.get(Calendar.MINUTE);
		}
		if(DateTime.SECOND == dateTime){
			return c.get(Calendar.SECOND);
		}
		return null;
	}
	
}
