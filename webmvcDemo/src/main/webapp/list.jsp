<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 8/7/2017
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<c:forEach items="${customers}" var="customer">
    ${customer.id}
    ${customer.name}
    ${customer.sex}
    ${customer.salary}
    <fmt:formatDate value="${customer.birth}" pattern="yyyy-MM-dd"/>
    <br>
</c:forEach>
</body>
</html>
