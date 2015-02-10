<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.user.*, neu.cs5200.movieTv.movie.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Upcoming Movies</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>

<body>
<%	
	MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
	String urlApi ="http://api.themoviedb.org/3/movie/upcoming?api_key=cb308fc308a03542532cff9b7c2ed4d9";	
	String json = client.findJson(urlApi, "", "");
	List<Movie> movies = client.parserMovieJsonList(json);
	String userId = request.getParameter("userId");
%>

<ul class="nav nav-tabs">
	<!-- <li role="presentation" class="active"><a href="#">Popular Movie</a></li> -->
  	<li role="presentation"><a href="/MovieTvApp/popularMovies.jsp?userId=<%= userId%>">Popular Movie</a></li>
  	<li role="presentation"><a href="/MovieTvApp/topRatedMovies.jsp?userId=<%= userId%>">Top Rated Movie</a></li>
  	<li role="presentation"><a href="/MovieTvApp/nowPlayingMovies.jsp?userId=<%= userId%>">Now Playing Movie</a></li>
  	<li role="presentation" class="active"><a href="#">Upcoming Movie</a></li>
  	<li role="presentation"><a href="/MovieTvApp/latestMovies.jsp?userId=<%= userId%>">Latest Movie</a></li>
  	
	<form class="navbar-form navbar-left" action="search">
		<input type="input" name="movieName" class="form-control" placeholder="Movie Name">		
		<input type="hidden" name="userId" value=<%= userId%>>	
		<button type="submit" class="btn btn-primary">Search</button>
	</form>
</ul>

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
        	<p>Rate: <%= movie.getVoteAverage() %></p> 	
      	  </div>       
        </div>  
    </div>
   <%} %>	
  </div>
</div>

</body>
</html>