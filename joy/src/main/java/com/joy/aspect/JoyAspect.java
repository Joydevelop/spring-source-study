package com.joy.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author Joy
 */
@Aspect
@Component
public class JoyAspect {

	@Before("execution(public void com.joy.service.UserService.test())")
	public void joyBefore(JoinPoint joinpoint) {
		System.out.println("JoyAspect before");
	}
}
