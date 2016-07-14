package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.TaskTmp;

public interface TaskTmpMapper {
	/**
	* @Title: isExistTaskTmp
	* @Description: TODO(判断是否存在临时任务)
	* @param hashFinger
	* @return
	* @author jason.peng
	* @date 2016年2月22日 下午4:51:51
	 */
	public Integer isExistTaskTmp(@Param("hashFinger")String hashFinger);
	/**
	* @Title: saveTaskTmp
	* @Description: TODO(保存临时任务记录)
	* @param taskTmp
	* @author jason.peng
	* @date 2016年2月22日 下午5:01:59
	 */
	public void saveTaskTmp(TaskTmp taskTmp);
	/**
	* @Title: deleteTaskTmps
	* @Description: TODO(删除任务的临时记录)
	* @param ids
	* @author jason.peng
	* @date 2016年2月24日 上午1:03:39
	 */
	public void deleteTaskTmps(@Param("ids")List<Integer> ids);

}
