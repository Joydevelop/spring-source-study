package com.joy.proxy;

import org.springframework.cglib.proxy.*;

/**
 * @author Joy
 */
public class CglibMainTest {
	public static void main(String[] args) {
		MemberService target = new MemberService();
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(MemberService.class);
		enhancer.setCallbacks(new Callback[]{(MethodInterceptor) (o, method, objects, methodProxy) -> {
			System.out.println("before");
			Object result = methodProxy.invoke(target, objects);
			System.out.println("after");
			return result;
		}, NoOp.INSTANCE});
		enhancer.setCallbackFilter(method -> {
			if (method.getName().equals("test")) {
				return 0;
			} else {
				return 1;
			}
		});
		MemberService memberService = (MemberService) enhancer.create();
		memberService.test();
	}
}


