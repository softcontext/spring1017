package com.example.demo.ioc4;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor // 디폴트 생성자
@Component
@Scope("prototype")
public class Car {
	@Value("${car.default.name:자동차}")
	private String name;

	// 빈 컨테이너 등록된 후에 프레임워크에 의해서 메소드가 기동합니다.
	@PostConstruct
	public void init() {
		System.out.println(">>> this.name = " + this.name);
		this.name = "Good Car";
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
}
