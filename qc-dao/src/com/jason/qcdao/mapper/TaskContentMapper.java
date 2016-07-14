package com.jason.qcdao.mapper;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.vo.ReadTaskContent;
import com.jason.qcdao.domain.vo.WatchTaskContent;

/**
* @ClassName: TaskContentMapper
* @Description: TODO(任务内容数据库访问接口)
* @author jason.peng
* @date 2016年1月8日 上午10:34:23
 */
public interface TaskContentMapper {

	/**
	* @Title: getTaskContentItem
	* @Description: TODO(获取一个任务内容条目)
	* @param id
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午2:16:52
	 */
	public WatchTaskContent getWatchTaskContent(@Param("taskId")Integer taskId);
	/**
	* @Title: getReadTaskContent
	* @Description: TODO(获取一个任务阅读内容)
	* @param taskId
	* @return
	* @author jason.peng
	* @date 2016年1月12日 下午2:54:06
	 */
	public ReadTaskContent getReadTaskContent(@Param("taskId")Integer taskId);
}
