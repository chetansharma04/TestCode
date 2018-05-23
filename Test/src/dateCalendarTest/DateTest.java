package dateCalendarTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

	public static void main(String[] args) {
		Calendar monthStart = new GregorianCalendar();
//		System.out.println("monthStart = "+monthStart.getTime());
//		System.out.println("Month = "+ monthStart.getActualMaximum(Calendar.DAY_OF_MONTH));
//		System.out.println("Year = "+ monthStart.getActualMaximum(Calendar.DAY_OF_YEAR));

		
//		currentDate();
//		appendDate();
		
//		isBetweenDate
		Calendar calendar1 = Calendar.getInstance();
		Calendar calendar2 = Calendar.getInstance();
		Calendar calendar3 = Calendar.getInstance();
		
		calendar1.add(Calendar.DATE, -20);
		calendar2.add(Calendar.DATE, 20);
		
		System.out.println("date1 = "+calendar1.getTime());
		System.out.println("date2 = "+calendar2.getTime());
		System.out.println("date3 = "+calendar3.getTime());
		
		
		System.out.println("isBetweenDate = "+isBetweenDate(calendar1.getTime(), calendar2.getTime(), calendar3.getTime()));
//		isBetweenDate
		
		
	}
	
	public static void currentDate(){
		Date Date = new Date();
		System.out.println("new Date() = "+Date);
		
		String dateS = "";
//		dateS = com.sdgc.truops.onboarding.util.grcImport.DateUtil.formatDate(new Date(), "yyyy-MM-dd");
		System.out.println("dateS = "+dateS);
	}

	
	
	public static void appendDate(){
		
		Calendar calendar = Calendar.getInstance();
		
		System.out.println("date = "+calendar.getTime());
		
		calendar.add(Calendar.DATE, 2);
		
//		String dateS = "";
//		dateS = com.sdgc.truops.onboarding.util.grcImport.DateUtil.formatDate(calendar.getTime(), "yyyy-MM-dd");
		System.out.println("date = "+calendar.getTime());
	}
	
	
	
	public static boolean isBetweenDate(Date fromDate, Date toDate, Date compareDate){

		return compareDate.after(fromDate) && compareDate.before(toDate);
	}
	
	
	
	
	
			
}
