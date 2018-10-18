package com.example.demo.proxy2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // Client
	@Autowired
	private Hello h;
	
	public void useHello() {
		h.say(); 
		// h가 가리키는 실체는 Hello로 만든 객체일 수도 있고,
		// Proxy로 만든 객체일 수도 있다.
		// 스프링이 무엇을 DI하는냐에 따라서 사용하는 실체가 변경되고
		// 수행로직이 달라진다.
	}
	
	public static void main(String[] args) {
		
		Hello hello = new Hello();
		hello.say(); // 1. 핵심로직만 실행
		
		System.out.println();
		
		Hello proxy = new Proxy();
		proxy.say(); // 2. 핵심로직 + 부가로직을 실행

	}

}
