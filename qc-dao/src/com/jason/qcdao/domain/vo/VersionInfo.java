package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Version
 * @Description: TODO(应用版本实体)
 * @author jason.peng
 * @date 2016年1月7日 上午8:33:28
 */
public class VersionInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer coerce;

	private String number;

	private Float size;

	private String url;

	private String description;

	private Date createTime;

	public Integer getCoerce() {
		return coerce;
	}

	public void setCoerce(Integer coerce) {
		this.coerce = coerce;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Float getSize() {
		return size;
	}

	public void setSize(Float size) {
		this.size = size;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Version [coerce=" + coerce + ", number=" + number + ", size="
				+ size + ", url=" + url + ", description=" + description
				+ ", createTime=" + createTime + "]";
	}

}
