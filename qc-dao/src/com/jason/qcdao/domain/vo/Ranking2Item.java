package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: Ranking2Item
 * @Description: TODO(排行榜实体)
 * @author jason.peng
 * @date 2016年3月19日 下午4:10:27
 *
 */
public class Ranking2Item implements Serializable {

	private static final long serialVersionUID = 1L;

	private String account;

	private String headimg;

	private String nickname;

	private Integer yesterdayPoint;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
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

	public Integer getYesterdayPoint() {
		return yesterdayPoint;
	}

	public void setYesterdayPoint(Integer yesterdayPoint) {
		this.yesterdayPoint = yesterdayPoint;
	}

	@Override
	public String toString() {
		return "Ranking2Item [account=" + account + ", headimg=" + headimg
				+ ", nickname=" + nickname + ", yesterdayPoint="
				+ yesterdayPoint + "]";
	}

}
