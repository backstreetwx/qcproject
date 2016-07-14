package com.jason.qcdao.mapper;

import java.util.List;

import com.jason.qcdao.domain.vo.NoticeItem;

/**
* @ClassName: NoticeMapper
* @Description: TODO(通知实体数据库访问接口)
* @author jason.peng
* @date 2016年1月8日 上午9:27:24
 */
public interface NoticeMapper {
	/**
	* @Title: getNotices
	* @Description: TODO(获取通知)
	* @return
	* @author jason.peng
	* @date 2016年1月11日 上午8:13:00
	 */
	public List<NoticeItem> getNotices();

}
