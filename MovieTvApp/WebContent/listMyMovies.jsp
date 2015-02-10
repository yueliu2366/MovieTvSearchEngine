<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.user.*, neu.cs5200.movieTv.movie.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Favorite Movies</title>
<link href="css/bootstrap.css" rel="stylesheet"/>

</head>
<body>

<%
	User user = (User) request.getAttribute("user");
	User2MovieDao umDao = new User2MovieDao();
	List<Long> movieIdList = umDao.findMovieIdByUserId(user.getId());

	MovieJsonWebServiceClient client = new MovieJsonWebServiceClient();
	ArrayList<Movie> movieList = new ArrayList<Movie>();

	for(long movieId : movieIdList) {
		movieList.add(client.findMovieById(movieId));
	} 

	//System.out.println(user.getId());
%> 

<ul class="nav nav-tabs">
	<li role="presentation" class="active"><a href="#">Home</a></li>
  	<li role="presentation"><a href="/MovieTvApp/popularMovies.jsp?userId=<%= user.getId()%>">Movie</a></li>
  	<li role="presentation"><a href="/MovieTvApp/popularTvs.jsp?userId=<%= user.getId()%>">TV</a></li>
  	<li role="presentation"><a href="/MovieTvApp/popularPeople.jsp?userId=<%= user.getId()%>">People</a></li>
  	<li role="presentation"><a href="/MovieTvApp/group.jsp?userId=<%= user.getId()%>">Group</a></li>
  	
<%-- 	<form class="navbar-form navbar-left" action="search">
		<input type="input" name="movieName" class="form-control" placeholder="Movie Name">		
		<input type="hidden" name="userId" value=<%= user.getId()%>>	
		<button type="submit" class="btn btn-primary">Search</button>
	</form> --%>
</ul>
   

<div class="container">
  <div class="row">
  <%for(Movie movie : movieList) { %>
    <div class="col-xs-6 col-md-3">
	    <div class="thumbnail">  
	      <a href="/MovieTvApp/movieInfo.jsp?movieId=<%= movie.getId()%>"> 
     	  <img src="<%= movie.getPosterPath()%>">   	
     	  <div class="caption">
     	    Release Date: <%= movie.getReleaseDate() %>
        	<h3><%= movie.getTitle()%></h3>
        	<%-- <p><%= movie.getOverview() %></p> --%>
        	</a>      	
      	  </div>       
        </div>  
    </div>
   <%} %>	
  </div>
</div>

</body>
</html>