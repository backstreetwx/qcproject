package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

public class UserOrder2 implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 支付宝
	 */
	public static final int TYPE_ALIPAY = 1;
	/**
	 * 话费
	 */
	public static final int TYPE_PHONE = 2;

	/**
	 * 未处理
	 */
	public static final int UNTREATED_STATUS = 0;
	/**
	 * 已审核
	 */
	public static final int VERIFY_STATUS = 1;
	/**
	 * 已处理
	 */
	public static final int PROCESSED_STATUS = 2;
	/**
	 * 异常订单
	 */
	public static final int EXCEPTION_STATUS = 3;

	private Integer id;

	private String orderId;

	private String hashId;

	private Integer type;

	private String icon;

	private String title;

	private Integer point;

	private String params;

	private Integer status;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
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

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
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
		return "UserOrder2 [id=" + id + ", orderId=" + orderId + ", hashId="
				+ hashId + ", type=" + type + ", icon=" + icon + ", title="
				+ title + ", point=" + point + ", params=" + params
				+ ", status=" + status + ", createTime=" + createTime + "]";
	}

}
