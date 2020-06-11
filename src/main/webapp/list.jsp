<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<div>
		<span>id</span><span>img</span><span>date</span>
	</div>
	<c:forEach items="${list}" var="l">
		<div>
			<span>${l.id}</span><span>${l.img}</span><span>${l.img_date}</span>
		</div>
	</c:forEach>
</body>
</html>