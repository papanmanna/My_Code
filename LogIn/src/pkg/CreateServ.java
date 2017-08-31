package pkg;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateServ")
public class CreateServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateServ() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			processRequest(request, response);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int mob=Integer.parseInt(request.getParameter("mob"));
		String passwd=request.getParameter("passwd");
		User user=new User();
		user.setName(name);
		user.setGmail(email);
		user.setMob(mob);
		user.setPasswd(passwd);
		UserDao ud=new UserDao();
		HttpSession session = request.getSession();
		if(ud.createUser(user)==0){
			    request.setAttribute("error", "User Name Already Exists.");
			    request.getRequestDispatcher("signup.jsp").forward(request, response);
		}
		else{
			session.setAttribute("message","User successfully created");
			response.sendRedirect("Index.jsp");
		}
	}

}
