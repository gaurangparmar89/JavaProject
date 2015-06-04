<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
 <jsp:useBean id="user" scope="session" class="db.UserInfoBean">
 </jsp:useBean>
<form action="DatabaseAccessServlet" method="post">
<h2> ADMIN PAGE</h2>
<hr>
<br>
 <table>

 <!-- login.jsp form completed with all input controls -->

 <tr>
 <td>&nbsp;</td>
 <td>&nbsp;</td>
 <td>&nbsp;</td>
 </tr>
 <tr>
 <td> <input TYPE="Submit" name="tables"
value="CreateTables"> </td>
 <td> <input TYPE="SUBMIT" name="tables"
value="DropTables"> </td>
 <td> <input TYPE="SUBMIT" name="tables"
value="DisplayTables"> </td>
 <td> <input TYPE="SUBMIT" name="tables"
value="Import"> </td>
 <td> <input TYPE="SUBMIT" name="tables"
value="Export"> </td>
 </tr>
 <tr>
 <td> <a href="LogoutServlet">Logout </a> </td>
 </tr>
 </table>

 </form>
 <br />
 <p>${message}</p>
 <hr>
 <p>Username: <%=user.getUserName()%></p>
 <p>Password: <%=user.getPassword()%></p>
 <p>Host: <%=user.getHost()%></p>
 <p>DataBase: <%=user.getDbms()%></p>
 <p>Schema: <%=user.getDatabaseSchema()%></p>
 <p>SessionID: <%=user.getSessionID()%></p>

</body>
</html>