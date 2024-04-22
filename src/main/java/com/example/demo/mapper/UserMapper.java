package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {
	// 查询的结果放在list<User>集合里面
	List<User> findAll();

	String getPassword(@Param("username") String username);
	// 这里的@Param是为了传参数到xml,这里是为了传username获取正确密码
}

/*
 * Mapper层负责实现与数据库的交互操作,一般会在这里提供了方法(先设计接口)
 * 然后在配置文件(也就是Mapper.xml)中进行配置其实现的关联,具体的sql语句 就是写在Mapper.xml里面的
 * (接口里的方法名和Mapper.xml定义的statement的id相同)
 * 通常Mapper层使用ORM（对象关系映射）框架来简化数据库操作,这里用的就是MyBatis
 */
