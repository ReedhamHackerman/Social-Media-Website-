package db;

import java.sql.Connection;
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
	
	
	public void DeleteThePostOfUser(int postId) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		   
		
		try {
			
			conn =  this.datasource.getConnection();
			
			String sql = "DELETE FROM posts WHERE postid = ?";
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, postId);
			pstmt.executeUpdate();
			System.out.print(postId);
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
	
		
	}
	
	
	public void LikeAnyPost(String email,int postid) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
	
		
		try {
			
			conn =  this.datasource.getConnection();
			
            String sql = String.format("INSERT INTO social.like (postid,useremailid) VALUES('%d','%s')",postid,email);
			
            stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			System.out.print(postid);
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
	
		
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
				String postDate = res.getString("date");
				
				System.out.println(id);

				allPost.add(new Post(id,emailId,content,postDate));
			}
			
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
		return allPost;
		
	}

	
	
	

	public ArrayList<Post> getAllPostOfUser(String email)  throws Exception
	{
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<Post> allPost =new ArrayList<Post>();
		
		
		try {  
			
			conn =  this.datasource.getConnection();
			String sql = "select p.*, count(l.postid) as likes" + 
	                " FROM posts p " + 
	                 " LEFT JOIN social.like l ON  p.postid = l.postid " +  
	                 "JOIN user u ON  p.emailid = u.email " +     
	                  "GROUP BY p.postid HAVING p.emailid = ?";
								
			  
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			
			res = pstmt.executeQuery();
		
			
			while(res.next()) {
				
				int id = res.getInt("postid");
				String emailId = res.getString("emailid");
				String content = res.getString("content");
				String postDate = res.getString("date");
				int likes  = res.getInt("likes");
				System.out.println(id);

				allPost.add(new Post(id,emailId,content,postDate,likes));
			}
			
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
		return allPost;
		
	}
	
	
	
	
	
	
	
	
public void UploadPost(Post post) throws Exception
{
       
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

	
		String emailid = post.getEmailId();
		String content = post.getContent();
		String date = post.getPostDate();
		
		
		
		try {
			
			conn =  this.datasource.getConnection();
			
			String sql = String.format("INSERT INTO posts (emailid,content,date) VALUES('%s','%s','%s')",emailid,content,date);
			
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
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
