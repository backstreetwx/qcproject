package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.vo.PacketItem;


/**
* @ClassName: UserMapper
* @Description: TODO(用户实体数据库访问接口)
* @author jason.peng
* @date 2016年1月6日 上午7:45:34
 */
public interface UserMapper {
	/**
	* @Title: isExistUser
	* @Description: TODO(通过ID判断用户是否存在)
	* @param id
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午4:39:46
	 */
	public Integer isExistUserById(@Param("id")Integer id);
	/**
	* @Title: isExistUserByCellphone
	* @Description: TODO(通过手机号码判断用户是否存在)
	* @param cellphone
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午4:44:03
	 */
	public Integer isExistUserByAccount(@Param("account")String account);
	/**
	* @Title: isExistUserByOpenId
	* @Description: TODO(通过openId码判断用户是否存在)
	* @param openId
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午7:38:09
	 */
	public Integer isExistUserByOpenId(@Param("openId")String openId);
	/**
	* @Title: isExistUserByHashId
	* @Description: TODO(是否存在用户通过HashId)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年2月19日 下午9:07:17
	 */
	public Integer isExistUserByHashId(@Param("hashId")String hashId);
	/**
	 * 
	* @Title: getUserByOpenId
	* @Description: TODO(通过openId获取用户)
	* @param openId
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午7:16:40
	 */
	public User getUserByOpenId(@Param("openId")String openId);
	/**
	* @Title: getUserByAccount
	* @Description: TODO(通过account获取用户)
	* @param account
	* @return
	* @author jason.peng
	* @date 2016年1月6日 下午7:16:43
	 */
	public User getUserByAccount(@Param("account")String account);
	/**
	* @Title: getUserByHashId
	* @Description: TODO(通过hashId获取用户)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午8:08:06
	 */
	public User getUserByHashId(@Param("hashId")String hashId);
	/**
	* @Title: saveUser
	* @Description: TODO(保存用户)
	* @param user
	* @author jason.peng
	* @date 2016年1月6日 下午7:24:26
	 */
	public void saveUser(User user);
	/**
	* @Title: updateUser
	* @Description: TODO(更新用户)
	* @param user
	* @author jason.peng
	* @date 2016年1月7日 上午7:53:34
	 */
	public void updateUser(User user);
	/**
	* @Title: updateInfo
	* @Description: TODO(更新用户信息)
	* @param user
	* @author jason.peng
	* @date 2016年1月7日 上午11:10:05
	 */
	public void updateInfo(User user);
	/**
	* @Title: getHashId
	* @Description: TODO(通过ID查询用户的hashId)
	* @param id
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午9:12:54
	 */
	public String getHashId(@Param("id")Integer id);
	/**
	* @Title: updatePassword
	* @Description: TODO(更新密码)
	* @param account
	* @param password
	* @param salt
	* @author jason.peng
	* @date 2016年1月11日 下午1:57:07
	 */
	public void updatePassword(@Param("account")String account, @Param("password")String password, @Param("salt")String salt);
	/**
	* @Title: updateStatus
	* @Description: TODO(更新用户的状态)
	* @param lockedStatus
	* @author jason.peng
	* @date 2016年2月22日 上午10:50:52
	 */
	public void updateStatus(@Param("hashId")String hashId, @Param("status")Integer status);
	/**
	* @Title: getUsersByHashIds
	* @Description: TODO(获取用户信息)
	* @param hashIds
	* @return
	* @author jason.peng
	* @date 2016年3月14日 下午4:04:15
	 */
	public List<PacketItem> getByHashIds(@Param("hashIds")List<String> hashIds);
	/**
	* @Title: getByHashId
	* @Description: TODO(获取用户信息通过hashId)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年3月14日 下午8:16:32
	 */
	public PacketItem getByHashId(@Param("hashId")String hashId);
	/**
	* @Title: updateRate
	* @Description: TODO(更新用户比率)
	* @param hashId
	* @param rate
	* @author jason.peng
	* @date 2016年3月22日 上午9:47:38
	 */
	public void updateRate(@Param("hashId")String hashId, @Param("rate")Float rate);

	
}
