package com.jason.qcserver.job;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserTmp;
import com.jason.qcserver.base.BaseServiceSupport;
import com.jason.qcserver.utils.DateUtil;

@Component
public class DailyJob extends BaseServiceSupport{

	public void doWork() {
		logger.info("开始日常工作......");
		// 清除缓存中数据
		ipCache.getConnectionFactory().getConnection().flushDb();
		fingerCache.getConnectionFactory().getConnection().flushDb();
		otherCache.delete("packet");
		// 为用户创建明细
		int index = 1, size = 1000;
		Date createTime = DateUtil.minusDate(new Date(), 1);
		String str = DateUtil.DateToString(createTime);
		
		for(int i=0;i<1000;i++) {
			Integer start = (index -1) * size;
			Integer len = size;
			List<UserTmp> userTmps = userTmpMapper.getUserTmpForDetail(start, len);
			// 保存详情信息
			for (UserTmp userTmp : userTmps) {
				UserDetail userDetail = new UserDetail();
				userDetail.setHashId(userTmp.getHashId());
				userDetail.setType(UserDetail.TASK_TYPE);
				userDetail.setIcon(UserDetail.TASK_ICON);
				userDetail.setTitle("广告收益（" + str + "）");
				userDetail.setPoint(userTmp.getTaskPoint());
				userDetail.setCreateTime(createTime);
				userDetailMapper.saveUserDetail(userDetail);
			}
			if(userTmps.size() < size) {
				break;
			} else {
				index++;
			}
		}
		// 3.更新用户的临时表数据
		userTmpMapper.updateUserTmpForDaily();
		// 4、结束任务
		taskMapper.updateTaskForFinish();
		
		logger.info("日常工作完成......");
	}
}
