package f14g40.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.DBConnection;
import db.DatabaseBean;



@SuppressWarnings("serial")
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		System.out.println("sign servlet");
		String user = "/Success.jsp";
		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		int rs = 0;
		PreparedStatement ps = null;
		Connection connection = DBConnection.getconnection();
		if(username.equals("")||password.equals(""))
		{}
		else{
		System.out.println("username: "+username+"password: "+password);
		DatabaseBean db = new DatabaseBean();
		db.executeSQL(DatabaseBean.CREATE_USER_TABLE);
		String query = "INSERT INTO user_details Values (?,?)";
        try
        {
		ps = connection.prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        //ps.executeQuery();
        rs = ps.executeUpdate();
        System.out.println(rs);
	}
		
catch(Exception e)
        {
	e.printStackTrace();
        }

		}
        if(rs!=0)
        {
        	System.out.println("inside success "+rs);
        	request.setAttribute("status", "Sign up successful");
//        	request.getRequestDispatcher("page.jsp").forward(request, response);
        	RequestDispatcher dispatcher = request.getRequestDispatcher(user);
			dispatcher.forward(request, response);
        }
        else
        {
        	System.out.println("inside not success "+rs);
        	request.setAttribute("status", "Sign up not successful");
//        	request.getRequestDispatcher("page.jsp").forward(request, response);
        	RequestDispatcher dispatcher = request.getRequestDispatcher(user);
			dispatcher.forward(request, response);
        }
}
	
	}
