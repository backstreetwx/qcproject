package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.vo.DetailItem;

/**
* @ClassName: UserDetailMapper
* @Description: TODO(用户详情数据库访问接口)
* @author jason.peng
* @date 2016年1月7日 上午9:49:36
 */
public interface UserDetailMapper {
	/**
	* @Title: saveUserDetail
	* @Description: TODO(保存用户详情)
	* @param userDetail
	* @author jason.peng
	* @date 2016年1月7日 上午10:39:06
	 */
	public void saveUserDetail(UserDetail userDetail);
	/**
	* @Title: getDetails
	* @Description: TODO(获取详情分页数据)
	* @param hashId
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午11:32:27
	 */
	public List<DetailItem> getDetails(@Param("hashId")String hashId, @Param("start")Integer start, @Param("len")Integer len);

}
