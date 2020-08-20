package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import model.Post;
import model.User;

public class FriendDbUtil 
{
	

	private DataSource datasource;  
	
	
	
	public FriendDbUtil(DataSource datasource) 
	{
		this.datasource = datasource;
	}
	
	
	public ArrayList<User> getAllFriendsOfUser(User email)  throws Exception
	{
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<User> allFriends =new ArrayList<User>();
		
		User emailid  = email;
		try {
			
			conn =  this.datasource.getConnection();
			   
			String sql = "select * from friends where emailid = ? ";
			
			pstmt = (PreparedStatement) conn.createStatement();
			
			res = pstmt.executeQuery(sql);
		
			
			while(res.next()) {
				
				String emailId = res.getString("emailid");
				
				System.out.println(emailid);

				allFriends.add(emailid);
			}
			
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
		return allFriends;
		
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
