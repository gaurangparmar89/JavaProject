<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
</head>
<body>

<jsp:useBean id="message" scope="session" class="db.DatabaseBean">
 </jsp:useBean>
 <h2> USER PAGE</h2>
 <hr>
 <br>
  <%=message.getInfo() %>
  <br>
  <a href="LogoutServlet">Logout </a>
</body>
</html>