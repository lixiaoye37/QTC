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
		crossorigin="anonymous" />
	
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>Cross Check</title>
	
	<link rel="stylesheet" href="../js/Kalendae/build/kalendae.css"
		type="text/css" charset="utf-8">
		
	<script src="../js/Kalendae/build/kalendae.standalone.js"
		type="text/javascript" charset="utf-8"></script>
		
	<script src="../js/custom/src/CrossCheck.js" type="text/javascript"
		charset="utf-8"></script>

</head>

<body>
	<p style="text-align: right;">
		<a href="LogoutController">Logout</a>
	</p>

	<div class="container" id="heading">
		<h1>QTC</h1>

		<div id="list">
			<ul class="nav nav-pills nav-fill">
			
				<li class="nav-item"><a class="nav-link" href="Home.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Cross Check</a></li>
				<li class="nav-item"><a class="nav-link" href="RequirementsCheck.jsp">Requirement Check</a></li>
				
			</ul>
		</div>
	</div>
	
	<div class="container">	
	
		<div class="row">
			<div class="col-sm-4">
				<h3>Filters</h3>
				<hr>
				<form action="CrossCheck" method="post" onsubmit="return validation()">
					<label id="stateView">State:</label>
					<select id="StateList">
						<option value="Select">Select</option>
						<c:forEach items="${StateList}" var="State" varStatus="i">
							<option value="${State}">${State}</option>	
						</c:forEach>
					</select>
						
					<br/><br/>
						
					<label id="zipcodeView">ZipCode:</label>
					<input type="text" id="zipcodeQuery" placeholder="Enter a zipcode"> 
				
					<br/><br/>
					
					<span class="form-inline">
					
					<table style="width: 100%">
						<tr>
							<th align=left id="StartDateView">Start Date (mm/dd/yyyy)</th>
							<th align=left id="EndDateView">End Date (mm/dd/yyyy)</th>
						</tr>
	
						<tr>
							<td>
								<input type="text" class="auto-kal" id="StartDateQuery" placeholder="Enter a search query">
							</td>
							
							<td>
								<input type="text" class="auto-kal" id="EndDateQuery" placeholder="Enter a search query">
							</td>
						</tr>
					</table>
					
					<br/><br/>
					
					</span>
					<h4 id="CrossCheckOptionView">List to check:</h4>
					
					<input type="radio" name="CrossCheck" id="Option_0" value=0> ERRA not in Referral
					<br /> 
					<input type="radio" name="CrossCheck" id="Option_1" value=1> Referral not in ERRA
					<br /> 
					<input type="radio" name="CrossCheck" id="Option_2" value=2> Both Matching
					<br /> 
					<br />
					
					
					
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