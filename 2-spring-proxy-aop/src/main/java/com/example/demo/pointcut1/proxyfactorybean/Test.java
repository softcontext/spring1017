package com.example.demo.pointcut1.proxyfactorybean;

import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
//		Advice advice = new MyAdvice();
		
		/*
		 * 	execution() : 사용하는 표현식 종류
		 * 	* one*(..) : 리턴자료형 메소드명(파라미터)
		 * 	* : all
		 *  one* : 메소드명이 one 문자열로 시작
		 *  (..) : 파라미터 개수가 0~N개 가능, 각 파라미터 자료형은 상관이 없다.
		 */
//		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
//		pointcut.setExpression("execution(* one*(..))");
//		
//		Advisor advisor = new DefaultPointcutAdvisor(pointcut, advice);
//		
//		ProxyFactory factory = new ProxyFactory();
//		factory.setTarget(new First());
//		factory.addAdvisor(advisor);
//		
//		First f = (First) factory.getProxy();
//		f.one();
//		f.one2();
//		f.two();
//		f.add(2, 3);
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"proxy-factory-bean.xml");
		
		First f = (First) context.getBean("proxyFirst");
		f.one();
		f.one2();
		f.two();
		f.add(2, 3);
	}

}
