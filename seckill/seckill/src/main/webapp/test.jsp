<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2016/6/2
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script type="text/javascript">
    //添加用户
    function addUser() {
        var form = document.forms[0];
        form.action = "/seckill/test";
        alert("${pageContext.request.contextPath}/seckill/test");
        //form.action = "${pageContext.request.contextPath}/user/addUser2";
        //form.action = "${pageContext.request.contextPath}/user/addUser3";
        form.method = "post";
        form.submit();
    }
</script>
<body>
<form>
    <table>
        <tr>
            <td>账号</td>
            <td>
                <input type="text" name="userName">
            </td>
        </tr>
        <tr>
            <td>密码</td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td> </td>
            <td>
                <input type="button" value="提交" onclick="addUser()">
            </td>
        </tr>
    </table>
</form>

</form>

</body>
</html>
