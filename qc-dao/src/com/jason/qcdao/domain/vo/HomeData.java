package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: HomeData
 * @Description: TODO(首页数据)
 * @author jason.peng
 * @date 2016年1月11日 上午8:02:53
 */
public class HomeData implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<BannelItem> bannelItems;

	private List<NoticeItem> noticeItems;

	public List<BannelItem> getBannelItems() {
		return bannelItems;
	}

	public void setBannelItems(List<BannelItem> bannelItems) {
		this.bannelItems = bannelItems;
	}

	public List<NoticeItem> getNoticeItems() {
		return noticeItems;
	}

	public void setNoticeItems(List<NoticeItem> noticeItems) {
		this.noticeItems = noticeItems;
	}

	@Override
	public String toString() {
		return "HomeData [bannelItems=" + bannelItems + ", noticeItems="
				+ noticeItems + "]";
	}

}
