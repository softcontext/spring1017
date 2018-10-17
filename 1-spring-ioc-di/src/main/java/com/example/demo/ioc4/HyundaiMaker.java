package com.example.demo.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// <bean id="hyundaiMaker" class="com.example.demo.ioc4.HyundaiMaker"></bean>

@Primary
@Component("hyundaiMaker")
public class HyundaiMaker implements CarMaker {
	@Autowired
	private Car car;
	
	@Override
	public Car sell(Money money) {
		System.out.println("HyundaiMaker # " + money.getAmount() + "원을 차 값으로 받는다.");
		
//		Car car = new Car("Sonata");
		car.setName("Sonata");
		System.out.println("HyundaiMaker # " + car.getName() + "를 만들어서 판다.");
		
		return car;
	}
}
