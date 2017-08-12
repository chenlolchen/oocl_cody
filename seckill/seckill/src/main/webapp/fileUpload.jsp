<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<%--<form name="serForm" action="upload" method="post" enctype="multipart/form-data">--%>
    <%--<h1>采用流的方式上传文件</h1>--%>
    <%--<input type="file" name="file">--%>
    <%--<input type="submit" value="upload"/>--%>
<%--</form>--%>

<%--<form name="Form2" action="fileUpload2" method="post"  enctype="multipart/form-data">--%>
    <%--<h1>采用multipart提供的file.transfer方法上传文件</h1>--%>
    <%--<input type="file" name="file">--%>
    <%--<input type="submit" value="upload"/>--%>
<%--</form>--%>

<%--<form name="Form3" action="springUpload" method="post" enctype="multipart/form-data">--%>
    <%--<h1>使用spring mvc提供的类的方法上传文件</h1>--%>
    <%--<input type="file" name="file">--%>
    <%--<p>输入数据：</p><input type="text" name="name" id="name">--%>
    <%--<p>输入年龄：</p><input type="text" name="age" id="age">--%>
    <%--<input type="submit" value="upload"/>--%>
<%--</form>--%>

<div>
<p>输入数据：</p><input type="text" name="name" id="name">
<input type="file" id="file" name="file"/>

<input type="button" value="上传" onclick="clickBtn()"/>
</div>
</body>
<script src="/js/jquery-1.12.4.js"></script>
<script src="/js/ajaxfileupload.js"></script>
<script>
    $(function(){
        alert("asdasdas");
    })
    function clickBtn(){
        $.ajaxFileUpload({
            url:'springUpload',
            secureuri :false,
            fileElementId :'file',//file控件id
            data:{"name":$("#name").val()},
            success : function (data, status){
                alert(data)
            }
        })
    }
</script>
</html>