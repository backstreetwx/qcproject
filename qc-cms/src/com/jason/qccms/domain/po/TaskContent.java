package com.jason.qccms.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TaskContent
 * @Description: TODO(任务内容实体)
 * @author jason.peng
 * @date 2016年1月8日 上午10:33:29
 */
public class TaskContent implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 微信地址
	 */
	public static final Integer WEIXIN_URL_TYPE = 0;
	/**
	 * 地址
	 */
	public static final Integer URL_TYPE = 1;
	/**
	 * 文章
	 */
	public static final Integer ARTICLE_TYPE = 2;

	private Integer id;

	private Integer taskId;

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

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
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
		return "TaskContent [id=" + id + ", taskId=" + taskId + ", type="
				+ type + ", url=" + url + ", content=" + content
				+ ", createTime=" + createTime + "]";
	}

}
