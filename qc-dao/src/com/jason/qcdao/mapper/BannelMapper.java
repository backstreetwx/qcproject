package com.jason.qcdao.mapper;

import java.util.List;

import com.jason.qcdao.domain.vo.BannelItem;

/**
* @ClassName: BannelMapper
* @Description: TODO(焦点图实体数据库访问接口)
* @author jason.peng
* @date 2016年1月8日 上午9:26:26
 */
public interface BannelMapper {
	/**
	* @Title: getBannels
	* @Description: TODO(获取焦点图)
	* @return
	* @author jason.peng
	* @date 2016年1月11日 上午8:09:51
	 */
	public List<BannelItem> getBannels();

}
