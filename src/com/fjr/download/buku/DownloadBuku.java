package com.fjr.download.buku;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadBuku extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/WEB-INF/test.jsp");
		request.setAttribute("content", "download-buku");

		try {
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println("eror dispatching sevlet");
		}
	}

}
