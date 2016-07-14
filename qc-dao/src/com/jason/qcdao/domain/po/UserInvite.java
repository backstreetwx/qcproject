package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserInvite
 * @Description: TODO(用户邀请记录实体)
 * @author jason.peng
 * @date 2016年1月7日 上午9:02:38
 *
 */
public class UserInvite implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String byHashId;

	private String hashId;

	private Integer point;

	private Integer status;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getByHashId() {
		return byHashId;
	}

	public void setByHashId(String byHashId) {
		this.byHashId = byHashId;
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
		return "UserInvite [id=" + id + ", byHashId=" + byHashId + ", hashId="
				+ hashId + ", point=" + point + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
