package com.month.exams.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.month.exams.mapper.TGoodsMapper;
import com.month.exams.pojo.TGoods;
import com.month.exams.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService{

	@Autowired
	private TGoodsMapper tGoodsMapper;
	
	@Override
	public List<TGoods> getList() {
		// TODO Auto-generated method stub
		return tGoodsMapper.selectByExample(null);
	}

	@Override
	public void save(TGoods tGoods) {
		// TODO Auto-generated method stub
		tGoods.setZt(0);
		tGoodsMapper.insert(tGoods);
	}

	@Override
	public void dwon(int id) {
		// TODO Auto-generated method stub
		tGoodsMapper.dwon(id);
	}

	@Override
	public void uo(int id) {
		// TODO Auto-generated method stub
		tGoodsMapper.up(id);
	}

	@Override
	public TGoods findId(int id) {
		// TODO Auto-generated method stub
		return tGoodsMapper.selectByPrimaryKey(id);
	}

}
