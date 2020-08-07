<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="CreateUser" method="POST">
	<label for="fname"><b>First Name</b></label>
		<input type="text" name="fname" /><br>
	<label for="lname"><b>Last Name</b></label>
		<input type="text" name="lname" /><br>
	<label for="fname"><b>Email</b></label>
		<input type="email" name="email" /><br>
	<label for="fname"><b>PassWord</b></label>
		<input type="password" name="pass" /><br>
		<button type="submit">Register</button>
		<button type="reset">Clear</button>
	</form> 
	
	
	<form action="Login" method="POST">
		<input type="email" name="email" /><br>
		<input type="pass" name="pass" /><br>
		<button type="submit">Login</button>
		<button type="reset">Clear</button>
	</form>


</body>
</html>