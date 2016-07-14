package com.jason.qcms.domain.po;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private String username;

	private String password;

	private String salt;

	private String email;

	private String realname;

	private String phone;

	private Integer sex;

	private Date birthday;

	private Boolean locked;

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
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
				+ password + ", salt=" + salt + ", email=" + email
				+ ", realname=" + realname + ", phone=" + phone + ", sex="
				+ sex + ", birthday=" + birthday + ", locked=" + locked
				+ ", createTime=" + createTime + "]";
	}

}
