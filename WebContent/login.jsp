<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<c:if test="${requestScore.error != null}">
		<p style="color:red">Username or password is invalid!!!</p>
	</c:if>
	<form action="./CartServlet" method="post">
		<input type="hidden" name="type" value="login" />
		<p>
			Username: <input type="text" name="username" required />
		</p>
		<p>
			Password: <input type="password" name="password" required />
		</p>
		<p>
			<input type="submit" value="Login" />
		</p>
	</form>
</body>
</html>