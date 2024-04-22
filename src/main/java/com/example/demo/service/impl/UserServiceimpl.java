package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

@Service("userService")
public class UserServiceimpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	/*
	 * @Autowired是一个注解配置,用于自动装配（自动注入）Spring Bean到其他Bean中
	 * 这么说太笼统了,这里的之所以需要调用这个依赖的原因是需要用到mapper层的UserMapper
	 * 所以将UserMapper的实例注入,前面的controller层的@Autowired也是同理,之所以写是因为需要将
	 * UserService的具体实现类也就是UserServiceimpl,注入进来,调用里面的findAll()和isPass()
	 */

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	@Override
	public String getPassword(String username) {
		return userMapper.getPassword(username);
	}

	// 验证密码方法
	public Boolean isPass(String username, String password) {
		String truePassword = getPassword(username);
		if (password.equals(truePassword))
			return true;
		else
			return false;
	}
}
