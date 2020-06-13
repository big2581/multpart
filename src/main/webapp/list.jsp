<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basepath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="<%=basepath %>"/>
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
	<c:forEach items="${pageinfo.list}" var="l">
	<tr>
		<td>${l.id}</td><td><img src="${l.img}"/></td><td><fmt:formatDate value="${l.img_date}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate></td>
	</tr>
	</c:forEach>
	</table>
	<span>当前页：${pageinfo.pageNum}</span><br>
	<span>每页的数量：${pageinfo.pageSize}</span><br>
	<span>总记录数：${pageinfo.total}</span><br>
	<span>总页数：${pageinfo.pages}</span><br>
	<a href="pagelist?pn=1">首页</a>
	<a href="pagelist?pn=${pageinfo.hasPreviousPage?pageinfo.prePage:1}">前一页</a>
	<a href="pagelist?pn=${pageinfo.hasNextPage?pageinfo.nextPage:pageinfo.pages}"<c:if test="${pageinfo.hasNextPage}"></c:if> >后一页</a>
	<a href="pagelist?pn=${ pageinfo.pages}">尾页</a>
</body>
</html>