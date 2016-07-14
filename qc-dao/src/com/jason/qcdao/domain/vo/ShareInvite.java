package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: ShareInvite
 * @Description: TODO(分享邀请)
 * @author jason.peng
 * @date 2016年1月12日 上午9:03:21
 */
public class ShareInvite implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer inviteCount;

	private Integer invitePoint;

	private Float invitePointF;

	private Integer inviteId;

	public Integer getInviteCount() {
		return inviteCount;
	}

	public void setInviteCount(Integer inviteCount) {
		this.inviteCount = inviteCount;
	}

	public Integer getInvitePoint() {
		return invitePoint;
	}

	public void setInvitePoint(Integer invitePoint) {
		this.invitePoint = invitePoint;
	}

	public Float getInvitePointF() {
		return invitePointF;
	}

	public void setInvitePointF(Float invitePointF) {
		this.invitePointF = invitePointF;
	}

	public Integer getInviteId() {
		return inviteId;
	}

	public void setInviteId(Integer inviteId) {
		this.inviteId = inviteId;
	}

	@Override
	public String toString() {
		return "ShareInvite [inviteCount=" + inviteCount + ", invitePoint="
				+ invitePoint + ", invitePointF=" + invitePointF
				+ ", inviteId=" + inviteId + "]";
	}

}
