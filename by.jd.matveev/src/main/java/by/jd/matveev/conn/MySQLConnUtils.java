package by.jd.matveev.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

	public static Connection getMySQLConnection () throws ClassNotFoundException, SQLException{
		String hostName = "localhost";
		String dbName = "booking";
		String userName = "root";
		String password = "root";
		return getMySQLConnection(hostName, dbName, userName, password);
	}
	public static Connection getMySQLConnection (String hostName, String dbName, String userName, String password) throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
		//String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/booking", "root", "root");
		return conn;/*SET GLOBAL time_zone = '+3:00';*/
	}
}
