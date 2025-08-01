package standard.com.sprk.main;

import java.util.Scanner;

import standard.com.sprk.connection.ConnectionUtil;
import standard.com.sprk.dao.EmployeeDao;
import standard.com.sprk.entity.Employee;

public class DeleteEmployee {

	public static void main(String[] args) {
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