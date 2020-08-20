package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.Friend;


public class FriendDbUtil
{

	private DataSource datasource;
	
	
	
	public FriendDbUtil(DataSource datasource) 
	{
		this.datasource = datasource;
	}
	
	

//
//	public ArrayList<Friend> DisplayAllFriends(String email)  throws Exception
//	{
//		
//		
//		Connection conn = null;
//		Statement stmt = null;
//		PreparedStatement pstmt = null;
//		ResultSet res = null;
//		ArrayList<Friend> allFriend =new ArrayList<Friend>();
//		
//		
//		try {
//			
//			conn =  this.datasource.getConnection();
//			
//			String sql = "SELECT * FROM social.friend where status = 0 and uemail =?";
//		
//			  
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, email);
//			
//			res = pstmt.executeQuery();
//		
//			
//			while(res.next()) {
//				
//				int status = res.getInt("status");
//				String userEmail = res.getString("uemail");
//				String friendEmail = res.getString("femail");
//				
//			
//              
//				allFriend.add(new Friend(userEmail,friendEmail,status));
//			}
//			
//			
//		} finally {
//			// TODO: handle finally clause
//			close(conn,stmt,pstmt,res);
//		}
//		return allFriend;
//		
//	}
//	
	
	

	public void AddFriend(String uemail,String femail) throws Exception
	{
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;
		
		   
		
		try {
			
            conn =  this.datasource.getConnection();
			
			String sql = String.format("INSERT INTO friend (uemail,femail,status) VALUES('%s','%s',0)",uemail,femail);
			
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
		
			
		} finally {
			// TODO: handle finally clause
			close(conn,stmt,pstmt,res);
		}
	
		
	}
	
	
	
	

	private void close(Connection conn, Statement stmt, PreparedStatement pstmt, ResultSet res) 
	{
		
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