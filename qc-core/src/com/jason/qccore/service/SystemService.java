package com.jason.qccore.service;

import java.util.List;

import com.jason.qcdao.domain.po.Notice2;
import com.jason.qcdao.domain.vo.BannelItem;
import com.jason.qcdao.domain.vo.Notice2Item;
import com.jason.qcdao.domain.vo.NoticeItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.ShareUrl;
import com.jason.qcdao.domain.vo.VersionInfo;

/**
* @ClassName: VersionService
* @Description: TODO(版本业务逻辑接口)
* @author jason.peng
* @date 2016年1月7日 上午8:42:41
 */
public interface SystemService {
	/**
	* @Title: getVersion
	* @Description: TODO(获取系统版本信息)
	* @param type
	* @return
	* @author jason.peng
	* @date 2016年1月7日 上午8:47:10
	 */
	public VersionInfo getVersionInfo(Integer type);
	/**
	* @Title: getBannels
	* @Description: TODO(获取焦点图)
	* @return
	* @author jason.peng
	* @date 2016年1月11日 上午8:08:38
	 */
	public List<BannelItem> getBannels();
	/**
	* @Title: getNotices
	* @Description: TODO(获取通知)
	* @return
	* @author jason.peng
	* @date 2016年1月11日 上午8:08:54
	 */
	public List<NoticeItem> getNotices();
	/**
	* @Title: getShareUrl
	* @Description: TODO(获取分享地址)
	* @return
	* @author jason.peng
	* @date 2016年1月26日 下午2:18:48
	 */
	public ShareUrl getShareUrl(String hashId);
	/**
	* @Title: getNotice2
	* @Description: TODO(获取通知)
	* @return
	* @author jason.peng
	* @date 2016年3月16日 下午2:07:39
	 */
	public Notice2 getNotice2();
	/**
	* @Title: getNotice2Page
	* @Description: TODO(获取通知列表)
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年3月16日 下午2:19:42
	 */
	public Page<Notice2Item> getNotice2Page(Integer index, Integer size);

}
