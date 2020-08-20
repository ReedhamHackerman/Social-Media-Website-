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
</head>
<body>
<h1>Welcome Here Its Your Post Page</h1>


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
	
	
	
	
	
<form action="CreatePost" method="post">
  <label for="fname">Content</label><br>
  <input type="text"  name="content" Placeholder="Enter Whatever You want to add"><br>
	</form>
	
	
</body>
</html>