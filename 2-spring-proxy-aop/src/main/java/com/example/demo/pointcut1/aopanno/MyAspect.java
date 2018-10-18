package com.example.demo.pointcut1.aopanno;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

//<aop:config proxy-target-class="true">
//	<aop:pointcut expression="execution(* two(..))" id="pointcut"/>
//	
//	<aop:aspect ref="myAspect">
//		<aop:before method="myBefore" pointcut="execution(* add(..))"/>
//		<aop:around method="myAround" pointcut-ref="pointcut"/>
//		<aop:after-returning method="myAfterReturning" pointcut="execution(* divide(..))" returning="result"/>
//		<aop:after-throwing method="myAfterThrowing" pointcut="execution(* divide(..))" throwing="error"/>
//		<aop:after method="myAfter" pointcut-ref="pointcut"/>
//	</aop:aspect>
//</aop:config>	
	
	@Pointcut("execution(* two(..))")
	public void pointcut() {}
	
	@Before("execution(* add(..))")
	public void myBefore(JoinPoint jointPoint) {
		System.out.println("-----MyAspect # myBefore------");
		Object[] args = jointPoint.getArgs();
		if (args != null && args.length > 0) {
			for (Object object : args) {
				System.out.println(">>> " + object);
			}
		}
	}
	
	@Around("pointcut()")
	public Object myAround(ProceedingJoinPoint jointPoint) throws Throwable {
		System.out.println("-----MyAspect # myAround : Before------");
		
		Object ret = jointPoint.proceed();

		System.out.println("=====MyAspect # myAround : After======");
		
		return ret;
	}
	
	@AfterReturning(pointcut="execution(* divide(..))", returning="result")
	public void myAfterReturning(JoinPoint jointPoint, Object result) {
		System.out.println("=====MyAspect # myAfterReturning======");
		System.out.println(">>> " + result);
	}
	
	@AfterThrowing(pointcut="execution(* divide(..))", throwing="error")
	public void myAfterThrowing(JoinPoint jointPoint, Throwable error) {
		System.out.println("=====MyAspect # myAfterThrowing======");
		System.out.println(">>> " + error.getMessage());
	}
	
	@After("pointcut()")
	public void myAfter(JoinPoint jointPoint) {
		System.out.println("=====MyAspect # myAfter======");
	}

}
