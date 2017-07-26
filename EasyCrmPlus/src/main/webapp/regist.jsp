<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/25/2017
  Time: 4:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Regist</title>
</head>
<body>
    <form method="post" action="sec/add">
        name: <input type="text" name="name" value="${name}">${ename}<br>
        sal: <input type="number" name="sal" value="${sal}">${esal}<br>
        birth: <input type="date" name="birth" value="${birth}"><br>
        sex:<input type="radio" name="sex" value="true" checked="checked"/>男
        <input type="radio" value="false" name="sex"/>女<br/>
        favs:<input type="checkbox" value="basket" checked="checked" name="favs">篮球
        <input type="checkbox" value="football" name="favs">足球
        <input type="submit" value="注册">
    </form>
</body>
</html>
