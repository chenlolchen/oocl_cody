/**
 * Created by CHENCO7 on 8/7/2017.
 */
var tableOperator = function (root) {
    var httpMethod = new HttpMethod("/springJsonTest");
    var obj = {};

    obj.renderTable = function (data) {
        data.forEach((item)=> {
            var tr = $("<tr></tr>");
            root.append(tr);
            tr.append("<td>" + item.id + "</td>");
            tr.append("<td>" + item.name + "</td>");
            tr.append("<td>" + item.sex + "</td>");
            tr.append("<td>" + item.salary + "</td>");
            tr.append("<td>" + formatDate(new Date(item.birth)) + "</td>");
            tr.append("<td><button class='deleteBtn'>删除</button></td>");
            tr.append("<td><button type='button' class='btn btn-primary btn-sm showUpdateBtn' data-toggle='modal' data-target='#myModal' id='" + item.id + "'>更新</button></td>");
        });
        addDeleteBtnEvent();
        showUpdateColumnEvent();
    };

    obj.addColumn = function (data) {
        var tr = $("<tr></tr>");
        root.append(tr);
        tr.append("<td>" + data.id + "</td>");
        tr.append("<td>" + data.name + "</td>");
        tr.append("<td>" + data.sex + "</td>");
        tr.append("<td>" + data.salary + "</td>");
        tr.append("<td>" + formatDate(new Date(data.birth)) + "</td>");
        tr.append("<td><button class='deleteBtn' id=''>删除</button></td>");
        tr.append("<td><button type='button' class='btn btn-primary btn-sm showUpdateBtn' data-toggle='modal' data-target='#myModal' id='" + data.id + "'>更新</button></td>");
        addDeleteBtnEvent();
        showUpdateColumnEvent();
    };

    obj.deleteColumn = function (data) {
        var columnNode = $(data).parent().parent();
        var id = columnNode.children('td').eq(0).text();

        httpMethod.delete("customer/" + id, function () {
            columnNode.remove();
        });
    };

    obj.updateColumn = function(data){
        var columns = root.children("tr");
        for(let i = 0; i < columns.length; i++){
            var tdList = columns.eq(i).children("td");
            if(tdList.eq(0).text() == data.id){
                tdList.eq(1).text(data.name);
                tdList.eq(2).text(data.sex);
                tdList.eq(3).text(data.salary);
                tdList.eq(4).text(formatDate(new Date(data.birth)));
            }
        }

    };

    var addDeleteBtnEvent = function () {
        $(".deleteBtn").on("click", function () {
            obj.deleteColumn($(this));
        })
    };

    var showUpdateColumnEvent = function () {
        $(".showUpdateBtn").on("click", function () {
            httpMethod.get("customer/" + $(this).attr("id"), function (data) {
                renderModal(data);
            })
        })
    };

    var renderModal = function (data) {
        $(".modal-body [name=id]").text(data.id);
        $(".modal-body [name=name]").val(data.name);
        $(".modal-body [name=salary]").val(data.salary);
        var date = formatDate(new Date(data.birth));
        $(".modal-body [name=birth]").val(date);
    };

    return obj;
};