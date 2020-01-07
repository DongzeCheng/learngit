package com.month.exams.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.month.exams.mapper.TGoodsMapper;
import com.month.exams.mapper.TOrderMapper;
import com.month.exams.pojo.TGoods;
import com.month.exams.pojo.TOrder;
import com.month.exams.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private TOrderMapper tOrderMapper;
	
	@Autowired
	private TGoodsMapper tGoodsMapper;
	
	@Override
	public TGoods back(int id) {
		// TODO Auto-generated method stub
		return tGoodsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void save(TOrder tOrder) {
		// TODO Auto-generated method stub
		tOrder.setZt(0);
		tOrderMapper.insert(tOrder);
	}

}
