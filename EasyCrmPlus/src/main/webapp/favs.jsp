<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/25/2017
  Time: 8:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Favs</title>
</head>
<body>
    <c:forEach items="${favs}" var="fav">
        <p>${fav}</p>
    </c:forEach>
</body>
</html>
