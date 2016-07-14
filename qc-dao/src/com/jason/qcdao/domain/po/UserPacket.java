package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Packet
 * @Description: TODO(红包实体)
 * @author jason.peng
 * @date 2016年1月7日 上午9:45:32
 */
public class UserPacket implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String hashId;

	private Integer point;

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
		return "Packet [id=" + id + ", hashId=" + hashId + ", point=" + point
				+ ", createTime=" + createTime + "]";
	}

}
