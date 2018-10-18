package com.example.demo.pointcut1.aopns3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyAroundAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		System.out.println("-----Around Before Advice-----");
		
		Object ret = invocation.proceed(); // 타겟 객체의 핵심로직 메소드를 호출
		
		System.out.println("=====Around After Advice======");
		
		return ret;
	}

}
