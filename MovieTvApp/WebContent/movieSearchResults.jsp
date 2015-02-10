<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.user.*, neu.cs5200.movieTv.movie.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Movie Search Results</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>
<body>
<h1>Here is your movie results:</h1>
<%	String movieName = (String) request.getAttribute("movieName");
	String userId = request.getParameter("userId");
	MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
	List<Movie> movies = client.findMovieByMovieName(movieName);
%>

<div class="container">
  <div class="row">
  <%for(Movie movie : movies) { %>
    <div class="col-xs-6 col-md-3">
	   <div class="thumbnail"> 
	      <a href="/MovieTvApp/movieInfo.jsp?movieId=<%= movie.getId()%>&userId=<%= userId%>">  
     	    <img src="<%= movie.getPosterPath()%>">  
     	  </a> 	
     	  <div class="caption">
     	    Release Date: <%= movie.getReleaseDate() %>
        	<h3><%= movie.getTitle()%></h3>
        	<p><%= movie.getVoteAverage() %></p>  	
      	  </div>       
        </div>  
    </div>
   <%} %>	
  </div>
</div>
	
</body>
</html>