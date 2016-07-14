package com.jason.qcdao.domain.vo;

import java.io.Serializable;

public class DuiBaNotice implements Serializable {

	private static final long serialVersionUID = 1L;

	private String appKey;

	private Long timestamp;

	private Boolean success;

	private String errorMessage;

	private String orderNum;

	private String bizId;

	private String sign;

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public String getBizId() {
		return bizId;
	}

	public void setBizId(String bizId) {
		this.bizId = bizId;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@Override
	public String toString() {
		return "DuiBaNotice [appKey=" + appKey + ", timestamp=" + timestamp
				+ ", success=" + success + ", errorMessage=" + errorMessage
				+ ", orderNum=" + orderNum + ", bizId=" + bizId + ", sign="
				+ sign + "]";
	}

}
