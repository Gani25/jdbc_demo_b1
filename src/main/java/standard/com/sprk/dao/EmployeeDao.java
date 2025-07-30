package standard.com.sprk.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import standard.com.sprk.entity.Employee;

public class EmployeeDao {

	// Aggregation
	private Connection connection;

	public EmployeeDao(Connection connection) {
		this.connection = connection;
	}

	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> employees = new ArrayList<>();

		// Logic of SQL
		// Step 3: Create SQL Statements
		String sql = "select * from employee";
		PreparedStatement ps = connection.prepareStatement(sql);

		// Step 4: Execute SQL Statements
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			// Load all employees in List
			Employee employee = new Employee();
			employee.setEmpId(rs.getInt("emp_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setGender(rs.getString("gender"));
			employee.setEmail(rs.getString("email"));
			employee.setCreatedAt(rs.getTimestamp("created_at"));
			employee.setUpdatedAt(rs.getTimestamp("updated_at"));
			employees.add(employee);
		}

		// Step 5: Close All
		closeAll(connection, rs, ps);

		return employees;
	}

	// supporting method
	private void closeAll(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement) throws SQLException {
		if (connection!= null) {
			connection.close();
		}
		if(resultSet!=null) {
			resultSet.close();
		}
		if(preparedStatement != null) {
			preparedStatement.close();
		}
	}
}
