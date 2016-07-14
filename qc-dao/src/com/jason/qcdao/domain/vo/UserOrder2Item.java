package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserOrderItem
 * @Description: TODO(用户订单记录条目)
 * @author jason.peng
 * @date 2016年1月7日 下午5:25:30
 */
public class UserOrder2Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer type;

	private String icon;

	private String title;

	private String params;

	private Integer point;

	private Integer status;

	private Date createTime;

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
		return "UserOrder2Item [type=" + type + ", icon=" + icon + ", title="
				+ title + ", params=" + params + ", point=" + point
				+ ", status=" + status + ", createTime=" + createTime + "]";
	}

}
