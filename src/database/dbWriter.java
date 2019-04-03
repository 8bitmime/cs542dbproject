package database;

import java.sql.*;

import model.Location;
import model.Outcome;
import model.ReceivingHospital;
import model.Staff;
import model.TTime;
import model.TypeofCall;



public class dbWriter {
	
	private Connection conn;
	
	public dbWriter(){
		try {
			conn = DatabaseUtil.connect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public boolean insertLocation(Location location) throws Exception {
        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
//            ps.setString(1, location.getName());
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Constant c = generateConstant(resultSet);
//                resultSet.close();
//                return false;
//            }

        	PreparedStatement ps = conn.prepareStatement("INSERT INTO loc (location_id ,room_number,street_num,street_name,type_l,name_l) values(seq_locid.nextval,?,?,?,?,?);");
            ps.setInt(1,  location.getRoomNumber());
            ps.setInt(2,  location.getStreetNumber());
            ps.setString(3,  location.getStreetName());
            ps.setString(4,  location.getType());
            ps.setString(5,  location.getName());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }
    
    public boolean insertOutcome(Outcome outcome) throws Exception {
        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
//            ps.setString(1, location.getName());
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Constant c = generateConstant(resultSet);
//                resultSet.close();
//                return false;
//            }

        	PreparedStatement ps = conn.prepareStatement("INSERT INTO outcome (outcome_id ,oresult, recieving_service, recieving_hospital) values(seq_outcomeid.nextval,?,?,?);");
            ps.setString(1,  outcome.getResult());
            ps.setString(2,  outcome.getReceivingService());
            ps.setString(3,  outcome.getRecvHosptial().getHospitalName());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }
    
    public boolean insertHospital(ReceivingHospital hospital) throws Exception {
        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
//            ps.setString(1, location.getName());
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Constant c = generateConstant(resultSet);
//                resultSet.close();
//                return false;
//            }

        	PreparedStatement ps = conn.prepareStatement("INSERT INTO recieving_hospital (hospital_id ,hospital_name ,location_id) values(seq_hospitalid.nextval,?,?);");
            ps.setString(1,  hospital.getHospitalName());
            ps.setInt(2,  hospital.getLocation().getLocationID());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }
    
    public boolean insertStaff(Staff staff) throws Exception {
        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
//            ps.setString(1, location.getName());
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Constant c = generateConstant(resultSet);
//                resultSet.close();
//                return false;
//            }

        	PreparedStatement ps = conn.prepareStatement("INSERT INTO staff (staff_id, name_s, badge_id,dob) values(seq_staffid.nextval,?,?,?);");
            ps.setString(1,  staff.getName());
            ps.setInt(2,  staff.getBadgeID());
            ps.setTimestamp(3, staff.getDateofBirth());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }
    
    public boolean insertTime(TTime time) throws Exception {
        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
//            ps.setString(1, location.getName());
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Constant c = generateConstant(resultSet);
//                resultSet.close();
//                return false;
//            }

        	PreparedStatement ps = conn.prepareStatement("INSERT INTO time_t (time_t, type_t) values(?,?);");
            ps.setTimestamp(1, time.getTime());
            ps.setString(2, time.getTimeType());
            ps.execute();
            return true;
            
        } catch (Exception e) {
            throw new Exception("Failed to insert constant: " + e.getMessage());
        }
    }
    
    public boolean inserTypeCall(TypeofCall call) throws Exception {
        try {
//            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Constants WHERE name = ?;");
//            ps.setString(1, location.getName());
//            ResultSet resultSet = ps.executeQuery();
//            
//            // already present?
//            while (resultSet.next()) {
//                Constant c = generateConstant(resultSet);
//                resultSet.close();
//                return false;
//            }

        	PreparedStatement ps = conn.prepareStatement("INSERT INTO type_of_call (call_id, reported, actual,outcome_id, location_id) values(seq_callid.nextval,?,?,?,?);");
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
}
