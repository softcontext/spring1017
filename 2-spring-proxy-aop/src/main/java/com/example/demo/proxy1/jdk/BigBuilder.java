package com.example.demo.proxy1.jdk;

public class BigBuilder implements Builder {

	@Override
	public boolean build() {
		System.out.println("큰 건물을 건설한다.");
		return true;
	}

}
