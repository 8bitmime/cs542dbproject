package cs542dbproject;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import util.DateConverter;

public class TestMain {
	private static final String testPath = "data/EMS_Test_Data.csv";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVPaser csvPaser = new CSVPaser(testPath);
		List<String[]> records = null;
		try {
			records = csvPaser.readCSV();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] temp = records.get(0);
		System.out.println(temp[0]);
		
		int rollCount = 0;
		try {
			rollCount = csvPaser.buildModel(records);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Number of line have been parsed: "+rollCount);
		System.out.println(DateConverter.converDate("10/26/2011 7:37"));
		
	}

}
