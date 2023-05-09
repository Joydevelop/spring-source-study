package com.joy;

import com.joy.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Joy
 */
public class SpringMainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.register(AppConfig.class);
		applicationContext.refresh();
		UserService userService = applicationContext.getBean(UserService.class);
		userService.insert();
	}
}