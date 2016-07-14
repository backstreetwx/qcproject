package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: TaskShare
 * @Description: TODO(获取分享的信息)
 * @author jason.peng
 * @date 2016年1月12日 下午4:52:07
 *
 */
public class TaskShare implements Serializable {

	private static final long serialVersionUID = 1L;

	private String icon;

	private String title;

	private String subTitle;

	private String url;

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "TaskShare [icon=" + icon + ", title=" + title + ", subTitle="
				+ subTitle + ", url=" + url + "]";
	}

}
