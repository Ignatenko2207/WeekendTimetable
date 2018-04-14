package org.itstep.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.itstep.model.Group;
import org.itstep.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAO{

	@Autowired
	HibernateUtil hiber;

	Group save(Group group) {

		if (get(group.getName()) == null) {
			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(group);

			transaction.commit();

			session.close();

			return group;
		}
		return null;
	}

	Group update(Group group) {

		if (get(group.getName()) != null) {
			Session session = hiber.getSessionFactory().openSession();

			Transaction transaction = session.beginTransaction();

			session.saveOrUpdate(group);

			transaction.commit();

			session.close();

			return group;
		}
		return null;
	}

	Group get(String name) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		Group groupFromDB = session.get(Group.class, name);

		transaction.commit();

		session.close();

		return groupFromDB;
	}

	void delete(Group group) {

		Session session = hiber.getSessionFactory().openSession();

		Transaction transaction = session.beginTransaction();

		session.delete(group);

		transaction.commit();

		session.close();
	}
	
	
}
