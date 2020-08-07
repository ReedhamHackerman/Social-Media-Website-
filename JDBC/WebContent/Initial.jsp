<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

*{
  margin: 0;
  padding: 0;
}

body{
  background: #e9eaea;
  font-family: roboto;
  user-select: none;
}

.container{
  width: 450px;
  margin: 30px auto;
}

.signup,
.login{
  width: 50%;
  background: #fff;
  float: left;
  height: 60px;
  line-height: 60px;
  text-align: center;
  cursor: pointer;
  text-transform: uppercase;
}

.signup-form,
.login-form{
  background: #fff;
  padding: 40px;
  clear: both;
  width: 100%;
  box-sizing: border-box;
  height: 400px;
  margin:120px;
}

.input{
  width: 100%;
  padding: 20px;
  box-sizing: border-box;
  margin-bottom: 25px;
  border: 2px solid #e9eaea;
  color: #3e3e40;
  font-size: 14px;
  outline: none;
  transform: all 0.5s ease;
}

.input:focus{
  border: 2px solid #34b3a0;
}

.btn{
  width: 100%;
  background: #34b3a0;
  height: 60px;
  text-align: center;
  line-height: 60px;
  text-transform: uppercase;
  color: #fff;
  font-weight: bold;
  letter-spacing: 1px;
  cursor: pointer;
  margin-bottom: 30px;
}

span a{
  text-decoration: none;
  color: #000;
}

::-webkit-input-placeholder { /* Chrome/Opera/Safari */
  color: #3e3e40;
  font-family: roboto;
}
::-moz-placeholder { /* Firefox 19+ */
  color: #3e3e40;
  font-family: roboto;
}
:-ms-input-placeholder { /* IE 10+ */
  color: #3e3e40;
  font-family: roboto;
}
:-moz-placeholder { /* Firefox 18- */
  color: #3e3e40;
  font-family: roboto;
}





</style>

<meta charset="ISO-8859-1">
<title>Social Media Site</title>
</head>
<body>
  <div class="wrapper">
    <div class="container">
      
      <div class="signup-form">
      <form action="CreateUser" method="post">
          <input type="text" placeholder="First Name" class="input" name="fname"><br />
          <input type="text" placeholder="Last Name" class="input" name="lname"><br />
          <input type="text" placeholder="enter Mail" class="input" name="email"><br />
          <input type="password" placeholder="Choose a Password" class="input" name="pass"><br />
          <button type="submit" class="btn" >Register</button>
       </form>
        </div>
    
        <div class="login-form">
      <form action="Login" method="POST">
          <input type="email" placeholder="Email or Username" class="input" name="email"><br />
          <input type="Password" placeholder="Password" class="input" name="pass"><br />
          <button type="submit" class="btn">Log-In</button>
      </form>
      </div>
    </div>
  </div>



</body>
</html>