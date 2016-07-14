package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Notice
 * @Description: TODO(通知实体)
 * @author jason.peng
 * @date 2016年1月8日 上午9:24:09
 */
public class Notice implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String title;

	private String content;

	private Integer status;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Notice [id=" + id + ", title=" + title + ", content=" + content
				+ ", status=" + status + ", createTime=" + createTime + "]";
	}

}
