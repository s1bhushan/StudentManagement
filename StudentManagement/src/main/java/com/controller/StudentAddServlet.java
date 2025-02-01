package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;

//@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String batch = request.getParameter("batch");
		String course = request.getParameter("course");

		Student student = new Student(id, name, address, batch, course);

		StudentDAO dao = new StudentDAOImpl();
		
		RequestDispatcher rd=request.getRequestDispatcher("/read"); 

		int res = dao.saveStudent(student);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS ADD!!!" + "</h1>");
			rd.include(request, response);
		} else
			out.print("<h1>" + "FAILED TO ADD!!!" + "</h1>");
		rd.include(request, response);

	}

}
