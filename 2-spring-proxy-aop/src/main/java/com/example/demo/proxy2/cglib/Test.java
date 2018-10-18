package com.example.demo.proxy2.cglib;

import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.ProxyFactory;

public class Test { // Client

	public static void main(String[] args) {
		
		Hello hello = new Hello();
		hello.say(); // 1. 핵심로직만 실행
		hello.bye();
		
		System.out.println();
		
		Advice advice = new MyAdvice();
		
		// CGLIB Dynamic Proxy
		ProxyFactory factory = new ProxyFactory();
		factory.setTarget(hello); // 타겟 객체 지정
		factory.addAdvice(advice); // 어드바이스 객체 설정
		
		// 타겟 객체와 어드바이스 객체만 지정하면 기본적으로
		// 타겟 객체의 모든 메소드를 호출할 때 어드바이스 로직이 작동합니다.
		
//		-----Around Before Advice-----
//		핵심로직: Hello~!!!
//		=====Around After Advice======
		
//		-----Around Before Advice-----
//		핵심로직: Goodbye~!
//		=====Around After Advice======
		
		// 그런데 때때로 타겟 객체의 일부 메소드만 어드바이스를 적용하고 싶을 때가 있습니다.
		// 이를 조절하는 기술로 Pointcut을 추가로 적용해야 합니다.
		
		Hello proxy = (Hello) factory.getProxy();
		proxy.say(); // 2. 핵심로직 + 부가로직을 실행
		proxy.bye();
		
		
	}

}
