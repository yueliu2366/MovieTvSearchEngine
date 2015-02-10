<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.movie.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Movie Details</title>
</head> -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/bootstrap.min.css" rel='stylesheet' type='text/css' />
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
<%
  String movieId = request.getParameter("movieId");
  String userId = request.getParameter("userId");
 
  MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
  Movie movie = client.findMovieById(Long.parseLong(movieId));
%>

<div class="main_bg" id="about">
	<div class="container">
		<div class="row about">
			<form action="mark" method="get">
			  <h1><%= movie.getTitle() %></h1>
			  <%-- <h2><%= movieId%></h2> --%>
			  <div class="col-md-3 about_img">
			  	<img src="<%= movie.getPosterPath()%>" class="img-rounded" height="400" width="300">
			  </div>
			  
			  <div class="col-md-9 about_text">
			  	  <button type="submit" class="btn btn-primary">Mark</button>
				  <p><%= movie.getOverview() %></p>		
				  <input name="userId" value=<%= userId %> type="hidden">
				  <input name="movieId" value=<%= movieId %> type="hidden">
			  </div>
			</form>
		</div>
	</div>
</div>


</body>
</html>