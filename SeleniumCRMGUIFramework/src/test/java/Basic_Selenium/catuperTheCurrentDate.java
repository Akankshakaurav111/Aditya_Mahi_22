package Basic_Selenium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class catuperTheCurrentDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  Date dateobj=new Date();
  SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
  String actDate=sim.format(dateobj);
  System.out.println(actDate);
  
  Calendar cal = sim.getCalendar();//CAPTURE THE FULL CALANDAR
  cal.add(Calendar.DAY_OF_MONTH,30);//GIVE THE AFTER AND BEFORE DATE
 String dateRequies = sim.format(cal.getTime());
 System.out.println(dateRequies);
  
  
  
  
	}

}
