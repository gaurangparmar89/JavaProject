<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login to database</title>
</head>
<body>
<h2> ADMIN LOGIN</h2>
<hr>
<br>
<a href = "OpenPage.jsp">Home</a>
<br>
<form action="SchemaServlet" method="post">
<table>
<tr>
<th align="right">User name:</th>
<td> <input TYPE="TEXT" name="userName" size="14"> </td>
</tr>
<tr>
<th align="right">Password:</th>
<td> <input TYPE="PASSWORD" name ="password"
size="14"> </td>
</tr>
<tr>
<th align="right"> Server:</th>
<td> 
<select name="host">

<option value="131.193.209.54:3306">server54</option>
 <option value="131.193.209.57:3306">server57</option>
 <option value="localhost" selected="SELECTED">localhost</option>
 </select>
</td>
</tr>
<tr>
<th align = "right">Schema: </th>
<td> <input type = "text" name="schema" value = "f14g40"></td>
</tr>
<tr>

<tr>
<td>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td></td>
</tr></table>
 <table>

 <tr>
 <td> <input TYPE="Submit" name="User"
value="Login"> </td>
</tr>
</table>
</form>
<br>
<p>${message}</p>
</body>
</html>