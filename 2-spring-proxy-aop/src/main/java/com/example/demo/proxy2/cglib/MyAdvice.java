package com.example.demo.proxy2.cglib;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("-----Around Before Advice-----"); // 상황에 따라 실행되는 로직
		
		Object ret = invocation.proceed(); // 위임(Delegation): 핵심로직을 호출
		
		System.out.println("=====Around After Advice======"); // 상황에 따라 실행되는 로직
		
		return ret;
	}

}
