package com.jason.qcms.domain.qo;

import com.jason.qcms.utils.CharsetUtil;

/**
 * @ClassName: TaskQo
 * @Description: TODO(任务查询对象)
 * @author jason.peng
 * @date 2016年2月29日 上午8:39:51
 */
public class TaskQo extends BaseSupport {

	private Integer QType;

	private String QTitle;

	private String QSubTitle;

	private Integer QStatus;

	public Integer getQType() {
		return QType;
	}

	public void setQType(Integer qType) {
		QType = qType;
	}

	public String getQTitle() {
		return QTitle;
	}

	public void setQTitle(String qTitle) {
		QTitle = CharsetUtil.convert(qTitle);
	}

	public String getQSubTitle() {
		return QSubTitle;
	}

	public void setQSubTitle(String qSubTitle) {
		QSubTitle = CharsetUtil.convert(qSubTitle);;
	}

	public Integer getQStatus() {
		return QStatus;
	}

	public void setQStatus(Integer qStatus) {
		QStatus = qStatus;
	}

	@Override
	public BaseSupport getObject() {
		return this;
	}

	@Override
	public String toString() {
		return "TaskQo [QType=" + QType + ", QTitle=" + QTitle + ", QSubTitle="
				+ QSubTitle + ", QStatus=" + QStatus + "]";
	}

}
