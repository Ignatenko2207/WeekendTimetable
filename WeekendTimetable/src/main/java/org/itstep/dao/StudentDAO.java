package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.model.Group;
import org.itstep.model.Lesson;
import org.itstep.model.Student;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO{

	@Autowired
	HibernateUtil hiber;
	
	Student save(Student student) {
	
		if( get(student.getLogin()) == null ) {
			
			Session session = hiber.getSessionFactory().openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.saveOrUpdate(student);
			transaction.commit();
			session.close();
			
			return student;
		}
		
		return null;
	}
	
	Student update(Student student) {
		
		if( get(student.getLogin()) != null ) {
			
			Session session = hiber.getSessionFactory().openSession();
			
			Transaction transaction = session.beginTransaction();
			
			session.saveOrUpdate(student);
			transaction.commit();
			session.close();
			
			return student;
		}
		
		return null;
	}
	
	Student get(String login) {
		
		Session session = hiber.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student studentFromDb = session.get(Student.class, login);
		
		transaction.commit();
		session.close();
		
		return studentFromDb;
	}
	
	void delete(Student student) {
		
		Session session = hiber.getSessionFactory().openSession();
		
		Transaction transaction = session.beginTransaction();
		
		session.delete(student);
		
		transaction.commit();
		session.close();
	}
	
	List<Student> findAllByGroup(Group group) {
		
		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createNativeQuery("SELECT * FROM lessons WHERE subject_id = :group_name",
				Lesson.class);

		query.setParameter("group_name", group.getName());

		List<Student> studentFromDB = (List<Student>) session.beginTransaction();
		
		transaction.commit();

		session.close();

		return studentFromDB;
	}
}
