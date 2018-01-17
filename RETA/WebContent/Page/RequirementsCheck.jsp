<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Requirement Check</title>
</head>
<body>

<b> Requirement Check </b>

<br>
<br></br>
<tr> Filter </tr>
<br></br>


<%--ZIZipcode validation 
function is_int(value){ 
  if ((parseFloat(value) == parseInt(value)) && !isNaN(value)) {
    return true;
  } else { 
    return false;
  } --%>

<form action="main" method="get">
	<th>State</th><br></br>
	<input type="text" name="searchQuery" placeholder="Type here" value="${param.searchQuery}">
	<br></br>
	<th>ZipCode</th><br></br>
	<input type="text" name="searchQuery" placeholder="Type here" value="${param.searchQuery}">
</form>



<%--
<form action="action.jsp">
  <select name="productId">
    <option value="1">Alabama</option> <option value="2">Alaska</option> <option value="3">Arizona</option>
    <option value="4">Arkansas</option>  <option value="5">California</option>  <option value="6">Colorado</option>
    <option value="7">Connecticut</option> <option value="8">Delaware</option>  <option value="9">Florida</option> 
    <option value="10">Georgia</option> <option value="11">Hawaii</option> <option value="12">Idaho</option>
    <option value="13">Illinois</option>  <option value="14">India</option>  <option value="15">Iowa</option> 
    <option value="16">Kansas</option> <option value="17">Kentucky</option>  <option value="18">Lousiana</option> 
     <option value="19">Maine</option> <option value="20">Maryland</option>  <option value="21">Massachussetts</option> 
     <option value="22">Michigan</option> <option value="23">Minnesota</option>  <option value="24">Mississippi</option> 
     <option value="25">Missouri</option> <option value="26">Montana</option>  <option value="27">Nebraska</option> 
     <option value="28">Nevena</option> <option value="29">New Hampshire</option>  <option value="30">New Jersey</option> 
      <option value="31">New Mexico</option> <option value="32">New York</option>  <option value="33">North Carolina</option> 
      <option value="34">North Dakota</option> <option value="35">Ohio</option>  <option value="36">Oklahoma</option> 
      <option value="37">Oregon</option> <option value="38">Pennsylvania</option>  <option value="39">Rhode Island</option> 
      <option value="40">South Carolina</option> <option value="41">South Dakota</option>  <option value="42">Tennessee</option> 
      <option value="43">Texas</option> <option value="44">Utah</option>  <option value="45">Vermont</option> 
      <option value="46">Virginia</option> <option value="47">Washington</option>  <option value="48">West Virginia</option> 
      <option value="49">Wisconsin</option> <option value="50">Wyoming</option>     
      
  </select>

</form> --%>
 
<%--
String productSelected = request.getParameter("productId");
--%>

<br> Requirement checks:
<form ACTION="jspCheckBox.jsp">
<input type="checkbox" name="id" value="Meets Requirement"> Java<BR>
<input type="checkbox" name="id" value="Doesn't meet Requirement"> .NET<BR>
<input type="submit" value="Submit">
</form>



<ul>
	<c:forEach items="${zipCodes}" var="all">
	
		<tr>
		<a href="zip?id=${todo.id}"/a>
							<td>${item.number}</td>
							
		
	</c:forEach>
</ul>







</body>
</html>