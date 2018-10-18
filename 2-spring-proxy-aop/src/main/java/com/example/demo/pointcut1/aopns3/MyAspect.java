package com.example.demo.pointcut1.aopns3;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class MyAspect {

	// 항상기동: 타겟 메소드 보다 앞서서 수행됩니다.
	public void myBefore(JoinPoint jointPoint) {
		System.out.println("-----MyAspect # myBefore------");
		Object[] args = jointPoint.getArgs();
		if (args != null && args.length > 0) {
			for (Object object : args) {
				System.out.println(">>> " + object);
			}
		}
	}
	
	// 앞은 항상기동, 뒤는 조건기동: 타겟 메소드를 감싼 형태로 앞, 뒤에서 수행됩니다.
	public Object myAround(ProceedingJoinPoint jointPoint) throws Throwable {
		System.out.println("-----MyAspect # myAround : Before------");
		
		// 여기서 타겟 메소드를 호출하자라는 코드가 있어야만
		// 위 코드는 Before로 실행되고 아래 코드는 After로 실행됩니다.
		Object ret = jointPoint.proceed();

		System.out.println("=====MyAspect # myAround : After======");
		
		return ret;
	}
	
	// 조건기동: 타겟 메소드가 정상적으로 처리된 후 수행됩니다.
	public void myAfterReturning(JoinPoint jointPoint, Object result) {
		System.out.println("=====MyAspect # myAfterReturning======");
		System.out.println(">>> " + result);
	}
	
	// 조건기동: 타겟 메소드 처리 시 예외가 발생한 경우 수행됩니다.
	public void myAfterThrowing(JoinPoint jointPoint, Throwable error) {
		System.out.println("=====MyAspect # myAfterThrowing======");
		System.out.println(">>> " + error.getMessage());
	}
	
	// 항상기동: 타겟 메소드가 수행된 다음 뒤에서 수행됩니다.
	public void myAfter(JoinPoint jointPoint) {
		System.out.println("=====MyAspect # myAfter======");
	}

}
