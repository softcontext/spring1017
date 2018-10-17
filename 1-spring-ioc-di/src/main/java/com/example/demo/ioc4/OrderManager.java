package com.example.demo.ioc4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// @Service 애노테이션은 @Component 애노테이션의 확장(상속)입니다.
// 빈 객체를 역할에 따라서 구분해 놓으면 나중에 객체들을 조작할 때 역할별로 그룹핑해서 처리할 수 있습니다.
@Service("manager")
public class OrderManager {
	// 자료형이 CarMaker인 빈 객체를 찾아서 변수에 주입합니다.
	@Autowired
	// @Autowired로 대상을 찾았는데 대상이 2개 이상이면 그 중에서 어는 것을 사용할지 결정합니다.
	// 에러메시지: expected single matching bean but found 2: hyundaiMaker,kiaMaker
//	@Qualifier("hyundaiMaker")
	private CarMaker maker;
	
	public OrderManager() {}
	
	public OrderManager(CarMaker maker) {
		super();
		this.maker = maker;
	}

	public void order() {
		Money money = new Money(1000);
		System.out.println("OrderManager # " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager # 돈을주고 " + car.getName() + "를 산다.");
	}

	// 빈 id가 kiaMaker인 객체를 찾아서 파라미터로 전달합니다.
//	@Resource(name="kiaMaker")
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
	
}
