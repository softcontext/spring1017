package com.example.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//Request ==Filter==> DispatcherServlet ==Interceptor==> Controller ==> DAO ==> DB
public class MyLogInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("DispatcherServlet ==Interceptor==> Controller");
		// 용례: 로깅, 인증(회원여부), 권한체크(회원인데 접근권한 보유여부) ...
		
		/*
		 * 리턴 값이 true이면 핸들러 실행 체인의 다음 단계로 진행되지만, 
		 * false라면 작업을 중단하고 리턴하므로 남은 인터셉터들과 컨트롤러는 실행되지 않는다.
		 */
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("DispatcherServlet <==Interceptor== Controller");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("DispatcherServlet <==Interceptor== View");
	}

}
