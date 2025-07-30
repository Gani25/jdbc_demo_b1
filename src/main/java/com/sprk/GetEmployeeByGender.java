package com.sprk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class GetEmployeeByGender {

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

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a gender: ");
			String gender = sc.next();
					
			//Step 3: Create SQL Statements
			String sql = "select * from employee where gender = ?";
			// select * from employee where gender = Male
			// select * from employee where gender = "Male"
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, gender);
			//Step 4: Execute SQL Statements
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				System.out.println("---------------------------------------------------");
				System.out.println("~~~Employee Information~~~");
				System.out.println("---------------------------------------------------");
				System.out.println("Employee Id: " + rs.getInt("emp_id"));
				System.out.println("First Name: " + rs.getString("first_name"));
				System.out.println("Last Name: " + rs.getString("last_name"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Gender: " + rs.getString("gender"));
				System.out.println("Created At: " + rs.getTimestamp("created_at"));
				System.out.println("Updated At: " + rs.getTimestamp("updated_at"));

			}

			// Step 5: Close All
			conn.close();
			rs.close();
			ps.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}

}
