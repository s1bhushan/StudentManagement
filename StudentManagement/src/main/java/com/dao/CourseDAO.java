package com.dao;


import java.util.List;

import com.model.Course;

public interface CourseDAO {

	int saveCourse(Course course);
	List<Course> getAllCourse();
	/*int deleteStudent(Student student);
	int deleteStudentByrollno(int id);
	int updateStudent(Student student);
	List<Student>getAllStudent();
	Student getStudentById(int id);*/

}
