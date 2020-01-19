package com.page.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConverterBilangan  extends HttpServlet{

	
	public void doGet(HttpServletRequest request, HttpServletResponse resp ) {
		request.setAttribute("content", "bil-to-kalimat");
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/test.jsp");
		try {
			 rd.forward(request , resp );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
}
