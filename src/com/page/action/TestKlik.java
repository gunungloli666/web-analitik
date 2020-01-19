package com.page.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestKlik extends HttpServlet{

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("content", "home");
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/test.jsp");
		try {
			 rd.forward(request , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
}
