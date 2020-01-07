package com.month.exams.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.month.exams.pojo.TUser;
import com.month.exams.service.UserService;

@RequestMapping("/user")
@RestController
public class UserController {

	@Reference
	private UserService userService;
	
	@RequestMapping("/role")
	public String role(){
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		TUser tUser = userService.findUsername(name);
		return tUser.getRole();
	}
}
