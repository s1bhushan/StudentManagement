
package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;

//@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address=request.getParameter("name");
		String batch=request.getParameter("name");
		String course=request.getParameter("name");

		
		Student student=new Student(id, name,address,batch,course);
		
		StudentDAO dao = new StudentDAOImpl();

		int res = dao.updateStudent(student);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS UPDATE!!!" + "</h1>");
		} else
			out.print("<h1>" + "FAILED TO UPDATE!!!" + "</h1>");



	}

}

