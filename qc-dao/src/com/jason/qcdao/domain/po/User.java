package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: User
 * @Description: TODO(用户持久化对象)
 * @author jason.peng
 * @date 2016年1月6日 上午7:44:36
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 未知授权
	 */
	public static final Integer UNKNOWN_TYPE = 0;
	/**
	 * 微信授权
	 */
	public static final Integer WX_TYPE = 1;
	/**
	 * qq授权
	 */
	public static final Integer QQ_TYPE = 2;
	/**
	 * 未知
	 */
	public static final Integer UNKNOWN_SEX = 0;
	/**
	 * 男
	 */
	public static final Integer MAN_SEX = 1;
	/**
	 * 女
	 */
	public static final Integer WOMAN_SEX = 2;
	/**
	 * 未锁定
	 */
	public static final Integer UNLOCKED_STATUS = 0;
	/**
	 * 锁定
	 */
	public static final Integer LOCKED_STATUS = 1;

	public static final String HEADIMG_DEFAULT = "http://7xo77v.com2.z0.glb.qiniucdn.com/header_moren.png";

	private Integer id;

	private String hashId;

	private String account;

	private String password;

	private String salt;

	private Integer inviteId;

	private Integer type;

	private String openId;

	private String headimg;

	private String nickname;

	private Integer sex;

	private Float rate;

	private Integer status;

	private Date createTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
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

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
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
		return "User [id=" + id + ", hashId=" + hashId + ", account=" + account
				+ ", password=" + password + ", salt=" + salt + ", inviteId="
				+ inviteId + ", type=" + type + ", openId=" + openId
				+ ", headimg=" + headimg + ", nickname=" + nickname + ", sex="
				+ sex + ", rate=" + rate + ", status=" + status
				+ ", createTime=" + createTime + "]";
	}

}
