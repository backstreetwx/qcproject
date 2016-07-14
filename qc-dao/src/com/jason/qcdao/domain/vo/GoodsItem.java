package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: GoodsItem
 * @Description: TODO(商品条目)
 * @author jason.peng
 * @date 2016年1月7日 下午2:45:22
 */
public class GoodsItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String icon;

	private String title;

	private Integer virtualPoint;

	private Integer point;

	private Integer number;

	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getVirtualPoint() {
		return virtualPoint;
	}

	public void setVirtualPoint(Integer virtualPoint) {
		this.virtualPoint = virtualPoint;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "GoodsItem [id=" + id + ", icon=" + icon + ", title=" + title
				+ ", virtualPoint=" + virtualPoint + ", point=" + point
				+ ", number=" + number + ", description=" + description + "]";
	}

}
