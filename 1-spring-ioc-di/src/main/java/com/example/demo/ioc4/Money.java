package com.example.demo.ioc4;

import lombok.AllArgsConstructor;
import lombok.Data;

// DTO(Data Transfer Object)
// 여러 상태정보를 하나로 취급하기 위해서 사용하는 객체
// 이러한 객체는 상태가 mutable 하기 때문에 일반적으로 스프링 빈 컨테이너에 등록하지 않고
// 필요 시, 객발자가 new 연산자로 직접 객체를 생성해서 사용하고 필요없으면 바로 G.C 대상이 되도록 한다.
@Data
@AllArgsConstructor
public class Money {
	private int amount;
}
