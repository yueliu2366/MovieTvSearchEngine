<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="neu.cs5200.movieTv.people.*, java.util.*, neu.cs5200.movieTv.comment.*,neu.cs5200.movieTv.tv.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
		String tvId = request.getParameter("tvId");
		TvJsonWebServiceClient client = new TvJsonWebServiceClient();
		Tv tv = client.findTvById(tvId);
		String userId = request.getParameter("userId");
		int cId;
		
		CommentDao dao = new CommentDao();
		String action = request.getParameter("action");
		String content = request.getParameter("content");
		Comment comment = new Comment(); 
		 
		Comment2TvDao ctDao = new Comment2TvDao();
		Comment2Tv c2t = new Comment2Tv();
		if ("create".equals(action)) {
			comment = new Comment(content);
			cId = dao.createComment(comment);
			comment = dao.findCommentById(cId);
			c2t = new Comment2Tv(comment, tvId); 
			ctDao.createComment2Tv(c2t);
			
		}
		List<Comment> cms = ctDao.findCommentsByTid(tvId);
		
%> 
	<div class="main_bg" id="about">
		<!-- start about us -->
		<div class="container">
			<div class="row about">
				<div class="col-md-3 about_img">
					<img src=<%=tv.getPosterPath() %> height="300" width="150" alt="" class="responsive" />
				</div>
				<div class="col-md-9 about_text">
					<h3>Name: <%=tv.getOriginalName() %> <%=userId %> <%=tvId %></h3>
					<p>OverView: <%=tv.getOverView() %></p>
					<form action="tvInfo.jsp">
						<table class="table">
							<tr>
								<th>Input your comment:</th>
							</tr>
							<tr>
								<td><input name="content" class="form-control" /></td>
								<td><input type="hidden" name="userId" value=<%=userId%>></td>
								<td><input type="hidden" name="tvId" value=<%=tvId%>></td>
								<td><button name="action" value="create"
										class="btn btn-success">submit</button></td>
							</tr>
							<%
								for (Comment cmt : cms) {
							%>
							<tr>
								<td><%=cmt.getContent()%></td>
							</tr>
							<%
								}
							%>
						</table>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
