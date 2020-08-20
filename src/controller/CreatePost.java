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

import db.PostDbUtil;

import model.User;


@WebServlet("/CreatePost")
public class CreatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 @Resource(name="jdbc/social")
	private DataSource datasource;
    private PostDbUtil pdu;

  
    public CreatePost()  {
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
		String content = request.getParameter("content");
		HttpSession session = request.getSession();
		User user  =  (User) session.getAttribute("user");
		boolean created = user.createPost(content, pdu);
		if(created) {
		
			System.out.print(user.getEmail());
			response.sendRedirect("ViewAllFriendsList");
		}else {
			//redirect to index page in user in registered with an error
			
			RequestDispatcher dispatch = request.getRequestDispatcher("MyHomePage.jsp");
			request.setAttribute("rerror", true);
			dispatch.forward(request, response);
		}
		
		
		System.out.println(created);	
		
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
