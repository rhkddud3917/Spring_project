<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="makeDiary" method="post"> 
		[Title] <input type="text" name="title"><br>        
    	[Content] <textarea name="content" cols="40" rows="8"></textarea><br>
        [Category]
    <select name="category">
    	<option value="1">sports</option>
    	<option value="2">life</option>
    	<option value="3">food</option>
    	<option value="4">journey</option>
	</select> <br>
        <input type="submit" name="choose" value="post">
    </form>
</body>
</html>