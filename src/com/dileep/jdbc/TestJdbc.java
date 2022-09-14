package com.dileep.jdbc;

import java.sql.Connection;

import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		//testing JDBC connection
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";  
		String user="hbstudent";
		String pass="hbstudent";
		
		try {
			System.out.println("connecting to database: "+ jdbcUrl);
			Connection myConn =
					DriverManager.getConnection(jdbcUrl,user,pass);
			System.out.println("Connection Successful!!!");
		}
		
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}

}
