package com.jason.qccms.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: SysUser
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author jason.peng
 * @date 2016年3月8日 下午1:45:40
 */
public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Integer LOCK_NO = 0;
	
	public static final Integer LOCK_YES = 1;

	private Integer id;

	private String username;

	private String password;

	private String phone;

	private String qq;

	private String wx;

	private String email;

	private String remark;

	private Integer lock;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getLock() {
		return lock;
	}

	public void setLock(Integer lock) {
		this.lock = lock;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password="
				+ password + ", phone=" + phone + ", qq=" + qq + ", wx=" + wx
				+ ", email=" + email + ", remark=" + remark + ", lock=" + lock
				+ ", createTime=" + createTime + "]";
	}

}
