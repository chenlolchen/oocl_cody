<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 8/7/2017
  Time: 10:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>
<% System.out.println("jsp"); %>
    <h1>Hello: ${name}</h1>
    <h1>age: ${age}</h1>
<form action="test3" method="post">
    <input type="text" name="name">
    <input type="text" name="age">
    <input type="date" name="birth">
    <input type="submit">
</form>
</body>
</html>
