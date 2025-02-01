package com.model;

import java.io.Serializable;


public class Student implements Serializable{
	private int rollno;
	private String name;
	private String address;
	private String batch;
	private String course;
	
	public Student(int rollno, String name, String address, String batch, String course) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.address = address;
		this.batch = batch;
		this.course = course;
	}
	public int getRollno() {
		return rollno;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", address=" + address + ", batch=" + batch
				+ ", course=" + course + "]";
	}
	

}
