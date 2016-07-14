package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Version
 * @Description: TODO(应用版本实体)
 * @author jason.peng
 * @date 2016年1月7日 上午8:33:28
 */
public class Version implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 设备类型android
	 */
	public static final Integer ANDROID_TYPE = 1;
	/**
	 * 设备类型IOS
	 */
	public static final Integer IOS_TYPE = 2;
	/**
	 * 非强制
	 */
	public static final Integer NO_COERCE = 1;
	/**
	 * 强制
	 */
	public static final Integer YES_COERCE = 2;

	private Integer id;

	private Integer type;

	private Integer coerce;

	private String number;

	private Float size;

	private String url;

	private String description;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

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
		return "Version [id=" + id + ", type=" + type + ", coerce=" + coerce
				+ ", number=" + number + ", size=" + size + ", url=" + url
				+ ", description=" + description + ", createTime=" + createTime
				+ "]";
	}

}
