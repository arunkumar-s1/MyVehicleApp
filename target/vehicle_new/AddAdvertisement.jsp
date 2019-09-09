<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>  
<head>  
<meta charset="ISO-8859-1">  
<title>Insert title here</title>  
</head>  
<body>  
  
<h1>Add New Advertisement</h1>  
<form action="SaveAdd" method="post">  
<table>  
<tr><td>Name:</td><td><input type="text" name="name"/></td></tr>  
<tr><td>Id:</td><td><input disabled type="text" name="id" value=<%= request.getParameter("id") %>></td></tr>  
<tr><td>Kilometer</td><td><input type="text" name="kilometer"/></td></tr>  
<tr><td>User Posted:</td><td><input type="text" name="user_posted"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Save Advertisement"/></td></tr>  
</table>  
</form>  
  
<br/>  
<a href="ViewAdd">View Adds</a>  
<br>

</body>  
</html>  