package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

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

@WebServlet("/JavaReadServlet")
public class JavaReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public JavaReadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private CourseDAO dao;
	private StudentDAO dao1;
	
	public void init() throws ServletException{
		dao = new CourseDAOImpl();
		dao1 = new StudentDAOImpl();
	}

	
	
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		

		List<Course> courseList = dao.getAllCourse();
		List<Student> studentList = dao1.getAllStudent();

		Iterator<Course> itr = courseList.iterator();
		Iterator<Student> itr1 = studentList.iterator();
		
		
		out.print("<head>");
		out.print("<link rel=\"stylesheet\" href=\"./css/table.css\">");
		out.print("</head>");
		
		out.print("<a href='Student.html'>"+"HOME"+"</a>");
		

		out.print("<table  id='customers'>");
		
		
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> BATCH</th>");
		out.print("<th> COURSE </th>");
		out.print("<th> SUBJECT </th>");
		out.print("<th> ASSIGNMENT </th>");
		out.print("<th> MARKS </th>");
		out.print("<th> Remove </th>");
		out.print("<th> Update </th>");
		out.print("</tr>");

		while (itr1.hasNext()) {
			
			Student student = itr1.next();
			
		while (itr.hasNext()) {
			Course course =  itr.next();
			
			out.print("<tr>");
			out.print("<td>" + student.getRollno() + "</td>");
			out.print("<td>" + student.getName() + "</td>");
			out.print("<td>" + student.getBatch() + "</td>");
     		out.print("<td>" + student.getCourse() + "</td>");
			out.print("<td>" + course.getSubject() + "</td>");
			out.print("<td>" + course.getAssignment() + "</td>");
			out.print("<td>" + course.getMarks() + "</td>");
			out.print("<td>");
			out.print("<a href='delete?id="+course.getRollno()+"'>"+"DELETE"+"</a>");
			out.print("</td>");
			out.print("<td>");
			out.print("<a href='update?id="+course.getRollno()+"'>"+"UPDATE"+"</a>");

			out.print("</td>");
			out.print("</tr>");
		}

		out.print("</table>");
		}


	}

		
		
	}

