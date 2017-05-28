<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
</head>
<body>
	<form action="${pageContext.request.contextPath}/">
	    <input type="submit" value="Home" />
	</form>
	<c:choose>
		<c:when test="${loginedUser == null}">
		<table border="0">
		<tr>
			<td>
			<form action="${pageContext.request.contextPath}/register">
			    <input type="submit" value="Register" />
			</form>
			</td>
			<td>
			<form action="${pageContext.request.contextPath}/login">
			    <input type="submit" value="Login" />
			</form>
			</td>
		</tr>
		</table>
		</c:when>
		
		<c:otherwise>
		<table border="0">
		<tr>
			<td>
			<a href="${pageContext.request.contextPath}/userInfo">${loginedUser.userName}</a>
			</td>
			<td>
			<form action="${pageContext.request.contextPath}/logout">
				<input type="submit" value="Log out" />
			</form>
			</td>
		</tr>
		</table>
		</c:otherwise>
	</c:choose>
</body>
</html>