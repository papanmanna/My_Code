<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="pkg.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Welcome Page</title>
	<link rel="stylesheet" type="text/css" href="css/welcome.css">
	<link rel="stylesheet" type="text/css" href="css/font-awesome.css">
	
</head>
<body>


<%

	User user=(User)session.getAttribute("currentUser"); 
		 if(session.getAttribute("currentUser")==null)
			response.sendRedirect(response.encodeRedirectURL("Index.jsp"));
%>

	
	<div class="container dark ">
		<div class="wrapper">
			<p id="left"><marquee width="100%"><h1>WELCOME<%= " "+session.getAttribute("name") %></h1></marquee></p>
			<div id="clear"></div>
			<div id="right">
				<p id="email">Email:<%= session.getAttribute("gmail") %></p>
				<p id="mob">Mobile:<%= session.getAttribute("mob") %></p>			
			</div>
			<div id="clear"></div>
		</div>
	</div>


	<div class="container light ">
			<div class="wrapper">
				<div class="menu">
					<ul><b>
						<li><a href="#">Home</a></li>
						<li><a href="#">Project</a></li>
						<li><a href="#">Contact Us</a></li>
						<li><a href="#">About Us</a></li>
					</b></ul>
				</div>
				<div class="search">	
					<form>
						<input id="text" type="text" placeholder="Search Here" name="searchbox" >
						<input id="submit" type="submit" value="Search">
					</form>
				</div>
			</div>
	</div>

	<div class="container dark">
			<img src="img/car2.jpg">
			<div id="clear"></div>
			
				<div id="content">
					<ul>
						<li><a href="#"><b>CONTENTS</b></a>
							<ul>
								<li><a href="#">Home</a></li>
								<li><a href="#">Project</a></li>
								<li><a href="#">Contact Us</a></li>
								<li><a href="#">About Us</a></li>
							</ul>
						</li>
					</ul>
				</div>
			
			<div id="clear"></div>
	</div>
	</div>
	
	<div class="container light">
		<div class="info">
			<table>
				<tr>
					<td>
						<span><strong><p>Address Details</p></strong></span>	
						<br>Anandapur,Beside NRI Complex
						<br>Kolkata-700150<br>
						<br><span><strong><p>Contact Details</p></strong></span>
						<br><strong>Mobile No.:</strong>(+91)8389087428
						<br><strong>Email Id.:</strong><a id="hyperlink" href="#">mannapapan.r@gmail.com</a>
					</td>				
					<td>
						<span><strong><p>User's Information</p></strong></span>	
						<br><strong>Mobile No.:</strong><%= " "+session.getAttribute("mob") %>
						<br><strong>Email Id.:</strong><a id="hyperlink" href="#"><%= " "+session.getAttribute("gmail") %></a>
						<br><strong>Name:</strong><%= " "+session.getAttribute("name") %>
						<br><br><a href="logout.jsp">Sign Out</a>
					</td>
				</tr>
			</table>
		</div>
	</div>

	<div class="container dark">
		<p id="footer">Thanks For Visiting</p>
	</div>
</body>
</html>