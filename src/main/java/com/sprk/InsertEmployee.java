package com.sprk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class InsertEmployee {

	public static void main(String[] args) {
		// step 1: Load Driver Class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step 2: Obtain Connection
			// server-link/database_name
			String url = "jdbc:mysql://localhost:3306/core_java_jdbc";
			String username = "root";
			String password = "root";
			Connection conn = DriverManager.getConnection(url, username, password);

			// Inputs
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter gender: ");
			String gender = sc.next();
			
			sc.nextLine(); // Dummy Input for Space
			System.out.println("Enter first name: ");
			String firstName = sc.nextLine();
			System.out.println("Enter last name: ");
			String lastName = sc.nextLine();
			
			System.out.println("Enter email: ");
			String email = sc.next();
			
			
			//Step 3: Create SQL Statements
			String sql = "insert into employee(first_name,last_name, gender, email) values (?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setString(3, gender);
			ps.setString(4, email);

			//Step 4: Execute SQL Statements
			// Non Select Query
			int result = ps.executeUpdate();
			if(result > 0) {
				System.out.println(result + " employee saved successfully");
			}else {
				System.out.println("Something bad happens");
			}

			
			// Step 5: Close All
			conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
