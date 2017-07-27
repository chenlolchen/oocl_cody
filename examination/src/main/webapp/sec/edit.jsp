<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/27/2017
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sec/updateCargo?id=${cargo.id}" method="post">
    store: <select name="storeId">
    <c:forEach items="${storeList}" var="store">
        <option name="storeId" value="${store.id}">${store.address}</option>
    </c:forEach>
</select>
    <br>
    name: <input type="text" name="name" value="${cargo.name}"><br>
    price: <input type="number" name="price" value="${cargo.price}"><br>
    amount: <input type="number" name="amount" value="${cargo.amount}"><br>
    created_at: <input type="date" name="created_at" value="${cargo.createdDate}"><br>
    <input type="submit" value="添加">
</form>
</body>
</html>
