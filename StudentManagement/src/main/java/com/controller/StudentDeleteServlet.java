package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;

//@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		
		
		StudentDAO dao=new StudentDAOImpl();
		
		int res=dao.deleteStudentByrollno(id);
		if(res>0) {
			out.print("<h1>"+"SUCCESS DELETE!!!"+"</h1>");
		}
		else
			out.print("<h1>"+"FAILED TO DELETE!!!"+"</h1>");


	}

}
