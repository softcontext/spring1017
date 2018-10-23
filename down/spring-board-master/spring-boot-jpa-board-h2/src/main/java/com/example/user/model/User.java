package com.example.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true, length=100)
	private String email;
	
	@Column(nullable=false, length=100, columnDefinition="VARCHAR(100) DEFAULT '1234'")
	private String password;

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
}
