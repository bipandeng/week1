package com.bpd.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bpd.bean.Goods;
import com.bpd.bean.Type;
import com.bpd.mapper.GoodsMapper;

@Service
public class GoodsServiceImpl implements GoodsService {

	
	@Resource
	private GoodsMapper goodsMapper;
	
	
	public List<Goods> listGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsMapper.listGoods(map);
	}

	public int addGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.addGoods(goods);
	}

	public int updGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsMapper.updGoods(goods);
	}

	public Goods selOne(int id) {
		// TODO Auto-generated method stub
		return goodsMapper.selOne(id);
	}

	public List<Type> listType() {
		// TODO Auto-generated method stub
		return goodsMapper.listType();
	}

	public int delsGoods(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return goodsMapper.delsGoods(map);
	}

	

}
