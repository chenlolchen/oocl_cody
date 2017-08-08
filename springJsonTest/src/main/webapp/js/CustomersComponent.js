/**
 * Created by CHENCO7 on 8/8/2017.
 */
function CustomersComponent(template){
    this.model=null;
    this.template=template;
    this.addCustomer=function(customer){
        j.ajax("POST","addCustomer",customer,{"Content-Type":"application/json"},this,function(customer){
            this.model.push(customer);
            _render(this.model);
        });
    };
    this.updateCustomer=function(customer){

    };
    this.findAllCustomers=function(){
        j.ajax("GET","findAllCustomers",null,null,this,function(customers){
            this.model=customers;
            _render(this.model);
        });

    };
    function _render(data){
        template.empty();
        data.forEach(function(item){
            $("<tr/>").append($("<td/>").text(item.id))
                .append($("<td/>").text(item.cname))
                .append($("<td/>").append($("<button/>").text("del").addClass("btn").data(item)))
                .appendTo(template);
        });
        $("button:contains(del)").on("click",function(){
            $this=$(this);
            j.ajax("DELETE","deleteCustomer?id="+$this.data().id,null,null,this,function(m){
                data=data.filter(function(item){
                    return item.id!=$this.data().id;
                });
                _render(data);
            });

        });

    }

}