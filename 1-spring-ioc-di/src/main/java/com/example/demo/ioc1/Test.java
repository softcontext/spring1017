package com.example.demo.ioc1;

public class Test {

	public static void main(String[] args) {
		OrderManager manager = new OrderManager(); // 객체 생성
		manager.order(); // 필요한 시점에 로직을 실행
	}

}
