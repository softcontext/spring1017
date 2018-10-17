package com.example.demo.ioc1;

public class OrderManager {
	// 운영정책에 따라 KiaMaker 에게 주문을 해야 합니다.
	// 개발자가 어떻게 대응해야 할까요?
	// 1. 새 클래스 KiaMaker를 만든다.
	// 2. OrderManager가 KiaMaker를 사용하도록 코드를 수정합니다.
	
	// OrderManager가 사용하는 클래스가 매일 변경되어야 합니다.
	// 개발자가 어떻게 대응해야 할까요?
	// 상황에 따라 코드 수정이 빈번하다면 해당 클래스는 개발이 완료된 클래스라고 볼 수 없습니다.
	// 상황에 따라 코드를 수정하지 않고도 운영자가 직접 로직의 변경을 선택해서 사용할 수 있도록 조치해야 합니다.
	// 즉, 클래스의 수정이 없이도 OrderManager가 사용하는 클래스의 변경이 적용되어야 합니다.
	
	private HyundaiMaker maker = new HyundaiMaker();
//	private KiaMaker maker = new KiaMaker();
	
	public void order() {
		Money money = new Money(1000);
		System.out.println("OrderManager # " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager # 돈을주고 " + car.getName() + "를 산다.");
	}
}
