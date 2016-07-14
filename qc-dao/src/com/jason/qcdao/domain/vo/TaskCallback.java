package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: TaskCallback
 * @Description: TODO(任务回调)
 * @author jason.peng
 * @date 2016年1月13日 上午8:12:58
 */
public class TaskCallback implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TaskCallback [status=" + status + "]";
	}

}
