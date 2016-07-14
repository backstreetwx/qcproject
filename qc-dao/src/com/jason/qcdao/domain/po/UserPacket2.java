package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserPacket2
 * @Description: TODO(红包实体)
 * @author jason.peng
 * @date 2016年3月15日 上午7:57:18
 */
public class UserPacket2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String orderId;

	private String hashId;

	private Integer point;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserPacket2 [id=" + id + ", orderId=" + orderId + ", hashId="
				+ hashId + ", point=" + point + ", createTime=" + createTime
				+ "]";
	}

}
