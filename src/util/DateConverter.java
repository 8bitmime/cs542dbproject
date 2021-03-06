package util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	private final static String dateFormate ="MM/dd/yyyy HH:mm";
	private final static String bodFormate = "MM/dd/yyyy";
	
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
	
	public static Timestamp converBod(String date){
		SimpleDateFormat formatter = new SimpleDateFormat(bodFormate);
		Timestamp timeStamp = null;
		try {
			timeStamp = new Timestamp(formatter.parse(date).getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			timeStamp = null;
		}
		return timeStamp;
	}
	
	public static String converBodtoString(Timestamp date){
		SimpleDateFormat formatter = new SimpleDateFormat(bodFormate);
		Date temp = new Date();
		temp.setTime(date.getTime());
		return formatter.format(temp);
	}
}
