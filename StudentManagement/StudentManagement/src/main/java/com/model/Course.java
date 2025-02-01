package com.model;

public class Course {
	private String subject;
	private String assignment;
	private double marks;
	private int rollno;
	public Course(String subject, String assignment, double marks, int rollno) {
		super();
		this.subject = subject;
		this.assignment = assignment;
		this.marks = marks;
		this.rollno = rollno;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAssignment() {
		return assignment;
	}
	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	@Override
	public String toString() {
		return "Course [subject=" + subject + ", assignment=" + assignment + ", marks=" + marks + ", Rollno=" + rollno
				+ "]";
	}
	
	
	

}
