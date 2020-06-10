<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传图片和日期</title>
</head>
<body>
	<h1>cpdd</h1>

	<hr>
	<form action="up/go" enctype="multipart/form-data" method="POST">
		<label>图片：</label> <input type="file" name="imgs"> <label>上传时间：</label>
		<input type="date" name="img_date"> <input type="submit"
			value="提交">
	</form>
</body>
</html>