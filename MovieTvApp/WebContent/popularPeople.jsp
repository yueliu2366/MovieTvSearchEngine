<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="neu.cs5200.movieTv.people.*,java.util.*, neu.cs5200.movieTv.user.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<!-- <head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Justified Nav Template for Bootstrap</title>
<link href="css/bootstrap.css" rel="stylesheet"/>

Bootstrap core CSS
<link href="css/bootstrap.min.css" rel="stylesheet">

Custom styles for this template
<link href="css/justified-nav.css" rel="stylesheet">


HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries
[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]
</head> -->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Popular People</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>

<body>
	<%
		PeopleJsonWebServiceClient pplJws = new PeopleJsonWebServiceClient();
		List<People> newPeople = pplJws.findPopularPeople();
		//User user = (User) request.getAttribute("user");
		
		String userId = request.getParameter("userId");
	%>
	<div class="container">

		<div class="masthead">
			<h3 class="text-muted">Most popular stars</h3>
			<div role="navigation">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#">Popular People</a></li>
					<form class="navbar-form navbar-left" action="/MovieTvApp/searchPeopleAction" method="post">
						<input type="input" name="personname" class="form-control"
							placeholder="Person Name"> 
						<input type="hidden"
							name="userId" value=userId<%-- <%=user.getId()%> --%>>
						<button type="submit" class="btn btn-primary">Search</button>
					</form>

				</ul>
			</div>
		</div>


		<!-- Example row of columns -->
		<div class="row">
			<%
				for (People person : newPeople) {
			%>
			<div class="col-xs-6 col-md-3">
				<div class="thumbnail">
					<a href="/MovieTvApp/personInfo.jsp?personId=<%=person.getId()%>&userId=<%= userId%>">
						<img src="<%=person.getProfilePath()%>">
					</a>
					
					<div class="caption">
						<table>
							<tr>
								<th><%=person.getName()%></th>
							</tr>
						</table>


					</div>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<!-- /container -->


	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>