package com.angelowkey.lotto.model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;


public class WebScraper {
	
	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException{
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] Months = dfs.getMonths();
		System.out.println(Arrays.toString(Months));
 
	}	
	
	
	public HashMap scrape(String fromMonth, String fromDay, String fromYear, String toMonth, String toDay, String toYear) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		HashMap<String, Object> results = new HashMap<String, Object>();
		System.out.println("webscraper");
		System.out.println(fromMonth + fromDay + fromYear + toMonth + toDay + toYear);
		   WebClient client = new WebClient();
			  client.getOptions().setJavaScriptEnabled(false);
			  client.getOptions().setCssEnabled(false); 
			  HtmlPage searchPage =  client.getPage("https://www.pcso.gov.ph/SearchLottoResult.aspx");
			//  System.out.println(searchPage.asXml());
			  //setting dropdown option FROM (SIMULATION)
			  HtmlSelect fromSelectMonth = searchPage.getHtmlElementById("cphContainer_cpContent_ddlStartMonth");
			  fromSelectMonth.setSelectedAttribute(fromMonth, true);
			  HtmlSelect fromSelectDay = searchPage.getHtmlElementById("cphContainer_cpContent_ddlStartDate");
			  fromSelectDay.setSelectedAttribute(fromDay, true);
			  HtmlSelect fromSelectYear = searchPage.getHtmlElementById("cphContainer_cpContent_ddlStartYear");
			  fromSelectYear.setSelectedAttribute(fromYear, true);
			  //setting dropdown option TO (SIMULATION)
			  HtmlSelect toSelectMonth = searchPage.getHtmlElementById("cphContainer_cpContent_ddlEndMonth");
			  toSelectMonth.setSelectedAttribute(toMonth, true);
			  HtmlSelect toSelectDay = searchPage.getHtmlElementById("cphContainer_cpContent_ddlEndDay");
			  toSelectDay.setSelectedAttribute(toDay, true);
			  HtmlSelect toSelectYear = searchPage.getHtmlElementById("cphContainer_cpContent_ddlEndYear");
			  toSelectYear.setSelectedAttribute(toYear, true);
			  
//			  System.out.println(fromMonth);
//			  System.out.println(fromDay);
//			  System.out.println(fromYear);
//			  System.out.println(toMonth);
//			  System.out.println(toDay);
//			  System.out.println(toYear);

			  
			  HtmlSubmitInput  searchButton = searchPage.getHtmlElementById("cphContainer_cpContent_btnSearch");
			  //get the result page   BUTTON SIMULATION
			  HtmlPage pota = searchButton.click();
			// HtmlPage ss = searchButton.click();
			// System.out.println(ss.getUrl());
			// System.out.println(ss.asXml());
			// System.out.println( ss.getElementById("header-col2-title2").getTextContent()+"POTAKA");
			
			//  HtmlPage currentPage = (HtmlPage) client.getCurrentWindow().getEnclosedPage();
			
		//	  String res = resultSearch.getHtmlElementById("header-col2-title2").getTextContent();
		//    final HtmlTable table =  ss.getHtmlElementById("cphContainer_cpContent_GridView1");
		
			  final HtmlTable table =   (HtmlTable) pota.getByXPath("//table").get(0);
			  int size = table.getBodies().get(0).getRows().size();
			  System.out.println(size);
			  
			  
			  ArrayList<ArrayList<String>> tableData = new ArrayList<ArrayList<String>>(); 		  
			 // String cell = table.getBodies().get(0).getRows().get(1).getCell(1).getTextContent(); 
				  int x=0;
				  //for each row
				  for (final HtmlTableRow row : table.getRows()) {
					  tableData.add(new ArrayList<String>());	
					  	//for each cell
					    for (final HtmlTableCell cell : row.getCells()) {
					    //adding data	  
					  	  tableData.get(x).add(cell.asNormalizedText());
					    }
					    x++;
					  	 // System.out.println(x);
					}	  
	//System.out.println(table.getRow(1).getCell(1).asNormalizedText());		  
	//results.put("Title", res);
	results.put("Size", String.valueOf(size));
	results.put("tableData", tableData);
	//results.put("Cell", cell);
	
	  
	  return results;
	}
}
