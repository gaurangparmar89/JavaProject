package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseBean {

	 public static final String CREATE_USER_TABLE ="CREATE TABLE IF NOT EXISTS user_details (user_name varchar(50), user_password varchar(50), PRIMARY KEY (user_name))";
	 public static final String DROP_USER_TABLE = "DROP TABLE user_details";
	 public static final String SELECT_USER_TABLE = "SELECT * FROM user_details";
	 
	 public static String result = "";

	 public String getInfo()
	 {
		 return result;
	 }
	 public void selectuser(String user)
	 {
		 String query_user = "Select * from user_details WHERE user_name="+'"'+user+'"';
		 ResultSet rs = executeSQLselect(query_user);
		 result = getHtmlTable(rs);
		 
	 }

	public String getHtmlTable(ResultSet rs){
		if(rs == null)
			return "<h3><span style =\"color:red;\"> Please check the table name. </span></h3>";
			
		try{
			
			System.out.println("resultset not null");
			StringBuffer htmlRows = new StringBuffer();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			htmlRows.append("<table><TBODY>");
			htmlRows.append("<tr>");
			for (int i = 1; i <= columnCount; i++)
			{
			htmlRows.append("<td><b>" + metaData.getColumnName(i) + "</td>");
			
			}
			htmlRows.append("</tr>");
			
			while (rs.next()){
			htmlRows.append("<tr>");
			for (int i = 1; i <= columnCount; i++)
			{System.out.println(rs.getString(i));
			htmlRows.append("<td>" + rs.getString(i) + "</td>");
			}
			}
			htmlRows.append("</tr>");
			htmlRows.append("</TBODY></TABLE>");
			return htmlRows.toString();
			} // end try
			catch (SQLException e) {
			System.out.println("Error processing result set: ");
			e.printStackTrace();
			return "SQLException ***** ERROR *****";
			}
			
	}
	public void executeSQL(String query) {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getconnection();
		
		try
		{
			System.out.println("execute");
			Statement statement = connection.createStatement();
		statement.executeUpdate(query);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			try{
				connection.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		
	}
	public ResultSet executeSQLselect(String query) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Connection connection = DBConnection.getconnection();
		System.out.println("texecuting");
		try
		{
			System.out.println("execute select");
		
		Statement statement = connection.createStatement();
		rs = statement.executeQuery(query);
		
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return rs;
		
		
	}

}
