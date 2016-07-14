package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: TaskContent
 * @Description: TODO(任务内容)
 * @author jason.peng
 * @date 2016年1月12日 上午10:56:17
 */
public class WatchTaskContent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer type;

	private String url;

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

	@Override
	public String toString() {
		return "WatchTaskContent [type=" + type + ", url=" + url + "]";
	}

}
