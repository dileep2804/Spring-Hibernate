package com.dileep.hibernate.demo;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dileep.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		//create session Factory
		SessionFactory factory= new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		//create session
		Session session=factory.getCurrentSession();
		
		
		try {
			//start transaction
			session.beginTransaction();
			
			//query students
			List<Student> Allstudents= session
					.createQuery("from Student").getResultList();
			
			List<Student> StarkStudents=session
					.createQuery("from Student s where s.lastName='Stark'")
					.getResultList();
		    
			List<Student> KushwahaStarkStudents=session
					.createQuery("from Student s where s.lastName='Stark' OR s.lastName='Kushwaha'")
					.getResultList();
			
			List<Student> likeStudents= session
					.createQuery("from Student s where "
							+ "s.email LIKE '%gmail.com'").getResultList();
			
//			List<Student> StarkStudents=session
//					.createQuery("from Student s where s.lastName='Stark'")
//					.getResultList();
			
			
			//display students
			System.out.println("\nAll Students");
			displayStudents(Allstudents);
			
			System.out.println("\n\nAll Students having last name Stark");  
			displayStudents(StarkStudents);
			
			System.out.println("\n\nStark and Kushwaha Students");
			displayStudents(KushwahaStarkStudents);
			
			System.out.println("\n\ngmail students");
			displayStudents(likeStudents);
			
			//commit transaction
			session.getTransaction().commit();
		}
		finally {
			factory.close();
		}
		
	}

	
	
	private static void displayStudents(List<Student> Allstudents) {
		for(Student tempstudent : Allstudents) {
			System.out.println(tempstudent);
		}
	}

}
