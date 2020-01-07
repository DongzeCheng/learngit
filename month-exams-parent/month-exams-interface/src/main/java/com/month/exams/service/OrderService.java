package com.month.exams.service;

import com.month.exams.pojo.TGoods;
import com.month.exams.pojo.TOrder;

public interface OrderService {

	public TGoods back(int id);

	public void save(TOrder tOrder);
}
