package database;

import java.sql.*;

import model.Call;
import model.Location;
import model.Outcome;
import model.ReceivingHospital;
import model.ReceivingService;
import model.Staff;
import model.TTime;

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
		int id = 0;
		try {

			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO call (call_id, call_reported, call_actual) values (seq_callid.nextval,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, call.getReported());
			ps.setString(2, call.getActural());
			ps.execute();

			PreparedStatement statement = conn
					.prepareStatement("select seq_callid.currval from dual");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				id = (int) rs.getLong(1);
			}

			System.out.println("Inserted record's ID: " + id);
			ps.close();
			rs.close();
			for (TTime time : call.getTimeList()) {
				if (!(time.getTime() == null || time.getTimeType() == "")) {
					this.insertTime(time);
					this.insertTimes_of_call(id, time);
				}
			}
			int locationID = this.insertLocation(call.getLocation());
			this.insertCalllocation(id, locationID);

			for (Staff staff : call.getStaffList()) {
				int staffId = this.insertStaff(staff);
				this.insertRespond_to(staffId, id);
			}

			 int outcomeID = this.insertOutcome(call.getOutcome());
			 this.insertCall_outcome(id, outcomeID);
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert inserCall: " + e.getMessage());
		}
	}

	/**
	 * 
	 * @param location
	 * @return id
	 * @throws Exception
	 */
	public int insertLocation(Location location) throws Exception {
		int generatedKey = 0;
		try {

			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO loc (location_id ,loc_name,addr,loc_type) values(seq_locid.nextval,?,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, location.getName());
			ps.setString(2, location.getAddress());
			ps.setString(3, location.getType());

			ps.execute();
			PreparedStatement statement = conn
					.prepareStatement("select seq_locid.currval from dual");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				generatedKey = (int) rs.getLong(1);
			}
			
			ps.close();
			rs.close();
		} catch (Exception e) {
			throw new Exception("Failed to insert insertLocation: "
					+ e.getMessage());
		}
		return generatedKey;
	}

	public boolean insertTimes_of_call(int callId, TTime time) throws Exception {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO times_of_call (call_id, time_t, type_t) values(?,?,?)");
			ps.setInt(1, callId);
			ps.setTimestamp(2, time.getTime());
			ps.setString(3, time.getTimeType());
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert insertTimes_of_call: "
					+ e.getMessage());
		}

	}

	public boolean insertRespond_to(int staffId, int callId) throws Exception {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO respond_to (staff_id, call_id) values(?,?)");
			ps.setInt(1, staffId);
			ps.setInt(2, callId);
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert insertRespond_to: "
					+ e.getMessage());
		}

	}

	public boolean insertCall_outcome(int callID, int outcomeID)
			throws Exception {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO call_outcome (call_id, outcome_id) values(?,?)");
			ps.setInt(1, callID);
			ps.setInt(2, outcomeID);
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert insertCall_outcome: "
					+ e.getMessage());
		}
	}

	public boolean insertService_transports(int outcomeID, int serviceID)
			throws Exception {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO service_transports (outcome_id, service_id) values(?,?)");
			ps.setInt(1, outcomeID);
			ps.setInt(2, serviceID);
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert insertService_transports: "
					+ e.getMessage());
		}

	}

	public boolean insertHospital_transports(int outcomeID, int hospitalID)
			throws Exception {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO hospital_transports (outcome_id, hospital_id) values(?,?)");
			ps.setInt(1, outcomeID);
			ps.setInt(2, hospitalID);
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert insertHospital_transports: "
					+ e.getMessage());
		}
	}

	public boolean insertCalllocation(int callId, int locationID)
			throws Exception {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO call_location (call_id, loc_id) values(?,?)");
			ps.setInt(1, callId);
			ps.setInt(2, locationID);
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert insertCalllocation: "
					+ e.getMessage());
		}
	}

	public boolean insertHospitalLocation(int hospitalID, int locationID)
			throws Exception {
		try {
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO hospital_location (hospital_id, loc_id) values(?,?)");
			ps.setInt(1, hospitalID);
			ps.setInt(2, locationID);
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert insertHospitalLocation: "
					+ e.getMessage());
		}
	}

	/**
	 * 
	 * @param outcome
	 * @return id
	 * @throws Exception
	 */
	public int insertOutcome(Outcome outcome) throws Exception {
		int generatedKey = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO outcome (outcome_id ,oresult)values (seq_outcomeid.nextval,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, outcome.getResult());
			ps.execute();
			PreparedStatement statement = conn
					.prepareStatement("select seq_outcomeid.currval from dual");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				generatedKey = (int) rs.getLong(1);
			}
			ps.close();
			rs.close();
			
			if (outcome.getReceivingService()!=null) {
				System.out.println("service empty");
				int sevcID = this.insertService(outcome.getReceivingService());
				this.insertService_transports(generatedKey, sevcID);
			}
			if (outcome.getRecvHosptial()!=null) {
				System.out.println("hospital empty");
				int hospitalID = this.insertHospital(outcome.getRecvHosptial());
				this.insertHospital_transports(generatedKey, hospitalID);
			}
		} catch (Exception e) {
			throw new Exception("Failed to insert Outcome: " + e.getMessage());
		}
		return generatedKey;
	}

	/**
	 * 
	 * @param hospital
	 * @return id
	 * @throws Exception
	 */
	public int insertHospital(ReceivingHospital hospital) throws Exception {
		int generatedKey = 0;
		try {
			int hospitaladdID = this.insertLocation(hospital
					.getHospitalAddress());

			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO recieving_hospital (hospital_id ,hospital_name ,location_id) values(seq_hospitalid.nextval,?,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, hospital.getHospitalName());
			ps.setInt(2, hospitaladdID);
			ps.execute();
			ps.close();

			PreparedStatement statement = conn
					.prepareStatement("select seq_hospitalid.currval from dual");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				generatedKey = (int) rs.getLong(1);
			}
			rs.close();
			

			int locationID = this.insertLocation(hospital.getHospitalAddress());
			this.insertHospitalLocation(generatedKey, locationID);

		} catch (Exception e) {
			throw new Exception("Failed to insert hospital: " + e.getMessage());
		}
		return generatedKey;
	}

	/**
	 * 
	 * @param service
	 * @return id
	 * @throws Exception
	 */
	public int insertService(ReceivingService service) throws Exception {
		int generatedKey = 0;
		try {

			PreparedStatement ps = conn
					.prepareStatement(
							"INSERT INTO recieving_service (service_id ,service_name) values(seq_sevcid.nextval,?)",
							Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, service.getName());
			ps.execute();
			ps.close();

			PreparedStatement statement = conn
					.prepareStatement("select seq_sevcid.currval from dual");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				generatedKey = (int) rs.getLong(1);
			}

		} catch (Exception e) {
			throw new Exception("Failed to insert service: " + e.getMessage());
		}
		return generatedKey;
	}

	/**
	 * 
	 * @param staff
	 * @return id
	 * @throws Exception
	 */
	public int insertStaff(Staff staff) throws Exception {
		int generatedKey = 0;
		try {

			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO staff (staff_id, name_s, badge_id,dob) values(seq_staffid.nextval,?,?,?)");
			ps.setString(1, staff.getName());
			ps.setInt(2, staff.getBadgeID());
			ps.setTimestamp(3, staff.getDateofBirth());
			ps.execute();
			PreparedStatement statement = conn
					.prepareStatement("select seq_staffid.currval from dual");
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				generatedKey = (int) rs.getLong(1);
			}
			
			rs.close();
			ps.close();
		} catch (Exception e) {
			throw new Exception("Failed to insert staff: " + e.getMessage());
		}
		return generatedKey;
	}

	/**
	 * 
	 * @param time
	 * @return id
	 * @throws Exception
	 */
	public boolean insertTime(TTime time) throws Exception {
		try {
			System.out.println(time.getTimeType() + " - --" + time.getTime());
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO time_t (time_t, type_t) values(?,?)");

			ps.setTimestamp(1, time.getTime());
			ps.setString(2, time.getTimeType());
			ps.execute();
			ps.close();
			return true;

		} catch (Exception e) {
			throw new Exception("Failed to insert Time: " + e.getMessage());
		}
	}
	
	public void closeConn() throws SQLException{
		conn.close();
	}

}
