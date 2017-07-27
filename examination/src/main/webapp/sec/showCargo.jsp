<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/27/2017
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Show Cargo</title>
    <style>
        .active{
            background-color: cornflowerblue;
        }
    </style>
</head>
<body>

<c:forEach items="${storeList}" var="store">
        <span <c:if test="${param.get('storeId') == store.id}">class="active"</c:if>>
        <a href="${pageContext.request.contextPath}/sec/showCargoList?storeId=${store.id}">${store.address}</a>
        </span>

</c:forEach>
<br>
<table>
    <c:forEach items="${cargoList}" var="cargo">
        <tr>
            <td>${cargo.name}</td>
            <td>${cargo.amount}</td>
            <td>${cargo.price}</td>
            <td><fmt:formatDate value="${cargo.createdDate}" pattern="yyyy年MM月dd日"/></td>
            <td><a href="${pageContext.request.contextPath}/sec/showEdit?id=${cargo.id}">更新</a></td>
            <td>
                <a href="${pageContext.request.contextPath}/sec/deleteCargo?id=${cargo.id}&storeId=${param.storeId}">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
