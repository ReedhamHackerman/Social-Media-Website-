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

import db.PostDbUtil;
import model.Post;


@WebServlet("/ShowOnlyUserPost")
public class ShowOnlyUserPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 @Resource(name="jdbc/social")
	private DataSource datasource;
   private PostDbUtil pdu;


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
    public ShowOnlyUserPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		ArrayList<Post> posts = new ArrayList<Post>();
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		try {
			posts = pdu.getAllPostOfUser(email);
			System.out.print("You are Inside try");
			
            RequestDispatcher dipatcher = request.getRequestDispatcher("profile.jsp");
 			 
 			 request.setAttribute("alluserpost", posts);
 			 
 			 dipatcher.forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(posts);
		System.out.print(email);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
