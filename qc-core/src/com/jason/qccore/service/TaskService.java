package com.jason.qccore.service;

import com.jason.qcdao.domain.po.TaskTmp;
import com.jason.qcdao.domain.vo.HotTaskItem;
import com.jason.qcdao.domain.vo.Page;
import com.jason.qcdao.domain.vo.ReadTaskContent;
import com.jason.qcdao.domain.vo.TaskItem;
import com.jason.qcdao.domain.vo.TaskShare;
import com.jason.qcdao.domain.vo.UserTaskItem;
import com.jason.qcdao.domain.vo.WatchTaskContent;

/**
* @ClassName: TaskService
* @Description: TODO(任务业务逻辑接口)
* @author jason.peng
* @date 2016年1月8日 上午10:43:21
 */
public interface TaskService {
	/**
	* @Title: getTaskPage
	* @Description: TODO(获取任务列表)
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月8日 上午11:29:55
	 */
	public Page<TaskItem> getTaskPage(String hashId, Integer index, Integer size);
	/**
	* @Title: getTaskPage
	* @Description: TODO(获取任务列表)
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月8日 上午11:29:55
	 */
	public Page<TaskItem> getTaskPage2(String hashId, Integer index, Integer size);
	/**
	* @Title: getUserTaskPage
	* @Description: TODO(获取用户任务记录列表)
	* @param hashId
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月8日 上午11:54:33
	 */
	public Page<UserTaskItem> getUserTaskPage(String hashId, Integer index, Integer size);
	/**
	* @Title: getHotTaskPage
	* @Description: TODO(获取热门任务)
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月8日 下午2:05:49
	 */
	public Page<HotTaskItem> getHotTaskPage(String hashId, Integer index, Integer size);
	/**
	* @Title: getHotTaskPage
	* @Description: TODO(获取热门任务)
	* @param index
	* @param size
	* @return
	* @author jason.peng
	* @date 2016年1月8日 下午2:05:49
	 */
	public Page<HotTaskItem> getHotTaskPage2(String hashId, Integer index, Integer size);
	/**
	* @Title: getTaskContentItem
	* @Description: TODO(获取一个任务内容条目)
	* @param id
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午2:16:07
	 */
	public WatchTaskContent getWatchTaskContent(String hashId, Integer taskId);
	/**
	* @Title: getReadTaskContent
	* @Description: TODO(获取一个任务阅读内容)
	* @param taskId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午2:53:18
	 */
	public ReadTaskContent getReadTaskContent(Integer taskId);
	/**
	* @Title: getShareUrl
	* @Description: TODO(获取分享地址)
	* @param hashId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午4:14:56
	 */
	public TaskShare getTaskShare(String hashId, Integer taskId);
	/**
	* @Title: doCallback
	* @Description: TODO(处理任务回调)
	* @param hashId
	* @param taskId
	* @author jason.peng
	* @date 2016年1月13日 上午8:09:05
	 */
	public void doCallback(String hashId, Integer taskId);
	/**
	* @Title: doCallback
	* @Description: TODO(处理任务回调)
	* @param hashId
	* @param taskId
	* @author jason.peng
	* @date 2016年1月13日 上午8:09:05
	 */
	public void doCallback2(String hashId, Integer taskId);
	/**
	* @Title: doRead
	* @Description: TODO(处理任务阅读)
	* @param taskId
	* @param id
	* @author jason.peng
	* @date 2016年1月13日 上午7:55:49
	 */
	public void doRead(TaskTmp taskTmp);
	/**
	* @Title: isExistTaskTmp
	* @Description: TODO(是否存在临时任务记录)
	* @param hashFinger
	* @return
	* @author jason.peng
	* @date 2016年2月22日 下午4:50:18
	 */
	public boolean isExistTaskTmp(String hashFinger);
	
	public Page<TaskItem> getTaskPage3(String hashId, Integer index,
			Integer size);

}
