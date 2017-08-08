/**
 * Created by CHENCO7 on 8/8/2017.
 */
function CustomersComponent(template) {
    var self = this;
    this.model = null;

    this.addCustomer = function (customer) {
        httpMethod.post("customer", JSON.stringify(customer), function (customer) {
            self.model.push(customer);
            _render(self.model);
        });
    };
    this.updateCustomer = function (customer) {
        httpMethod.put("customer", JSON.stringify(customer), function (customer) {
            self.model = self.model.map(function (item) {
                if(item.id == customer.id){
                    return customer;
                }
                return item;
            });
            $("#myModal").modal("hide");
            _render(self.model);
        })
    };
    this.findAllCustomers = function () {
        httpMethod.get("listAll", function (customers) {
            self.model = customers;
            _render(self.model);
        });
    };
    function _render(data) {
        template.empty();
        data.forEach(function (item) {
            $("<tr/>").append($("<td/>").text(item.id))
                .append($("<td/>").text(item.name))
                .append($("<td>").text(item.sex))
                .append($("<td>").text(item.salary))
                .append($("<td>").text(formatDate(new Date(item.birth))))
                .append($("<td/>").append($("<button/>").text("del").addClass("btn").data(item)))
                .append($("<td/>").append($("<button/>").text("update").addClass("btn").data(item)))
                .appendTo(template);
        });
        $("button:contains(del)").on("click", function () {
            $this = $(this);
            httpMethod.delete("customer/" + $this.data().id, function () {
                data = data.filter(function (item) {
                    return item.id != $this.data().id;
                });
                _render(data);
            });
        });
        $("button:contains(update)").on("click", function () {
            $this = $(this);
            httpMethod.get("customer/" + $this.data().id, function (data) {
                _renderModal(data);
            });
        });
    }

    function _renderModal(data) {
        $(".modal-body [name=id]").text(data.id);
        $(".modal-body [name=name]").val(data.name);
        $(".modal-body [name=salary]").val(data.salary);
        var date = formatDate(new Date(data.birth));
        $(".modal-body [name=birth]").val(date);
        $("#myModal").modal("show");
    }
}