<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="neu.cs5200.movieTv.tv.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Justified Nav Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/justified-nav.css" rel="stylesheet">


<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<%
	TvJsonWebServiceClient tvJws = new TvJsonWebServiceClient();
	List<Tv> newTvs = tvJws.findTopRatedTvs() ;
	String userId = request.getParameter("userId");
	%>
	<div class="container">

		<div class="masthead">
			<h3 class="text-muted">Tvs on the air</h3>
			<div role="navigation">
				<ul class="nav nav-tabs">
					<li ><a href="/MovieTvApp/popularTvs.jsp?userId=<%=userId%>">Popular Tv</a></li>
					<li ><a
						href="/MovieTvApp/airingTodayTvs.jsp?userId=<%=userId%>">Aring
							today Tv</a></li>
					<li ><a href="/MovieTvApp/onTheAirTvs.jsp?userId=<%=userId%>">On
							the Air Tv</a></li>
					<li class="active"><a href="#">Top
							rated Tv</a></li>
					<form class="navbar-form navbar-left"
						action="/MovieTvApp/searchTvAction" method="post">
						<input type="input" name="tvname" class="form-control"
							placeholder="Tv Name"> <input type="hidden"
							name="userId" value=<%=userId%>>
						<button type="submit" class="btn btn-primary">Search</button>
					</form>

				</ul>
			</div>
		</div>


		<!-- Example row of columns -->
		<div class="row">
			<%
				for (Tv tv : newTvs) {
			%>
			<div class="col-xs-6 col-md-3">
				<div class="thumbnail">
					<img src="<%=tv.getPosterPath()%>">
					<div class="caption">
						<%=tv.getOriginalName() %>
						<h4>Release Date:<%=tv.getFirstAirDate() %></h4>
						<a href="/MovieTvApp/tvInfo.jsp?tvId=<%=tv.getId()%>&userId=<%=userId%>"
							class="btn btn-primary">Detail</a>
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