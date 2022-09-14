package com.dileep.hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dileep.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		//create sessionFactory
		SessionFactory factory= new Configuration()
							.configure("hibernate.cfg.xml")
							.addAnnotatedClass(Student.class)
							.buildSessionFactory();
		
		//get session
		Session session = factory.getCurrentSession();
		
		try {
			//begin transaction
			session.beginTransaction();
			
			//get student to delete
			int s1id=2;
			Student s1=session.get(Student.class, s1id);
//			System.out.println("obtained studetn is: "+s1);
//			
//			//delete student 
//			session.delete(s1);
//			
//			session.getTransaction().commit();
			
			System.out.println("Done!!!");
			
			
			//OTHER WAY TO DELETE
//			session.beginTransaction();
			session.createQuery("delete from Student s where s.firstName='Aman'")
					.executeUpdate();
			session.getTransaction().commit();
			
		}
		finally {
			session.close();
		}
		
	}

}
