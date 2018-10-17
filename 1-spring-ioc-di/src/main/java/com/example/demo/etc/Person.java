package com.example.demo.etc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

//<context:property-placeholder location="my.properties"/>
@PropertySource(value = { "my.properties" })

@Component
@Data
public class Person {
	
	@Value("#{member.name}")
	private String name;
	@Value("#{member.age}")
	private int age;
	
	@Value("${car.default.name:null}")
	private String carName;
	@Value("${car.default.doors:0}")
	private int carDoors;
	
	// Run As > Run Configuration > VM arguments > -Duser.region=KR
	@Value("#{systemProperties['user.region'] == null ? 'US' : systemProperties['user.region']}")
	private String defaultLocale;
}
