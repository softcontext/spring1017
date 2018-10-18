package com.example.demo.pointcut1.aopns3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"aopns-example3.xml");
		
		First f = context.getBean(First.class);
		f.one();
		f.one2();
		f.two();
		f.add(2, 3);
		
		try {
			f.divide(4, 2);
			f.divide(4, 0);
		} catch (Exception ignore) {}
		
		System.out.println();
		
		Second s = context.getBean(Second.class);
		s.one();
		s.one2();
		s.two();
		s.add(2, 3);
	}

}
