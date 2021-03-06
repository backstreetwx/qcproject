package com.jason.qcms.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Task
 * @Description: TODO(任务实体)
 * @author jason.peng
 * @date 2016年1月8日 上午10:27:26
 */
public class TaskVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer type;

	private String icon;

	private String title;

	private String subTitle;

	private Integer point;

	private Integer limitRead;

	private Integer shareCount;

	private Integer readCount;

	private Integer readPoint;

	private Date startTime;

	private Date finishTime;

	private Integer sequence;

	private Integer status;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getLimitRead() {
		return limitRead;
	}

	public void setLimitRead(Integer limitRead) {
		this.limitRead = limitRead;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getReadPoint() {
		return readPoint;
	}

	public void setReadPoint(Integer readPoint) {
		this.readPoint = readPoint;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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
		return "TaskVo [id=" + id + ", type=" + type + ", icon=" + icon
				+ ", title=" + title + ", subTitle=" + subTitle + ", point="
				+ point + ", limitRead=" + limitRead + ", shareCount="
				+ shareCount + ", readCount=" + readCount + ", readPoint="
				+ readPoint + ", startTime=" + startTime + ", finishTime="
				+ finishTime + ", sequence=" + sequence + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
