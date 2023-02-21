<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateCategory" method="post" style="margin-left: 20px">
	名称：<input type="text" name="name" value="${category.name }"><br>
	<input type="hidden" name="id" value="${category.id }"><br>
	<input type="submit" value="修改"> 
</form>
</body>
</html>