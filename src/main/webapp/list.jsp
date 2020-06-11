<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>成功界面</title>
</head>
<body>
	<h1>cpdd</h1>

	<hr>
	<h1>ok?ok:false</h1>
	<table border="1" cellspacing="0">
	<tr>
	<th>id</th><th>img</th><th>date</th>
	</tr>
	<c:forEach items="${list}" var="l">
	<tr>
		<td>${l.id}</td><td>${l.img}</td><td><fmt:formatDate value="${l.img_date}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
	</tr>
	</c:forEach>
	</table>
</body>
</html>