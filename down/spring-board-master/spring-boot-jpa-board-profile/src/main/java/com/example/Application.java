package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Value("${spring.datasource.platform:NONE}")
	private String datasourcePlatform;

	@Autowired
	private ServerProperties serverProperties;

	@Autowired
	private Environment environment;

	@Override
	public void run(String... args) throws Exception {
		System.out.println();
		System.out.println("====================================================");
		System.out.print("\tActive Profiles = [");
		for (String string : environment.getActiveProfiles()) {
			System.out.print(string + ",");
		}
		System.out.println("]");
		System.out.println("====================================================");
		System.out.println();
		
		System.out.println();
		System.out.println("====================================================");
		System.out.println("\tspring.datasource.platform = " + datasourcePlatform);
		System.out.println("====================================================");
		System.out.println();
		
		System.out.println(serverProperties);
	}
}
