
<%@page import="java.util.Calendar"%>
<%@ page import = "javax.servlet.RequestDispatcher" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%--CSS --%>
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">--%>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%-- <form action = "/LottoScrappingAndRandomizer/RandomNumberServelet" method = "POST">--%>


<div style="width:1000px; margin:auto; background: GhostWhite; padding-top:20px">
	<div style="width:900px; margin: auto"class="d-flex flex-row-reverse bd-highlight">
			<form action = "RandomNumberServelet " class="p-2 bd-highlight">
				<input type="hidden" name="thisIsA" value=search>
			
				From: <select name="fromMonth">
						${fromMonth}
					</select>
					
					<select name="fromDay">
						${fromDay}
					</select>
					
					<select name="fromYear">
						${fromYear}
					</select>	
					&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
				To: <select name="toMonth">
						${toMonth}
					</select>
					
					<select name="toDay">
						${toDay}
					</select>
					
					<select name="toYear">
						${toYear}
					</select>	
				<br><br>
				<div class="d-grid gap-2 d-md-flex justify-content-md-end">
				<input type="submit" value="Search" class="btn btn-primary me-md-2">
				</div>
		</form>
	</div>
	
	<table style="margin:auto; width:900px;padding:10px; border-spacing:30px">
		<tr>
			<td style="margin:auto; width:650px; background:DodgerBlue;margin-left:10px;text-align:center;color:white">
				<h5 style="margin:auto;  text-align: center;width:650px;color:white">Previous Lotto Results</h5>
				(Note: Results for today, will be published tomorrow)
			</td>
			<td style="margin:auto; width:250px; background:GhostWhite">
				<div style="border:solid;width:230px;margin:auto; height:47px; border-width:.5px; border-color:DodgerBlue">
					<h4 style="text-align:center; margin: auto;margin-top:10px;color:DodgerBlue">Statistics</h4>
				</div>
				
			</td>
		</tr>
		
		<tr>
			<td>
				<div  style="width:650px; height:400px; margin:auto;overflow-y: scroll;overflow-y:auto; background: whtie; border: solid; border-width:1px; border-color:DodgerBlue">
				${Table}
				</div>
			</td>
			<td>
				<div style="margin:auto;height:400px; width:230px; border:solid; border-width: 1px; border-color:DodgerBlue; text-align:center">
					<b>Top 6 Number Drawn(6/42)</b>
					<br>
					1-23-11-22-45-36
						<table style="width:100%">
							<tr style="color:DodgerBlue">	
								<th>No.</th>
								<th>Times</th>
								<th>Last Appeared</th>
							
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
						</table>	
							<b>Top 2 Number Drawn(EZ2)</b>
							<br>
							1-9
						<table style="width:100%">
							<tr style="color:DodgerBlue">	
								<th>No.</th>
								<th>Times</th>
								<th>Last Appeared</th>
							
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
							<tr>
								<td>1</td>
								<td>23</td>
								<td>17Feb2009</td>
							</tr>
						</table>
					<a href="">show more..	</a>		
				</div>
			</td>	
		</tr>
			
		<tr>
			<td>
				<h7 style="margin: auto; float: right;font-style:italic">${TableSize} Search Result</h7>
			</td>
			<td>
			</td>
		</tr>
		
		<tr>
			<td>
				<div style="width:650px; margin: auto">
					<h5 style="text-align: Center;color:DodgerBlue">Randomizer</h5>
					<div style="border-style: solid; border-width: 1px; border-color:DodgerBlue; padding:5px;height: 315px">

						Draw for today:
						<br>
						&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
						${drawForTheDay}
						<br>
						<br>
						Please Select:
						<form action = "RandomNumberServelet">
							&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;
							<input type="hidden" name="thisIsA" value="random">
						
							<input type="radio" id="6/42" value="6/42" name="choice">
							<label for="6/42">6/42</label>
							&nbsp;
							<input type="radio" id="6/45" value="6/45" name="choice">
							<label for="6/45">6/45</label>
							&nbsp;
							<input type="radio" id="6/49" value="6/49" name="choice">
							<label for="6/49">6/49</label>
							&nbsp;
							<input type="radio" id="6/55" value="6/55" name="choice">
							<label for="6/55">6/55</label>
							&nbsp;
							<input type="radio" id="6/58" value="6/58" name="choice">
							<label for="6/58">6/58</label>
							&nbsp;
							<input type="radio" id="ez2" value="ez2" name="choice">
							<label for="ez2">EZ2</label>
							&nbsp;
							<input type="radio" id="swer3" value="swer3" name="choice">
							<label for="swer3">Swertres</label>
							&nbsp;
							<br>
							&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;	
							<input type="radio" id="4d" value="4d" name="choice">
							<label for="4d">4 Digit</label>
							&nbsp;
							<input type="radio" id="6d" value="6d" name="choice">
							<label for="6d">6 Digit</label>
							&nbsp;
							
							<div class="border border-success p-2 mb-2 border-opacity-25" style="Height: 100px; font-size:65px; text-align: center;
							color: DodgerBlue">	
							${combination}
							</div>
							
							<div class="d-grid gap-2"> 
								<input type="submit" class="btn btn-primary" value="Feeling Very Luck">	
							</div>	
						</form>
						
					</div>
				</div>
			</td>
			<td>
				<div style="margin:auto;height:350px; width:230px; border:solid; border-width: 1px; border-color:DodgerBlue; text-align:center;">
					<b>Generated Combination</b>
					<font size=2px>
					<table width="95%" style="text-align:left;margin:auto">
							<tr style="position:sticky">
								<th>
									<div style="color:DodgerBlue">Combi &nbsp;</div>
								</th>
								<th>
									<div style="color:DodgerBlue">D.Gen</div>
								</th>
							</tr>	
					</table>
					
					<div style="overflow-y:auto; height:300px">
						<table width="95%" style="text-align:left;margin:auto">
								
								${combinationTable}
						</table>
					</div>
					</font>
				
				</div>
			</td>	
		</tr>
		
	</table>
	


	

	
</div>






</body>
</html>
