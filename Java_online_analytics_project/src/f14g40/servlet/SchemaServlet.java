package f14g40.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.DBConnection;
import db.UserInfoBean;

/**
 * Servlet implementation class SchemaServlet
 */
@WebServlet("/SchemaServlet")
public class SchemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchemaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("login servlet");
		HttpSession session = request.getSession();
		String loguser = request.getParameter("User");
		System.out.println(loguser);
		
		
			request.setAttribute("message", "");
//		String user = "/display.jsp";
		String fail = "/SchemaLogin.jsp";
		String pass = "/login.jsp";
		Boolean login = false;
		String checkUser = null;
		String checkPass = null;
		InetAddress ip;
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String schema = request.getParameter("schema");
		String ipadd = request.getParameter("host");
		
		DBConnection.ip = ipadd;

		//ub.databaseSchema = username;
		
		
		System.out.println("username: "+username+"password: "+password);
		
		Connection connection = DBConnection.getconnection();
		
		String query = "SELECT user_name, user_password FROM user_details WHERE (user_name = ? AND user_password = ?)";
        try
        {
        if(connection!=null)	
        {
    		if(username.equals("root") && password.equals("Sunny@1989"))
    		{
    			UserInfoBean.sessionID = session.getId();
    			UserInfoBean.userName = username;
    			UserInfoBean.password = password;
    			UserInfoBean.isLoggedIn = true;
    			
    			UserInfoBean.dbms = "MYSQL";
    			ip = InetAddress.getLocalHost();
    			UserInfoBean.host = ip.getHostName();
    			System.out.println("admin");
    			UserInfoBean.databaseSchema = schema;
            	System.out.println("success");
    			request.setAttribute("message", "");
    			RequestDispatcher dispatcher = request.getRequestDispatcher("/adminHome.jsp");
    			dispatcher.forward(request, response);
    		}
        	
    		else
    		{
    			request.setAttribute("message", "Check Login");
    		
			RequestDispatcher dispatcher = request.getRequestDispatcher("/OpenPage.jsp");
			dispatcher.forward(request, response);
    		}
        }
        else
        {
        	System.out.println("fail");
			request.setAttribute("message", "Check login");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/SchemaLogin.jsp");
			dispatcher.forward(request, response);	
        }
        }
        finally{try{
        	connection.close();
  
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
		
        	
        }
		}


	}


