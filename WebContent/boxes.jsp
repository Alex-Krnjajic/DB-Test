<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="dbEntry" method="post">
<input type="text" name="table" value="boxes" readonly><br>
id:<input type="text" name="id"><br>  
height<input type="text" name="height"><br>
width:<input type="text" name="width"><br>
depth:<input type="text" name="depth"><br>
weight:<input type="text" name="weight"><br>
colour:<input type="text" name="colour"><br>
effect:<input type="text" name="effect"><br>
<input type="submit" value="submit info">  
</form> 
</body>
</html>