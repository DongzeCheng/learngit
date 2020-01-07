package com.month.exams.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.month.exams.mapper.TUserMapper;
import com.month.exams.pojo.TUser;
import com.month.exams.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private TUserMapper tUserMapper;
	
	@Override
	public TUser findUsername(String username) {
		// TODO Auto-generated method stub
		return tUserMapper.findUsername(username);
	}

}
