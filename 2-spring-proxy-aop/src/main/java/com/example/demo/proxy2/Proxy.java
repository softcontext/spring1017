package com.example.demo.proxy2;

public class Proxy extends Hello {
	
	@Override
	public void say() {
		System.out.println("-----전 처리 부가로직-----"); // 상황에 따라 실행되는 로직
		
		super.say(); // 위임(Delegation): 핵심로직을 호출
		
		System.out.println("=====후 처리 부가로직====="); // 상황에 따라 실행되는 로직
	}

}
