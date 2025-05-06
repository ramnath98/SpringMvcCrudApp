package com.springmvccrudapp.daoiml;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.springmvccrudapp.daoi.StudentDaoI;
import com.springmvccrudapp.model.Student;

import jakarta.transaction.Transaction;

@Repository
public class StudentDaoImpl implements StudentDaoI {
	@Autowired
	SessionFactory sf;
	
	@Override
	public void saveData(Student s) {
		
		Session session = sf.openSession();
		session.persist(s);
		session.beginTransaction().commit();
		
	}

	@Override
	public List<Student> login(String username, String password) {
		Session session = sf.openSession();
		if(username.equals("ADMIN") && password.equals("ADMIN"))
		{
			List<Student> list = session .createQuery("from Student").getResultList();
			return list;
		}
		else
		{
			Query<Student> query = session.createQuery("from Student where username=?1 and password=?2");
			query.setParameter(1, username);
			query.setParameter(2, password);
			List<Student> list = query.getResultList();
			return list;
			
		}
		
	}

	@Override
	public List<Student> deleteStudent(int rollno) {
		
		
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query<Student> query= session.createQuery("delete from Student where rollno=?1");
		query.setParameter(1, rollno);
		query.executeUpdate();
		tx.commit();
		return getStudents();
	}
	
	public List<Student> getStudents()
	{
		Session session =sf.openSession();
		return session.createQuery("from Student").getResultList();
	}

	@Override
	public Student editStudent(int rollno) {
		// TODO Auto-generated method stub
		
		Session session = sf.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		Query<Student> query= session.createQuery("from Student where rollno=?1");
		query.setParameter(1, rollno);
		
	Student	s= query.getSingleResult();
		return s;
		
	
	}

	@Override
	public List<Student> updateStudent(Student s) {
		Session session = sf.openSession();
		session.merge(s);
		session.beginTransaction().commit();
		return getStudents();
	}
	
	
	

	
	
}
