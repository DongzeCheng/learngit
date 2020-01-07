package com.month.exams.service;

import java.util.List;

import com.month.exams.pojo.TGoods;

public interface GoodsService {

	public List<TGoods> getList();

	public void save(TGoods tGoods);

	public void dwon(int id);

	public void uo(int id);

	public TGoods findId(int id);
}
