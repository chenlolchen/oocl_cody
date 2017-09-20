
   foodService.$inject = ['$http','Upload'];

    function foodService($http,Upload) {
        return {
            findAllFoods : findAllFoods,
            addFood:addFood,
            editFood:editFood,
            deleteFood:deleteFood,
            findByCategories:findByCategories
        };

        function findAllFoods(callback) {
            var request = {
                method: 'GET',
                url: '/api/food'
            };

            return $http(request).then(function(data, status, headers) {
                callback(data);
            });

        }

        function addFood(food,callback) {
            console.log("service.........."+JSON.stringify(food));
             var files = {
                image: food.image
            };
              var fields = {
                name:food.name,
                price:food.price,
                categories:food.categories
            }
            var request = {
                method: 'POST',
                url: '/api/food',
                fields:fields,
                file:files
            };
         return Upload.upload(request).success(function success(res) {
            console.log(res);
            callback(res);
        }).error(function error(res) {
            console.log(res);
        });

        }

        function editFood(food,callback) {
            var files = {
                image: food.image
            };
            var fields = {
                _id:food._id,
                name:food.name,
                price:food.price,
                categories:food.categories
            }
            var request = {
                method: 'POST',
                url: '/api/food/food',
                fields:fields,
                file:files
            };
            return Upload.upload(request).success(function success(res) {
                console.log(res);
                callback(res);
            }).error(function error(res) {
                console.log(res);
            });

        }

         function deleteFood(id,callback) {
            var request = {
                method: 'DELETE',
                url: '/api/food/'+id,
            };
            return $http(request).then(function(data, status, headers) {
                callback(data);
            });

        }
      
        function findByCategories(categories,callback){
            var request = {
                method: 'GET',
                url: '/api/food/categories/'+categories
            };
            return $http(request).then(function(data, status, headers) {
                callback(data);
            });

        }

    }

module.exports = foodService;