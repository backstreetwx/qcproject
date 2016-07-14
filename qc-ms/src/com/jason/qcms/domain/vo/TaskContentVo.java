package com.jason.qcms.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: TaskContent
 * @Description: TODO(任务内容实体)
 * @author jason.peng
 * @date 2016年1月8日 上午10:33:29
 */
public class TaskContentVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer type;

	private String url;

	private String content;

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

	@Override
	public String toString() {
		return "TaskContentVo [type=" + type + ", url=" + url + ", content="
				+ content + "]";
	}

}
