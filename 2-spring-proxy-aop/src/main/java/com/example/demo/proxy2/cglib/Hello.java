package com.example.demo.proxy2.cglib;

public class Hello {
	public void say() {
		System.out.println("핵심로직: Hello~!!!"); // 언제나 실행되어야 하는 로직
	}
	
	public void bye() {
		System.out.println("핵심로직: Goodbye~!"); // 언제나 실행되어야 하는 로직
	}
}
