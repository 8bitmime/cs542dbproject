package database;

import java.sql.*;

import model.Call;
import model.Location;
import model.Outcome;
import model.ReceivingHospital;
import model.ReceivingService;
import model.Staff;
import model.TTime;
import model.TypeofCall;
import model.TypeofEvent;

public class dbWriter {

	private Connection conn;

	public dbWriter() {
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean inserCall(Call call) throws Exception {
		try {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO type_of_call (call_id, reported, actual,outcome_id, location_id) values(seq_callid.nextval,?,?,?,?);");
			ps.setString(1, call.getReported());
			ps.setString(2, call.getActural());
			ps.setInt(3, call.getOutcome().getOutcomeID());
			// TODO how to get thoes id
			ps.execute();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert constant: " + e.getMessage());
		}
	}

	public int insertLocation(Location location) throws Exception {
    	int generatedKey = 0;
        try {
        	
        	PreparedStatement ps = conn.prepareStatement("INSERT INTO loc (location_id ,loc_name,addr,loc_type) values(seq_locid.nextval,?,?,?);",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,  location.getName());
            ps.setString(2,  location.getAddress());
            //confirm the type
            ps.setString(3,  location.getName());



            ps.execute();
            PreparedStatement statement = conn.prepareStatement("select seq_locid.currval from dual");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	generatedKey = (int) rs.getLong(1);
            }
            System.out.println("Inserted record's ID: " + generatedKey);
            
        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        } 
        return generatedKey;
    }

	public int insertOutcome(Outcome outcome) throws Exception {
		int generatedKey = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO outcome (outcome_id ,oresult, recieving_service, recieving_hospital) values(seq_outcomeid.nextval,?,?,?);",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, outcome.getResult());
			ps.setString(2, outcome.getReceivingService());
			ps.setString(3, outcome.getRecvHosptial().getHospitalName());
			ps.execute();
            PreparedStatement statement = conn.prepareStatement("select seq_outcomeid.currval from dual");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	generatedKey = (int) rs.getLong(1);
            }
            System.out.println("Inserted record's ID: " + generatedKey);

		} catch (Exception e) {
			throw new Exception("Failed to insert constant: " + e.getMessage());
		}
		return generatedKey;
	}

	public int insertHospital(ReceivingHospital hospital) throws Exception {
		int generatedKey = 0;
		try {
			// PreparedStatement ps =
			// conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
			// ps.setString(1, location.getName());
			// ResultSet resultSet = ps.executeQuery();
			//
			// // already present?
			// while (resultSet.next()) {
			// Constant c = generateConstant(resultSet);
			// resultSet.close();
			// return false;
			// }

			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO recieving_hospital (hospital_id ,hospital_name ,hospital_address) values(seq_hospitalid.nextval,?,?);",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, hospital.getHospitalName());
			ps.setString(2, hospital.getHospitalAddress());
			ps.execute();
			
            PreparedStatement statement = conn.prepareStatement("select seq_hospitalid.currval from dual");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	generatedKey = (int) rs.getLong(1);
            }
            System.out.println("Inserted record's ID: " + generatedKey);

		} catch (Exception e) {
			throw new Exception("Failed to insert constant: " + e.getMessage());
		}
		return generatedKey;
	}

	public int insertStaff(Staff staff) throws Exception {
		int generatedKey = 0;
		try {
			// PreparedStatement ps =
			// conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
			// ps.setString(1, location.getName());
			// ResultSet resultSet = ps.executeQuery();
			//
			// // already present?
			// while (resultSet.next()) {
			// Constant c = generateConstant(resultSet);
			// resultSet.close();
			// return false;
			// }

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO staff (staff_id, name_s, badge_id,dob) values(seq_staffid.nextval,?,?,?);");
			ps.setString(1, staff.getName());
			ps.setInt(2, staff.getBadgeID());
			ps.setTimestamp(3, staff.getDateofBirth());
			ps.execute();
			
            PreparedStatement statement = conn.prepareStatement("select seq_staffid.currval from dual");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	generatedKey = (int) rs.getLong(1);
            }
            System.out.println("Inserted record's ID: " + generatedKey);
            

		} catch (Exception e) {
			throw new Exception("Failed to insert constant: " + e.getMessage());
		}
		return generatedKey;
		
	}

	public int insertTime(TTime time) throws Exception {
		int generatedKey = 0;
		try {
			// PreparedStatement ps =
			// conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
			// ps.setString(1, location.getName());
			// ResultSet resultSet = ps.executeQuery();
			//
			// // already present?
			// while (resultSet.next()) {
			// Constant c = generateConstant(resultSet);
			// resultSet.close();
			// return false;
			// }

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO time_t (time_t, type_t) values(?,?);");
			ps.setTimestamp(1, time.getTime());
			ps.setString(2, time.getTimeType());
			ps.execute();
			
			PreparedStatement statement = conn.prepareStatement("select seq_staffid.currval from dual");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	generatedKey = (int) rs.getLong(1);
            }
            System.out.println("Inserted record's ID: " + generatedKey);
            
		} catch (Exception e) {
			throw new Exception("Failed to insert constant: " + e.getMessage());
		}
		return generatedKey;
	}
	
	public int insertRecvServcie(ReceivingService recvService) throws Exception {
		int generatedKey = 0;
		try {
			// PreparedStatement ps =
			// conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
			// ps.setString(1, location.getName());
			// ResultSet resultSet = ps.executeQuery();
			//
			// // already present?
			// while (resultSet.next()) {
			// Constant c = generateConstant(resultSet);
			// resultSet.close();
			// return false;
			// }

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO time_t (time_t, type_t) values(?,?);");
			ps.setTimestamp(1, time.getTime());
			ps.setString(2, time.getTimeType());
			ps.execute();
			
			PreparedStatement statement = conn.prepareStatement("select seq_staffid.currval from dual");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	generatedKey = (int) rs.getLong(1);
            }
            System.out.println("Inserted record's ID: " + generatedKey);
            
		} catch (Exception e) {
			throw new Exception("Failed to insert constant: " + e.getMessage());
		}
		return generatedKey;
	}
	
	public int insertTypeofEvent(TypeofEvent typeEvent) throws Exception {
		
		int generatedKey = 0;
		try {
			// PreparedStatement ps =
			// conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
			// ps.setString(1, location.getName());
			// ResultSet resultSet = ps.executeQuery();
			//
			// // already present?
			// while (resultSet.next()) {
			// Constant c = generateConstant(resultSet);
			// resultSet.close();
			// return false;
			// }

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO time_t (time_t, type_t) values(?,?);");
			ps.setTimestamp(1, time.getTime());
			ps.setString(2, time.getTimeType());
			ps.execute();
			
			PreparedStatement statement = conn.prepareStatement("select seq_staffid.currval from dual");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
            	generatedKey = (int) rs.getLong(1);
            }
            System.out.println("Inserted record's ID: " + generatedKey);
            
		} catch (Exception e) {
			throw new Exception("Failed to insert constant: " + e.getMessage());
		}
}
