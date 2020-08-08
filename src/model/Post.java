package model;


import java.sql.Date;
public class Post {
	public int postId;
	public String emailId;
	public String content;
	public Date postDate;
	
	public Post(int postId,String emailId,String content,Date postDate)
	{
		this.postId = postId;
		this.emailId = emailId;
		this.content = content;
		this.postDate = postDate;
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

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
