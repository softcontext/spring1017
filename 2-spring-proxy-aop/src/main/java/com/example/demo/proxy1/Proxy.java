package com.example.demo.proxy1;

public class Proxy implements Hello {
	
	private Hello hello;
	
	public Proxy(Hello hello) {
		this.hello = hello;
	}
	
	@Override
	public void say() {
		System.out.println("-----전 처리 부가로직-----"); // 상황에 따라 실행되는 로직
		
		hello.say(); // 위임(Delegation): 핵심로직을 호출
		
		System.out.println("=====후 처리 부가로직====="); // 상황에 따라 실행되는 로직
	}

}
