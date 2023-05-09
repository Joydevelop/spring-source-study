package com.joy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Joy
 */
public class JdkProxyMainTest {
	public static void main(String[] args) {
		MemberService target = new MemberService();


		MemberInterface memberInterface = (MemberInterface) Proxy.newProxyInstance(JdkProxyMainTest.class.getClassLoader(), new Class[]{MemberInterface.class}, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println("before");
				Object invoke = method.invoke(target,args);
				System.out.println("after");
				return invoke;
			}
		});
		memberInterface.test();

	}
}
