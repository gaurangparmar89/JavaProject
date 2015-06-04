package f14g40.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		System.out.println("login servlet");
		HttpSession session = request.getSession();
		String loguser = request.getParameter("User");
		System.out.println(loguser);
		InetAddress ip;
		if(loguser.equals("Login"))
		{
			request.setAttribute("message", "");
		String user = "/userview.jsp";
		
		String fail = "/login.jsp";
		Boolean login = false;
		String checkUser = null;
		String checkPass = null;
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		
		
		System.out.println("username: "+username+"password: "+password);
		
		ResultSet rs = null;
		PreparedStatement ps = null;
		DatabaseBean db = new DatabaseBean();
		Connection connection = DBConnection.getconnection();
		

		
		String query = "SELECT user_name, user_password FROM user_details WHERE (user_name = ? AND user_password = ?)";
        try
        {
		ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        //ps.executeQuery();
        rs = ps.executeQuery();
        if(rs.next())
        {
        checkUser = rs.getString(1);
        checkPass = rs.getString(2);
        }
        if(checkUser == null && checkPass == null)
        {
        	login = false;
        }
        else if((checkUser.equals(username)) && (checkPass.equals(password)))
        {
            login = true;
            System.out.println("in database");
        }
        else
        {
            login = false;
        }
        
	
		
		if(login == true)
		{
			UserInfoBean.sessionID = session.getId();
			UserInfoBean.userName = username;
			UserInfoBean.password = password;
			UserInfoBean.isLoggedIn = true;
			UserInfoBean.dbms = "MYSQL";
			ip = InetAddress.getLocalHost();
			UserInfoBean.host = ip.getHostName();

			System.out.println("user");
			request.setAttribute("message", "");
			db.selectuser(username);
			RequestDispatcher dispatcher = request.getRequestDispatcher(user);
			dispatcher.forward(request, response);
		}
		else
		{
			System.out.println("fail");
			request.setAttribute("message", "Invalid login");
			UserInfoBean.isLoggedIn = false;
			RequestDispatcher dispatcher = request.getRequestDispatcher(fail);
			dispatcher.forward(request, response);
		}
        }
        catch(Exception e)
        {
        	request.setAttribute("message", "Invalid login");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
        	dispatcher.forward(request, response);
        	e.printStackTrace();
        }
      
        	
        	
        
		}
		
else{
	
	RequestDispatcher dispatcher = request.getRequestDispatcher("/SignUp.jsp");
	dispatcher.forward(request, response);
			
		}

	}
	}

