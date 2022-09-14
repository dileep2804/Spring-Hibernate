package com.dileep.hibernate.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dileep.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		//create session Factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//get session from SessionFactory
		Session session = factory.getCurrentSession();
		
		try {
			// begin transaction
			session.beginTransaction();
			
			//get the required student
			int s1id=1;
			Student s1=session.get(Student.class, s1id);
			System.out.println("student is: "+s1);
			
			//update student
			s1.setEmail("newemail2@yeah.com");
			System.out.println("udated student is: "+s1);
			
			//commit transaction to save the update in database
			session.getTransaction().commit();
			System.out.println("Done!!!");
			
			//UPDATE Student using creatQuery
			session=factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("updating email for all students");
			
			session.createQuery("update Student set email='foo@ggg.com'").executeUpdate();
			
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
	}

}
