package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.User;
import com.example.demo.service.impl.UserServiceimpl;

@CrossOrigin
@RestController
//这个注解会将返回值中的对象直接转为JSON,再响应回来
@RequestMapping("/user")
//@RequestMapping作用就是映射URL路径，将http的请求地址映射到控制器(controller)类的处理方法上
public class UserController {

	@Autowired
	private UserServiceimpl userServiceimpl;
	// 通过@Autowired直接将实例化的service层的具体实现类注入进来

	@CrossOrigin
	@RequestMapping("/findAll")
	public List<User> findAll() {
		return userServiceimpl.findAll();
	}

	@CrossOrigin
	@RequestMapping("/isPass")
	public Boolean isPass(String username, String password) {
		boolean ispass = userServiceimpl.isPass(username, password);
		return ispass;
	}

}

