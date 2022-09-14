package com.dileep.hibernate.demo;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dileep.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		//create session Factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		
		try {
			//use the session object to save Java object
			
			//create student object
			System.out.println("creating a student object");
			Student student=new Student("Aman", "Kushwaha","aman123@gmail.com");
			
			//start transaction
			System.out.println("starting the transaction");
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the student object");
			session.save(student);
			
			//commit transaction
			System.out.println("commiting the transaction");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		//
		
		//
		
		
	}

}
