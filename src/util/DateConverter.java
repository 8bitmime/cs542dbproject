package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter {
	private final static String dateFormate ="MM/dd/yyyy HH:mm";
	
	public static Timestamp converDate(String date){
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormate);
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(formatter.parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			timeStamp = null;
		}
		return timeStamp;
	}
}
