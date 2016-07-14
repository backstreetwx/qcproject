package com.jason.qcdao.domain.vo;

import java.io.Serializable;

public class TaskRead implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer limitRead;

	private Integer readCount;

	private Integer point;

	private Integer status;

	public Integer getLimitRead() {
		return limitRead;
	}

	public void setLimitRead(Integer limitRead) {
		this.limitRead = limitRead;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
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

	@Override
	public String toString() {
		return "TaskRead [limitRead=" + limitRead + ", readCount=" + readCount
				+ ", point=" + point + ", status=" + status + "]";
	}

}
