package model;

import java.util.Date;
//import java.sql.Date;

import db.PostDbUtil;

public class Post {
	public int postId;
	public String emailId;
	public String content;
	public String postDate;
	Date utilDate = new Date();
	java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	String currentDateAndTime = sqlDate.toString();
	public Post(int postId,String emailId,String content,String postDate)
	{
		this.postId = postId;
		this.emailId = emailId;
		this.content = content;
		this.postDate = postDate;
	}

	public Post(String emailId,String content)
	{
		this.emailId = emailId;
		this.content = content;
		this.postDate = getPostDate();
	}
	
	
	
	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostDate() {
		
		return currentDateAndTime;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	
	
	public  void DisplayAllPost(PostDbUtil pdu)
	{
		try {
			pdu.getAllPosts();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	


	public boolean UploadPost(PostDbUtil pdbu) 
	{
		try {
			 pdbu.UploadPost(this);
			 return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	

}
