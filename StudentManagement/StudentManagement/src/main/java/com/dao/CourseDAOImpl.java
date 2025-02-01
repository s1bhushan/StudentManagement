
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;
import com.utility.DBUtility;

public class CourseDAOImpl implements CourseDAO{

	public int saveCourse(Course course) {
		int i = 0;

		String sql = "insert into course values(?,?,?,?)";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(4, course.getRollno());
			ps.setString(1, course.getSubject());
			ps.setString(2, course.getAssignment());
			ps.setDouble(3, course.getMarks());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("CourseDao saveCourse: " + e);
		}
		return i;
	}
	
	public List<Course> getAllCourse() {

		List<Course> listC = new ArrayList<Course>();
		String sql = "SELECT * FROM course";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Course coursed = new Course(rs.getString(1), rs.getString(2),rs.getDouble(3),rs.getInt(4));
				listC.add(coursed);

			}

		} catch (Exception e) {
			System.out.println(" CourseDAOImpl  GET ALL Course info  " + e);
		}

		return listC;

	}


	/*public int deleteStudent(Student stud) {
		int i = 0;
		String sql = "DELETE FROM student WHERE rollno=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, stud.getRollno());

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("StudentDAO deleteStudent  " + e);
		}
		return i;
	}

	public int deleteStudentByrollno(int id) {
		int i = 0;
		String sql = "DELETE FROM student WHERE rollno=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("StudentDAO deleteStudentbyrollno  " + e);
		}
		return i;
	}

	public int updateStudent(Student updateStudent) {

		int i = 0;
		String sql = "UPDATE STUDENT set name=? , address=?,batch=?,course=? where Rollno=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, updateStudent.getName());
			ps.setString(2, updateStudent.getAddress());
			ps.setString(3, updateStudent.getBatch());
			ps.setString(4, updateStudent.getCourse());
			ps.setInt(3, updateStudent.getRollno());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("StudentDAO  saveStudent   " + e);
		}
		return i;

	}

	public List<Student> getAllStudent() {

		List<Student> listP = new ArrayList<Student>();
		String sql = "SELECT * FROM student";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				Student stude = new Student(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
				listP.add(stude);

			}

		} catch (Exception e) {
			System.out.println(" StudentDAO   GET ALL Student  " + e);
		}

		return listP;

	}

	@Override
	public Student getStudentById(int id) {
		String sql = "SELECT * FROM STUDENT WHERE rollno=?";

		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql);) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Student stude = new Student(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4),rs.getString(5));
				return stude;
			}

		} catch (Exception e) {
			System.out.println(" StudentDAO   GET ALL Student  " + e);
		}

		return null;

	}*/

	

}