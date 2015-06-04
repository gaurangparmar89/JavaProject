package f14g40.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import db.DBConnection;
import db.DatabaseBean;
import db.MessageBean;
import db.UserInfoBean;


/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/DatabaseAccessServlet")
public class DatabaseAccessServlet extends HttpServlet {
	String result;
	private DatabaseMetaData dmd;
	
	private boolean status = false;
	private String dbms;
	private String host; 
	private String databaseSchema;
	private final String [] TABLE_TYPES={"TABLE","VIEW"};
	private String databaseInfo [] = new String [10];
	private String userName;
	private String password;
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
			 // TODO Auto-generated method stub
			HttpSession session = request.getSession();
			System.out.println("DatabaseAccessServlet");
			String message = "";
			
			UserInfoBean userInfo= new UserInfoBean();
			DatabaseBean db = new DatabaseBean();
			userName = userInfo.getUserName();
			password = userInfo.getPassword();
			dbms = userInfo.getDbms();
			host = userInfo.getHost();
			databaseSchema = userInfo.getDatabaseSchema();
			
			System.out.println(userName+" "+password+" "+dbms+ " "+userInfo.getSessionID());
			Connection conn =  DBConnection.getconnection();
			try {
				dmd = conn.getMetaData();
				status = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			 
			 String action = request.getParameter("tables");
			 System.out.println("DatabaseServlet: " + action);
			 MessageBean messagebean = new MessageBean();
			 String nextUrl = null;
			 			 
			 switch (action) {
			 case "CreateTables":
			 //dbase.setQueryType("CREATE");
			 //dbase.executeSQL(SQLConstants.CREATE_USER_TABLE);
				 
				 db.executeSQL(db.CREATE_USER_TABLE);
				 message = "Successful Operation";
				 nextUrl = "/adminHome.jsp";
				 break;
			 case "DropTables":
			 //dbase.setQueryType("DROP");
			 //dbase.executeSQL(SQLConstants.DROP_USER_TABLE);
				
				db.executeSQL(db.DROP_USER_TABLE);
				message = "Successful Operation";
				nextUrl = "/adminHome.jsp";
			 break;
			 case "DisplayTables":
			 //dbase.setQueryType("SELECT");
			 //dbase.executeSQL(SQLConstants.SELECT_USER_TABLE);
			 //message.setMessage(dbase.getHtmlTable());
				 nextUrl = "/display.jsp";
				 ResultSet resultset = db.executeSQLselect(db.SELECT_USER_TABLE);
				 String result = db.getHtmlTable(resultset);
				 System.out.println("Result "+result);
				 message = "";
				 db.result = result;
				
				 
				 
			 break;
			 
			 case "Import":
			 // code to import
			 break;
			 case "Export":
			 // code to export
			 break;
			 default:
			 System.err.println("Bad action");
			 // set error messages and codes
			 break;
			 }
			 
			 request.setAttribute("message", message);
			 RequestDispatcher dispatcher =
			request.getRequestDispatcher(nextUrl);
			 dispatcher.forward(request, response);
	}


}
