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
import model.Friend;
import model.Post;
import model.User;



@WebServlet("/ViewAllFriendsList")
public class ViewAllFriendsList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/social")
	private DataSource datasource;
    private UserDBUtil udb;
  
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
    
 
    
    public ViewAllFriendsList() {
        super();
        
    }  

  
 	  
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		  ArrayList<User> allFriends = new ArrayList<User>();
	 		
		  HttpSession session = request.getSession();
		  User user = (User) session.getAttribute("user");
	 		
	 		try {
	 			allFriends = udb.DisplayAllFriends(user.getEmail());
	 			 
	 			 RequestDispatcher dipatcher = request.getRequestDispatcher("ViewAllPost");
	 			 
	 			 request.setAttribute("allfriend", allFriends);
	 			 
	 			 dipatcher.forward(request, response);
	 			 
	 			
	 		} catch (Exception e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
