package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.Notice2;
import com.jason.qcdao.domain.vo.Notice2Item;

/**
* @ClassName: Notice2Mapper
* @Description: TODO(通知实体数据库访问接口)
* @author jason.peng
* @date 2016年3月16日 下午2:03:07
 */
public interface Notice2Mapper {
	/**
	* @Title: getNotice2
	* @Description: TODO(获取通知)
	* @return
	* @author jason.peng
	* @date 2016年3月16日 下午2:09:18
	 */
	public Notice2 getNotice2();
	/**
	* @Title: getNotice2s
	* @Description: TODO(获取通知列表)
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年3月16日 下午2:21:19
	 */
	public List<Notice2Item> getNotice2s(@Param("start")Integer start, @Param("len")Integer len);

}
