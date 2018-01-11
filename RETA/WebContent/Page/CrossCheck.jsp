<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Todo List</title>
</head>
<body>

<p style="text-align: right;">
	<a href="LogoutController">Logout</a>
</p>

<h3>Filters</h3>


<form action="MainController" method="get">
	<th>State</th><br></br>
	<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
	<br></br>
	<th>ZipCode</th><br></br>
	<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
</form>
<form action="MainController" method="get">
	<th>Start Date</th><br></br>
	<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
	<br></br>
	<th>End Date</th><br></br>
	<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
	<br></br>
</form>

<form action="">
<th>List to check</th><br></br>
  <input type="radio" name="gender" value="male"> ERRA not in Referral<br>
  <input type="radio" name="gender" value="female"> Referral not in ERRA<br>
  <input type="radio" name="gender" value="other"> Both Matching
</form>
<form action="AddController" method="get">
	
	<input type="submit" name="newTodo" value="Submit">
</form>

<ul>
	<c:forEach items="${listOfTodos}" var="todo">
	
		<li>
			<c:choose>
				<c:when test="${todo.done}">
					<a href="ToggleStatusController?id=${todo.id}">Mark as Not Done</a>
					<s>${todo.description}</s>
				</c:when>
				<c:otherwise>
					<a href="ToggleStatusController?id=${todo.id}">Mark as Done</a>
					${todo.description} 
				</c:otherwise>
			</c:choose>
		</li>
		
	</c:forEach>
</ul>



</body>
</html>