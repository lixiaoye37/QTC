<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
	
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Editing Specialty List...</title>

</head>

<body>
	<!-- This the header Guys with  -->
	<div class="container">

		<h1>QTC</h1>
	

	</div>
	
	<div class="container">
		<div class="form-group">
			<c:set var="i" scope="session" value="0"/>
			<div class="row">
				<c:forEach items="${specialties}" var="specialty">
				
						<div class="col-xs-6">
							${specialty.name}
							<input class="form-control" type="text" name ="radius" value="${specialty.radius}">
							
						</div>
								
				</c:forEach>
			</div>
		</div>
			
		<div class="form-group" >
			<form action="Main" method="get">
				<div class="row">
					
					<div class="col-xs-6">
						<button name="add"  value="1" class="btn btn-default">add</button>
						<button class="btn btn-default">edit</button>
					</div>
				
				</div>	
			</form>
		</div>	
		
			<%-- <c:if test="${click==1}">
				<form action="Main" method="get">
					<div class="col-xs-6">
						name:<input class="form-control" type="text" name ="name">
						radius:<input class="form-control" type="text" name ="radius">
						<button class="btn btn-default" name="add" value="0">Submit</button>
					</div>
				</form>
			</c:if>
			<p> show here: ${click}</p> --%>
	</div>
</body>
</html>