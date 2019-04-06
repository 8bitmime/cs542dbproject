package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import model.Location;
import model.Outcome;
import model.ReceivingHospital;

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
				int roomNumber = resultSet.getInt("room_number");
				int streetNumber = resultSet.getInt("street_num");
				String streetName = resultSet.getString("street_name");
				String type = resultSet.getString("type_l");
				String name = resultSet.getString("name_l");
				Location location = new Location(locationID, roomNumber,
						streetNumber, streetName, type, name);
				allLocations.add(location);
			}
			resultSet.close();
			statement.close();
			return allLocations;

		} catch (Exception e) {
			throw new Exception("Failed in getting books: " + e.getMessage());
		}
	}

	public List<Outcome> getAllOutcome() throws Exception {

		List<Outcome> allOutcome = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM outcome";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int outcomeID = resultSet.getInt("outcome_id");
				String result = resultSet.getString("oresult");
				String receivingService = resultSet.getString("recieving_service");
				String recvHosptialt = resultSet.getString("recieving_hospital");
				PreparedStatement ps = conn.prepareStatement("SELECT * FROM recieving_hospital WHERE hospital_name = ?");
				ps.setString(1,  recvHosptialt);
				
				ResultSet hosResult = ps.executeQuery();
				int hospitalID = hosResult.getInt("hospital_id");
				String hospitalName = hosResult.getString("oresult");
				String hospital_name  = hosResult.getString("hospital_name");
				String location_id = hosResult.getString("location_id");
				
				ReceivingHospital recvHosptial = new ReceivingHospital(hospitalID,hospitalName,location)
				Outcome outcome = new Outcome(outcomeID, result,
						receivingService, recvHosptial);
				allOutcome.add(outcome);
			}
			resultSet.close();
			statement.close();
			return allOutcome;

		} catch (Exception e) {
			throw new Exception("Failed in getting books: " + e.getMessage());
		}
	}

	public List<Location> getAllConstants() throws Exception {

		List<Location> allLocations = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM Constants";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Double value = resultSet.getDouble("value");

				Location location = new Location(locationID, roomNumber,
						streetNumber, streetName, type, name);
				allLocations.add(location);
			}
			resultSet.close();
			statement.close();
			return allLocations;

		} catch (Exception e) {
			throw new Exception("Failed in getting books: " + e.getMessage());
		}
	}

	public List<Location> getAllConstants() throws Exception {

		List<Location> allLocations = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM Constants";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Double value = resultSet.getDouble("value");

				Location location = new Location(locationID, roomNumber,
						streetNumber, streetName, type, name);
				allLocations.add(location);
			}
			resultSet.close();
			statement.close();
			return allLocations;

		} catch (Exception e) {
			throw new Exception("Failed in getting books: " + e.getMessage());
		}
	}

	public List<Location> getAllConstants() throws Exception {

		List<Location> allLocations = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM Constants";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Double value = resultSet.getDouble("value");

				Location location = new Location(locationID, roomNumber,
						streetNumber, streetName, type, name);
				allLocations.add(location);
			}
			resultSet.close();
			statement.close();
			return allLocations;

		} catch (Exception e) {
			throw new Exception("Failed in getting books: " + e.getMessage());
		}
	}

	public List<Location> getAllConstants() throws Exception {

		List<Location> allLocations = new ArrayList<>();
		try {
			Statement statement = conn.createStatement();
			String query = "SELECT * FROM Constants";
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				String name = resultSet.getString("name");
				Double value = resultSet.getDouble("value");

				Location location = new Location(locationID, roomNumber,
						streetNumber, streetName, type, name);
				allLocations.add(location);
			}
			resultSet.close();
			statement.close();
			return allLocations;

		} catch (Exception e) {
			throw new Exception("Failed in getting books: " + e.getMessage());
		}
	}

}
