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
		ALL POSTS
	</h2>
	<table width="500" cellpadding="0" cellspacing="0" border = "1">
		<tr>
			<td>title</td>
			<td>content</td>
			<td>category</td>
		</tr>
		<c:forEach items= "${entire_posts}" var="dto">
		<tr>
			<td><a href="post_page?pNum=${dto.pNum}">${dto.pTitle}</a></td>
			<td>${dto.pContent }</td>
			<td>${dto.cName}</td>
		</tr>
		</c:forEach>
	</table>
	
	<h2>
		MY POSTS
	</h2>
	<table width="500" cellpadding="0" cellspacing="0" border = "1">
		<tr>
			<td>title</td>
			<td>content</td>
			<td>category</td>
			<td>option</td>
		</tr>
		<c:forEach items= "${my_posts}" var="dto">
		<tr>
			<td><a href="post_page?pNum=${dto.pNum}">${dto.pTitle}</a></td>
			<td>${dto.pContent }</td>
			<td>${dto.cName }</td>
			<td>
				<form action="deleting_post?pNum=${dto.pNum}" method="post">         
        			<input type="submit" name="delete" value="delete">
    			</form>
    		</td>
			
		</tr>
		</c:forEach>
	</table>
	<form action="going_make_post" method="post">         
        <input type="submit" name="write" value="write">
    </form>
</body>
</html>