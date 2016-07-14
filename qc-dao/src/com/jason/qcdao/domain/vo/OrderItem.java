package com.jason.qcdao.domain.vo;

import java.io.Serializable;

public class OrderItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer type;

	private String icon;

	private String title;

	private Integer point;

	private String description;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

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

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "OrderItem [type=" + type + ", icon=" + icon + ", title="
				+ title + ", point=" + point + ", description=" + description
				+ "]";
	}

}
