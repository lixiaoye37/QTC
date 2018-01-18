<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
		
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>CrossCheck</title>
</head>
<body>

	<div class="container" id="heading">
		<h1>QTC</h1>

		<div id="list">
			<ul class="nav nav-pills nav-fill">
			
				<li class="nav-item"><a class="nav-link" href="Home.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Cross Check</a></li>
				<li class="nav-item"><a class="nav-link" href="Requirecheck2.jsp">Requirement Check</a></li>
				
			</ul>
		</div>
	</div>
	

	

	<div class="container">	
	
		<div class="row">
			<div class="col-sm-4">
				<h3>Filters</h3>
				<hr>
				<form action="#" method="get">
					<label>State:</label>
					<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
						
					<br/><br/>
						
					<label>ZipCode:</label>
					<input type="text" placeholder="Enter a search query" name="searchQuery"/>
				
					<br/><br/>
					
					<span class="form-inline">
					
					<label>Start Date:</label>
					<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
							
					<br/><br/>
						
					<label>End Date:</label>
					<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
					
					<br/><br/>
					</span>
					<h4>List to check:</h4>
					<input type="radio" name="data" value="Erra_Ref"> ERRA not in Referral
					<br/>
					<input type="radio" name="data" value="Ref_ERRA"> Referral not in ERRA 
					<br/>			
					<input type="radio" name="data" value="Both"> Both Matching
					
					
					
					<br/>
					<input class="btn btn-primary" type="submit" name="newTodo" value="Submit">
					
				</form>
			</div>
			<!--Note 2: This is where we should display area -->
			<div class="col-sm-4">
				
				
			</div>
			<!--End of Note 2  -->
		</div>
	</div>


</body>
</html>