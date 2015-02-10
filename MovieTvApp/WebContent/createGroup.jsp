<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.movie.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Create Discussion Group</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>

<body>

<%
	PopularMovieDao dao = new PopularMovieDao();
	String userId = request.getParameter("userId");
%>
<div class="container">
  <form action="createGroup">

	<div class="form-group">
		<input type="input" name="name" class="form-control" placeholder="Group Name">
	</div>	
	
	<div class="form-group">
		<select name="movieId" placeholder="Discussion Topic">
			<% for(int index = 1; index <= 10; index++)  {
				PopularMovie pm = dao.findPopMovieByIndex(index);
			%>
			<option value=<%= pm.getMovieId()%>> <%=pm.getTitle() %>  </option>
			<%} %>
		</select>
	</div>
	
	<input type="hidden" name="userId" value=<%=userId%>>
	
	<button class="btn btn-primary btn-block">Create</button>		
  
  </form>
</div>

</body>
</html>