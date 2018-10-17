package com.example.demo.ioc4;

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
				"car-config2.xml");
		
		OrderManager manager = (OrderManager) context.getBean("manager");
		manager.order();
		
		Car car1 = context.getBean(Car.class);
		System.out.println(car1);
		System.out.println(car1.getName());
		
		Car car2 = context.getBean(Car.class);
		System.out.println(car2);
		System.out.println(car2.getName());
		
		System.out.println(car1 == car2); // false
		
		KiaMaker kiaMaker = context.getBean("kiaMaker", KiaMaker.class);
		System.out.println(kiaMaker.getCar());
	}

}
