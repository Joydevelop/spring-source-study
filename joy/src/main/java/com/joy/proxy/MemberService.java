package com.joy.proxy;

/**
 * @author Joy
 */
public class MemberService implements MemberInterface {
	@Override
	public void test() {
		System.out.println("test");
	}

	public void test1() {
		System.out.println("test1");
	}

}
