package com.example.demo.ioc3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
//		CarMaker maker = new KiaMaker(); // 객체 생성
//		CarMaker maker = new com.example.demo.ioc3.HyundaiMaker(); // 객체 생성
//		
//		OrderManager manager = new OrderManager(); // 객체 생성
//		manager.setMaker(maker); // DI: 의존 관계 설정
//		manager.order(); // 필요한 시점에 로직을 실행
		
		/*
		 * 스프링에게 객체생성 및 의존 관계 설정을 위임하는 방법
		 * 1. XML
		 * 2. Annotation
		 * 3. Java Configuration Class
		 */
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"car-config.xml");
		
		// 빈 id로 객체를 구한다.
//		OrderManager manager = (OrderManager) context.getBean("manager");
		
		// 자료형으로 객체를 구한다.
		OrderManager manager = (OrderManager) context.getBean(OrderManager.class);
		
		manager.order();
		
		OrderManager manager2 = (OrderManager) context.getBean(OrderManager.class);
		
		// Singleton: 컨테이너 안에 해당 자료형의 객체가 하나만 존재합니다.
		// 요청할 때마다 이미 만들어 놓은 객체를 전달합니다.
		System.out.println(manager == manager2); // true
	}

}
