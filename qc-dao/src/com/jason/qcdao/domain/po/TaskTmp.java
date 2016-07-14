package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TaskTmp
 * @Description: TODO(任务临时实体)
 * @author jason.peng
 * @date 2016年2月22日 下午4:39:40
 *
 */
public class TaskTmp implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String hashFinger;

	private Integer userId;

	private Integer taskId;

	private String finger;

	private String ip;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashFinger() {
		return hashFinger;
	}

	public void setHashFinger(String hashFinger) {
		this.hashFinger = hashFinger;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getFinger() {
		return finger;
	}

	public void setFinger(String finger) {
		this.finger = finger;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "TaskTmp [id=" + id + ", hashFinger=" + hashFinger + ", userId="
				+ userId + ", taskId=" + taskId + ", finger=" + finger
				+ ", ip=" + ip + ", createTime=" + createTime + "]";
	}

}
