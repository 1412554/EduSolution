<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  	<head>
     	<title>Question 3</title>
  	</head>
  	
  	<body>
  	<jsp:include page="account.jsp"></jsp:include>
  	<h1>Detailed Thinking test</h1>
  	<h3>Question 1:</h3>
  	<form method="POST" action="q4_1">
  		<input type="radio" name="a3" value="a"> A. 10p<br>
  		<input type="radio" name="a3" value="b"> B. 20p<br>
  		<input type="radio" name="a3" value="c"> C. 30p<br>
  		<input type="radio" name="a3" value="d"> D. 40p<br>
  		<input type="submit" value= "Next quetion" />
	</form>	
  	
  	</body>
</html>