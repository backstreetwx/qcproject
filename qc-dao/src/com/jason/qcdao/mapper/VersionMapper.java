package com.jason.qcdao.mapper;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.vo.VersionInfo;

/**
* @ClassName: VersionMapper
* @Description: TODO(应用版本数据库访问接口)
* @author jason.peng
* @date 2016年1月7日 上午8:35:26
 */
public interface VersionMapper {
	/**
	* @Title: getVersion
	* @Description: TODO(获取某一设备类型应用的版本信息)
	* @param type
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午8:50:54
	 */
	public VersionInfo getVersion(@Param("type")Integer type);

}
