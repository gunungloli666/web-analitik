package com.fjr.downloader;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadTa extends HttpServlet{

	
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/test.jsp");
		request.setAttribute("content", "download-ta-main"); 

		String page = "1"; 
		if(request.getParameter("page")!= null ) {
			page = request.getParameter("page");
			int pageNum = (int)Integer.parseInt(page); 
			if( pageNum > 84 || pageNum <  1 ) {
				page = "1"; 
			}
		}
		request.setAttribute("page", page); 
		try {
			 rd.forward(request , response );			
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}
}
