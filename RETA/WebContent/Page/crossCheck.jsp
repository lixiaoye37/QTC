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

	<h3>Filters</h3>
	<br />
	<br />


	<form action="CrossCheck" method="post" onsubmit="return validation()">
		
		<div class="wrapper">
			<div style="float: left;">

				<div class="dropdown">
					<b id="zipcodeView">ZipCode:</b> 
					<input type="text" id="zipcodeQuery" placeholder="Enter a zipcode"> 
					
					<b id="stateView">State:</b> 
					<select id="StateList">
						<option value="Select">Select</option>
						<option value="CA">CA</option>
						<option value="VA">VA</option>
						<option value="QA">QA</option>
						<option value="RE">RE</option>
					</select>
				</div>
				
				<br /> 
				<br />

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

				<br /> List to check <br />
				 
				<input type="radio" name="option" value="0"> ERRA not in Referral<br /> 
				<input type="radio" name="option" value="1"> Referral not in ERRA<br /> 
				<input type="radio" name="option" value="2"> Both Matching<br /> <br />
				<input type="submit" value="Search">
			
			</div>

			<div style="float: left;">
				<ul>
					<c:forEach items="${listOfTodos}" var="todo">

						<li><c:choose>
								<c:when test="${todo.done}">
									<a href="ToggleStatusController?id=${todo.id}">Mark as Not
										Done</a>
									<s>${todo.description}</s>
								</c:when>
								<c:otherwise>
									<a href="ToggleStatusController?id=${todo.id}">Mark as Done</a>
										${todo.description} 
									</c:otherwise>
							</c:choose></li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</form>
</body>
</html>