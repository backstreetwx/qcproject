package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Order
 * @Description: TODO(订单实体)
 * @author jason.peng
 * @date 2016年3月18日 上午9:59:17
 *
 */
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 支付宝
	 */
	public static final Integer TYPE_ALIPAY = 1;
	/**
	 * 话费
	 */
	public static final Integer TYPE_PHONE = 2;
	/**
	 * 上架
	 */
	public static final Integer UP_STATUS = 1;
	/**
	 * 下架
	 */
	public static final Integer DOWN_STATUS = 2;
	private Integer id;

	private Integer type;

	private String icon;

	private String title;

	private Integer point;

	private String description;

	private Integer status;

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
		return "Order [id=" + id + ", type=" + type + ", icon=" + icon
				+ ", title=" + title + ", point=" + point + ", description="
				+ description + ", status=" + status + ", createTime="
				+ createTime + "]";
	}

}
