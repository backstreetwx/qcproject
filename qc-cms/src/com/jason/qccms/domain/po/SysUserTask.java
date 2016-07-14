package com.jason.qccms.domain.po;

import java.io.Serializable;
import java.util.Date;

public class SysUserTask implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer sysUserId;

	private Integer taskId;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSysUserId() {
		return sysUserId;
	}

	public void setSysUserId(Integer sysUserId) {
		this.sysUserId = sysUserId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysUserTask [id=" + id + ", sysUserId=" + sysUserId
				+ ", taskId=" + taskId + ", createTime=" + createTime + "]";
	}

}
