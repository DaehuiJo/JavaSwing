package Database;

import java.sql.*;

public class DBConnection {
	String driver = "com.mysql.jdbc.Driver"; //Driver name
	String url = "jdbc:mysql://localhost/bookmanagement"; //url & database
	String id = "root";
	String pw = "vmfltmxkdlf1";
	Connection con = null;
	public DBConnection() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, id, pw);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection(){
		return con;
	}
}
