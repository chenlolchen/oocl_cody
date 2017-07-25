<%@ page import="pojo.User" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<xx/>
<%
    User u=(User)session.getAttribute("u");
    out.print("<br/>");
    out.print(u.getUname());
    out.print(u.getPassword());
%>
<hr/>
<h1>${sessionScope.u.password }</h1>
<h2>${u.uname}</h2>
<hr/>
<table>
    <c:forEach items="${us}" var="uu" varStatus="a" begin="2" end="5">
        <tr>
            <td>${uu.uname }</td>
            <td>${a.index }</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>