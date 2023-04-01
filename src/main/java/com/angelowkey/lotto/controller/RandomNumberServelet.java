package com.angelowkey.lotto.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angelowkey.lotto.dao.RandomNumberDao;
import com.angelowkey.lotto.model.DrawForTheDay;
import com.angelowkey.lotto.model.PopulateDataBase;
import com.angelowkey.lotto.model.RandomNumber;
import com.angelowkey.lotto.model.Randomizer;
import com.angelowkey.lotto.model.SelectionDateSetter;
import com.angelowkey.lotto.model.TableBuilder;
import com.angelowkey.lotto.model.WebScraper;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

/**
 * Servlet implementation class RandomNumberServelet
 */
@WebServlet("/RandomNumberServelet")
public class RandomNumberServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private RandomNumberDao randomNumberDao = new RandomNumberDao();
	
	private SelectionDateSetter sds = new SelectionDateSetter(); 
	private TableBuilder tb = new TableBuilder(); 
	private DrawForTheDay dftd = new DrawForTheDay();
	private Randomizer rn = new Randomizer();
	private PopulateDataBase pdb = new PopulateDataBase();
	
	
	
    public RandomNumberServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//request.setAttribute("Size", sds.());
		String identifier = request.getParameter("thisIsA");
		System.out.println(identifier + "potakaaaaaaaaaa");
		request.setAttribute("drawForTheDay", dftd.setDraw());
		
		try {
				if(identifier.equals("search")) {
					System.out.println("EATBULAGA");	
					response.getWriter().append("Served at: ").append(request.getContextPath());
					request.setAttribute("fromMonth", sds.setNewFromMonth(request.getParameter("fromMonth")));
					request.setAttribute("fromDay", sds.setNewFromDay(request.getParameter("fromDay")));
					request.setAttribute("fromYear", sds.setNewFromYear(request.getParameter("fromYear")));
					
					request.setAttribute("toMonth", sds.setNewToMonth(request.getParameter("toMonth")));
					request.setAttribute("toDay", sds.setNewToDay(request.getParameter("toDay")));
					request.setAttribute("toYear", sds.setNewToYear(request.getParameter("toYear")));
					
					String[] tbResults = new String[5];
					try {
						tbResults=tb.createTable(request.getParameter("fromMonth"),request.getParameter("fromDay"),request.getParameter("fromYear"),request.getParameter("toMonth"),request.getParameter("toDay"),request.getParameter("toYear"));
						request.setAttribute("Table", tbResults[0]);
						request.setAttribute("TableSize", tbResults[1]);
						
					}
				
					catch(Exception e){
						request.setAttribute("Table", "No Data Found!");
						request.setAttribute("TableSize", "Zero");
					}
					request.setAttribute("combinationTable", tb.combiTable());
				}
				else if (identifier.equals("random")) {
					System.out.println("random");	
					try {
						String ran=rn.randomize(request.getParameter("choice"));
						request.setAttribute("combination", ran);
						RandomNumber randomNumber = new RandomNumber();
						randomNumber.setNumber(ran);
						randomNumber.setDrawType(request.getParameter("choice"));
						randomNumber.setDate(LocalDate.now().toString());
						

						try {
							randomNumberDao.insertRandomNumber(randomNumber);
						} catch (ClassNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					catch(Exception e) {
						request.setAttribute("combination", "");
					}
					finally {
						defaultData(request,response);
					}
					request.setAttribute("combinationTable", tb.combiTable());
				
					
				}

			}
		catch(Exception e) {
				try {
					defaultData(request,response);
				} catch (FailingHttpStatusCodeException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					request.setAttribute("combinationTable", tb.combiTable());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/randomNumber.jsp");
		dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String number = request.getParameter("number");
		String drawType = request.getParameter("drawType");
		String date = request.getParameter("date");
		String matchFound = request.getParameter("matchFound");
		
		RandomNumber randomNumber = new RandomNumber();
//		randomNumber.setNumber(number);
//		randomNumber.setDrawType(drawType);
//		randomNumber.setDate(date);
//		randomNumber.setMatchFound(matchFound);

//		WebScraper ws  = new WebScraper();
//		HashMap <String, Object> results =  new HashMap <String, Object>();
//		results = ws.scrape();
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		request.setAttribute("Title", results.get("Title"));
//		request.setAttribute("Size", results.get("Size"));
//		request.setAttribute("tableData", results.get("tableData"));
//		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
//		dispatcher.forward(request,response);
		
		
		try {
			randomNumberDao.insertRandomNumber(randomNumber);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//
		
	}

	
	private void defaultData(HttpServletRequest request, HttpServletResponse response) throws IOException, FailingHttpStatusCodeException, ParseException, ClassNotFoundException, SQLException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("fromMonth", sds.setMonth());
		request.setAttribute("fromDay", sds.setFromDay());
		request.setAttribute("fromYear", sds.setYear());
		request.setAttribute("toMonth", sds.setMonth());
		request.setAttribute("toYear", sds.setYear());
		request.setAttribute("toDay", sds.setToDay());
		
		String[] tbResults = new String[5];
		System.out.println(sds.getMonth()+"default data");
		tbResults=tb.createTable(sds.getMonth(),sds.getFromDay(),sds.getYear(),sds.getMonth(),sds.getToDay(),sds.getYear());
		request.setAttribute("Table", tbResults[0]);
		request.setAttribute("TableSize", tbResults[1]);
		//pdb.populateDb();
	}
}
