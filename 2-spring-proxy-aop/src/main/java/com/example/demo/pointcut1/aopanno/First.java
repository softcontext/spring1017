package com.example.demo.pointcut1.aopanno;

import org.springframework.stereotype.Component;

@Component
public class First {
	
	public void one() {
		System.out.println("First # one()");
	}
	
	public void one2() {
		System.out.println("First # one2()");
	}
	
	// before advice
	
	public void two() {
		System.out.println("First # two()");
	}
	
	// after advice
	
	public int add(int a, int b) {
		System.out.println("First # add(int a, int b)");
		return a + b;
	}
	
	public int divide(int a, int b) {
		System.out.println("First # divide(int a, int b)");
		return a / b;
	}
}
