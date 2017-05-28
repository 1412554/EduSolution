<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>${loginedUser.userName}</title>
</head>
<body>
	<jsp:include page="account.jsp"></jsp:include>
	<h1>${loginedUser.userName}</h1>
	<table border="1">
	<tr>
		<td>Logical thinking</td>
		<td>${loginedUser.logicalThinking}</td>
	</tr>
	<tr>
		<td>Detailed thinking</td>
		<td>${loginedUser.detailedThinking}</td>
	</tr>
	<tr>
		<td>Speed of Learning</td>
		<td>${loginedUser.speedOfLearning}</td>
	</tr>
	<tr>
		<td>Communication</td>
		<td>${loginedUser.communication}</td>
	</tr>
	</table>
</body>
</html>