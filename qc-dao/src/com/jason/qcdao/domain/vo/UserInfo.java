package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: UserInfo
 * @Description: TODO(用户信息)
 * @author jason.peng
 * @date 2016年1月7日 上午10:55:56
 */
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer type;

	private String account;

	private Integer inviteId;

	private String headimg;

	private String nickname;

	private Integer sex;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", type=" + type + ", account=" + account
				+ ", inviteId=" + inviteId + ", headimg=" + headimg
				+ ", nickname=" + nickname + ", sex=" + sex + "]";
	}

}
