
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


<div style="width:900px; margin:auto; background: GhostWhite; padding-top:20px">
	<div style="width:800px; margin: auto"class="d-flex flex-row-reverse bd-highlight">
			<form action = "searchServelet" class="p-2 bd-highlight">
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
	
	

	<h5 style="margin:auto;  text-align: center; background:lightgrey;width:800px">Previous Lotto Results</h5>
	<h6 style="margin:auto;  text-align: center; background:lightgrey;width:800px">(March 12 - March 15)</h6>
	<div  style="width:800px; height:500px; margin:auto;overflow-y: scroll; background: whtie">
	${Table}
	</div>

	<div style="width:800px; margin: auto">
	<h6 style="margin: auto; float: right">${TableSize} Search Result</h6>
	<br>
	Randomizer	
	</div>
</div>






</body>
</html>
