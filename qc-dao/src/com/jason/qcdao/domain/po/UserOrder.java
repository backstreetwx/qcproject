package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserOrder
 * @Description: TODO(用户的订单)
 * @author jason.peng
 * @date 2016年1月7日 下午2:32:19
 */
public class UserOrder implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 未处理
	 */
	public static final Integer UNTREATED_STATUS = 0;
	/**
	 * 已审核
	 */
	public static final Integer VERIFY_STATUS = 1;
	/**
	 * 已处理
	 */
	public static final Integer PROCESSED_STATUS = 2;
	/**
	 * 异常订单
	 */
	public static final Integer EXCEPTION_STATUS = 3;

	private Long id;

	private String hashId;

	private String orderId;

	private String type;

	private String icon;

	private String title;

	private String params;

	private Integer point;

	private Integer status;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
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

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
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
		return "UserOrder [id=" + id + ", hashId=" + hashId + ", orderId="
				+ orderId + ", type=" + type + ", icon=" + icon + ", title="
				+ title + ", params=" + params + ", point=" + point
				+ ", status=" + status + ", createTime=" + createTime + "]";
	}

}
