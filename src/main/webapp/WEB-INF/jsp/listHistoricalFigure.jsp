<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <c:forEach>标签是jsp的标准标签库(jstl)
	${}的取值方式是jsp的EL表达式。
	由于是spring+spring mvc+mybatis，所以<from>标签没有简单便利的表达方式，只能按html的标签写。
 --%>
</head>
<body>
<a href="listCategory" style="float:left">分类</a>
<div align="center" width="800px" >
	<br>
	<div>
			当前分类：${category.name }
	</div>
	<br>
	<table width="600px" border="1" cellspacing="0">
		<tr>
			<td>ID</td>
			<td>姓名</td>
			<td>时代</td>
			<td>成就</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		
		<c:forEach items="${hs }" var="h" varStatus="st">
			<tr>
				<td>${h.id}</td>
				<td>${h.name}</td>
				<td>${h.year }</td>
				<td>${h.achievement }</td>
				<td><a href="editHistoricalFigure?id=${h.id }">编辑</a></td>
				<td><a href="deleteHistoricalFigure?id=${h.id }">删除</a></td>
			</tr>
		</c:forEach>
	</table>
	<div style="text-align:center">
		<a href="?id=${category.id }&start=0">首页</a>
		<c:if test="${page.start-page.count >= 0 }">
			<a href="?id=${category.id }&start=${page.start-page.count }">上一页</a>
		</c:if>
		<c:if test="${page.start!=page.last }">
			<a href="?id=${category.id }&start=${page.start+page.count }">下一页</a>
		</c:if>
		<a href="?id=${category.id }&start=${page.last }">末页</a>
	</div>
	<br>
	<br>
	<form action="addHistoricalFigure" method="post" align="center">
		姓名：<input type="text" name="name" /><br>
		时代：<input type="text" name="year" /><br>
		成就：<input type="text" name="achievement" /><br>
		<input type="hidden" name="category.id" value="${category.id }" />
		<input type="submit" value="提交" />
	</form>
</div>
</body>
</html>