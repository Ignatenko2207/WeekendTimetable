package org.itstep.dao;

import java.util.List;

import javax.transaction.Transaction;
import javax.websocket.Session;
import org.itstep.model.Subject;
import org.itstep.model.Lesson;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectDAO {
	
	
	// @Query(value = "SELECT * FROM lessons WHERE start_time>?1 AND start_time<?2", nativeQuery = true)
	
	@Autowired
	HibernateUtil hiber;
	
	Subject save(Subject subject) {
		
		if(get(subject.getId()) == null )
		{
			org.hibernate.Session session = hiber.getSessionFactory().openSession();
			
			org.hibernate.Transaction transaction = session.beginTransaction();
					
			session.saveOrUpdate(subject);
			
			transaction.commit();
			
			session.close();
			
			return subject;
		}
		return null;
	}
	Subject update(Subject subject) {
		
		if(get(subject.getId()) != null )
		{
			org.hibernate.Session session = hiber.getSessionFactory().openSession();
			
			org.hibernate.Transaction transaction = session.beginTransaction();
					
			session.saveOrUpdate(subject);
			
			transaction.commit();
			
			session.close();
			
			return subject;
		}
		return null;
	}
	
	Subject get(Integer id) {
	
	org.hibernate.Session session = hiber.getSessionFactory().openSession();
	
	org.hibernate.Transaction transaction = session.beginTransaction();
			
	Subject subjectFromDB = session.get(Subject.class, id);
	
	transaction.commit();
	
	session.close();
	
	return subjectFromDB;
	}
	
	void delete(Subject id) {
		
		org.hibernate.Session session = hiber.getSessionFactory().openSession();
		
		org.hibernate.Transaction transaction = session.beginTransaction();
				
		session.delete(id);
		
		transaction.commit();
		
		session.close();
	} 
}
