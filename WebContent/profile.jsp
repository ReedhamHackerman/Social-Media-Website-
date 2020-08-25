<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.*" %>
    <%@ page import="model.Post" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>

	<tag:forEach var="post" items="${alluserpost}">
            <div class="post">
                
                <p>${post.getPostDate()}<br></p>
               <p>${post.getContent()}</p>
              <form action="PostOperations" method="GET">
                    <tag:if test="${post.getEmailId() == user.getEmail()}">
                        <button type="submit" value="${post.getPostId()}" name="edit">Edit</button>
                    </tag:if>    
                     <button type="submit" value="${post.getPostId()}" name="like" >Like ${post.getLike()}</button>  
                    <tag:if test="${post.getEmailId() != user.getEmail()}">
                        <button type="submit" value="${post.getPostId()}" name="save">Save</button>
                    </tag:if>
                    <tag:if test="${post.getEmailId() == user.getEmail()}">
                        <button type="submit" value="${post.getPostId()}" name="del" >Delete</button>
                    </tag:if>
                    <input type="hidden" value="Home" name="page">
                </form>
            </div>
        </tag:forEach>
        
        
        
        
        <tag:forEach var="pendingR" items="${allpendingrequest}">
            <div class="pendingR">
                
                <p>${pendingR.getFname()}<br></p>
                <p>${pendingR.getLname()}<br></p>
                <p>${pendingR.getEmail()}<br></p>
              <a href="AcceptOrDeclineRequest">  <button type="submit" value="${pendingR.getEmail()}" name="accept" >Accept</button> </a>
              <a href="AcceptOrDeclineRequest"> <button type="submit" value="${pendingR.getEmail()}" name="decline" >Decline</button> </a>
            </div>
        </tag:forEach>
        
        
        
        
<a href='ViewAllFriendsList'>Click Me to Home Page</a>
	
</body>
</html>