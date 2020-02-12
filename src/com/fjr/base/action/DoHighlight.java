package com.fjr.base.action;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjr.base.sintaxhighlighter.SyntaxDao;


public class DoHighlight extends HttpServlet{

	// mohammad fajar
	SyntaxDao syntaxDao = SyntaxDao.getInstance();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		String content = request.getParameter("content"); 
		System.out.println(content); 
		
	}
}
