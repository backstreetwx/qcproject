package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: PacketItem
 * @Description: TODO(用户红包详情的条目)
 * @author jason.peng
 * @date 2016年3月14日 下午2:49:49
 *
 */
public class PacketItem implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final Integer DEFAULT_SIZE = 20;

	private Integer id;
	
	private String account;

	private String nickname;

	private String headimg;

	private Integer point;

	private Date pickTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Date getPickTime() {
		return pickTime;
	}

	public void setPickTime(Date pickTime) {
		this.pickTime = pickTime;
	}

	@Override
	public String toString() {
		return "PacketItem [id=" + id + ", account=" + account + ", nickname="
				+ nickname + ", headimg=" + headimg + ", point=" + point
				+ ", pickTime=" + pickTime + "]";
	}

	
}
