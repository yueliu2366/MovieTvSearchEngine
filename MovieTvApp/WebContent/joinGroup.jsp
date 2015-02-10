<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030" import= "neu.cs5200.movieTv.group.*, neu.cs5200.movieTv.user.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Join Group</title>
<link href="css/bootstrap.css" rel="stylesheet"/>
</head>

<body>
<%
	int groupId = Integer.parseInt(request.getParameter("groupId"));
	long userId = Long.parseLong(request.getParameter("userId"));
	
	DisGroupDao gDao = new DisGroupDao();
	DisGroup group = gDao.findGroupByGroupId(groupId);
	
	
	//Member m = new Member();
	//m.setId(userId);
	//m.setGroups(groups)
	
%>

</body>
</html>