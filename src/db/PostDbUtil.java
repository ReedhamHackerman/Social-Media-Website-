package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import javax.sql.DataSource;

import model.Post;

public class PostDbUtil 
{
	

	private DataSource datasource;
	
	
	public PostDbUtil(DataSource datasource) 
	{
		this.datasource = datasource;
	}
	
	
	

	public ArrayList<Post> getAllPosts()  throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<Post> allPost =new ArrayList<Post>();
		
		
		try {
			
			conn =  this.datasource.getConnection();
			
			String sql = "select * from posts";
			
			
			
			
			stmt = conn.createStatement();
			
			res = stmt.executeQuery(sql);
			
			
			while(res.next()) {
				
				int id = res.getInt("postid");
				String emailId = res.getString("emailid");
				String content = res.getString("content");
				Date postDate = res.getDate("date");

				allPost.add(new Post(id,emailId,content,postDate));
			}
			
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
		return allPost;
		
	}
	

	private void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet res) {
		
		try {
			
			if(conn != null){				
				conn.close();
			}
			
			if(stmt != null) {				
				stmt.close();
			}
			
			if(pstmt != null) {				
				pstmt.close();
			}
			
			if(res != null) {				
				res.close();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
	}

}
