package com.dileep.hibernate.demo;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dileep.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student=new Student("shailendra", "Kushwaha","dabla@gmail.com");
			
			//start transaction
			System.out.println("starting the transaction");
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the "+student);
			session.save(student);
			
			//commit transaction
			System.out.println("commiting the transaction");
			session.getTransaction().commit();
			
			//MY NEW CODE
			
			//find out whats id:primary key of saved student
			System.out.println("Saved student Generated id: "+student.getId());
			
			//get a new session and start the transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting Student witg id: "+student.getId());
			
			Student mystudent = session.get(Student.class, student.getId());
			
			System.out.println("\nStudent obtained is: "+mystudent);
			
			//commit the transaction
			session.getTransaction().commit();
			
			
			System.out.println("Done!!!");
		}
		finally {
			factory.close();
		}
		//
		
		//
		
		
	}

}
