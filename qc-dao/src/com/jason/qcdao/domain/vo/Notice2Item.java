package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Notice2Item
 * @Description: TODO(通知条目)
 * @author jason.peng
 * @date 2016年3月16日 下午2:17:27
 */
public class Notice2Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer type;

	private String title;

	private String description;

	private String pic;

	private String url;

	private Date createTime;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Notice2Item [type=" + type + ", title=" + title
				+ ", description=" + description + ", pic=" + pic + ", url="
				+ url + ", createTime=" + createTime + "]";
	}

}
