package com.month.exams.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.month.exams.pojo.TGoods;
import com.month.exams.pojo.TOrder;
import com.month.exams.service.OrderService;

import entity.Result;

@RequestMapping("/order")
@RestController
public class OrderController {

	@Reference
	private OrderService orderService;
	
	@RequestMapping("/back")
	public TGoods back(int id){
		return orderService.back(id);
	}
	
	@RequestMapping("/save")
	public Result save(@RequestBody TOrder tOrder){
		try {
			orderService.save(tOrder);
			return new Result(true, "提交成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return new Result(false, "提交失败");
		}
	}
}
