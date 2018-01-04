<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet"
		href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
		integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
		crossorigin="anonymous">
		
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Requirement Check</title>
		
		
		<script type="text/javascript">
			function selectAll()
			{
				var items = document.getElementsByName('specialty');
				for(var i = 0; i < items.length; i++)
				{
					if(items[i].type == 'checkbox')
					{
						items[i].checked = true;
					}
				}
			}
			
			function deselectAll()
			{
				var items = document.getElementsByName('specialty');
				for(var i = 0; i < items.length; i++)
				{
					if(items[i].type == 'checkbox')
					{
						items[i].checked = false;
					}
				}
			}
		</script>
			
	</head>
	<body>
		<div class="container">
			<h1>Requirements Check Specialty</h1>
		</div>
		
		<div class="container">
			<a href="EditListView.jsp">Edit Specialty List Mileage</a>
		
			<div class="form-group">
				<form action="CheckoutSpecialtyList" method="post">
				
					<div class="row">
						<c:forEach items="${specialties}" var="specialty" varStatus="i">
							<div class="col-xs-6">
								<input type="checkbox" name="specialty" value="${specialty.name}"> ${specialty.name} <br>
							</div>
							
						</c:forEach>
					
					</div>
					
					<div class="row">
						<div class="col-xs-6">
							<input type="button" class="btn btn-default" onclick='selectAll()' value='Select All'/>
							<input type="button" class="btn btn-default" onclick='deselectAll()' value='Deselect All'/>
							<p>
								<input type="submit" class="btn btn-default" name="Submit" value="Add" />
							</p>
						</div>
											
					</div>
										
				</form>
			</div>
			
		</div>
	</body>
</html>