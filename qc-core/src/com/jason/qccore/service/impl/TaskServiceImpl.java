package com.jason.qccore.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.jason.qccore.service.TaskService;
import com.jason.qccore.utils.Md5Util;
import com.jason.qccore.utils.Md5Util.EncodeStrategy;
import com.jason.qccore.utils.RandomUtil;
import com.jason.qcdao.domain.po.Task;
import com.jason.qcdao.domain.po.TaskContent;
import com.jason.qcdao.domain.po.TaskTmp;
import com.jason.qcdao.domain.po.User;
import com.jason.qcdao.domain.po.UserDetail;
import com.jason.qcdao.domain.po.UserInvite;
import com.jason.qcdao.domain.po.UserTask;
import com.jason.qcdao.domain.vo.HotTaskItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.ReadTaskContent;
import com.jason.qcdao.domain.vo.TaskCallback;
import com.jason.qcdao.domain.vo.TaskItem;
import com.jason.qcdao.domain.vo.TaskRead;
import com.jason.qcdao.domain.vo.TaskShare;
import com.jason.qcdao.domain.vo.UserTaskItem;
import com.jason.qcdao.domain.vo.WatchTaskContent;
/**
* @ClassName: TaskServiceImpl
* @Description: TODO(任务业务逻辑接口实现类)
* @author jason.peng
* @date 2016年1月8日 上午10:43:52
 */
@Service
public class TaskServiceImpl extends BaseServiceImpl implements TaskService {

	@Override
	public Page<TaskItem> getTaskPage(String hashId, Integer index, Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		
		// 获取用户
		User user = getUserByHashId(hashId);
		// 更新用户的比率
		updateUserRate(user);
		
		List<TaskItem> items = taskMapper.getTasks(hashId, start, len);
		Date current = new Date();
		for (TaskItem taskItem : items) {
			
			// 新建策略（比例给积分）
			float rate = user.getRate() == null ? 1.0f: user.getRate();
			int point = (int)((float)taskItem.getPoint() * rate);
			taskItem.setPoint(point);
						
			
			if(taskItem.getFinishTime().getTime() - current.getTime() < 0) {
				continue;
			}
			 
			if(taskItem.getTmpId() != null) {
				taskItem.setStatus(Task.NONE_STATUS);
				continue;
			}
		}
		return new Page<TaskItem>(size, items);
	}
	
	@Override
	public Page<TaskItem> getTaskPage2(String hashId, Integer index, Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		
		// 获取用户
		User user = getUserByHashId(hashId);
		// 更新用户的比率
		updateUserRate(user);
		
		List<TaskItem> items = taskMapper.getTasks(hashId, start, len);
		Date current = new Date();
		for (TaskItem taskItem : items) {
			
			// 新建策略（比例给积分）
			float rate = user.getRate() == null ? 1.0f: user.getRate();
			int point = (int)((float)taskItem.getPoint() * rate);
			taskItem.setPoint(point);
			
			if(taskItem.getFinishTime().getTime() - current.getTime() < 0) {
				continue;
			}
			 
			if(taskItem.getTmpId() != null) {
				taskItem.setStatus(Task.NONE_STATUS);
				continue;
			}
		}
		return new Page<TaskItem>(size, items);
	}

	@Override
	public Page<UserTaskItem> getUserTaskPage(String hashId, Integer index, Integer size) {
		
		Integer start = (index -1) * size;
		Integer len = size;
		
		List<UserTaskItem> items = userTaskMapper.getUserTasks(hashId, start, len);
		return new Page<UserTaskItem>(size, items);
	}

	@Override
	public Page<HotTaskItem> getHotTaskPage(String hashId, Integer index, Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		
		// 获取用户
		User user = getUserByHashId(hashId);
		// 更新用户的比率
		updateUserRate(user);
		
		List<HotTaskItem> items = taskMapper.getHotTasks(hashId, start, len);
		for (HotTaskItem hotTaskItem : items) {
			
			// 新建策略（比例给积分）
			float rate = user.getRate() == null ? 1.0f: user.getRate();
			int point = (int)((float)hotTaskItem.getPoint() * rate);
			hotTaskItem.setPoint(point);
			
			if(hotTaskItem.getTmpId() != null) {
				hotTaskItem.setStatus(Task.NONE_STATUS);
				continue;
			}
		}
		return new Page<HotTaskItem>(size, items);
	}
	
