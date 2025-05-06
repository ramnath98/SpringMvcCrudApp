package com.springmvccrudapp.daoi;

import java.util.List;

import com.springmvccrudapp.model.Student;

public interface StudentDaoI {
	
	public void saveData(Student s);
	
	public List<Student> login(String username,String password);
	
	public List<Student> deleteStudent(int rollno);
	
	public Student editStudent(int rollno);
	
	public List<Student> updateStudent(Student s);

}

