package connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * 
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
		try {
			return (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/clube_bd_ap2", "root", "password");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
