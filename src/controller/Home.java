package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.activation.DataSource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.PostDbUtil;
import model.Post;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DataSource dataSource;
	private PostDbUtil postDbUtil;
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			postDbUtil = new PostDbUtil((javax.sql.DataSource) dataSource);
		
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
         ArrayList<Post> allPost = new ArrayList<Post>();
		
		
		
		try {
			
			allPost  = postDbUtil.getAllPosts();
			 
			 RequestDispatcher dipatcher = request.getRequestDispatcher("MyHomePage.jsp");
			
			 request.setAttribute("allpost", allPost);
			 
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
