package com.example.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// URL 문자열을 클래스에만 설정할 수 있습니다.
//@WebServlet(urlPatterns= {"/home.do"})
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// HTTP 요청방식(GET, POST)에 따라 기동하는 메소드가 결정됩니다.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		res.getWriter().write("<h1>Hello, I am Servlet!</h1>");
		
		// 브라우저에 요청에 따라 데이터를 구해오는 로직
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
