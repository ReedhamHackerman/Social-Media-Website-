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
              <form action="PostOperations" method="POST">
                    <tag:if test="${post.getEmailId() == user.getEmail()}">
                        <button type="submit" value="${post.getPostId()}" name="edit">Edit</button>
                    </tag:if>    
                     <button type="submit" value="${post.getPostId()}" name="like" >Like </button>  
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

	
</body>
</html>