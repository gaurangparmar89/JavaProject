
<h2> USER LOGIN </h2>
<hr>
<br>
<a href="OpenPage.jsp">Home</a>

<form action="LoginServlet" method="post">
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
 <td> <input TYPE="Submit" name="User"
value="Signup"> </td>
</tr>
</table>
</form>
<br>
<p>${message}</p>