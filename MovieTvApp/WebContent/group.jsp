<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import="neu.cs5200.movieTv.user.*, neu.cs5200.movieTv.movie.*, java.util.*, neu.cs5200.movieTv.group.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Discussion Group</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>

<body>

<%
	String userId = request.getParameter("userId");
	DisGroupDao dao = new DisGroupDao();
	List<DisGroup> myGroups = dao.findGroupByCreator(Long.parseLong(userId));
%>

<ul class="nav nav-tabs">
	<li role="presentation" class="active"><a href="#">Your Group</a></li>
  	<li role="presentation"><a href="/MovieTvApp/createGroup.jsp?userId=<%= userId%>">Create Group</a></li>
  	<%-- <li role="presentation"><a href="/MovieTvApp/joinGroup.jsp?userId=<%= userId%>">Join Group</a></li>  --%> 	
</ul>


<table class="table table-hover">
	<tr>
		<th>Discussion Group Name</th>
		<th>Related Movie</th>		
	</tr>
	
 	<%for(DisGroup group : myGroups) {  %> 
	<tr>
 		<td> <a href="/MovieTvApp/joinGroup.jsp?userId=<%= userId%>&groupId=<%= group.getId()%>"> <%= group.getName() %></a> </td>
 		
 		<%
 			long mId = group.getMovieId();
 			PopularMovieDao pmDao = new PopularMovieDao();
 			PopularMovie pm = pmDao.findPopMovieByMovieId(mId);
 		%>
 		
		<td><%= pm.getTitle() %></td>
	</tr>

 	<%} %> 
</table>

</body>
</html>