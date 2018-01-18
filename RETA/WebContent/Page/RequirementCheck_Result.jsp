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