package com.joy.proxy;

import com.joy.service.UserService;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;


/**
 * @author Joy
 */
public class SpringProxyMainTest {
	public static void main(String[] args) {
		MemberService target = new MemberService();


		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(target);
		proxyFactory.addAdvice((MethodBeforeAdvice) (method, args1, target1) -> System.out.println("before"));
		MemberService proxy = (MemberService) proxyFactory.getProxy();
		proxy.test();
	}
}
