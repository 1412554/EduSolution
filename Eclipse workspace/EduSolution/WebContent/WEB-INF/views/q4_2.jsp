<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  	<head>
     	<title>Question 4</title>
  	</head>
  	
  	<body>
  	<jsp:include page="account.jsp"></jsp:include>
  	<h1>Speed of Learning test</h1>
  	<h3>Question 1:</h3>
  	<form method="POST" action="finish">
  		<input type="radio" name="a4" value="a"> A. 10p<br>
  		<input type="radio" name="a4" value="b"> B. 20p<br>
  		<input type="radio" name="a4" value="c"> C. 30p<br>
  		<input type="radio" name="a4" value="d"> D. 40p<br>
  		<input type="submit" value= "Finish" />
	</form>	
	<h2>I think the communication skills shouldn't be evaluate through this kind of test.</h2>
  	
  	</body>
</html>