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
	<title>R/ETAT Tool</title>

</head>

<body>

	<div class="container" id="heading">
		<h1>QTC</h1>

		<div id="list">
			<ul class="nav nav-pills nav-fill">
			
				<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="CrossCheck.jsp">Cross Check</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Requirement Check</a></li>
				
			</ul>
		</div>
	</div>
	
	<br/>
	<br/>
	<br/>
	<br/>
	
	<div align="center" class="form-group" id="filePath">
		<form action="DataSet" method="POST" >
		
			<label>Enter a Referral File</label>
			<input class="form-control-file" type="file" name="ref_file" accept=".xlsx"/>
			<br/>
			
			<label>Enter an ERRA File</label>
			<input class="form-control-file" type="file" name="erra_file" accept=".xlsx"/>
			<br/>
			
			<label>Enter a Provider File </label>
			<input class="form-control-file" type="file" name="prov_file" accept=".xlsx"/>
			
			<button>submit</button>
		</form>
	</div>
	

	
	
</body>


</html>