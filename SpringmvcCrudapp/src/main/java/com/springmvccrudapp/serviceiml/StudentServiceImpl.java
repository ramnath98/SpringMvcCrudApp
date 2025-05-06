package com.springmvccrudapp.serviceiml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvccrudapp.daoi.StudentDaoI;
import com.springmvccrudapp.model.Student;
import com.springmvccrudapp.servicei.StudentServiceI;
@Service
public class StudentServiceImpl implements StudentServiceI{

	@Autowired
	StudentDaoI sdi;

	@Override
	public void saveData(Student s) {
		sdi.saveData(s);
		
	}

	@Override
	public List<Student> login(String username, String password) {
		
		
		List<Student> list = sdi.login(username,password);
		return list;
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		
		
		List<Student> list = sdi.deleteStudent(rollno);
		return list;
	}

	@Override
	public Student editStudent(int rollno) {
		Student s = sdi.editStudent(rollno);
		return s;
	}

	@Override
	public List<Student> updateStudent(Student s) {
		
		return sdi.updateStudent(s);
	}

	
	
	

}
