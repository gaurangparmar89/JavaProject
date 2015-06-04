package db;

import java.sql.DriverManager;
import java.sql.*;
import javax.sql.*;

public class DBConnection {

	static Connection con=null;
	String dbtime;
	String query = "Select * FROM users";
	public static String userName = "f14g40";  
	public static String ip = "";
    public static String password = "f14g40KQcdY";
    
    
    	public static Connection getconnection() {
	 
		
	try {
		String url = "jdbc:mysql://"+ip+"/"+userName;
		System.out.println(url+" "+ip+" "+password+" "+userName);
		Class.forName ("com.mysql.jdbc.Driver"); 
        con = DriverManager.getConnection (url, userName, password);  
        System.out.println ("Database connection established");  
        
        

		//con.close();
		} //end try

		catch(Exception e) {
		e.printStackTrace();
		
		
		}
	return con;

}
}