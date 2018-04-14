package org.itstep.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.model.Lesson;
import org.itstep.model.Subject;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LessonDAO {

	@Autowired
	HibernateUtil hiber;

	Lesson save(Lesson lesson) {

		if (get(lesson.getId()) == null) {

			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(lesson);

			transaction.commit();

			session.close();

			return lesson;
		}
		return null;
	}

	Lesson update(Lesson lesson) {

		if (get(lesson.getId()) != null) {

			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(lesson);

			transaction.commit();

			session.close();

			return lesson;
		}
		return null;
	}

	Lesson get(Integer id) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Lesson lessonFromDB = session.get(Lesson.class, id);

		transaction.commit();

		session.close();

		return lessonFromDB;
	}

	void delete(Lesson lesson) {
		
			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.delete(lesson);

			transaction.commit();

			session.close();

		
	}

	List<Lesson> findAllByStartTime(Long startPeriod, Long endPeriod) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createNativeQuery("SELECT * FROM lessons WHERE start_time> :st_time AND start_time< :end_time",
				Lesson.class);

		query.setParameter("st_time", startPeriod);

		query.setParameter("end_time", endPeriod);
		
		List<Lesson> lessonsFromDB = (List<Lesson>) session.beginTransaction();
		
		transaction.commit();

		session.close();

		return lessonsFromDB;
	}

	List<Lesson> findAllBySubject(Subject subject) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Query query = session.createNativeQuery("SELECT * FROM lessons WHERE subject_id = :sub_id",
				Lesson.class);

		query.setParameter("sub_id", subject.getId());

		List<Lesson> lessonsFromDB = (List<Lesson>) session.beginTransaction();
		
		transaction.commit();

		session.close();

		return lessonsFromDB;
	}
}
