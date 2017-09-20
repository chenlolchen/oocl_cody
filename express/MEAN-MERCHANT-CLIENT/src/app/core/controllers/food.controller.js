 foodController.$inject = ['foodService','$state'];
var $ = require("jquery");
var app = require("../../index");


function foodController(foodService,$state) {
    var vm = this;
    vm.categories = ["ALL","酒水","小吃","套餐","主食"];
    vm.food = {};
    vm.currentFood = {};
    vm.currentFood.categories = vm.categories[1];
    vm.foods = [];
    vm.operation = "";

    vm.findAllFoods = function(){
        foodService.findAllFoods(function(result){
            console.log(result.data);
            vm.foods = result.data;
        });
    } 

    vm.addFood = function(){
         console.log(vm.food.image);
        foodService.addFood(vm.currentFood,function(result){
            console.log(result);
            vm.findAllFoods();
        });
        
    }

    vm.addOper = function(){
         $("#myModalLabel").text("Add Food");
    //    $(".change").directive('helloWorld', function() { 
    //          return { 
    //             restrict: 'E', 
    //             template: "<button type='button' class='btn btn-primary' id='operButton'  data-dismiss='modal' ng-click='vm.addFood()'>Add</button>", 
    //             replace: true,
    //          }; 
    //      }); 
        $("#modal_form div input").val("");
        $("#addButton").css("display","");
        $("#editButton").css("display","none");
        vm.currentFood = {};
    }

    vm.editOper = function(food){
        vm.currentFood = food.food;
       $("#myModalLabel").text("Edit Food");
       $("#addButton").css("display","none");
       $("#editButton").css("display","");
    }
    
    vm.editFood = function(){
        foodService.editFood(vm.currentFood,function(result){
            console.log("edit"+result);
            vm.findAllFoods();
        });

         // window.location.reload();
    }

    vm.deleteFood = function(id){

        swal({
            title: "Are you sure?",
            text: "You will delete you food!!",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "Yes, delete it!",
            cancelButtonText: "No, cancel plx!",
            closeOnConfirm: false,
            closeOnCancel: false
            },
            function(isConfirm){
                if (isConfirm) {
                    swal("Deleted!", "Your food was deleted.", "success");
                    foodService.deleteFood(id,function(result){
                        console.log("delete"+result);
                        // $("."+id).parent().parent().remove();
                        vm.findAllFoods();
                     });

                } else {
                    swal("Cancelled", "Your have save your food :)", "error");
                }
            });

    }

    vm.findByCategories = function(categories){
        foodService.findByCategories(categories.x,function(result){
            console.log("categories"+result);
             vm.foods = result.data; 
        });
    }

    vm.findAllFoods();
}

module.exports = foodController;