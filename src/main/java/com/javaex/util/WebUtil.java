package com.javaex.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebUtil {
	
	//필드
	
	
	//생성자
	//public WebUtil() {} => 생략
	
	//메소드 gs
	
	
	//메소드 일반
	
	//리다이렉트
	public static void redirect(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		
		response.sendRedirect(url);
	}
	
	//포워드
	public static void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}


}
