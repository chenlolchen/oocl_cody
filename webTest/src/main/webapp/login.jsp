<%@ page import="pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/25/2017
  Time: 11:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>
        Hello: <% String name = (String) request.getAttribute("name"); out.print(name); %>
    </h1>
    ${ u.uname }
    ${ tt }
    669
    <c:forEach items="${us}" var="u">
        ${u.uname}, ${u.password}
    </c:forEach>

    <form action="close">
        <button>注销</button>
    </form>
</body>
</html>
