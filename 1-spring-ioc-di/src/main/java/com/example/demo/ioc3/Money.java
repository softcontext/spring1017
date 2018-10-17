package com.example.demo.ioc3;

import lombok.AllArgsConstructor;
import lombok.Data;

//Equivalent to {
//	@code 
//	@Getter 
//	@Setter 
//	@RequiredArgsConstructor 
//	@ToString 
//	@EqualsAndHashCode
//	}.

@Data
@AllArgsConstructor
//@Getter 
//@Setter
public class Money {
	private int amount;

//	public int getAmount() {
//		return amount;
//	}

//	public void setAmount(int amount) {
//		this.amount = amount;
//	}
	
}
