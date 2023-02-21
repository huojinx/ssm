<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updateHistoricalFigure" method="post">
	姓名：<input type="text" name="name" value="${historicalfigure.name }"/><br>
	时代：<input type="text" name="year" value="${historicalfigure.year }" /><br>
	成就：<input type="text" name="achievement" value="${historicalfigure.achievement }" /><br>
	<input type="hidden" name="category.id" value="${historicalfigure.category.id }" />
	<input type="hidden" name="id" value="${historicalfigure.id }" />
	<input type="submit" value="修改" />
</form>
</body>
</html>