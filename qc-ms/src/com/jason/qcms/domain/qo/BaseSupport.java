package com.jason.qcms.domain.qo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName: BaseSupport
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2016年2月29日 上午8:07:02
 */
public abstract class BaseSupport {

	private Integer pageIndex = 1;

	private Integer pageSize = 20;

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getStart() {
		return (pageIndex- 1) * pageSize;
	}

	public Integer getOffset(){
		return pageSize;
	}

	/**
	 * @Title: getObject
	 * @Description: TODO(获取子类对象)
	 * @param baseSupport
	 * @author jason.peng
	 * @date 2016年2月29日 上午8:32:22
	 */
	public abstract BaseSupport getObject();

	/**
	 * @Title: getQueryString
	 * @Description: TODO(获取查询字符串)
	 * @return
	 * @author jason.peng
	 * @date 2016年2月29日 上午8:31:36
	 */
	public String getQueryString() {
		try {
			BaseSupport son = getObject();
			StringBuffer sb = new StringBuffer();
			Class<? extends BaseSupport> clazz = son.getClass();
			Field[] fields = clazz.getDeclaredFields();
			for (Field field : fields) {
				String name = field.getName();
				Method method = clazz.getDeclaredMethod("get"
						+ toFirstLowerCase(name));
				Object value = method.invoke(son);
				sb.append(name).append("=").append(value == null ? "" : value)
						.append("&");
			}
			if (sb.length() > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			return sb.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @Title: toFirstLowerCase
	 * @Description: TODO(将单词首字母变为大写)
	 * @param para
	 * @return
	 * @author jason.peng
	 * @date 2015年8月7日 上午10:21:50
	 */
	private String toFirstLowerCase(String para) {
		if (para == null) {
			return para;
		}
		return para.replaceFirst(para.substring(0, 1), para.substring(0, 1)
				.toUpperCase());
	}
}
