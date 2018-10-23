package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.web.interceptor.LoginInterceptor;

@Configuration
public class AppConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
//		<interceptors>
//			<interceptor>
//				<mapping path="/boards/view/**" />
//				<mapping path="/boards/write/**" />
//				<mapping path="/boards/update/**" />
//				<mapping path="/boards/delete/**" />
//				<beans:bean class="com.example.web.interceptor.LoginInterceptor" />
//			</interceptor>
//		</interceptors>
		
		registry.addInterceptor(loginInterceptor)
			.addPathPatterns("/boards/view/**")
			.addPathPatterns("/boards/write/**")
			.addPathPatterns("/boards/update/**")
			.addPathPatterns("/boards/delete/**");
	}
}
