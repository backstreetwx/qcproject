package com.jason.qcdao.base;

import org.springframework.beans.factory.annotation.Autowired;

import com.jason.qcdao.mapper.BannelMapper;
import com.jason.qcdao.mapper.DomainMapper;
import com.jason.qcdao.mapper.GoodsMapper;
import com.jason.qcdao.mapper.Notice2Mapper;
import com.jason.qcdao.mapper.NoticeMapper;
import com.jason.qcdao.mapper.OrderMapper;
import com.jason.qcdao.mapper.TaskContentMapper;
import com.jason.qcdao.mapper.TaskMapper;
import com.jason.qcdao.mapper.TaskTmpMapper;
import com.jason.qcdao.mapper.UserOrder2Mapper;
import com.jason.qcdao.mapper.UserOrderMapper;
import com.jason.qcdao.mapper.UserPacket2Mapper;
import com.jason.qcdao.mapper.UserPacketMapper;
import com.jason.qcdao.mapper.UserAccountMapper;
import com.jason.qcdao.mapper.UserDetailMapper;
import com.jason.qcdao.mapper.UserInviteMapper;
import com.jason.qcdao.mapper.UserMapper;
import com.jason.qcdao.mapper.UserTaskMapper;
import com.jason.qcdao.mapper.UserTmpMapper;
import com.jason.qcdao.mapper.VersionMapper;

/**
* @ClassName: BaseDaoSupport
* @Description: TODO(数据库访问接口的支撑类，提供所有的数据库接口实现类)
* @author jason.peng
* @date 2016年1月6日 上午7:38:56
 */
public abstract class BaseDaoSupport {
	@Autowired
	protected UserMapper userMapper;
	@Autowired
	protected UserAccountMapper userAccountMapper;
	@Autowired
	protected VersionMapper versionMapper;
	@Autowired
	protected UserInviteMapper userInviteMapper;
	@Autowired
	protected UserPacketMapper userPacketMapper;
	@Autowired
	protected UserPacket2Mapper userPacket2Mapper;
	@Autowired
	protected UserDetailMapper userDetailMapper;
	@Autowired
	protected GoodsMapper goodsMapper;
	@Autowired
	protected UserOrderMapper userOrderMapper;
	@Autowired
	protected BannelMapper bannelMapper;
	@Autowired
	protected NoticeMapper noticeMapper;
	@Autowired
	protected TaskMapper taskMapper;
	@Autowired
	protected TaskContentMapper taskContentMapper;
	@Autowired
	protected UserTaskMapper userTaskMapper;
	@Autowired
	protected UserTmpMapper userTmpMapper;
	@Autowired
	protected DomainMapper domainMapper;
	@Autowired
	protected TaskTmpMapper taskTmpMapper;
	@Autowired
	protected Notice2Mapper notice2Mapper;
	@Autowired
	protected UserOrder2Mapper userOrder2Mapper;
	@Autowired
	protected OrderMapper orderMapper;
}
