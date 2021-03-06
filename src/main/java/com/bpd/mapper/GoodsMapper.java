package com.bpd.mapper;

import java.util.List;
import java.util.Map;

import com.bpd.bean.Goods;
import com.bpd.bean.Type;

public interface GoodsMapper {

	/**
	 * 查询
	 * @param map
	 * @return
	 */
	public   List<Goods> listGoods(Map<String, Object> map);
	public   int  addGoods(Goods goods);
	public   int  updGoods(Goods goods);
	public   Goods selOne(int id);
	public   List<Type> listType();
	public   int  delsGoods(Map<String, Object> map);
}
