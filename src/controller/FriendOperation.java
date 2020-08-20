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

import db.FriendDbUtil;
import model.User;



@WebServlet("/FriendOperation")
public class FriendOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 @Resource(name="jdbc/social")
	 private DataSource datasource;
	 private FriendDbUtil fdu;
    public FriendOperation() 
    {
        super();
       
    }
    

    public void init() throws ServletException {
 		// TODO Auto-generated method stub
 		super.init();
 		
 		try {
 			fdu = new FriendDbUtil(datasource);
 		 
 		} catch (Exception e) {
 			// TODO: handle exception
 			throw new ServletException(e);
 		}
 	}
    
    


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String i = request.getParameter("addfriend");
		
		boolean added = user.AddFriend(user.getEmail(), i, fdu);
		System.out.print(added);
		if(added) 
		{
			
			System.out.print(user.getEmail());
			response.sendRedirect("ViewAllFriendsList");
		}else {
			//redirect to index page in user in registered with an error
			
			RequestDispatcher dispatch = request.getRequestDispatcher("MyHomePage.jsp");
			request.setAttribute("rerror", true);
			dispatch.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

}
