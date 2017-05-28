<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  	<head>
     	<title>HOME PAGE</title>
  	</head>
  	
  	<body>
  	<jsp:include page="account.jsp"></jsp:include>
  	
  	<center>
	  	<form method="POST" action="q1">
	  		<input type="submit" value="Start" />
		</form>	
	</center>
  	
  	</body>
</html>