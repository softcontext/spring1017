package com.example.demo.ioc2;

public class Test {

	// 3. Test 클래스에서 직접 KiaMaker/HyundaiMaker 단어가 노출되므로
	// 이 클래스는 변화에 취약하고 코드 수정이 불가피합니다.
	// OrderManager 클래스에 적용했던 #2을 이 클래스에도 적용해야 합니다.
	// 위 모습은 모든 클래스가 동일하므로 결국 맨 앞에 클래스는 프로그램에서 사용하는
	// 모든 객체와 의존하는 객체를 설정하는 코드를 수행해야 합니다.
	// 이러한 코딩을 설정파일을 통해 프레임워크에게 위임하면 편리합니다.
	
	public static void main(String[] args) {
//		CarMaker maker = new KiaMaker(); // 객체 생성
		CarMaker maker = new HyundaiMaker(); // 객체 생성
		
		OrderManager manager = new OrderManager(); // 객체 생성
		manager.setMaker(maker); // OrderManager가 사용해야 하는 대상 객체를 먼저 알려주어야 합니다.
		manager.order(); // 필요한 시점에 로직을 실행
	}

}
