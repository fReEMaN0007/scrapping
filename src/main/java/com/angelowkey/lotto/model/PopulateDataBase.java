package com.angelowkey.lotto.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.angelowkey.lotto.dao.RandomNumberDao;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class PopulateDataBase {
	WebScraper ws1 = new WebScraper();
	SelectionDateSetter sds = new SelectionDateSetter();
	RandomNumberDao rnd = new RandomNumberDao();
	PreviousResults pr = new PreviousResults();
	
	SimpleDateFormat sDFormatParse = new SimpleDateFormat("MM/dd/yyyy");
	SimpleDateFormat sDFormatOut = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sDFormatMonth = new SimpleDateFormat("MM");
	SimpleDateFormat sDFormatDay = new SimpleDateFormat("dd");
	SimpleDateFormat sDFormatYear= new SimpleDateFormat("yyyy");
	DateFormatSymbols dfs = new DateFormatSymbols();
	String[] months = dfs.getMonths();
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	
	HashMap<String, Object> results = new HashMap<String, Object>();
	
	public void populateDb() throws FailingHttpStatusCodeException, MalformedURLException, IOException, ParseException, ClassNotFoundException, SQLException {
		
		
		
		if(!rnd.dbChecker()) {
			System.out.println("DATE DITO DAPAT");
			String dateLast = rnd.lastEntryGetter();
			
		//	System.out.println(dateLast);
			Date fromDate = 	sDFormatOut.parse(dateLast);
			String from = sDFormatOut.format(fromDate).toString();
			
			
		//	System.out.println(from);
			LocalDate ff = LocalDate.parse(from, formatter);
			LocalDate ee = LocalDate.now();
			
			if(ff.isBefore(ee.minusDays(1))) {
				System.out.println("mag update ka");
				System.out.println(sDFormatOut.parse(dateLast));
				String fromMonth = sDFormatMonth.format(fromDate);
				String fromDay = sDFormatDay.format(fromDate);
				String fromYear = sDFormatYear.format(fromDate);
				
				for(int x=0;x<=months.length-1;x++) {
					
					if (Integer.valueOf(fromMonth)==x+1) {
						fromMonth = months[x];
						break;
					}
				}
				
				System.out.println(fromMonth);
					
				results = ws1.scrape(fromMonth, fromDay, fromYear, sds.getMonth(),sds.getToDay(),sds.getYear());
				
				System.out.println(fromMonth);
				System.out.println(fromDay);
				System.out.println(fromYear);

				System.out.println("------------------");
				System.out.println(sds.getMonth());
				System.out.println(sds.getToDay());
				System.out.println(sds.getYear());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			//	
				ArrayList<ArrayList<String>> tb = new ArrayList<ArrayList<String>>(); 	
				tb =  (ArrayList<ArrayList<String>>) results.get("tableData");
				
				int tableRowCount = Integer.valueOf(results.get("Size").toString());
				Date date;
				int trc = tableRowCount-1;
				
				
				for(int i=trc;i>=1;i--) {
					pr.setDraw_type(tb.get(i).get(0));
					pr.setCombination(tb.get(i).get(1));
					System.out.println(tb.get(i).get(0));
					System.out.println(tb.get(i).get(1));
					System.out.println(tb.get(i).get(2));
					date = sDFormatParse.parse(tb.get(i).get(2));
					
					pr.setDraw_date(sDFormatOut.format(date).toString());
					pr.setJackpot(tb.get(i).get(3));
					pr.setWinners(tb.get(i).get(4));
					try {
						rnd.insertPreviousResult(pr);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
					}
					
				}
			}
			else {
				System.out.println("updated");
				System.out.println("wag ka mag update");
			}
			
		
		//	
			
		}
		else {

			results = ws1.scrape("January", "1", "2013", sds.getMonth(),sds.getToDay(),sds.getYear());

			ArrayList<ArrayList<String>> tb = new ArrayList<ArrayList<String>>(); 	
			
			tb =  (ArrayList<ArrayList<String>>) results.get("tableData");
			
			int tableRowCount = Integer.valueOf(results.get("Size").toString());
			Date date;
		
			
			
			for(int i=1;i<=tableRowCount-1;i++) {
				pr.setDraw_type(tb.get(i).get(0));
				pr.setCombination(tb.get(i).get(1));
				System.out.println(tb.get(i).get(0));
				System.out.println(tb.get(i).get(1));
				System.out.println(tb.get(i).get(2));
				date = sDFormatParse.parse(tb.get(i).get(2));
				
				pr.setDraw_date(sDFormatOut.format(date).toString());
				pr.setJackpot(tb.get(i).get(3));
				pr.setWinners(tb.get(i).get(4));
				try {
					rnd.insertPreviousResult(pr);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				
				}
				
			}
			
		}
		
		
		

		
	}
	

}
