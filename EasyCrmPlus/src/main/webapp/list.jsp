<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/25/2017
  Time: 4:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
</head>
<body>
    <table>
        <c:forEach items="${ customers }" var="c">
            <tr>
                <td><a href="showFavs?id=${c.id}">${c.name}</a></td>
                <td>${c.sex}</td>
                <td>${c.birth}</td>
                <td>${c.sal}</td>
                <td><a href="del?id=${c.id}">删除</a></td>
                <td><a href="update?id=${c.id}">更新</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
