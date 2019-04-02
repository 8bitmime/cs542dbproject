package cs542dbproject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import model.Location;
import model.Outcome;
import model.ReceivingHospital;
import model.Staff;
import model.TTime;
import model.TypeofCall;
import util.Setting;

public class CSVPaser {
	private String filePath = null;

	private List<TTime> timeList;
	private List<Location> locationList;
	private List<ReceivingHospital> recvHospList;
	private List<Staff> staffList;
	private List<TypeofCall> typeCallList;

	/**
	 * ctor
	 * 
	 * @param filePath create all new object list
	 */
	public CSVPaser(String filePath) {
		this.filePath = filePath;

		this.timeList = new ArrayList<TTime>();
		this.locationList = new ArrayList<Location>();
		this.recvHospList = new ArrayList<ReceivingHospital>();
		this.staffList = new ArrayList<Staff>();
		this.typeCallList = new ArrayList<TypeofCall>();

	}

	/**
	 * 
	 * @return List<String[]> csvRecords
	 * @throws IOException
	 */
	public List<String[]> readCSV() throws IOException {

		List<String[]> csvRecords = null;

		Reader reader = Files.newBufferedReader(Paths.get(this.filePath));
		CSVReader csvReader = new CSVReaderBuilder(reader).withFieldAsNull(CSVReaderNullFieldIndicator.EMPTY_SEPARATORS)
				// Skip the header
				.withSkipLines(1).build();
		csvRecords = csvReader.readAll();
		return csvRecords;
	}

	/**
	 * 
	 * @param records
	 */
	
	//TODO: revisit the naming
	//TODO: location is missing
	public int buildModel(List<String[]> records) {
		int checkCount = 0;
		for (String[] record : records) {
			//populate time records
			TTime dispatched = new TTime(Timestamp.valueOf(record[0]), Setting.CSV_FORMATE[0]);
			TTime Enrout = new TTime(Timestamp.valueOf(record[1]), Setting.CSV_FORMATE[1]);
			TTime arrived = new TTime(Timestamp.valueOf(record[2]), Setting.CSV_FORMATE[2]);
			TTime available = new TTime(Timestamp.valueOf(record[3]), Setting.CSV_FORMATE[3]);
			TTime eaDispatched = new TTime(Timestamp.valueOf(record[4]), "EA-Dispatch");
			TTime eaArrived = new TTime(Timestamp.valueOf(record[5]), "EA-Arrived");
			TTime eaClear = new TTime(Timestamp.valueOf(record[6]), "EA-Clear");
			timeList.add(dispatched);
			timeList.add(Enrout);
			timeList.add(arrived);
			timeList.add(available);
			timeList.add(eaDispatched);
			timeList.add(eaArrived);
			timeList.add(eaClear);
			//end time records
			
			//populate Type of Call
			ReceivingHospital recvHospital = new ReceivingHospital(record[8],null);
			Outcome outCome = new Outcome (record[9],record[10], recvHospital);
			TypeofCall call = new TypeofCall(record[7], record[14], outCome);
			typeCallList.add(call);
			//TODO: ASK about the receving service structure, will hospital and EMS occure at same time?
			//TODO: Referring is missing
			//end of type of call
			
			//populate Staff
			Staff staff1 = new Staff( record[11], record[16]);
			Staff staff2 = new Staff( record[12], record[17]);
			Staff staff3 = new Staff( record[13], record[18]);
			staffList.add(staff1);
			staffList.add(staff2);
			staffList.add(staff3);
			checkCount++;
		}
		return checkCount;
	}

}
