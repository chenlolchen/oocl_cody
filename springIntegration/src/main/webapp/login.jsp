<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 8/9/2017
  Time: 1:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
${error}
    <form action="login" method="post">
        username: <input type="text" name="name">
        password: <input type="password" name="password">
        <input type="submit">
    </form>
</body>
</html>
