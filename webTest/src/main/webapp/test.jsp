<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 7/25/2017
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <h1>Hello</h1>
    <h2>
        <%
            for(int i = 0; i < 10; i++){
                for (int j = 0; j <= i; j++){
                    out.print("*");
                }
                out.print("<br>");
            }
        %>
        <%= new Date() %>
    </h2>
</body>
</html>
