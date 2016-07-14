package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: DuiBaDeducted
 * @Description: TODO(兑吧扣除积分)
 * @author jason.peng
 * @date 2016年2月19日 上午9:14:58
 */
public class DuiBaDeducted implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uid;

	private Long credits;

	private String appKey;

	private String timestamp;

	private String description;

	private String orderNum;

	private String type;

	private Integer facePrice;

	private Integer actualPrice;

	private String ip;

	private Boolean waitAudit;

	private String params;

	private String sign;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Long getCredits() {
		return credits;
	}

	public void setCredits(Long credits) {
		this.credits = credits;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getFacePrice() {
		return facePrice;
	}

	public void setFacePrice(Integer facePrice) {
		this.facePrice = facePrice;
	}

	public Integer getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Integer actualPrice) {
		this.actualPrice = actualPrice;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Boolean getWaitAudit() {
		return waitAudit;
	}

	public void setWaitAudit(Boolean waitAudit) {
		this.waitAudit = waitAudit;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "DuiBaDeducted [uid=" + uid + ", credits=" + credits
				+ ", appKey=" + appKey + ", timestamp=" + timestamp
				+ ", description=" + description + ", orderNum=" + orderNum
				+ ", type=" + type + ", facePrice=" + facePrice
				+ ", actualPrice=" + actualPrice + ", ip=" + ip
				+ ", waitAudit=" + waitAudit + ", params=" + params + ", sign="
				+ sign + "]";
	}

}
