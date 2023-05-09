package com.joy.service;

import com.joy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Joy
 */
@Component
public class UserService {
	@Resource
	private OrderService orderService;
	@Autowired
	private UserService userService;

//	@Resource
//	private UserMapper userMapper;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void test() {
		System.out.println("UserService Test");
		orderService.orderTest();
//		System.out.println(userMapper.selectName());
	}

	@Transactional
	public void insert() {
		//同一个事务 要么都插入成功要么都不成功
		jdbcTemplate.execute("insert into user values (123,233)");
		userService.a();
	}

	@Transactional
	public void a() {
		jdbcTemplate.execute("insert into user values (222,333)");
	}
}
