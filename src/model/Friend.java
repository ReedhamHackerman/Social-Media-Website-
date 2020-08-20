package model;

import db.FriendDbUtil;


public class Friend 
{
String userEmail;
String friendEmail;
int status;


public Friend(String userEmail,String friendEmail,int status)
{
	this.userEmail = userEmail;
	this.friendEmail = friendEmail;
	this.status = status;
	
}  



public String getUserEmail() {
	return userEmail;
}



public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}



public String getFriendEmail() {
	return friendEmail;
}



public void setFriendEmail(String friendEmail) {
	this.friendEmail = friendEmail;
}



public int getStatus() {
	return status;
}



public void setStatus(int status) {
	this.status = status;
}


//
//public  void DisplayFriendList(FriendDbUtil fdu,String uemail)
//{
//	try {
//		fdu.DisplayAllFriends(uemail);
//	} catch (Exception e) {
//		
//		e.printStackTrace();
//	}
//}

}
