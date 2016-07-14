package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: DetailItem
 * @Description: TODO(详情条目)
 * @author jason.peng
 * @date 2016年1月7日 上午11:23:44
 */
public class DetailItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String icon;

	private String title;

	private Integer point;

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

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DetailItem [icon=" + icon + ", title=" + title + ", point="
				+ point + ", createTime=" + createTime + "]";
	}

}
