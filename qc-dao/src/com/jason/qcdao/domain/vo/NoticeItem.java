package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: NoticeItem
 * @Description: TODO(通知条目)
 * @author jason.peng
 * @date 2016年1月11日 上午8:04:27
 *
 */
public class NoticeItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;

	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "NoticeItem [title=" + title + ", content=" + content + "]";
	}

}