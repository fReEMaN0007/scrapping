package com.angelowkey.lotto.model;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SelectionDateSetter {

	Date date = new Date();
	SimpleDateFormat DateForYear = new SimpleDateFormat("yyyy");
	SimpleDateFormat DateForDay = new SimpleDateFormat("dd");
	//get list of months
	DateFormatSymbols dfs = new DateFormatSymbols();
	String[] months = dfs.getMonths();
	
	public String setMonth() {	
	
		String[] selected = new String[12];
		//compare current month and make it selected
		for(int i=0;i<=11;i++) {
			if (Calendar.MONTH == i) {
				selected[i]="selected";
				break;
			}
		}
	
		//writing the html code using
		String fromMOnth ="";
			for(int i=0;i<=11;i++) {
				fromMOnth+="<option "+selected[i]+">"+months[i]+"</option>";	
			}
		return fromMOnth;
	}
	
	public String setNewFromMonth(String newFromMonthSource) {
		String selected="";
		String newFromMonth="";
		
		for(int i=0;i<=11;i++) {
			if (months[i].equals(newFromMonthSource.toString())) {
				System.out.println("putaputa");
				selected="selected";
			}
			else {
				selected="";
			}
			newFromMonth+="<option "+selected+">"+months[i]+"</option>";	
		}
		return newFromMonth;
	}
	
	
	public String getMonth() {
		System.out.println(months[Calendar.MONTH]+"<<<<<<<<<<<<<<<<<<<<--");
		
		return months[Calendar.MONTH];
	}
	
	public String setFromDay() {
		//formattin to return the date!
		//NOTE!!!!
		// simpledateformat only works for date class, dont work to others like calendar or localdate!
		

		String stringDate= DateForDay.format(date);
	
		String[] selected = new String[32];
		for(int i=1;i<=31;i++) {
			if(Integer.valueOf(stringDate) == i) {
				selected[i-1] = "selected";
				break;
			}
		}
		///////
		String fromDay = "";		
		for(int i=1;i<=31;i++){
			fromDay+="<option "+selected[i]+">"+i+"</option>";
		}
		return fromDay;
	}
	
	
	public String setNewFromDay(String newFromDaySource) {
		//formattin to return the date!
		//NOTE!!!!
		// simpledateformat only works for date class, dont work to others like calendar or localdate!
		

		String stringDate= DateForDay.format(date);
	
		String[] selected = new String[32];
		for(int i=1;i<=31;i++) {
			if(Integer.valueOf(newFromDaySource) == i) {
				selected[i] = "selected";
				break;
			}
		}
		///////
		String newFromDay = "";		
		for(int i=1;i<=31;i++){
			newFromDay+="<option "+selected[i]+">"+i+"</option>";
		}
		return newFromDay;
	}
	
	public String getFromDay() {
		return String.valueOf(Integer.valueOf(DateForDay.format(date))-1);
	}
	
	public String setYear() {

		String stringYear= DateForYear.format(date);
		String fromYear = "";	
		
		String[] selected = new String[100];
		
		for(int i=2013;i<=2023;i++) {
			if(Integer.valueOf(stringYear) == i) {
				selected[i-2013] = "selected";
				break;
			}
		}
		////
		for(int i=2013;i<=2023;i++){
			fromYear+="<option "+selected[i-2013]+">"+i+"</option>";
		}
		return fromYear;
	}
	
	public String setNewFromYear(String newYear) {

		String stringYear= DateForYear.format(date);
		String fromYear = "";	
		
		String[] selected = new String[100];
		
		for(int i=2013;i<=2023;i++) {
			if(Integer.valueOf(newYear) == i) {
				selected[i-2013] = "selected";
				break;
			}
		}
		////
		for(int i=2013;i<=2023;i++){
			fromYear+="<option "+selected[i-2013]+">"+i+"</option>";
		}
		return fromYear;
	}
	
	public String getYear() {
		
		return String.valueOf(DateForYear.format(date));
	}
	
	
	public String setToDay() {
		//formattin to return the date!
		//NOTE!!!!
		// simpledateformat only works for date class, dont work to others like calendar or localdate!
		
		SimpleDateFormat DateFor = new SimpleDateFormat("dd");
		String stringDate= DateFor.format(date);
	
		String[] selected = new String[32];
		for(int i=1;i<=31;i++) {
			if(Integer.valueOf(stringDate) == i) {
				selected[i] = "selected";
				break;
			}
		}
		///////
		String fromDay = "";		
		for(int i=1;i<=31;i++){
			fromDay+="<option "+selected[i]+">"+i+"</option>";
		}
		return fromDay;
	}
	
	public String setNewToDay(String newtoDay) {
		//formattin to return the date!
		//NOTE!!!!
		// simpledateformat only works for date class, dont work to others like calendar or localdate!
		
		SimpleDateFormat DateFor = new SimpleDateFormat("dd");
		String stringDate= DateFor.format(date);
	
		String[] selected = new String[32];
		for(int i=1;i<=31;i++) {
			if(Integer.valueOf(newtoDay) == i) {
				selected[i] = "selected";
				break;
			}
		}
		///////
		String fromDay = "";		
		for(int i=1;i<=31;i++){
			fromDay+="<option "+selected[i]+">"+i+"</option>";
		}
		return fromDay;
	}
	
	
	
	
	public String getToDay() {
			return String.valueOf(DateForDay.format(date));
	}
	
	public String setNewToMonth(String newToMonthSource) {
		String selected="";
		String newFromMonth="";
		
		for(int i=0;i<=11;i++) {
			if (months[i].equals(newToMonthSource.toString())) {
				System.out.println("putaputa");
				selected="selected";
			}
			else {
				selected="";
			}
			newFromMonth+="<option "+selected+">"+months[i]+"</option>";	
		}
		return newFromMonth;
	}
	
	public String setNewToYear(String newToYear) {

		String stringYear= DateForYear.format(date);
		String fromYear = "";	
		
		String[] selected = new String[100];
		
		for(int i=2013;i<=2023;i++) {
			if(Integer.valueOf(newToYear) == i) {
				selected[i-2013] = "selected";
				break;
			}
		}
		////
		for(int i=2013;i<=2023;i++){
			fromYear+="<option "+selected[i-2013]+">"+i+"</option>";
		}
		return fromYear;
	}
	
	
}