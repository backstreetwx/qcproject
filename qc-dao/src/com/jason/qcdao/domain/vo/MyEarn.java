package com.jason.qcdao.domain.vo;

import java.io.Serializable;

/**
 * @ClassName: MyEarn
 * @Description: TODO(我的收益)
 * @author jason.peng
 * @date 2016年1月11日 下午3:59:40
 */
public class MyEarn implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer totdayPoint;

	private Integer yesterdayPoint;

	private Integer mayPoint;

	private Integer totalPoint;

	private Integer taskPoint;

	private Integer taskCount;

	private Integer taskRead;

	public Integer getTotdayPoint() {
		return totdayPoint;
	}

	public void setTotdayPoint(Integer totdayPoint) {
		this.totdayPoint = totdayPoint;
	}

	public Integer getYesterdayPoint() {
		return yesterdayPoint;
	}

	public void setYesterdayPoint(Integer yesterdayPoint) {
		this.yesterdayPoint = yesterdayPoint;
	}

	public Integer getMayPoint() {
		return mayPoint;
	}

	public void setMayPoint(Integer mayPoint) {
		this.mayPoint = mayPoint;
	}

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}

	public Integer getTaskPoint() {
		return taskPoint;
	}

	public void setTaskPoint(Integer taskPoint) {
		this.taskPoint = taskPoint;
	}

	public Integer getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Integer taskCount) {
		this.taskCount = taskCount;
	}

	public Integer getTaskRead() {
		return taskRead;
	}

	public void setTaskRead(Integer taskRead) {
		this.taskRead = taskRead;
	}

	@Override
	public String toString() {
		return "MyEarn [totdayPoint=" + totdayPoint + ", yesterdayPoint="
				+ yesterdayPoint + ", mayPoint=" + mayPoint + ", totalPoint="
				+ totalPoint + ", taskPoint=" + taskPoint + ", taskCount="
				+ taskCount + ", taskRead=" + taskRead + "]";
	}

}
