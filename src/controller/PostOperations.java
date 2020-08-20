package controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import db.PostDbUtil;
import model.User;



@WebServlet("/PostOperations")
public class PostOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Resource(name="jdbc/social")
	 private DataSource datasource;
     private PostDbUtil pdu;
     public PostOperations() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			pdu = new PostDbUtil(datasource);
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String i = request.getParameter("del");
		if(i!=null)
		{
			int postId = Integer.parseInt(i);
			try {
				pdu.DeleteThePostOfUser(postId);
				System.out.print(postId);
				response.sendRedirect("ShowOnlyUserPost");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	
		String j = request.getParameter("like");
		  System.out.print(j);
		  System.out.println("hello");
	  
		if(j!=null)
		{
			int postIdlike = Integer.parseInt(j);
			try {
				pdu.LikeAnyPost(user.getEmail(),postIdlike);
				
				response.sendRedirect("ShowOnlyUserPost");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
	
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
