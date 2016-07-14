package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: ReadTaskContent
 * @Description: TODO(阅读任务内容)
 * @author jason.peng
 * @date 2016年1月12日 下午2:51:56
 */
public class ReadTaskContent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private Integer readCount;

	private Integer type;

	private String url;

	private String content;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ReadTaskContent [id=" + id + ", title=" + title
				+ ", readCount=" + readCount + ", type=" + type + ", url="
				+ url + ", content=" + content + ", createTime=" + createTime
				+ "]";
	}

}
