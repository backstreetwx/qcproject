package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: BannelItem
 * @Description: TODO(焦点图条目)
 * @author jason.peng
 * @date 2016年1月11日 上午8:02:48
 */
public class BannelItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer type;

	private String title;

	private String pic;

	private String url;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BannelItem [type=" + type + ", title=" + title + ", pic=" + pic
				+ ", url=" + url + "]";
	}
}
