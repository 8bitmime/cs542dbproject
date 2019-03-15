package cs542dbproject;

import java.util.List;

public class TestMain {
	private static final String testPath = "data/EMS_Test_Data.csv";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CSVPaser csvPaser = new CSVPaser(testPath);
		List<String[]> records = csvPaser.readCSV();
		
		for (String[] record : records) {
		    System.out.println("Name : " + record[0]);
		    System.out.println("Email : " + record[1]);
		    System.out.println("Phone : " + record[2]);
		    System.out.println("Country : " + record[3]);
		    
		}
		
	}

}
