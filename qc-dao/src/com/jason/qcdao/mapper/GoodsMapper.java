package com.jason.qcdao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jason.qcdao.domain.po.Goods;
import com.jason.qcdao.domain.vo.GoodsItem;

/**
* @ClassName: GoodsMapper
* @Description: TODO(商品的数据库访问接口)
* @author jason.peng
* @date 2016年1月7日 下午2:36:54
 */
public interface GoodsMapper {
	/**
	* @Title: getGoods
	* @Description: TODO(获取商品列表)
	* @param start
	* @param len
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午2:54:25
	 */
	public List<GoodsItem> getGoodses(@Param("start")Integer start, @Param("len")Integer len);
	/**
	* @Title: getGoods
	* @Description: TODO(获取商品)
	* @param id
	* @return
	* @author jason.peng
	* @date 2016年1月7日 下午5:03:23
	 */
	public Goods getGoods(Integer id);
	/**
	* @Title: updateGoodsForExchange
	* @Description: TODO(更新商品作为兑换)
	* @author jason.peng
	* @date 2016年1月7日 下午5:51:04
	 */
	public void updateGoodsForExchange(@Param("id")Integer id);
}
