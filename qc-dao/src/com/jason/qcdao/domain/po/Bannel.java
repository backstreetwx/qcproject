package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;
/**
* @ClassName: Bannel
* @Description: TODO(焦点图实体)
* @author jason.peng
* @date 2016年1月8日 上午9:21:14
 */
public class Bannel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 本地打开
	 */
	public static final Integer LOCAL_OPEN_TYPE = 1;
	/**
	 * 外部浏览器打开
	 */
	public static final Integer OUTSIDE_OPEN_TYPE = 2;
	/**
	 * 其他打开
	 */
	public static final Integer OTHER_OPEN_TYPE = 3;
	/**
	 * 上架
	 */
	public static final Integer UP_STATUS = 1;
	/**
	 * 下架
	 */
	public static final Integer DOWN_STATUS = 2;

	private Integer id;

	private Integer type;

	private String title;

	private String pic;

	private String url;

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
		return "Bannel [id=" + id + ", type=" + type + ", title=" + title
				+ ", pic=" + pic + ", url=" + url + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
