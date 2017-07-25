<%@ page import="pojo.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <style type="text/css">
        .odd{
            background-color: rebeccapurple;
        }
    </style>
</head>
<body>

<%
    User u = (User) session.getAttribute("u");
    out.print("<br/>");
    out.print(u.getUname());
    out.print(u.getPassword());
%>
<hr/>
<h1>${sessionScope.u.password }</h1>
<h2>${u.uname}</h2>
<hr/>
<table>
    <c:forEach items="${us}" var="uu" varStatus="a">
        <c:if test="${a.index % 2 == 0}">
            <tr class="even">
        </c:if>

        <c:if test="${a.index % 2 == 1}">
            <tr class="odd">
        </c:if>

            <td>${uu.uname }</td>
            <td>
                <c:if test="${uu.sex}">
                    男
                </c:if>
                <c:if test="${!uu.sex}">
                    女
                </c:if>
            </td>
            <td><fmt:formatDate value="${uu.birth}" pattern="yyyy年MM月dd日"/></td>
            <td>
                <fmt:formatNumber value="${uu.sal}" pattern="$##,###.00"/>
            </td>
            <td>${a.index }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>