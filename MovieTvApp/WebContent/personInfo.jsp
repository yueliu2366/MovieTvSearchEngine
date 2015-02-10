<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="neu.cs5200.movieTv.people.*, java.util.*, neu.cs5200.movieTv.comment.*"%>
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
		String personId = request.getParameter("personId");
		PeopleJsonWebServiceClient client = new PeopleJsonWebServiceClient();
		People person = client.findPeopleById(personId);
		String userId = request.getParameter("userId");
		int cId;
		
		CommentDao dao = new CommentDao();
		String action = request.getParameter("action");
		String content = request.getParameter("content");
		Comment comment = new Comment();
		
		Comment2PeopleDao cpDao = new Comment2PeopleDao();
		Comment2People c2p = new Comment2People();
		if ("create".equals(action)) {
			comment = new Comment(content);
			cId = dao.createComment(comment);
			comment = dao.findCommentById(cId);
			c2p = new Comment2People(comment, personId);
			cpDao.createComment2People(c2p);
			
		}
		List<Comment> cms = cpDao.findCommentsByPid(personId);
%> 
	<div class="main_bg" id="about">
		<!-- start about us -->
		<div class="container">
			<div class="row about">
				<div class="col-md-3 about_img">
					<img src=<%=person.getProfilePath()%> height="300" width="150" alt="" class="responsive" />
				</div>
				<div class="col-md-9 about_text">
					<h3>Name: <%=person.getName()%> <%=userId %> <%=personId %></h3>
					<h4>Date of Birth: <%=person.getBirthDay() %></h4>
					<h4>Place of Birth: <%=person.getPlaceOfBirth() %></h4>
					<p>Biography: <%=person.getBioGraphy() %></p>
					<form action="personInfo.jsp">
						<table class="table">
							<tr>
								<th>Input your comment:</th>
							</tr>
							<tr>
								<td><input name="content" class="form-control" /></td>
								<td><input type="hidden" name="userId" value=<%=userId%>></td>
								<td><input type="hidden" name="personId" value=<%=personId%>></td>
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
