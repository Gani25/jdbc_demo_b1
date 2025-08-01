package standard.com.sprk.main;

import java.util.List;
import java.util.Scanner;

import standard.com.sprk.connection.ConnectionUtil;
import standard.com.sprk.dao.EmployeeDao;
import standard.com.sprk.entity.Employee;

public class EmployeeManagementMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int choice;

		do {
			System.out.println("Please enter choice\n1. Insert\n2. Update\n3. Delete\n4. Get All\n5. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:

				insertEmployee();
				break;

			case 2:
				updateEmployee();
				break;
			case 3:
				deleteEmployee();
				break;
			case 4:
				getAllEmployees();
				break;
			case 5:
				System.out.println("Thanks for using our employee management system! Do Visit Again!!");
				break;
			default:
				System.out.println("Please enter correct choice");

			}
		} while (choice != 5);

	}

	private static void insertEmployee() {
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

				dao = new EmployeeDao(
						ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));
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

	private static void updateEmployee() {
		try {
			EmployeeDao dao = new EmployeeDao(
					ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter id: ");
			int id = sc.nextInt();

			// Find By id
			Employee existingEmployee = dao.getEmployeeById(id);

			if (existingEmployee == null) {
				System.out.println("Employee with id = " + id + " does not exists please enter another id");
			} else {

				System.out.println(existingEmployee);
				dao = new EmployeeDao(
						ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));

				System.out.println("Enter email: ");
				String email = sc.next();
				Employee existingEmail = null;
				// Update abdul123@gmail.com (Name = ABDUL GANI)
				if (!email.equalsIgnoreCase(existingEmployee.getEmail())) {

					existingEmail = dao.getEmployeeByEmail(email);
				}
				if (existingEmail != null) {
					System.out.println("Employee with email = " + email + " already exists please enter another email");
				} else {
					dao = new EmployeeDao(
							ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));
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

					int result = dao.updateEmployee(employee, id);

					if (result == 1) {
						System.out.println("Employee Updated Successfully");
					} else {

						System.out.println("Something Bad Happens");
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

	private static void getAllEmployees() {
		try {
			EmployeeDao dao = new EmployeeDao(
					ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));

			List<Employee> employees = dao.getAllEmployees();

			if (employees.isEmpty()) {
				System.out.println("No records found");
			} else {
				for (Employee employee : employees) {
					System.out.println("---------------------------------------------------------");
					System.out.println(employee);

				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void deleteEmployee() {
		try {
			EmployeeDao dao = new EmployeeDao(
					ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter id: ");
			int id = sc.nextInt();

			// Find By id
			Employee existingEmployee = dao.getEmployeeById(id);

			if (existingEmployee == null) {
				System.out.println("Employee with id = " + id + " does not exists please enter another id");
			} else {
				// Delete
				System.out.println("Deleting this employee = \n" + existingEmployee);
				dao = new EmployeeDao(
						ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));

				int result = dao.deleteEmployee(id);

				if (result == 1) {
					System.out.println("Employee Deleted Successfully");
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
