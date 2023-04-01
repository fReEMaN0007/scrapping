package com.angelowkey.lotto.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.angelowkey.lotto.dao.RandomNumberDao;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class TableBuilder {
	
	WebScraper ws = new WebScraper();
	RandomNumberDao rnd = new RandomNumberDao();
	
	public String[] createTable(String fromMonth, String fromDay, String fromYear, String toMonth, String toDay, String toYear) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		
		HashMap<String, Object> results = new HashMap<String, Object>();
		ArrayList<ArrayList<String>> tb = new ArrayList<ArrayList<String>>(); 	
		
		System.out.println(fromMonth + fromDay + fromYear + toMonth + toDay + toYear);
		
		results = ws.scrape( fromMonth, fromDay, fromYear, toMonth, toDay, toYear);
		
		tb =  (ArrayList<ArrayList<String>>) results.get("tableData");
		
		int tableRowCount = Integer.valueOf(results.get("Size").toString());
		System.out.println(tableRowCount);
		System.out.println(tb.size());

		String tableData = "<tr>";
		for(int i=1;i<=tableRowCount-1;i++) {
			tableData+= "<tr>";
			for(int x=0;x<=4;x++) {
				tableData+="<td>"+tb.get(i).get(x)+"</td>";	
			}
				tableData+="</tr>";
		}
		

		String table = "<table class=\"table table-bordered border-primary\">"+
		  "<tr style=\"color:DodgerBlue\">"+
		    "<th>Draw Type</th>"+
		    "<th>Combination</th>"+
		    "<th>Draw Date</th>"+
		    "<th>Jackpot</th>"+
		    "<th>Winners</th>"+
		 "</tr>"+tableData+"</table>";
		
		String[] stringResult = new String[5];
		stringResult[0] = table;
		stringResult[1] = String.valueOf(tableRowCount-1);
		
		return stringResult;
	}
	
	public String combiTable() throws ClassNotFoundException {
		ArrayList<String[]> tableData = new ArrayList<String[]>();
		
		String td="";
		tableData = rnd.getDataFromDb("");
	
		int size = tableData.size()-1;	
		
		 	
		    while (size>0) {
		    
		    	td+="<tr>"+
		    		"<td>"+tableData.get(size)[1]+"</td>"+	
		    		"<td>"+tableData.get(size)[2]+"</td>"+	
		    		"</tr>";
		         size--;
		      }
	   
		
		
		return td;
	}
	

}
