<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
    <title>Login</title>
 </head>
 
 <body>
    <jsp:include page="account.jsp"></jsp:include>
    <h1>Login</h1>
 
    <p style="color: red;">${errorString}</p>
 
    <form method="POST" action="doLogin">
       <table border="1">
          <tr>
             <td width="130">User name</td>
             <td><input type="text" name="userName" value= "${user.userName}" size="35"/> </td>
          </tr>
          <tr>
             <td>Password</td>
             <td><input type="password" name="password" value= "${user.password}" size="35"/> </td>
          </tr>
       </table>
       <br>
       <input type="submit" value= "Login" />
       <a href="${pageContext.request.contextPath}/">Cancel</a>
    </form>
 </body>
</html>