<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/27/2017
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Cargo</title>
</head>
<body>
    <form action="sec/addCargo" method="post">
        store: <select name="storeId">
            <c:forEach items="${storeList}" var="store">
                <option name="storeId" value="${store.id}">${store.address}</option>
            </c:forEach>
        </select><br>
        name: <input type="text" name="name"><br>
        price: <input type="number" name="price"><br>
        amount: <input type="number" name="amount"><br>
        created_at: <input type="date" name="created_at"><br>
        <input type="submit" value="添加">
    </form>
</body>
</html>
