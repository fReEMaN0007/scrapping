package com.angelowkey.lotto.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DrawForTheDay {
	
	
	public String setDraw(){
		
		Date date = new Date();
		SimpleDateFormat completeDate = new SimpleDateFormat("EEEE, d MMM yyyy");
		SimpleDateFormat dayOnly = new SimpleDateFormat("EEEE");
		
		
	
	String dateToday = completeDate.format(date);
	String day = dayOnly.format(date);
	
	switch(day) {
	  case "Monday":
		  dateToday+="	&nbsp; &nbsp;[ 6/55, 6/45, 4Digit, Swertres, EZ2 ]";
	    break;
	  case "Tuesday":
		  dateToday+="	&nbsp; &nbsp;[ 6/49, 6/42, 6Digit, Swertres, EZ2 ]";
	    break;
	  case "Wednesday":
		  dateToday+="	&nbsp; &nbsp;[ 6/55, 6/45, 4Digit, Swertres, EZ2 ]";
		break;
	  case "Thursday":
		  dateToday+="	&nbsp; &nbsp;[ 6/49, 6/42, 6Digit, Swertres, EZ2 ]";
		break; 
	  case "Friday":
		  dateToday+="	&nbsp; &nbsp;[ 6/58, 6/45, 4Digit, Swertres, EZ2 ]";
		break;
	  case "Saturday":
		  dateToday+="	&nbsp; &nbsp;[ 6/55 , 6/42, 6Digit, Swertres, EZ2 ]";
		break; 
	  case "Sunday":
		  dateToday+="	&nbsp; &nbsp;[ 6/58, 6/49, Swertres, EZ2 ]";
		break;
	
	  default:
	    // code block
	}
	return dateToday;
	}
	

}
