package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDAO;
import com.dao.CourseDAOImpl;
import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Course;
import com.model.Student;

@WebServlet("/JavaAddServlet")
public class JavaAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JavaAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private CourseDAO dao;

	@Override
	public void init() throws ServletException {

		dao = new CourseDAOImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));
		String subject = request.getParameter("subject");
		String assignment = request.getParameter("assignment");
		double marks = Double.parseDouble(request.getParameter("marks"));

		Course course = new Course(subject, assignment, marks, id);
		RequestDispatcher rd=request.getRequestDispatcher("/JavaReadServlet"); 


		int res = dao.saveCourse(course);
		if (res > 0) {
			out.print("<h1>" + "SUCCESS ADD!!!" + "</h1>");
			rd.include(request, response);
		} else {
			out.print("<h1>" + "FAILED TO ADD!!!" + "</h1>");
		rd.include(request, response);
		}
	}
}
