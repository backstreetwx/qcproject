package com.jason.qcdao.domain.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: UserDetail
 * @Description: TODO(用户详情实体)
 * @author jason.peng
 * @date 2016年1月7日 上午9:48:09
 *
 */
public class UserDetail implements Serializable {

	private static final long serialVersionUID = 1L;
	/**
	 * 红包详情
	 */
	public static final Integer PACKET_TYPE = 1;
	/**
	 * 用户订单
	 */
	public static final Integer USER_ORDER_TYPE = 2;
	/**
	 * 邀请好友
	 */
	public static final Integer INVITE_TYPE = 3;
	/**
	 * 任务详情
	 */
	public static final Integer TASK_TYPE = 4;
	/**
	 * 任务首次回调
	 */
	public static final Integer TASK_SHARE_TYPE = 5;
	/**
	 * 用户订单
	 */
	public static final Integer USER_ORDER_ERROR_TYPE = 4;
	/**
	 * 用户抢红包
	 */
	public static final Integer PACKET_2_TYPE = 6;
	
	/**
	 * 用户订单的ICON
	 */
	public static final String DEFAULT_ICON = "http://7xo77v.com2.z0.glb.qiniucdn.com/quchuan_icon120.png";
	/**
	 * 红包的ICON
	 */
	public static final String PACKET_ICON = "http://7xo77v.com2.z0.glb.qiniucdn.com/quchuan_icon_redbag.png";
	/**
	 * 用户订单的ICON
	 */
	public static final String USER_ORDER_ICON = "http://7xo77v.com2.z0.glb.qiniucdn.com/icon_zfb.png";
	/**
	 * 邀请好友的ICON
	 */
	public static final String INVITE_ICON = "http://7xo77v.com2.z0.glb.qiniucdn.com/quchuan_icon_share.png";
	/**
	 * 任务详情的ICON
	 */
	public static final String TASK_ICON = "http://7xo77v.com2.z0.glb.qiniucdn.com/quchuan_icon_header_task.png";

	private Long id;

	private String hashId;

	private Integer type;

	private String icon;

	private String title;

	private Integer point;

	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHashId() {
		return hashId;
	}

	public void setHashId(String hashId) {
		this.hashId = hashId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "UserDetail [id=" + id + ", hashId=" + hashId + ", type=" + type
				+ ", icon=" + icon + ", title=" + title + ", point=" + point
				+ ", createTime=" + createTime + "]";
	}

}
