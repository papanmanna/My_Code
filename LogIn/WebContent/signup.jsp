<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Signup Here</title>
		<link rel="stylesheet" type="text/css" href="css/signupstyle.css">
</head>
<body>

	<div class="container">
		<form action="./CreateServ" method="post">
		<div class="input">
			<input type="text" placeholder="Enter Your Name" name="name">
		</div>
		<div class="input">
			<input type="text" placeholder="Enter Your Email" name="email">
		</div>
		<div class="input">
			<input type="text" placeholder="Enter Your Mobile No." name="mob">
		</div>
		<div class="input">
			<input type="text" placeholder="Enter Your Password" name="passwd">
		</div>
		<center>
		<input type="submit" class="submit" name="submit" value="Create Account">
		</center>
		</form>
	</div>	
	<center><span style="color:red;font-size:30px;">*<%= request.getAttribute("error") %></span></center>	

</body>
</html>