package com.jason.qccms.domain.vo;

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

	private String icon;

	private String title;

	private String subTitle;

	private Integer point;

	private Integer limitRead;

	private Integer shareCount;

	private Integer readCount;

	private Integer readPoint;

	private Integer status;

	private Date createTime;

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

}
