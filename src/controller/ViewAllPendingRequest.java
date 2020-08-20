package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.UserDBUtil;
import model.User;


@WebServlet("/ViewAllPendingRequest")
public class ViewAllPendingRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/social")
	private DataSource datasource;
	private UserDBUtil udb;
   
    public ViewAllPendingRequest() {
        super();
       
    }
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			udb = new UserDBUtil(datasource);
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}
    
    
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<User> viewAllPendingRequest = new ArrayList<User>();
 		
		  HttpSession session = request.getSession();
		  User user = (User) session.getAttribute("user");
	 		
	 		try {
	 			viewAllPendingRequest = udb.DisplayAllPendingRequest(user.getEmail());
	 			 
	 			 RequestDispatcher dipatcher = request.getRequestDispatcher("profile.jsp");
	 			 System.out.print(viewAllPendingRequest);
	 			 request.setAttribute("allpendingrequest", viewAllPendingRequest);
	 			 
	 			 dipatcher.forward(request, response);
	 			 
	 			
	 		} catch (Exception e)
	 		{
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		doGet(request, response);
	}

}
