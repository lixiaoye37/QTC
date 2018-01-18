<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirement Check</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>

	<div class="container" id="heading">
		<h1>QTC</h1>

		<div id="list">
			<ul class="nav nav-pills nav-fill">

				<li class="nav-item"><a class="nav-link" href="Home.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="CrossCheck.jsp">Cross
						Check</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Requirement
						Check</a></li>

			</ul>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-4">
				<h5><a href="CheckoutSpecialtyList">Specialty List</a></h5>
				<h3>Filters</h3>
				<hr>
				<form action="#" method="get">
					<h4>Zip-Code:</h4>
					<input type="text" name="searchQuery" placeholder="Enter a search query" value="${param.searchQuery}">
					
					<br/>
					<br/>
					 
					<label for="inputState">State:</label> 
					<select id="inputState">
						<option selected>Choose...</option>
						<option>...</option>
					</select> <br /> <br />
		
					<h4>Requirement Check:</h4>
					<input type="checkbox" name="data" value="met"> Meets Requirement <br /> 
					<input type="checkbox" name="data" value="met">Doesn't meet Requirement <br /> <br />
					<input class="btn btn-primary" type="submit" name="newTodo" value="Submit">
		
				</form>
			</div>
		</div>

	</div>

	<!--  x = table for not avail *********************** -->
	<c:if test="${not empty x}">

		<table>
			<thead>
				<tr>
					<th>Specialty</th>
					<th>No. of Referrals</th>
					<th>Nearest Provider(s) ID</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.spec}</td>
						<td>${item.Ref}</td>
						<td><c:forEach items="${items.providers}" var="prov">
								<br /> ${prov} (${prov.distance})
				</c:forEach></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>


	</c:if>

	<!--  y = table for avail ************************* -->
	<c:if test="${not empty y}">

		<table>
			<thead>
				<tr>
					<th>Specialty</th>
					<th>In Range Provider(s) ID</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${items}" var="item">
					<tr>
						<td>${item.spec}</td>
						<td><c:forEach items="${items.providers}" var="prov">
								<br> ${prov} (${prov.distance})
							</c:forEach> <br></td>

					</tr>
				</c:forEach>
			</tbody>

		</table>

	</c:if>

</body>

</html>