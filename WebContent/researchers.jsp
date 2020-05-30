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
<input type="text" name="table" value="researchers" readonly><br>
id:<input type="text" name="id"><br>  
First name<input type="text" name="firstName"><br>
Last name:<input type="text" name="lastName"><br>
boxes Id:<input type="text" name="boxesId"><br>
sites Id:<input type="text" name="sitesId"><br>
security clearance:<input type="text" name="securityClearance"><br>
<input type="submit" value="submit info">  
</form> 
</body>
</html>