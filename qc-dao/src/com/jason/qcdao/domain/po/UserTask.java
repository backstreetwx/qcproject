package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserTask
 * @Description: TODO(用户任务记录实体)
 * @author jason.peng
 * @date 2016年1月8日 上午10:35:56
 *
 */
public class UserTask implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String orderId;

	private String hashId;

	private Integer taskId;

	private Integer readPoint;

	private Integer readCount;

	private Integer status;

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

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getReadPoint() {
		return readPoint;
	}

	public void setReadPoint(Integer readPoint) {
		this.readPoint = readPoint;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
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
		return "UserTask [id=" + id + ", orderId=" + orderId + ", hashId="
				+ hashId + ", taskId=" + taskId + ", readPoint=" + readPoint
				+ ", readCount=" + readCount + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
