<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="/j_security_check" method="post">
	<input type="text" name="j_username" placeholder="Id"/><br>
	<input type="text" name="j_password" placeholder="Password"/><br>
	<button type="submit">로그인</button>
</form>
</body>
</html>