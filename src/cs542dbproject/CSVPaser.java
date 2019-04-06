package cs542dbproject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import model.Call;
import model.Location;
import model.Outcome;
import model.ReceivingHospital;
import model.ReceivingService;
import model.Staff;
import model.TTime;
import model.TypeofEvent;
import util.DateConverter;
import util.Setting;

public class CSVPaser {
	private String filePath = null;

	private List<TTime> timeList;
	private List<Location> locationList;
	private List<ReceivingHospital> recvHospList;
	private List<Staff> staffList;
	private List<Call> CallList;

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
		this.CallList = new ArrayList<Call>();

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
	 * @throws ParseException 
	 */
	
	//TODO: revisit the naming
	//TODO: location is missing
	public int buildModel(List<String[]> records) throws ParseException {
		int checkCount = 0;
		for (String[] record : records) {
			//populate time records
			TTime dispatched = new TTime(DateConverter.converDate(record[0]), Setting.CSV_FORMATE[0]);
			TTime Enrout = new TTime(DateConverter.converDate(record[1]), Setting.CSV_FORMATE[1]);
			TTime arrived = new TTime(DateConverter.converDate(record[2]), Setting.CSV_FORMATE[2]);
			TTime available = new TTime(DateConverter.converDate(record[3]), Setting.CSV_FORMATE[3]);
			TTime eaDispatched = new TTime(DateConverter.converDate(record[4]), "EA-Dispatch");
			TTime eaArrived = new TTime(DateConverter.converDate(record[5]), "EA-Arrived");
			TTime eaClear = new TTime(DateConverter.converDate(record[6]), "EA-Clear");
			timeList.add(dispatched);
			timeList.add(Enrout);
			timeList.add(arrived);
			timeList.add(available);
			timeList.add(eaDispatched);
			timeList.add(eaArrived);
			timeList.add(eaClear);
			//end time records
			
			ReceivingHospital recvHospital = new ReceivingHospital(record[8],null);
			ReceivingService recvService  = new ReceivingService(record[10]);
			Outcome outCome = new Outcome (record[9],recvService, recvHospital);
			Location location = new Location(null,record[15],record[19]);
			
			//populate Staff
			Staff staff1 = new Staff( record[11], processBadgeID(record[16]));
			Staff staff2 = new Staff( record[12], processBadgeID(record[17]));
			Staff staff3 = new Staff( record[13], processBadgeID(record[18]));
			staffList.add(staff1);
			staffList.add(staff2);
			staffList.add(staff3);
			TypeofEvent reportEvent = new TypeofEvent(record[7]);
			TypeofEvent actualEvent = new TypeofEvent(record[14]);
			Call call = new Call(reportEvent, actualEvent, outCome, timeList, staffList, location);
			CallList.add(call);
			checkCount++;
		}
		return checkCount;
	}
	
	private int processBadgeID(String badgeID){
		int bID = 0;
	
		try{
			bID = Integer.parseInt(badgeID);
		}catch(Exception ex){
			bID = 999;
		}
		return bID;
	}

}
