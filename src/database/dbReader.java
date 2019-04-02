package database;

import java.sql.Connection;

public class dbReader {
	
	private Connection conn;
	
	public dbReader(){
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
