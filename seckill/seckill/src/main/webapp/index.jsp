<html>
<body>
<h2>Hello World!</h2>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%=basePath%>
<%=path%>
<img src="<%=basePath%>images/test.jpg" style="width: 500px;height: 500px;">
<img src="<%=path%>images/test.jpg" style="width: 500px;height: 500px;">
<div>idaa : ${idaa}</div>
</body>
</html>
