package db;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;


import model.User;

public class UserDBUtil {
	
	private DataSource datasource;
	
	public UserDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}
	
	
	public void insertUser(User user) throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		String fname = user.getFname();
		String lname = user.getLname();
		String email = user.getEmail();
		String pass = user.getPass();
		
		try {
			
			conn =  this.datasource.getConnection();
			
			String sql = String.format("INSERT INTO user (fname,lname,email,pass) VALUES('%s','%s','%s','%s')",fname,lname,email,pass);
			
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
	}
	   


	public ArrayList<User> DisplayAllFriends(String email)  throws Exception
	{
		
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<User> allFriend =new ArrayList<User>();
		
		
		try {
			
			conn =  this.datasource.getConnection();
			
			String sql = "SELECT  * FROM social.user su where  su.email !=? having su.email not in (select femail from social.friend)";
		
			  
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			res = pstmt.executeQuery();
		
			
			while(res.next())
			{
		
				String femail = res.getString("email");
				 String fname = res.getString("fname");
				 String lname = res.getString("lname");
				 
				 
				   System.out.print(femail);
				 
				 
				allFriend.add(new User(fname,lname,femail));
			}
			
			   
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
		return allFriend;
		
	}
	
	
	
	

	public ArrayList<User> DisplayAllPendingRequest(String email)  throws Exception
	{
		
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		ArrayList<User> allFriend =new ArrayList<User>();
		
		
		try {
			
			conn =  this.datasource.getConnection();
			
			String sql = "SELECT * FROM social.friend sf, social.user su where uemail =? and su.email = sf.femail and status  = 0";
		
			  
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			res = pstmt.executeQuery();
		
			
			while(res.next())
			{
		
				String femail = res.getString("femail");
				 String fname = res.getString("fname");
				 String lname = res.getString("lname");
				 
				 
				   System.out.print(femail);
				 
				 
				allFriend.add(new User(fname,lname,femail));
			}
			
			   
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
		return allFriend;
		
	}
	
		public void AcceptRequest(String fEmail,String uEmail) throws Exception {
				
				Connection conn = null;
				Statement stmt = null;
				PreparedStatement pstmt = null;
				ResultSet res = null;
				
				
				
				try {
					
					conn =  this.datasource.getConnection();
					
					String sql = String.format("INSERT INTO `social`.`friend` (`uemail`, `femail`, `status`) VALUES ('%s', '%s', '1')"  
							,uEmail,fEmail);
		//			String sql2 = String.format("INSERT INTO friend (uEmail,fEmail,status) VALUES('%s','%s',1)",fEmail,uEmail);
					stmt = conn.createStatement();
					System.out.println(sql);
		//			System.out.println(sql2);
					stmt.executeUpdate(sql);
		//			stmt.executeUpdate(sql2);
					
				} finally {
					// TODO: handle finally clause
					close(conn,stmt,pstmt,res);
				}
			}
	
	
	
	
	
	
	
	
	public User findUser(String email) throws Exception {
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		User tempUser = null;
		
		
		try {
			
			conn =  this.datasource.getConnection();
			
			String sql = String.format("SELECT * FROM user WHERE email = ?");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			res = pstmt.executeQuery();
			
			if(res.next()) {
				
				String fname = res.getString("fname");
				String lname = res.getString("lname");
				String tempEmail = res.getString("email");
				String pass = res.getString("pass");
				   
				tempUser = new User(fname,lname,tempEmail,pass);
			}
			
			return tempUser;
			
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