package standard.com.sprk.main;

import java.util.List;

import standard.com.sprk.connection.ConnectionUtil;
import standard.com.sprk.dao.EmployeeDao;
import standard.com.sprk.entity.Employee;

public class GetAll {

	public static void main(String[] args) {
		try {
			EmployeeDao dao = new EmployeeDao(ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));
			
			List<Employee> employees = dao.getAllEmployees();
			
			if(employees.isEmpty()) {
				System.out.println("No records found");
			}else {
				for(Employee employee: employees) {
					System.out.println("---------------------------------------------------------");
					System.out.println(employee);
					
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
