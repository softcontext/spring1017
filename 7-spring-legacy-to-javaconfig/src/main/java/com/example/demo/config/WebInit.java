package com.example.demo.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//<listener>
//	<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
//</listener>
public class WebInit implements WebApplicationInitializer {

//<servlet>
//	<servlet-name>appServlet</servlet-name>
//	<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
//	<init-param>
//		<param-name>contextConfigLocation</param-name>
//		<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
//	</init-param>
//	<load-on-startup>1</load-on-startup>
//</servlet>
//	
//<servlet-mapping>
//	<servlet-name>appServlet</servlet-name>
//	<url-pattern>/</url-pattern>
//</servlet-mapping>

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
//	<context-param>
//		<param-name>contextConfigLocation</param-name>
//		<param-value>/WEB-INF/spring/root-context.xml</param-value>
//	</context-param>
		
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(Config.class);
		ctx.setServletContext(servletContext);
		
		Dynamic servlet = servletContext
				.addServlet("appServlet", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
//		servlet.setInitParameter("contextConfigLocation", "/WEB-INF/appServlet-servlet.xml");
	}

}
