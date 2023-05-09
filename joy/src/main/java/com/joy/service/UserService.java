package com.joy.service;

import com.joy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
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
		jdbcTemplate.execute("insert into user values (123,233)");
		try {
			userService.a();
		}catch (Exception e){

		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW,timeout = 1)
	public void a() {
		jdbcTemplate.execute("insert into user values (222,333)");
		throw new RuntimeException();
	}
}
