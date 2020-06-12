<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basepath %>"/>
<title>动静分离</title>
</head>
<body>
	<img alt="static" src="image/">
	ip地址：10.1.15.131
	<%String id=session.getId(); %>
	sessionid：<%=id %>
</body>
</html>