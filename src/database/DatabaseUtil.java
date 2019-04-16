package database;

import java.sql.*;

public class DatabaseUtil {

	// These are to be configured and NEVER stored in the code.
	// once you retrieve this code, you can update
	public final static String dbUsername = "yyan3";
	public final static String dbPassword = "YYAN3";
	
	public final static String url = "jdbc:oracle:thin:@oracle.wpi.edu:1521:ORCL";

	// pooled across all usages.
	static Connection conn;
 
	/**
	 * Singleton access to DB connection to share resources effectively across multiple accesses.
	 */
	protected static Connection connect() throws Exception {
		if (conn != null) { return conn; }
		
		try {
			System.out.println("start connecting......");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url,dbUsername,dbPassword
					
					);
			System.out.println("Database has been connected successfully.");
			return conn;
		} catch (Exception ex) {
			throw new Exception("Failed in database connection"+ex);
		}
	}
}
