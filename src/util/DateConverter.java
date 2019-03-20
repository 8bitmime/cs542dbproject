package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter {
	private final static String dateFormate ="MM/dd/yyyy HH:mm";
	
	public static Timestamp converDate(String date) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormate);
		Timestamp timeStamp = new Timestamp(formatter.parse(date).getTime());
		return timeStamp;
	}
}
