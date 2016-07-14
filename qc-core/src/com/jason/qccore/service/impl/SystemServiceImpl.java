package com.jason.qccore.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.jason.qccore.service.SystemService;
import com.jason.qccore.utils.RandomUtil;
import com.jason.qcdao.domain.po.Notice2;
import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.vo.BannelItem;
import com.jason.qcdao.domain.vo.Notice2Item;
import com.jason.qcdao.domain.vo.NoticeItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.ShareUrl;
import com.jason.qcdao.domain.vo.VersionInfo;
/**
* @ClassName: VersionServiceImpl
* @Description: TODO(版本业务逻辑接口实现类型)
* @author jason.peng
* @date 2016年1月7日 上午8:43:16
 */
@Service
public class SystemServiceImpl extends BaseServiceImpl implements SystemService {

	@Override
	public VersionInfo getVersionInfo(Integer type) {
		return versionMapper.getVersion(type);
	}

	@Override
	public List<BannelItem> getBannels() {
		return bannelMapper.getBannels();
	}

	@Override
	public List<NoticeItem> getNotices() {
		return noticeMapper.getNotices();
	}

	@Override
	public ShareUrl getShareUrl(String hashId) {
		String domain = domainMapper.getRandDomain();
		if(domain.contains("*")) {
			String serial = RandomUtil.createCharacterSerial(12);
			domain = domain.replace("*", serial);
		}
		
		User user = getUserByHashId(hashId);
		
		ShareUrl shareUrl = new ShareUrl();
		shareUrl.setIcon(UserDetail.DEFAULT_ICON);
		shareUrl.setTitle("快来趣传联盟和我一起赚钱吧，记得注册时输入我的邀请码：" + user.getId());
		shareUrl.setSubTitle("动动手指，分享文章即能赚大钱！");
		shareUrl.setUrl("http://" + domain + "/qc-core/public/share/down");
		return shareUrl;
	}
	/**
	* @Title: getUserByHashId
	* @Description: TODO(获取用户)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年2月26日 下午5:28:11
	 */
	public User getUserByHashId(String hashId) {
		User user = (User) userCache.opsForValue().get(hashId);
		if(user == null) {
			user = userMapper.getUserByHashId(hashId);
			if(user != null) {
				userCache.opsForValue().set(hashId, user, 1, TimeUnit.DAYS);
			}
		}
		return user;
	}

	@Override
	public Notice2 getNotice2() {
		return notice2Mapper.getNotice2();
	}

	@Override
	public Page<Notice2Item> getNotice2Page(Integer index, Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		
		List<Notice2Item> items = notice2Mapper.getNotice2s(start, len);
		return new Page<Notice2Item>(size, items);
	}
}
