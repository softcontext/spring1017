package com.example.demo.proxy1.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 개발자가 앞서서 만든 Proxy 클래스는 오로지 HelloImpl 타겟 클래스만 프록싱 할 수 있으나
// InvocationHandler 인터페이스를 구현한 MyAdvice 클래스는 모든 타겟 클래스를 프록싱 할 수 있습니다.
public class MyAdvice implements InvocationHandler {
	private Object target;
	
	public MyAdvice(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		System.out.println("-----Around Before Advice-----"); // 상황에 따라 실행되는 로직
		
//		((HelloImpl)target).say(); // 이렇게 사용하면 범용성을 잃어 버리게 됩니다.
		
		// 타겟 클래스의 핵심로직을 호출하는 방법 또한 범용성을 확보해야 하므로
		// 자바 리플렉션에서 지원하는 Method 클래스의 invoke 메소드를 사용합니다.
		// Method 객체는 내부에 호출해야 하는 메소드 정보를 갖고 있습니다.
		// 다음 코드는 target 객체 안에 메소드를 호출하면서 args 를 파라미터로 전달하는 뜻이 됩니다.
		Object ret = method.invoke(target, args); // 위임(Delegation): 핵심로직을 호출
		
		System.out.println("=====Around After Advice======"); // 상황에 따라 실행되는 로직
		
		return ret;
	}

}
