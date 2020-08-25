package controller;

import java.io.IOException;

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


@WebServlet("/AcceptOrDeclineRequest")
public class AcceptOrDeclineRequest extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Resource(name="jdbc/social")
	private DataSource datasource;
    private UserDBUtil udb;
  
    public void init() throws ServletException 
    {
 		
 		super.init();
 		
 		try {
 			udb = new UserDBUtil(datasource);
 		 
 		} catch (Exception e) 
 		{
 			
 			throw new ServletException(e);
 		}
 	}
    
    public AcceptOrDeclineRequest() 
    {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User user  =  (User) session.getAttribute("user");
		String friendEmailId = request.getParameter("accept");
		System.out.print(friendEmailId);
		boolean  acceptFriendRequest = user.AcceptFriendRequest(udb, friendEmailId,user.getEmail());
		if(acceptFriendRequest) 
		{
			response.sendRedirect("ShowOnlyUserPost");
		}else {
			//redirect to index page in user in registered with an error
			
			RequestDispatcher dispatch = request.getRequestDispatcher("MyHomePage.jsp");
			request.setAttribute("rerror", true);
			dispatch.forward(request, response);
		}
		
	}
 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
