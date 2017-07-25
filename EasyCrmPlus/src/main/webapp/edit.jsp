<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<form method="post" action="edit?id=${customer.id}">
    name: <input type="text" name="name" value="${customer.name}"><br>
    sal: <input type="number" name="sal" value="${customer.sal}"><br>
    birth: <input type="date" name="birth" value="${customer.birth}"><br>
    sex:
    <c:if test="${customer.sex == true}">
        <input type="radio" name="sex" value="true" checked="checked"/>男
        <input type="radio" value="false" name="sex"/>女
    </c:if>
    <c:if test="${customer.sex == false}">
        <input type="radio" name="sex" value="true"/>
        <input type="radio" value="false" name="sex" checked="checked"/>女
    </c:if>
    <br/>

    favs:<input type="checkbox" value="basket" name="favs">篮球
    <input type="checkbox" value="football" name="favs">足球
    <input type="submit" value="注册">
</form>
</body>
</html>
