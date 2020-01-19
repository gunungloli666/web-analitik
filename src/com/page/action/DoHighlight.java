package com.page.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fjr.base.sintaxhighlighter.SyntaxDao;


public class DoHighlight extends HttpServlet{

	SyntaxDao syntaxDao;
	public DoHighlight() {
		syntaxDao = SyntaxDao.getInstance();
//		System.out.println("start a thread");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String id = session.getId();
		System.out.println("sessiion id: " + id); 
		
		
		String content = request.getParameter("content"); 
//		System.out.println(content); 
		String hasil = syntaxDao.highlight(content);
		request.setAttribute("content", "home");
		request.setAttribute("hasil", hasil);
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/test.jsp");
		try {
			 rd.forward(request , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String content = request.getParameter("content"); 
		System.out.println(content); 
		
	}
}
