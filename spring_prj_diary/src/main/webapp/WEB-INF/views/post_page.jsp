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
	<h2>
		POST
	</h2>
	<table width="500" cellpadding="0" cellspacing="0" border = "1">
		<tr>
			<td>title</td>
			<td>content</td>
		</tr>
		<tr>
			<td>${post_info.pTitle}</td>
			<td>${post_info.pContent }</td>
		</tr>
	</table>
	
	<h2>
		REPLE
	</h2>
	<table width="500" cellpadding="0" cellspacing="0" border = "1">
		<tr>
			<td>user</td>
			<td>content</td>
		</tr>
		<c:forEach items= "${reple_info}" var="dto">
		<tr>
			<td>${dto.uId}</td>
			<td>${dto.rContent }</td>			
		</tr>
		</c:forEach>
	</table>
	
	<h2>
		WRITE REPLE
	</h2>
	<form action="making_reple?pNum=${dto.pNum}" method="post">         
    	<textarea name="rContent" cols="40" rows="8"></textarea><br>
        <input type="submit" name="reple" value="reple"/>
    </form>
    <form action="going_entire_diary_page" method="post">         
        <input type="submit" name="home" value="home">
    </form>
</body>
</html>