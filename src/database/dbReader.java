package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import model.Location;
import model.Outcome;
import model.ReceivingHospital;
import model.Staff;

public class dbReader {

	private Connection conn;

	public dbReader() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Location> getAllLocation() throws Exception {

		List<Location> allLocations = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM loc";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int locationID = resultSet.getInt("location_id");
				String name = resultSet.getString("loc_name");
				String address = resultSet.getString("addr");
				String type = resultSet.getString("loc_type");
				Location location = new Location(locationID, type, name , address);
				allLocations.add(location);
			}
			resultSet.close();
			statement.close();
			return allLocations;

		} catch (Exception e) {
			throw new Exception("Failed in getting locations: " + e.getMessage());
		}
	}
	
	public List<Staff> getStaff(String sname, Timestamp sdob) throws Exception {
		List<Staff> result = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM staff WHERE name_s like ? OR dob=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,sname);
			ps.setTimestamp(2,sdob);
			System.out.println("get Staff "+sname + sdob);
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				System.out.println("get Staff "+sname + sdob);
				int staffID = resultSet.getInt("staff_id");
				String name = resultSet.getString("name_s");
				int badgeID = resultSet.getInt("badge_id");
				Timestamp dob = resultSet.getTimestamp("dob");
				Staff staff = new Staff(staffID, name, badgeID , dob);
				result.add(staff);
			}
			resultSet.close();
			statement.close();
			return result;

		} catch (Exception e) {
			throw new Exception("Failed in getting staff: " + e.getMessage());
		}
	}
}
