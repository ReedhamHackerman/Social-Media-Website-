<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.*" %>
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
			 		
				 		
		 		out.println("</li>");
			}
			out.println("</ol>");
		}
		
		
	
	%>
</body>
</html>