	@Override
	public Page<HotTaskItem> getHotTaskPage2(String hashId, Integer index, Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		
		// 获取用户
		User user = getUserByHashId(hashId);
		// 更新用户的比率
		updateUserRate(user);
		
		List<HotTaskItem> items = taskMapper.getHotTasks(hashId, start, len);
		for (HotTaskItem hotTaskItem : items) {
			// 新建策略（比例给积分）
			float rate = user.getRate() == null ? 1.0f: user.getRate();
			int point = (int)((float)hotTaskItem.getPoint() * rate);
			hotTaskItem.setPoint(point);
			
			if(hotTaskItem.getTmpId() != null) {
				hotTaskItem.setStatus(Task.NONE_STATUS);
				continue;
			}
		}
		return new Page<HotTaskItem>(size, items);
	}
	
	/**
	* @Title: updateUserRate
	* @Description: TODO(更新用户的比率)
	* @param user
	* @author jason.peng
	* @date 2016年3月22日 上午9:05:46
	 */
	private void updateUserRate(User user) {
		Integer mayPoint = userAccountMapper.getMayPoint(user.getHashId());
		if(mayPoint < 1500) {
			if(user.getRate() == null || user.getRate() != 6.0f) {
				updateRate(user.getHashId(), 6.0f);
			}
		} else if(mayPoint < 3000) {
			if(user.getRate() == null || user.getRate() != 4.0f) {
				updateRate(user.getHashId(), 4.0f);
			}
		} else if(mayPoint < 5000) {
			if(user.getRate() == null || user.getRate() != 2.0f) {
				updateRate(user.getHashId(), 2.0f);
			}
		} else if(mayPoint < 6000) {
			if(user.getRate() == null || user.getRate() != 3.0f) {
				updateRate(user.getHashId(), 3.0f);
			}
		} else if(mayPoint < 7000) {
			if(user.getRate() == null || user.getRate() != 1.0f) {
				updateRate(user.getHashId(), 1.0f);
			}
		} else {
			if(user.getRate() == null || user.getRate() != 0.5f) {
				updateRate(user.getHashId(), 0.5f);
			}
		}
	}
	
	/**
	* @Title: updateRate
	* @Description: TODO(更新比率)
	* @param hashId
	* @param f
	* @author jason.peng
	* @date 2016年3月22日 上午9:44:37
	 */
	private void updateRate(String hashId, Float rate) {
		// 更新缓存
		User user = (User) userCache.opsForValue().get(hashId);
		if(user != null) {
			user.setRate(rate);
			userCache.opsForValue().set(hashId, user, 1, TimeUnit.DAYS);
		}
		// 更新数据库
		userMapper.updateRate(hashId, rate);
	}

	@Override
	public WatchTaskContent getWatchTaskContent(String hashId, Integer taskId) {
		WatchTaskContent watchTaskContent = taskContentMapper.getWatchTaskContent(taskId);
		if(TaskContent.ARTICLE_TYPE.equals(watchTaskContent.getType())) {
			String domain = domainMapper.getRandDomain();
			if(domain.contains("*")) {
				String serial = RandomUtil.createCharacterSerial(12);
				domain = domain.replace("*", serial);
			}
			Integer id = getUserByHashId(hashId).getId();
			Long timestamp = new Date().getTime();
			String sign = getSign(taskId, id, timestamp);
			StringBuffer sb = new StringBuffer("http://")
									.append(domain)
									.append("/qc-core")
									.append("/public/task/content?")
									.append("taskId=")
									.append(taskId)
									.append("&id=")
									.append(id)
									.append("&sign=")
									.append(sign)
									.append("&timestamp=")
									.append(timestamp);
			watchTaskContent.setUrl(sb.toString());
		}
		return watchTaskContent;
	}

	@Override
	public ReadTaskContent getReadTaskContent(Integer taskId) {
		return taskContentMapper.getReadTaskContent(taskId);
	}

	@Override
	public TaskShare getTaskShare(String hashId, Integer taskId) {
		String domain = domainMapper.getRandDomain();
		if(domain.contains("*")) {
			String serial = RandomUtil.createCharacterSerial(12);
			domain = domain.replace("*", serial);
		}
		Integer id = getUserByHashId(hashId).getId();
		Long timestamp = new Date().getTime();
		String sign = getSign(taskId, id, timestamp);
		StringBuffer sb = new StringBuffer("http://")
								.append(domain)
								.append("/qc-core")
								.append("/public/task/content?")
								.append("taskId=")
								.append(taskId)
								.append("&id=")
								.append(id)
								.append("&sign=")
								.append(sign)
								.append("&timestamp=")
								.append(timestamp);
		
		TaskShare taskShare = taskMapper.getTaskShare(taskId);
		taskShare.setUrl(sb.toString());
		return taskShare;
	}
	/**
	* @Title: getSign
	* @Description: TODO(获取签名)
	* @param taskId
	* @param id
	* @param timestamp
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午4:27:31
	 */
	private String getSign(Integer taskId, Integer id, Long timestamp) {
		StringBuffer sb = new StringBuffer("task")
								.append(":")
								.append("key=ciyun520")
								.append(":")
								.append("taskId=")
								.append(taskId)
								.append(":")
								.append("id=")
								.append(id)
								.append(":")
								.append("timestamp=")
								.append(timestamp);
		
		return Md5Util.encrypt(sb.toString(), EncodeStrategy.ENCODE_HEX);
	}
	
