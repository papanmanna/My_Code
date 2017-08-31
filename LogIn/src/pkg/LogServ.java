package pkg;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

@WebServlet("/LogServ")
public class LogServ extends HttpServlet {
	private static final long serialVersionUID = 1L;     

    
    public LogServ() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}


	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException {
			
		User user=new User();
		user.setGmail(request.getParameter("gmail"));
		user.setPasswd(request.getParameter("passwd"));
		UserDao ud=new UserDao();
		user=ud.getUser(user);
		if(user.isvalid())
		{
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", user);
			session.setAttribute("name", user.getName().toUpperCase());
			session.setAttribute("gmail", user.getGmail());
			session.setAttribute("mob", user.getMob());
			System.out.println(user.getName());
			response.sendRedirect("Welcome.jsp");
		}
		else{
			response.sendRedirect(response.encodeRedirectURL("Index.jsp"));
		}
		
	}


	
}