<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>
<%@ page import="model.*" %>
<%@ page import="model.Post" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/index.css">
</head>
<body>

<header>

<h1 class="main-heading" >Home Page</h1>

<div class="search-bar">
			<input type="text" name="search" placeholder="Send Friend Request" autocomplete="off">			
		</div>

<a href="index.jsp">Logout</a>

</header>

<nav>

<a class="nav-link" href="Profile">Profile</a>
</nav>

<br><br>


<% 
	
		ArrayList<Post> allPost = (ArrayList<Post>) request.getAttribute("allpost");
	
	
		if(allPost == null){
			System.out.print("Its Empty");
			
		}else{
			out.println("<ol>");
			
			
			for(Post i : allPost)
			{
				out.println("<li>");
			
					out.print(i.content);
					out.print("<br>");
					out.println(i.emailId);
			 		out.println(i.postDate);
				 	
		 		out.println("</li>");
			}
			out.println("</ol>");
		}
		
		
	
	%>
	
	<tag:forEach var="friend" items="${allfriend}">
            <div class="friend">
                
                
                 <p>${friend}<br></p>
                 <p>${friend.getEmail()}<br></p>
                  <form action="FriendOperation" method="GET">
                     <button type="submit" value="${friend.getEmail()}" name="addfriend" >Add Friend</button>  
                </form>
                 
                 
            </div>
        </tag:forEach>
	
	<a href= 'ShowOnlyUserPost'>Click me To Go Profile</a>
	
<form action="CreatePost" method="post" class="home-form">
<h2 class="sub-heading">Create Post</h2>
<br>
<textarea name="postContent" placeholder="Post Your Thoughts ?"></textarea><br><br>
<button type="submit" name="createPost">Create</button>	

  <label for="fname">Content</label><br>
  <input type="text"  name="content" Placeholder="Enter Whatever You want to add"><br>
	</form>
	
	
</body>
</html>