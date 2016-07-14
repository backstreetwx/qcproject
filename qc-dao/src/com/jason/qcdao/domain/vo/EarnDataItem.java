package com.jason.qcdao.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: EarnData
 * @Description: TODO(收益数据)
 * @author jason.peng
 * @date 2016年1月11日 下午4:30:11
 */
public class EarnDataItem implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date;

	private Integer point;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "EarnDataItem [date=" + date + ", point=" + point + "]";
	}

}
