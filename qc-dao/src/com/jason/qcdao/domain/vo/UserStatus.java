package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: UserStatus
 * @Description: TODO(用户的登录获取授权状态信息)
 * @author jason.peng
 * @date 2016年1月6日 下午7:04:22
 */
public class UserStatus implements Serializable {

	private static final long serialVersionUID = 1L;

	private String hashId;

	private String account;

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "UserStatus [hashId=" + hashId + ", account=" + account + "]";
	}

}
