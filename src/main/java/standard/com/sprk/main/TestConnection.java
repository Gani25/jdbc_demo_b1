package standard.com.sprk.main;

import java.sql.SQLException;

import standard.com.sprk.connection.ConnectionUtil;

public class TestConnection {

	public static void main(String[] args) {
		try {
			System.out.println("Connection Obtain: "
					+ ConnectionUtil.getConnection("jdbc:mysql://localhost:3306/core_java_jdbc", "root", "root"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
