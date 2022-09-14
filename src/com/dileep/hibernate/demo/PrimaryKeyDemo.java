package com.dileep.hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dileep.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
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
			
			//create 4 student object
			System.out.println("creating a student object");
			Student student1=new Student("Aman", "Kushwaha","aman123@gmail.com");
			Student student2=new Student("Steve", "Rogers","captainamerica@gmail.com");
			Student student3=new Student("Peter", "Parker","spiderman@gmail.com");
			Student student4=new Student("Tony", "Stark","ironman@gmail.com");
			
			//start transaction
			System.out.println("starting the transaction");
			session.beginTransaction();
			
			//save students object
			System.out.println("saving the student object");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			session.save(student4);
			
			//commit transaction
			System.out.println("commiting the transaction");
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
		
	}
}
