package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: TaskRecordItem
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2016年1月8日 上午11:52:15
 */
public class UserTaskItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String icon;

	private String title;

	private Date finishTime;

	private Date createTime;

	private Integer readPoint;

	private Integer readCount;

	private Integer status;

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

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	@Override
	public String toString() {
		return "UserTaskItem [icon=" + icon + ", title=" + title
				+ ", finishTime=" + finishTime + ", createTime=" + createTime
				+ ", readPoint=" + readPoint + ", readCount=" + readCount
				+ ", status=" + status + "]";
	}

}
