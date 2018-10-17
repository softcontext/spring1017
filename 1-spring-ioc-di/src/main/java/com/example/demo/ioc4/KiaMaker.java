package com.example.demo.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component // 빈 id를 생략하면 클래스명을 사용합니다. 단, id는 소문자로 시작합니다.
public class KiaMaker implements CarMaker {
//	@Autowired
	private Car car;
	
	@Override
	public Car sell(Money money) {
		System.out.println("KiaMaker # " + money.getAmount() + "원을 차 값으로 받는다.");
		
//		Car car = new Car("K9");
		car.setName("K9");
		System.out.println("KiaMaker # " + car.getName() + "를 만들어서 판다.");
		
		return car;
	}

	
	public Car getCar() {
		return car;
	}

	@Autowired
	@Required // 주로 XML 설정 시 깜박하고 setter주입을 하지 않으면 바로 에러메시지를 출력한다.
	public void setCar(Car car) {
		this.car = car;
	}
	
}
