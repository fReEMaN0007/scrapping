package com.angelowkey.lotto.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.angelowkey.lotto.dao.RandomNumberDao;
import com.angelowkey.lotto.model.RandomNumber;
import com.angelowkey.lotto.model.SelectionDateSetter;
import com.angelowkey.lotto.model.TableBuilder;
import com.angelowkey.lotto.model.WebScraper;

/**
 * Servlet implementation class RandomNumberServelet
 */
@WebServlet("/searchServelet")
public class searchServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private RandomNumberDao randomNumberDao = new RandomNumberDao();
	private SelectionDateSetter sds = new SelectionDateSetter(); 
	private TableBuilder tb = new TableBuilder(); 
	
	
	
    public searchServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setAttribute("fromMonth", sds.setNewFromMonth(request.getParameter("fromMonth")));
		request.setAttribute("fromDay", sds.setNewFromDay(request.getParameter("fromDay")));
		request.setAttribute("fromYear", sds.setNewFromYear(request.getParameter("fromYear")));
		
		request.setAttribute("toMonth", sds.setNewToMonth(request.getParameter("toMonth")));
		request.setAttribute("toDay", sds.setNewToDay(request.getParameter("toDay")));
		request.setAttribute("toYear", sds.setNewToYear(request.getParameter("toYear")));
		
		System.out.println(request.getParameter("fromMonth")+"ditoooooooooooooo");

		
		String[] tbResults = new String[5];
		tbResults=tb.createTable(request.getParameter("fromMonth"),request.getParameter("fromDay"),request.getParameter("fromYear"),request.getParameter("toMonth"),request.getParameter("toDay"),request.getParameter("toYear"));
		request.setAttribute("Table", tbResults[0]);
		request.setAttribute("TableSize", tbResults[1]);
		//request.setAttribute("Size", sds.());
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
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

}
