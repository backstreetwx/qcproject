package com.jason.qcserver.job;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

import com.jason.qcdao.domain.vo.PacketItem;
import com.jason.qcserver.base.BaseServiceSupport;
import com.jason.qcserver.utils.DateUtil;

@Component
public class PacketJob extends BaseServiceSupport{
	/**
	 * 列表
	 */
	private static List<String> hashIds;
	/**
	* @Title: doWork
	* @Description: TODO(抢红包开始前的准备)
	* @author jason.peng
	* @date 2016年3月14日 下午2:41:04
	 */
	public void doWork() {
		Random random = new Random();
		// 随机产生总的红包个数1-5k
		Integer totalCount = (random.nextInt(5) + 1) * 1000;
		otherCache.opsForValue().set("packet-totalCount", totalCount);
		// 随机产出总的红包金额3-8k
		Integer totalPoint = (random.nextInt(6) + 3 ) * 100000;
		otherCache.opsForValue().set("packet-totalPoint", totalPoint);
		// 创建抢红包列表的数据
		hashIds = userTmpMapper.getRandHashIds(PacketItem.DEFAULT_SIZE);
		if(hashIds == null || hashIds.size() == 0) {
			logger.info("没有可用的用户资源....");
			return ;
		}
		// 获取用户信息
		Date pickTime = DateUtil.DateToDate(new Date(new Date().getTime() + 3600000), "yyyy-MM-dd HH");
		List<PacketItem> packetItems = userMapper.getByHashIds(hashIds);
		for (PacketItem packetItem : packetItems) {
			// 随机分数3-10元
			Integer point = random.nextInt(501) + 300;
			packetItem.setPoint(point);
			packetItem.setPickTime(pickTime);
			// 保存到缓存
			otherCache.opsForZSet().add("packet-packetItem", packetItem, point);
		}
		
		logger.info("准备红包数据成功.....");
	}
	
	/**
	* @Title: doUpdate
	* @Description: TODO(更新红包列表)
	* @author jason.peng
	* @date 2016年3月14日 下午4:47:48
	 */
	public void doUpdate() {
		
		if(hashIds == null || hashIds.size() == 0) {
			logger.info("更新红包列表失败....");
			return ;
		}
		
		Random random = new Random();
		
		String hashId = userTmpMapper.getRandHashId(hashIds);
		PacketItem packetItem = userMapper.getByHashId(hashId);
		
		long diff = random.nextInt(3) * 1000;
		Date pickTime = DateUtil.DateToDate(new Date(new Date().getTime() + diff), "yyyy-MM-dd HH:mm:ss");
		// 随机分数3-10元
		Integer point = random.nextInt(501) + 300;
		packetItem.setPoint(point);
		packetItem.setPickTime(pickTime);
		
		
		System.out.println("--------------->" + packetItem);
		otherCache.opsForZSet().add("packet-packetItem", packetItem, point);
		otherCache.opsForZSet().removeRange("packet-packetItem", 0, 0);
		
		hashIds.add(hashId);
		
	}
	
	/**
	* @Title: doClear
	* @Description: TODO(做清理工作)
	* @author jason.peng
	* @date 2016年3月14日 下午8:07:15
	 */
	public void doClear() {
		// 清除红包记录
		otherCache.delete("packet2");
		// 清除缓存
		otherCache.delete("packet-totalCount");
		otherCache.delete("packet-totalPoint");
		otherCache.delete("packet-packetItem");
		// 重置变量
		hashIds = null;
		logger.info("清除红包记录....");
	}
}
