package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Domain
 * @Description: TODO(域名实体)
 * @author jason.peng
 * @date 2016年1月12日 下午4:11:47
 */
public class Domain implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 上架
	 */
	public static final Integer UP_STATUS = 1;
	/**
	 * 下架
	 */
	public static final Integer DOWN_STATUS = 2;

	private Integer id;

	private String domain;

	private Integer status;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
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
		return "Domain [id=" + id + ", domain=" + domain + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
