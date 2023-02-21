<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<a href="listHistoricalFigure" style="float:left">历史人物列表</a>
--%>
<div style="width: 500px;margin: 0px auto;text-align: center">
	<table align="center" border="1" width="400px" cellspacing='0'>
		<tr>
			<td>ID</td>
			<td>名称</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${cs }" var="c" varStatus="st">
			<tr>
				<td>${c.id }</td>
				<td><a href="listHistoricalFigure?id=${c.id }" title="显示该分类下的历史人物">${c.name }</a></td>
				<td><a href="editCategory?id=${c.id }">编辑</a></td>
				<td><a href="deleteCategory?id=${c.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align:center">
			<a href="?start=0">首页</a>
			<c:if test="${page.start-page.count >= 0 }">
				<a href="?start=${page.start-page.count }">上一页</a>
			</c:if>
			<c:if test="${page.start!=page.last }">
				<a href="?start=${page.start+page.count}">下一页</a>
			</c:if>
			<a href="?start=${page.last }">末页</a>
	</div>
	<br>
	<br>
	<div style="text-align: center">
		<form action="addCategory" method="post">
			分类名称：<input type="text" name="name"><br>
			<input type="submit" value="增加分类">
		</form>
	</div>
</div>
</body>
</html>