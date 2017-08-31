

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Servlet1() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int a=Integer.parseInt(request.getParameter("1sttext"));
		int b=Integer.parseInt(request.getParameter("2ndtext"));
		int c=a+b;
		String str="your output is :"+c;
		/*PrintWriter out=response.getWriter();
		out.println(c);*/
		
		Cookie ck=new Cookie("name",str);
		response.addCookie(ck);
		
		response.sendRedirect("Servlet2");
	
	}

}
