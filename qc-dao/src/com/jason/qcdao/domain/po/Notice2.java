package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Notice2
 * @Description: TODO(通知实体)
 * @author jason.peng
 * @date 2016年3月16日 下午1:58:05
 */
public class Notice2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer type;

	private String title;

	private String pic;

	private String url;

	private String description;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "Notice2 [id=" + id + ", type=" + type + ", title=" + title
				+ ", pic=" + pic + ", url=" + url + ", description="
				+ description + ", status=" + status + ", createTime="
				+ createTime + "]";
	}

}
