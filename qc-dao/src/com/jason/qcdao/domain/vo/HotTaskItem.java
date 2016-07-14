package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: HotTaskItem
 * @Description: TODO(热门任务条目)
 * @author jason.peng
 * @date 2016年1月8日 下午2:03:36
 */
public class HotTaskItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long tmpId;

	private Integer id;

	private String icon;

	private String title;

	private String subTitle;

	private Integer point;

	private Integer limitRead;

	private Integer readCount;

	private Integer shareCount;

	private Integer status;

	public Long getTmpId() {
		return tmpId;
	}

	public void setTmpId(Long tmpId) {
		this.tmpId = tmpId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}

	public Integer getShareCount() {
		return shareCount;
	}

	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "HotTaskItem [tmpId=" + tmpId + ", id=" + id + ", icon=" + icon
				+ ", title=" + title + ", subTitle=" + subTitle + ", point="
				+ point + ", limitRead=" + limitRead + ", readCount="
				+ readCount + ", shareCount=" + shareCount + ", status="
				+ status + "]";
	}

}
