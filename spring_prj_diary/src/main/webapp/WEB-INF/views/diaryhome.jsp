<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border = "1">
		<tr>
			<td>title</td>
			<td>content</td>
		</tr>
		<c:forEach items= "${dtos}" var="dto">
		<tr>
			<td>${dto.pTitle}</td>
			<td>${dto.pContent }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="makeDiaryView">write diary</a></td>
		</tr>
	</table>
</body>
</html>