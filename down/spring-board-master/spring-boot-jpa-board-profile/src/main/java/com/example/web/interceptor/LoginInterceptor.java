package com.example.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.user.model.User;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			String url = session.getServletContext().getContextPath() + "/login";
			response.sendRedirect(url);
			logger.trace("[[ LoginInterceptor # preHandle() : NO PASS ]]");
			logger.info("[[ LoginInterceptor # preHandle() : NO PASS ]]");
			logger.debug("[[ LoginInterceptor # preHandle() : NO PASS ]]");
			logger.warn("[[ LoginInterceptor # preHandle() : NO PASS ]]");
			logger.error("[[ LoginInterceptor # preHandle() : NO PASS ]]");
			return false;
		}
		
		logger.trace("[[ LoginInterceptor # preHandle() : PASS ]]");
		logger.info("[[ LoginInterceptor # preHandle() : PASS ]]");
		logger.debug("[[ LoginInterceptor # preHandle() : PASS ]]");
		logger.warn("[[ LoginInterceptor # preHandle() : PASS ]]");
		logger.error("[[ LoginInterceptor # preHandle() : PASS ]]");
		
		return true;
	}
}
