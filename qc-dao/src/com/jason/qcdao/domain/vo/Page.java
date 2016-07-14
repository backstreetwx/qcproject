package com.jason.qcdao.domain.vo;

import java.util.List;

public class Page<T> {
	/**
	 * 默认分页大小
	 */
	public static final Integer DEFAULT_PAGE_SIZE = 20; // 默认分页大小

	private Integer pageSize; // 当前页面有多少条

	private List<T> recordList; // 本页的数据列表

	public Page() {
		super();
	}

	public Page(Integer pageSize, List<T> recordList) {
		super();
		this.pageSize = pageSize;
		if(recordList!= null && recordList.size() == 0) {
			this.recordList = null;
		} else {
			this.recordList = recordList;
		}
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<T> recordList) {
		if(recordList!= null && recordList.size() == 0) {
			this.recordList = null;
		} else {
			this.recordList = recordList;
		}
	}

}
