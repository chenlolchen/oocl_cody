<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/26/2017
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Shop</title>
</head>
<body>
    <span>${customer}</span>
    <c:forEach items="${books}" var="book">
        <div>
            <img src="${pageContext.request.contextPath}${book.image}" width="50" height="50">
            <a href="${pageContext.request.contextPath}/sec/addToShopCar?id=${book.id}">加入购物车</a>
        </div>
    </c:forEach>
</body>
</html>
