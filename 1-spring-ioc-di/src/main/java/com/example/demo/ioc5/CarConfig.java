package com.example.demo.ioc5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//<context:component-scan base-package="com.example.demo.ioc5"/>
@ComponentScan(basePackages="com.example.demo.ioc5")

// 빈 설정정보가 있을 때 사용합니다.
@Configuration
public class CarConfig {
	
//	CarMaker maker = new KiaMaker(); // 객체 생성
//	CarMaker maker = new com.example.demo.ioc3.HyundaiMaker(); // 객체 생성
//	OrderManager manager = new OrderManager(); // 객체 생성
//	manager.setMaker(maker); // DI: 의존 관계 설정

//	<bean id="kiaMaker" class="com.example.demo.ioc3.KiaMaker"></bean>
//	<bean id="hyundaiMaker" class="com.example.demo.ioc3.HyundaiMaker"></bean>
//	<bean id="manager" class="com.example.demo.ioc3.OrderManager">
//		<property name="maker" ref="hyundaiMaker"></property>
//	</bean>
	
	@Bean(name="kiaMaker")
	public KiaMaker kiaMaker() {
		KiaMaker maker = new KiaMaker();
		return maker;
	}
	
	@Primary
	@Bean // 빈 id를 생략하면 메소드명을 id로 사용합니다.
	public HyundaiMaker hyundaiMaker() {
		HyundaiMaker maker = new HyundaiMaker();
		return maker;
	}
	
	@Bean
	public OrderManager manager() {
		OrderManager manager = new OrderManager();
		manager.setMaker(kiaMaker());
		return manager;
	}
}





