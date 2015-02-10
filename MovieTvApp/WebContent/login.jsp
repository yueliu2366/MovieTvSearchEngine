<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>

<a href="/MovieTvApp/register.jsp" class="btn btn-link">New User Register</a>

<div class="container">
	<h1>Login</h1>
	<form class="form-signin" action="login" method="post">
		<div class="form-group">
			Username:
			<input name="username" class="form-control"/>
		</div>
		
		<div class="form-group">
			Password:
			<input name="password" type="password"  class="form-control"/>
		</div>
		
		<button class="btn btn-primary btn-block">Login</button>		
	</form>	
</div>
</body>
</html>