package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.model.Subject;
import org.itstep.model.Teacher;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TeacherDAO {

	@Autowired
	HibernateUtil hiber;

	Teacher save(Teacher teacher) {
		if (get(teacher.getLogin()) == null) {
			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.save(teacher);

			transaction.commit();

			session.close();

			return teacher;
		}

		return null;
	}

	Teacher update(Teacher teacher) {

		if (get(teacher.getLogin()) != null) {
			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(teacher);

			transaction.commit();

			session.close();

			return teacher;
		}

		return null;

	}

	Teacher get(String login) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Teacher teacherFromDB = session.get(Teacher.class, login);

		transaction.commit();

		session.close();

		return teacherFromDB;
	}

	void delete(Teacher teacher) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.delete(teacher);

		transaction.commit();

		session.close();
	}

	List<Teacher> findAllBySubject(Subject subject) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createNativeQuery("SELECT * FROM teachers WHERE subject = : subj");

		query.setParameter("subj", subject);

		List<Teacher> teacherFromDB = (List<Teacher>) session.beginTransaction();

		transaction.commit();

		session.close();
		
		return teacherFromDB;
	}
}
