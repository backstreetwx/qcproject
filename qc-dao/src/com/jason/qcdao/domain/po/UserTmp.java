package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserTmp
 * @Description: TODO(用户临时实体，保存的数据库变化比较大)
 * @author jason.peng
 * @date 2016年1月8日 上午10:38:33
 */
public class UserTmp implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String hashId;

	private Integer onePoint;

	private Integer twoPoint;

	private Integer threePoint;

	private Integer fourPoint;

	private Integer fivePoint;

	private Integer sixPoint;

	private Integer severPoint;

	private Integer taskPoint;

	private Integer taskCount;

	private Integer taskRead;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public Integer getOnePoint() {
		return onePoint;
	}

	public void setOnePoint(Integer onePoint) {
		this.onePoint = onePoint;
	}

	public Integer getTwoPoint() {
		return twoPoint;
	}

	public void setTwoPoint(Integer twoPoint) {
		this.twoPoint = twoPoint;
	}

	public Integer getThreePoint() {
		return threePoint;
	}

	public void setThreePoint(Integer threePoint) {
		this.threePoint = threePoint;
	}

	public Integer getFourPoint() {
		return fourPoint;
	}

	public void setFourPoint(Integer fourPoint) {
		this.fourPoint = fourPoint;
	}

	public Integer getFivePoint() {
		return fivePoint;
	}

	public void setFivePoint(Integer fivePoint) {
		this.fivePoint = fivePoint;
	}

	public Integer getSixPoint() {
		return sixPoint;
	}

	public void setSixPoint(Integer sixPoint) {
		this.sixPoint = sixPoint;
	}

	public Integer getSeverPoint() {
		return severPoint;
	}

	public void setSeverPoint(Integer severPoint) {
		this.severPoint = severPoint;
	}

	public Integer getTaskPoint() {
		return taskPoint;
	}

	public void setTaskPoint(Integer taskPoint) {
		this.taskPoint = taskPoint;
	}

	public Integer getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Integer taskCount) {
		this.taskCount = taskCount;
	}

	public Integer getTaskRead() {
		return taskRead;
	}

	public void setTaskRead(Integer taskRead) {
		this.taskRead = taskRead;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserTmp [id=" + id + ", hashId=" + hashId + ", onePoint="
				+ onePoint + ", twoPoint=" + twoPoint + ", threePoint="
				+ threePoint + ", fourPoint=" + fourPoint + ", fivePoint="
				+ fivePoint + ", sixPoint=" + sixPoint + ", severPoint="
				+ severPoint + ", taskPoint=" + taskPoint + ", taskCount="
				+ taskCount + ", taskRead=" + taskRead + ", createTime="
				+ createTime + "]";
	}

}
