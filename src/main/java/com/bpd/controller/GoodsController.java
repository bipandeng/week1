package com.bpd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bpd.bean.Goods;
import com.bpd.bean.Type;
import com.bpd.service.GoodsService;
import com.fasterxml.jackson.databind.deser.std.NumberDeserializers.BooleanDeserializer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class GoodsController {

	@Resource
	private GoodsService goodsService;

	@RequestMapping("list")
	public String listGoods(Model mod, Goods goods, @RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "") String name, @RequestParam(defaultValue = "") String start,
			@RequestParam(defaultValue = "") String end) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", name);
		map.put("start", start);
		map.put("end", end);
		PageHelper.startPage(pageNum, 2);
		List<Goods> list = goodsService.listGoods(map);
		PageInfo<Goods> pp = new PageInfo<Goods>(list);
		mod.addAttribute("pp", pp);
		mod.addAttribute("name", name);
		return "list";
	}
	@RequestMapping("delsGoods")
	@ResponseBody
	public  Boolean  delsGoods(String ids){
		String[] split = ids.split(",");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("ids", split);
		int i = goodsService.delsGoods(map);
		if(i>0){
			return true;
		}
		return false;
	}
	/**
	 * 添加
	 * @param goods
	 * @return
	 */
	@RequestMapping("addGoods")
	@ResponseBody
	public  Boolean  addGoods(Goods goods){
		int i = goodsService.addGoods(goods);
		if(i>0){
			return true;
		}
		return false;
	}
	/**
	 * 下拉
	 */
	@RequestMapping("selType")
	@ResponseBody
	public   List<Type> typeList(){
		List<Type> list = goodsService.listType();
		return list;
	}
	/**
	 * 修改
	 */
	@RequestMapping("updGoods")
	@ResponseBody
	public  Boolean  updGoods(Goods goods){
		int i = goodsService.updGoods(goods);
		if(i>0){
			return true;
		}
		return false;
	}
	/**
	 * 回显
	 */
	@RequestMapping("selone")
	@ResponseBody
	public   Goods  selOne(int id){
		Goods selOne = goodsService.selOne(id);
		return selOne;
	}
}
