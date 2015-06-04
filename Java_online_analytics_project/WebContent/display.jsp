<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Info</title>
</head>
<body>

<jsp:useBean id="message" scope="session" class="db.DatabaseBean">
 </jsp:useBean>
 <jsp:useBean id="user" scope="session" class="db.UserInfoBean">
 </jsp:useBean>
 <h2> USER INFO</h2>
 <hr>
 <br>
 
  <%=message.getInfo() %>
  <br>
  
  <a href="LogoutServlet">Logout </a>
  &nbsp;
  &nbsp;
  <a href="BackServlet">Back</a>
  <br>
  <br>
 <p>Username: <%=user.getUserName()%></p>
 <p>Password: <%=user.getPassword()%></p>
 <p>Host: <%=user.getHost()%></p>
 <p>DataBase: <%=user.getDbms()%></p>
 <p>Schema: <%=user.getDatabaseSchema()%></p>
 <p>SessionID: <%=user.getSessionID()%></p>
</body>
</html>