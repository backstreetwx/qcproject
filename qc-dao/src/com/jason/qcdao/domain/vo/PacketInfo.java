package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @ClassName: PacketInfo
 * @Description: TODO(红包信息)
 * @author jason.peng
 * @date 2016年3月14日 下午4:41:45
 */
public class PacketInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer point;

	private Integer totalCount;

	private Integer totalPoint;

	private List<PacketItem> packetItems;

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(Integer totalPoint) {
		this.totalPoint = totalPoint;
	}

	public List<PacketItem> getPacketItems() {
		return packetItems;
	}

	public void setPacketItems(List<PacketItem> packetItems) {
		this.packetItems = packetItems;
	}

	@Override
	public String toString() {
		return "PacketInfo [point=" + point + ", totalCount=" + totalCount
				+ ", totalPoint=" + totalPoint + ", packetItems=" + packetItems
				+ "]";
	}

}
