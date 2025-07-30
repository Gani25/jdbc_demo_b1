package standard.com.sprk.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	public static Connection getConnection(String url, String username, String password) throws SQLException {
		
		return DriverManager.getConnection(url, username, password);
		
	}

}
