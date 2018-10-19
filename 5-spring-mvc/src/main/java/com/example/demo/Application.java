package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"com.example.demo", "com.example.web"})

//@SpringBootConfiguration
//@EnableAutoConfiguration
//@ComponentScan(
//	basePackages= {"com.example.demo"},
//	excludeFilters={
//			@Filter(type=CUSTOM, classes={TypeExcludeFilter.class}), 
//			@Filter(type=CUSTOM, classes={AutoConfigurationExcludeFilter.class})
//})
//@Target(value={TYPE})
//@Retention(value=RUNTIME)
//@Documented
//@Inherited

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
