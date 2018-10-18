package com.example.demo.proxy1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test { // Client
	@Autowired
	private Hello h;
	
	public void useHello() {
		h.say(); 
		// 1번, 2번 중에 무엇일까요? 모른다. 
		// 다만, Hello 인터페이스의 구현체 중 하나일 것이라고 추측만 가능하다.
		// h 변수가 가리키는 실체는 HelloImpl 객체일 수도 있고, Proxy 객체일 수도 있다.
		// 실체는 런타임시에 결정되므로 코드 레벨에서는 미리 판단할 수 없습니다.
	}
	
	// 클라이언트 객체가 사용하는 로직이 빈번하게 변경되는 상황입니다.
	// 클라이언트 클래스의 소스코드를 바꾸지 않고도 이를 적용할 수 있는 방법이 필요합니다.
	public static void main(String[] args) {
		
		Hello hello = new HelloImpl();
		hello.say(); // 1. 핵심로직만 실행
		
		System.out.println();
		
		Hello proxy = new Proxy(hello);
		proxy.say(); // 2. 핵심로직 + 부가로직을 실행

	}

}
