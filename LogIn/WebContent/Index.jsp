<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>LOGIN PAGE</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
</head>
<body>

	<div class="container">
	<img src="img/face.png">   
		<form action="./LogServ" method="post">
			<div class="form-input">
				<input type="text" placeholder="Enter Your Email-id" name="gmail" > 
			</div>
			<div class="form-input">
				<input type="password" name="passwd" placeholder="Enter Your Password" > 
			</div>
			<input type="submit" class="login" name="submit" value="LOGIN"><br>
				<br><div class="or">OR</div><br>
				<a href="signup.jsp">Click To Sign Up</a>
			</form>		
	</div>	
	
</body>
</html>