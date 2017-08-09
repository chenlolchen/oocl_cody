<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 8/9/2017
  Time: 1:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <%--<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>
</head>
<body>
    <form method="post" action="register">
        username: <input type="text" name="name"/>
        password: <input type="password" name="password"/>
        age: <input type="number" name="age">
        <button id="register">注册</button>
    </form>
</body>
</html>
