package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserAccount
 * @Description: TODO(用户账号持久化对象)
 * @author jason.peng
 * @date 2016年1月6日 下午3:30:14
 */
public class UserAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 系统的积分汇率
	 */
	public static final Integer RATE = 100;

	private Integer id;

	private String hashId;

	private Integer mayPoint;

	private Integer totalPoint;

	private Integer inviteCount;

	private Integer invitePoint;

	private Integer packetCount;

	private Integer packetPoint;

	private Integer packet2Count;

	private Integer packet2Point;

	private Integer taskCount;

	private Integer taskPoint;

	private Integer orderCount;

	private Integer orderPoint;

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

	public Integer getPacketCount() {
		return packetCount;
	}

	public void setPacketCount(Integer packetCount) {
		this.packetCount = packetCount;
	}

	public Integer getPacketPoint() {
		return packetPoint;
	}

	public void setPacketPoint(Integer packetPoint) {
		this.packetPoint = packetPoint;
	}

	public Integer getPacket2Count() {
		return packet2Count;
	}

	public void setPacket2Count(Integer packet2Count) {
		this.packet2Count = packet2Count;
	}

	public Integer getPacket2Point() {
		return packet2Point;
	}

	public void setPacket2Point(Integer packet2Point) {
		this.packet2Point = packet2Point;
	}

	public Integer getTaskCount() {
		return taskCount;
	}

	public void setTaskCount(Integer taskCount) {
		this.taskCount = taskCount;
	}

	public Integer getTaskPoint() {
		return taskPoint;
	}

	public void setTaskPoint(Integer taskPoint) {
		this.taskPoint = taskPoint;
	}

	public Integer getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Integer orderCount) {
		this.orderCount = orderCount;
	}

	public Integer getOrderPoint() {
		return orderPoint;
	}

	public void setOrderPoint(Integer orderPoint) {
		this.orderPoint = orderPoint;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserAccount [id=" + id + ", hashId=" + hashId + ", mayPoint="
				+ mayPoint + ", totalPoint=" + totalPoint + ", inviteCount="
				+ inviteCount + ", invitePoint=" + invitePoint
				+ ", packetCount=" + packetCount + ", packetPoint="
				+ packetPoint + ", packet2Count=" + packet2Count
				+ ", packet2Point=" + packet2Point + ", taskCount=" + taskCount
				+ ", taskPoint=" + taskPoint + ", orderCount=" + orderCount
				+ ", orderPoint=" + orderPoint + ", createTime=" + createTime
				+ "]";
	}

}
