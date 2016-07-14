package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.vo.HotTaskItem;
import com.jason.qcdao.domain.vo.TaskCallback;
import com.jason.qcdao.domain.vo.TaskItem;
import com.jason.qcdao.domain.vo.TaskRead;
import com.jason.qcdao.domain.vo.TaskShare;

/**
* @ClassName: TaskMapper
* @Description: TODO(任务实体数据库访问接口)
* @author jason.peng
* @date 2016年1月8日 上午10:32:25
 */
public interface TaskMapper {
	/**
	* @Title: getTasks
	* @Description: TODO(获取任务列表)
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月8日 上午11:31:46
	 */
	public List<TaskItem> getTasks(@Param("hashId")String hashId, @Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: getTasks
	* @Description: TODO(获取任务列表)
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月8日 上午11:31:46
	 */
	public List<TaskItem> getTasks2(@Param("hashId")String hashId, @Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: getHotTasks
	* @Description: TODO(获取热门任务)
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月8日 下午2:06:37
	 */
	public List<HotTaskItem> getHotTasks(@Param("hashId")String hashId, @Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: getTaskShare
	* @Description: TODO(获取任务分享信息)
	* @param taskId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午4:55:56
	 */
	public TaskShare getTaskShare(@Param("id")Integer id);
	/**
	* @Title: getTaskCallback
	* @Description: TODO(获取任务回调)
	* @param taskId
	* @return
	* @author jason.peng
	* @date 2016年1月13日 上午8:14:49
	 */
	public TaskCallback getTaskCallback(@Param("id")Integer id);
	/**
	* @Title: updateTaskForShare
	* @Description: TODO(更新任务作为分享)
	* @param taskId
	* @param status
	* @author jason.peng
	* @date 2016年1月13日 上午8:40:28
	 */
	public void updateTaskForShare(@Param("id")Integer id);
	/**
	* @Title: getTaskRead
	* @Description: TODO(获取任务阅读相关)
	* @param taskId
	* @return
	* @author jason.peng
	* @date 2016年1月13日 上午8:46:35
	 */
	public TaskRead getTaskRead(@Param("id")Integer id);
	/**
	* @Title: updateTaskForRead
	* @Description: TODO(更新任务作为阅读)
	* @param taskId
	* @param point
	* @author jason.peng
	* @date 2016年1月13日 上午8:49:54
	 */
	public void updateTaskForRead(@Param("id")Integer id, @Param("point")Integer point, 
			@Param("status")Integer status);
	/**
	* @Title: updateTaskForFinish
	* @Description: TODO(更新任务完成)
	* @author jason.peng
	* @date 2016年1月14日 下午4:34:53
	 */
	public void updateTaskForFinish();
	/**
	* @Title: getFinishTaskIds
	* @Description: TODO(获取前一天完成的任务)
	* @return
	* @author jason.peng
	* @date 2016年2月24日 上午1:01:26
	 */
	public List<Integer> getFinishTaskIds();

}
