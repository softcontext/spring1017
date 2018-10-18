package com.example.demo.proxy1.jdk;

import java.lang.reflect.Proxy;

public class Test { // Client

	public static void main(String[] args) {
		
		Hello hello = new HelloImpl();
		hello.say(); // 1. 핵심로직만 실행
		
		System.out.println();
		
		// 프록시 클래스를 타겟클래스의 숫자만큼 만드는 것은 굉장히 번거로운 작업입니다.
		// 그래서 스프링은 개발자 대신 프록시 객체를 자동으로 생성하는 기술을 사용합니다.
		// Proxy 클래스는 개발자가 만들 필요가 없으므로 삭제했습니다.
		// 그런데 어디엔가는 부가로직을 정의해서 갖고 있어야 합니다.
		// 그래서 InvocationHandler 인터페이스를 구현하는 클래스를 만들고
		// invoke 메소드가 부가로직을 갖고 있도록 조치합니다.
		
		// JDK Dynamic Proxy
		Hello proxy = (Hello) Proxy.newProxyInstance(
				Hello.class.getClassLoader(), // 접근방법
				new Class<?>[] {Hello.class}, // 메소드 정보
				new MyAdvice(new HelloImpl())); // 부가로직
		
		proxy.say(); // 2. 핵심로직 + 부가로직을 실행
		
		System.out.println("\n---------------\n");
		
		Builder builder = new BigBuilder();
		builder.build();
		
		System.out.println();
		
		Builder proxyBuilder = (Builder) Proxy.newProxyInstance(
				Builder.class.getClassLoader(),
				new Class<?>[] {Builder.class},
				new MyAdvice(new BigBuilder())); // 어드바이스 클래스를 재사용
		
		proxyBuilder.build();
	}

}
