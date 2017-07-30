package com.melvin.tonia.model;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		;
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		Query query = session.createQuery("select username from UserDetails where UserId=?");
		query.setInteger(0, 3);
		List username = query.list();
		session.getTransaction().commit();
		
		session.close();
		System.out.print(username.get(0));
	}

}
