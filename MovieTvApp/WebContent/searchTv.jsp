<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>

<div class="container">

	<h1>Login</h1>
	<form action="/movieTvApp/searchTvAction" method="post">
		Tv name:
		<input name="tvname" class="form-control"/>
		
		<button class="btn btn-primary btn-block">Search Tv</button>
	</form>	
</div>

</body>
</html>