	@Override
	public void doCallback(final String hashId, final Integer taskId) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				
				TaskCallback taskCallback = taskMapper.getTaskCallback(taskId);
				if(Task.FINISH_STATUS.equals(taskCallback.getStatus())) {
					logger.info("疑是非法发包请求，hashId={}, taskId={}", hashId, taskId);
					// 记录非法用户
					return ;
				}
				
				String orderId = getOrderId(hashId, taskId);
				// 判断用户是否分享过
				if(userTaskMapper.isExistUserTask(orderId) == 1) {
					// 记录非法用户
					return ;
				}
				
				Date current = new Date();
				// 更新任务的分享
				taskMapper.updateTaskForShare(taskId);
				// 保存用户任务记录
				UserTask userTask = new UserTask();
				userTask.setOrderId(orderId);
				userTask.setHashId(hashId);
				userTask.setTaskId(taskId);
				userTask.setCreateTime(current);
				
				userTaskMapper.saveUserTask(userTask);
				// 测试是否成功....
				Integer shareCount = userAccountMapper.getShareCount(hashId);
				if(shareCount == 0) {
					Integer point = 600;
					userAccountMapper.updatePointForShare(hashId, point);
					// 更新用户临时记录
					userTmpMapper.updateUserTmpForShare2(hashId, point);
					// 保存详情信息
					UserDetail userDetail = new UserDetail();
					userDetail.setHashId(hashId);
					userDetail.setType(UserDetail.TASK_SHARE_TYPE);
					userDetail.setIcon(UserDetail.TASK_ICON);
					userDetail.setTitle("首次分享奖励");
					userDetail.setPoint(point);
					userDetail.setCreateTime(current);
					userDetailMapper.saveUserDetail(userDetail);
				} else {
					// 更新用户临时记录
					userTmpMapper.updateUserTmpForShare(hashId);
					// 更新分享次数
					userAccountMapper.updateShareCount(hashId);
				}
			}
		});
	}
	
	
	@Override
	public void doCallback2(final String hashId, final Integer taskId) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				
				TaskCallback taskCallback = taskMapper.getTaskCallback(taskId);
				if(Task.FINISH_STATUS.equals(taskCallback.getStatus())) {
					logger.info("疑是非法发包请求，hashId={}, taskId={}", hashId, taskId);
					// 记录非法用户
					return ;
				}
				
				String orderId = getOrderId(hashId, taskId);
				// 判断用户是否分享过
				if(userTaskMapper.isExistUserTask(orderId) == 1) {
					// 记录非法用户
					return ;
				}
				
				Date current = new Date();
				// 更新任务的分享
				taskMapper.updateTaskForShare(taskId);
				// 保存用户任务记录
				UserTask userTask = new UserTask();
				userTask.setOrderId(orderId);
				userTask.setHashId(hashId);
				userTask.setTaskId(taskId);
				userTask.setCreateTime(current);
				
				userTaskMapper.saveUserTask(userTask);
				// 更新用户临时记录
				userTmpMapper.updateUserTmpForShare(hashId);
				// 更新分享次数
				userAccountMapper.updateShareCount(hashId);
				
			}
		});
	}

	@Override
	public void doRead(final TaskTmp taskTmp) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				// 获取任务奖励
				TaskRead taskRead = taskMapper.getTaskRead(taskTmp.getTaskId());
