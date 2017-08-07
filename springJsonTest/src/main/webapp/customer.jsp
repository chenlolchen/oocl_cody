<%--
  Created by IntelliJ IDEA.
  User: CHENCO7
  Date: 8/7/2017
  Time: 4:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet"
          href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <style type="text/css">
        tr td {
            padding-right: 20px;
        }
    </style>
</head>
<body>
<div id="addDiv">
    name : <input type="text" name="name"><br>
    sex : <input type="radio" name="sex" value="true">男 <input type="radio" name="sex" value="false">女<br>
    salary : <input type="number" name="salary"><br>
    birth : <input type="date" name="birth"><br>
    <button id="addBtn">添加</button>
</div>
<table id="tableId">
</table>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                        aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <div class="modal-body">
                <div>id : <span name="id"></span></div>
                name : <input type="text" name="name"><br>
                sex : <input type="radio" name="sex" value="true">男 <input type="radio" name="sex" value="false">女<br>
                salary : <input type="number" name="salary"><br>
                birth : <input type="date" name="birth"><br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="updateColumn">确定</button>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript" src="js/httpMethod.js"></script>
<script type="text/javascript" src="js/dateUtil.js"></script>
<script type="text/javascript" src="js/tableOperator.js"></script>
<script type="text/javascript">
    var operator = tableOperator($("#tableId"));
    var httpMethod = new HttpMethod("/springJsonTest");

    $(function () {
        httpMethod.get("listAll", function (data) {
            operator.renderTable(data);
        });
    });

    $("#addBtn").on("click", function () {
        var root = $("#addDiv");
        var name = root.find("[name=name]").val();
        var sex = root.find("[name=sex]:checked").val();
        var salary = root.find("[name=salary]").val();
        var birth = root.find("[name=birth]").val();
        var customer = {name: name, sex: sex, salary: salary, birth: birth};
        httpMethod.post("customer", JSON.stringify(customer), function (data) {
            operator.addColumn(data);
        });
    });

    $("#updateColumn").on("click", function () {
        var id = $(".modal-body [name=id]").text();
        var name = $(".modal-body [name=name]").val();
        var sex = $(".modal-body [name=sex]:checked").val();
        var salary = $(".modal-body [name=salary]").val();
        var birth = $(".modal-body [name=birth]").val();
        var customer =  {id: id,name: name, sex: sex, salary: salary, birth: birth};
        httpMethod.put("customer",JSON.stringify(customer),function (data) {
            operator.updateColumn(data);
            $("#myModal").modal("hide");
        } )
    })

</script>
</body>
</html>
