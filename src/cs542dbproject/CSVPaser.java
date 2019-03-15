package cs542dbproject;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVReader;


public class CSVPaser {
	private String filePath = null;
	
	/**
	 * ctor
	 * @param filePath
	 */
	public CSVPaser(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * 
	 * @return List<String[]> csvRecords
	 */
	public List<String[]> readCSV() {
		List<String[]> csvRecords = null;

		try {

			Reader reader = Files.newBufferedReader(Paths.get(this.filePath));
			CSVReader csvReader = new CSVReader(reader);
			csvRecords = csvReader.readAll();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return csvRecords;
		
	}
	
	
}