//				if(Task.DOWN_STATUS.equals(taskRead.getStatus())) {
//					return ;
//				}
				
				if(Task.FINISH_STATUS.equals(taskRead.getStatus())) {
					return ;
				}
				
				Integer status = taskRead.getStatus();
				if(taskRead.getLimitRead() - taskRead.getReadCount() <= 1) {
					status = Task.FINISH_STATUS;
				}
				// 判断任务是否完成
				// 获取用户的hashId
				String hashId = userMapper.getHashId(taskTmp.getUserId());
				
				// 更新用户的汇率并获取
				User user = getUserByHashId(hashId);
				updateUserRate(user);
				int point = taskRead.getPoint();
				float rate = user.getRate() == null ? 1 : user.getRate();
				point = (int) ((float)point * rate);
				// 获取订单
				String orderId = getOrderId(hashId, taskTmp.getTaskId());
				// 更新任务记录
				taskMapper.updateTaskForRead(taskTmp.getTaskId(), point, status);
				// 更新用户任务记录表
				userTaskMapper.updateUserTaskForRead(orderId, point);
				// 更新用户临时记录
				userTmpMapper.updateUserTmpForRead(hashId, point);
				// 更新用户账号(不给分，统一给分)
//				userAccountMapper.updatePointForTask(hashId, taskRead.getPoint());
				userAccountMapper.updatePointForTask4(hashId, point);
				// 保存临时记录
				taskTmpMapper.saveTaskTmp(taskTmp);
				
				// 处理首次做任务邀请给奖励
				doInvite(hashId);
			}
			/**
			* @Title: doInvite
			* @Description: TODO(处理邀请)
			* @param hashId
			* @author jason.peng
			* @date 2016年3月23日 下午3:14:43
			 */
			private void doInvite(String hashId) {
				// 缓存中判断用户是否激活
				if(otherCache.opsForSet().isMember("userInvite", hashId)) {
					return ;
				}
				// 数据库中判断用户是否激活
				UserInvite userInvite = userInviteMapper.getUserInvite(hashId);
				if(userInvite == null) {
					// 设置到缓存
					otherCache.opsForSet().add("userInvite", new String[]{hashId});
					return ;
				}
				
				Integer point = 200;
				// 更新用户账号的邀请次数
				userAccountMapper.updatePointForInvite(userInvite.getByHashId(), point);
				// 保存一个邀请明细
				UserDetail userDetail = new UserDetail();
				userDetail.setHashId(userInvite.getByHashId());
				userDetail.setType(UserDetail.INVITE_TYPE);
				userDetail.setIcon(UserDetail.INVITE_ICON);
				userDetail.setTitle("邀请好友");
				userDetail.setPoint(point);
				userDetail.setCreateTime(new Date());
				userDetailMapper.saveUserDetail(userDetail);
				// 设置到缓存
				otherCache.opsForSet().add("userInvite", new String[]{hashId});
				
				logger.info("上线{}，下线{}", userInvite.getByHashId(), hashId);
			}
		});
	}
	
	/**
	* @Title: getUserByHashId
	* @Description: TODO(获取用户)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午4:25:15
	 */
	private User getUserByHashId(String hashId) {
		User user = (User) userCache.opsForValue().get(hashId);
		if(user == null) {
			user = userMapper.getUserByHashId(hashId);
			if(user != null) {
				userCache.opsForValue().set(hashId, user, 1, TimeUnit.DAYS);
			}
		}
		return user;
	}
	
	/**
	* @Title: getOrderId
	* @Description: TODO(获取订单号)
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午4:36:57
	 */
	private String getOrderId(String hashId, Integer taskId) {
		StringBuffer sb = new StringBuffer("task_order_id")
								.append(":")
								.append("hashId=")
								.append(hashId)
								.append(":")
								.append("taskId=")
								.append(taskId);
		return Md5Util.encrypt(sb.toString(), EncodeStrategy.ENCODE_HEX);
	}

	@Override
	public boolean isExistTaskTmp(String hashFinger) {
		int r = taskTmpMapper.isExistTaskTmp(hashFinger);
		if(r == 1) {
			return true;
		}
		return false;
	}

	@Override
	public Page<TaskItem> getTaskPage3(String hashId, Integer index,
			Integer size) {
		Integer start = (index -1) * size;
		Integer len = size;
		
		// 获取用户
		User user = getUserByHashId(hashId);
		// 更新用户的比率
		updateUserRate(user);
		
		List<TaskItem> items = taskMapper.getTasks2(hashId, start, len);
		Date current = new Date();
		for (TaskItem taskItem : items) {
			
			// 新建策略（比例给积分）
			float rate = user.getRate() == null ? 1.0f: user.getRate();
			int point = (int)((float)taskItem.getPoint() * rate);
			taskItem.setPoint(point);
			
			if(taskItem.getFinishTime().getTime() - current.getTime() < 0) {
				continue;
			}
			 
			if(taskItem.getTmpId() != null) {
				taskItem.setStatus(Task.NONE_STATUS);
				continue;
			}
		}
		return new Page<TaskItem>(size, items);
	}
}
