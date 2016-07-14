package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Goods
 * @Description: TODO(商品实体)
 * @author jason.peng
 * @date 2016年1月7日 下午2:27:13
 */
public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 上架状态
	 */
	public static final Integer UP_STATUS = 1;
	/**
	 * 下架状态
	 */
	public static final Integer DOWN_STATUS = 2;

	private Integer id;

	private String icon;

	private String title;

	private Integer virtualPoint;

	private Integer point;

	private Integer totalNumber;

	private Integer number;

	private String description;

	private Integer status;

	private Date createTime;

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

	public Integer getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
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
		return "Goods [id=" + id + ", icon=" + icon + ", title=" + title
				+ ", virtualPoint=" + virtualPoint + ", point=" + point
				+ ", totalNumber=" + totalNumber + ", number=" + number
				+ ", description=" + description + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
