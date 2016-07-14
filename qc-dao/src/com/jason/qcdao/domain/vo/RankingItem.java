package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: RankingItem
 * @Description: TODO(排行榜条目)
 * @author jason.peng
 * @date 2016年1月8日 下午1:52:24
 */
public class RankingItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private String account;

	private Integer index;

	private String headimg;

	private String nickname;

	private Integer totalPoint;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
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

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}

	@Override
	public String toString() {
		return "RankingItem [account=" + account + ", index=" + index
				+ ", headimg=" + headimg + ", nickname=" + nickname
				+ ", totalPoint=" + totalPoint + "]";
	}

}
