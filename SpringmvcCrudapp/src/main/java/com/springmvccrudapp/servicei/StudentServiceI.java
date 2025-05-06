package com.springmvccrudapp.servicei;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvccrudapp.model.Student;

public interface StudentServiceI {
	
	public void saveData(Student s);
	
	public List<Student> login(String username,String password);
	
	public List<Student> deleteStudent(int rollno);
	
	public Student editStudent(int rollno);
	
	public List<Student> updateStudent(Student s);
	
	
	
	
}
