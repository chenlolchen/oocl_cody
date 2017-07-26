<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/26/2017
  Time: 5:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ShopCar</title>
</head>
<body>
    <c:forEach items="${orderList}" var="item">
        <p>${item.id}</p>
        <p>${item.amount}</p>
    </c:forEach>
    <a href="sec/showBookStore">返回</a>
    <a href="sec/buyBook">购买</a>
</body>
</html>
