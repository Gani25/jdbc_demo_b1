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

	// Get Employee By Email
	public Employee getEmployeeByEmail(String email) throws SQLException {
		Employee employee = null;

		// Logic of SQL
		// Step 3: Create SQL Statements
		String sql = "select * from employee where email = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, email);

		// Step 4: Execute SQL Statements
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			// When we find that employee then only create object of employee
			employee = new Employee();

			// Load all data into employees object
			employee.setEmpId(rs.getInt("emp_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setGender(rs.getString("gender"));
			employee.setEmail(rs.getString("email"));
			employee.setCreatedAt(rs.getTimestamp("created_at"));
			employee.setUpdatedAt(rs.getTimestamp("updated_at"));

		}

		// Step 5: Close All
		closeAll(connection, rs, ps);

		return employee;
	}

	// Insert Employee
	public int insertEmployee(Employee employee) throws SQLException {
		int result = 0;
		// Logic of SQL
		// Step 3: Create SQL Statements
		String sql = "insert into employee(first_name, last_name, gender, email) values (?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(sql);

		// Set Values in ?
		ps.setString(1, employee.getFirstName());
		ps.setString(2, employee.getLastName());
		ps.setString(3, employee.getGender());
		ps.setString(4, employee.getEmail());

		// Step 4: Execute SQL Statements
		result = ps.executeUpdate();

		// Step 5: Close All
		closeAll(connection, null, ps);

		return result;

	}

	// Get Employee By Id
	public Employee getEmployeeById(int id) throws SQLException {
		Employee employee = null;

		// Logic of SQL
		// Step 3: Create SQL Statements
		String sql = "select * from employee where emp_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);

		// Step 4: Execute SQL Statements
		ResultSet rs = ps.executeQuery();

		if (rs.next()) {
			// When we find that employee then only create object of employee
			employee = new Employee();

			// Load all data into employees object
			employee.setEmpId(rs.getInt("emp_id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setGender(rs.getString("gender"));
			employee.setEmail(rs.getString("email"));
			employee.setCreatedAt(rs.getTimestamp("created_at"));
			employee.setUpdatedAt(rs.getTimestamp("updated_at"));

		}

		// Step 5: Close All
		closeAll(connection, rs, ps);

		return employee;
	}

	// Update Employee
	public int updateEmployee(Employee employee, int id) throws SQLException {
		int result = 0;
		// Logic of SQL
		// Step 3: Create SQL Statements
		String sql = "update employee set first_name = ?, last_name = ?, gender = ?, email = ? where emp_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);

		// Set Values in ?
		ps.setString(1, employee.getFirstName());
		ps.setString(2, employee.getLastName());
		ps.setString(3, employee.getGender());
		ps.setString(4, employee.getEmail());
		ps.setInt(5, id);

		// Step 4: Execute SQL Statements
		result = ps.executeUpdate();

		// Step 5: Close All
		closeAll(connection, null, ps);

		return result;

	}

	// supporting method
	private void closeAll(Connection connection, ResultSet resultSet, PreparedStatement preparedStatement)
			throws SQLException {
		if (connection != null) {
			connection.close();
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (preparedStatement != null) {
			preparedStatement.close();
		}
	}

	public int deleteEmployee(int id) throws SQLException {
		// Delete Emp By Id
		String sql = "delete from employee where emp_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, id);
		int result = 0;
		result = ps.executeUpdate();
		closeAll(connection, null, ps);

		return result;
	}
}
