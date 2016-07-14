package com.jason.qcms.domain.vo;

import java.util.List;
/**
 * 作者：jason.peng <br/>
 * 创建时间：2015-2-18 <br/>
 * 描述：分页功能中的一页的信息
 * @param <T>
 */
public class PageBean<T> {

	public static final Integer DEFAULT_PAGE_SIZE = 50; //默认分页大小
	
	private Integer pageIndex; // 当前页
	
	private Integer pageSize; // 每页显示多少条

	private Integer recordCount; // 总记录数
	
	private Integer pageCount; // 总页数
	
	private Integer beginPageIndex; // 页码列表的开始索引（包含）
	
	private Integer endPageIndex; // 页码列表的结束索引（包含）

	private List<T> recordList; // 本页的数据列表

	/**
	 * 作者：jason.peng <br/>
	 * 创建时间：2015-2-18 <br/>
	 * 描述：无参构造方法
	 */
	public PageBean() {
		
	}

	/**
	 * 只接受前4个必要的属性，会自动的计算出其他3个属生的值
	 * 
	 * @param currentPage
	 * @param pageSize
	 * @param recordCount
	 * @param recordList
	 */
	public PageBean(Integer pageIndex, Integer pageSize, Integer recordCount, List<T> recordList) {
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		// 计算总页码
		pageCount = (recordCount + pageSize - 1) / pageSize;

		// 计算 beginPageIndex 和 endPageIndex
		// >> 总页数不多于10页，则全部显示
		if (pageCount <= 10) {
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}else {
			// >> 总页数多于10页，则显示当前页附近的共10个页码
			// 当前页附近的共10个页码（前4个 + 当前页 + 后5个）
			beginPageIndex = pageIndex - 4;
			endPageIndex = pageIndex + 5;
			// 当前面的页码不足4个时，则显示前10个页码
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// 当后面的页码不足5个时，则显示后10个页码
			if (endPageIndex > pageCount) {
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 10 + 1;
			}
		}
	}

	public List<T> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<T> recordList) {
		this.recordList = recordList;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	@Override
	public String toString() {
		return "PageBean [pageIndex=" + pageIndex + ", pageSize=" + pageSize
				+ ", recordCount=" + recordCount + ", pageCount=" + pageCount
				+ ", beginPageIndex=" + beginPageIndex + ", endPageIndex="
				+ endPageIndex + ", recordList=" + recordList + "]";
	}
	
}
