package standard.com.sprk.main;

import java.util.List;
import java.util.Scanner;

import standard.com.sprk.connection.ConnectionUtil;
import standard.com.sprk.dao.EmployeeDao;
import standard.com.sprk.entity.Employee;

public class InsertEmployee {

	public static void main(String[] args) {
		try {
			EmployeeDao dao = new EmployeeDao(
					ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));

			Scanner sc = new Scanner(System.in);
			// Inputs
			System.out.println("Enter email: ");
			String email = sc.next();

			Employee existingEmployee = dao.getEmployeeByEmail(email);
			if (existingEmployee != null) {
				System.out.println("Employee with email = " + email + " already exists please enter another email");
			} else {

				dao = new EmployeeDao(ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));
				System.out.println("Enter gender: ");
				String gender = sc.next();

				sc.nextLine(); // Dummy Input for Space
				System.out.println("Enter first name: ");
				String firstName = sc.nextLine();
				System.out.println("Enter last name: ");
				String lastName = sc.nextLine();

				Employee employee = new Employee();
				employee.setEmail(email);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setGender(gender);

				int result = dao.insertEmployee(employee);

				if (result == 1) {
					System.out.println("Employee Saved Successfully");
				} else {

					System.out.println("Something Bad Happens");
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
