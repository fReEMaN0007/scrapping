package com.angelowkey.lotto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.angelowkey.lotto.model.PreviousResults;
import com.angelowkey.lotto.model.RandomNumber;

public class RandomNumberDao {
	
	
	public int insertRandomNumber(RandomNumber randomNumber) throws ClassNotFoundException {
		
		String insertStatement = "INSERT INTO random_number (number,draw_type,date) VALUES"
				+ "(?,?,?);";
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/lotto?useSSL=false", "root", "root4025637A");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(insertStatement)) {
                //id (auto) preparedStatement.setInt(1, 1);
        	 	//preparedStatement.setString(1, "2");
                preparedStatement.setString(1, randomNumber.getNumber());
                preparedStatement.setString(2, randomNumber.getDrawType());
                preparedStatement.setString(3, randomNumber.getDate());
             //   preparedStatement.setString(5, randomNumber.getMatchFound());
            

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();

            } catch (SQLException e) {
                // process sql exception
                //printSQLException(e);
            }
		return result;
	}
	
	public ArrayList<String[]> getDataFromDb(String id) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String selectStatement = "Select * from random_number;";
		ResultSet rs = null;
		ArrayList<String[]> combiResult = new ArrayList<String[]>();

		
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/lotto?useSSL=false", "root", "root4025637A");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(selectStatement)) {
        
            
        		rs = preparedStatement.executeQuery();
                System.out.println(preparedStatement);
                int x=0;
                while (rs.next()) {
         
                	combiResult.add(new String[3]);
                	combiResult.get(x)[0]=rs.getString("draw_type");
                	combiResult.get(x)[1]=rs.getString("number");
                	combiResult.get(x)[2]=rs.getString("date");
                    x++;
                }
                // Step 3: Execute the query or update query
               

            } catch (SQLException e) {
                // process sql exception
                //printSQLException(e);
            }
		
		
		return combiResult;
	}
	
	public void insertPreviousResult(PreviousResults previousResult) throws ClassNotFoundException {
		String insertStatement = "INSERT INTO lotto_results (draw_type,combination,draw_date,jackpot,winners) VALUES"
				+ "(?,?,?,?,?);";
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/lotto?useSSL=false", "root", "root4025637A");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(insertStatement)) {
                //id (auto) preparedStatement.setInt(1, 1);
        	 	//preparedStatement.setString(1, "2");
                preparedStatement.setString(1, previousResult.getDraw_type());
                preparedStatement.setString(2, previousResult.getCombination());
                preparedStatement.setString(3, previousResult.getDraw_date());
                preparedStatement.setString(4, previousResult.getJackpot());
                preparedStatement.setString(5, previousResult.getWinners());
             //   preparedStatement.setString(5, randomNumber.getMatchFound());
            

                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                result = preparedStatement.executeUpdate();

            } catch (SQLException e) {
                // process sql exception
                //printSQLException(e);
            }
	
		
		
	}
	
	public Boolean dbChecker() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String selectStatement = "SELECT COUNT(id)FROM lotto_results;";
		
		ResultSet rs = null;
		boolean empty = true;
		System.out.println("DBCHECKER");
		  try (Connection connection = DriverManager
	                .getConnection("jdbc:mysql://localhost:3306/lotto?useSSL=false", "root", "root4025637A");

	                // Step 2:Create a statement using connection object
	                PreparedStatement preparedStatement = connection.prepareStatement(selectStatement)) {
	    
	        		rs = preparedStatement.executeQuery();
        		//System.out.println(rs.getString(1)+"ffdsafsdfsa");
        		
        		if(rs.next()) {
        			empty = true;
        		}
            } 
        catch (SQLException e) {   
        	System.out.println("catch");
        	System.out.println(e);
            }
        
        System.out.println(empty);

		return empty;
	}
	
	public String lastEntryGetter() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String selectStatement = "select draw_date from lotto_results ORDER BY id DESC LIMIT 1;";
		
		ResultSet rs = null;
	
		String date= "";

        try (Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/lotto?useSSL=false", "root", "root4025637A");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(selectStatement)) {
    
        		rs = preparedStatement.executeQuery();
        		
        		if(rs.next()) {
        			date = rs.getString("draw_date");
        		}
            } 
        catch (SQLException e) {   
        	
            }

		
		return date;
	}

}
