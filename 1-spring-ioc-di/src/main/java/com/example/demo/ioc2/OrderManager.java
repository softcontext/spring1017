package com.example.demo.ioc2;

// OrderManager has CarMaker.
// OrderManager use CarMaker.
// OrderManager depend CarMaker. ==> Dependency Injection
public class OrderManager {
	// OrderManager가 사용하는 클래스가 매일 변경되어야 합니다.
	// 개발자가 어떻게 대응해야 할까요?
	// 상황에 따라 코드 수정이 빈번하다면 해당 클래스는 개발이 완료된 클래스라고 볼 수 없습니다.
	// 상황에 따라 코드를 수정하지 않고도 운영자가 직접 로직의 변경을 선택해서 사용할 수 있도록 조치해야 합니다.
	// 즉, 클래스의 수정이 없이도 OrderManager가 사용하는 클래스의 변경이 적용되어야 합니다.
	
	// 해결방법
	// 1. 인터페이스를 도입한다. (객체지향 격언: 변화가 있다면 인터페이스를 도입해라)
	// 인터페이스 자료형으로 사용 객체를 지칭한다.
	// 멤버변수는 코드변경 없이 그대로 사용할 수 있게 되었습니다.
	// 2. OrderManager가 사용하는 대상 객체를 가리키는 자료형이 코드에서 노출되지 않도록 조치합니다.
	// 객체지향 격언: 코드의 수정에는 닫혀 있고(배포 버전) 기능의 확장(패키지 버전을 통한 확장)에 열려 있도록 코딩하라.
	
	// OrderManager 클래스내에서 이 클래스가 사용하는 대상 객체를 지칭하는 
	// 모든 단어를 추방해서 변화가 있어도 이 클래스의 코드 수정은 없도록 만들었습니다.
	
	private CarMaker maker;
	
	public OrderManager() {
//		maker = new HyundaiMaker();
//		maker = new KiaMaker();
	}
	
	public void order() {
		Money money = new Money(1000);
		System.out.println("OrderManager # " + money.getAmount() + "원을 만든다.");
		
		Car car = maker.sell(money);
		System.out.println("OrderManager # 돈을주고 " + car.getName() + "를 산다.");
	}

	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
	
}
