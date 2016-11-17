var myCtrl = angular.module('myCtrl', []);

myCtrl.controller('MainCtrl', ["$scope", "$rootScope", "$http", function ($scope, $rootScope, $http) {

}]);

myCtrl.controller('ListCtrl', ["$scope", '$document', '$http', function($scope, $document, $http){
    $scope.maxSize = 5;
    $scope.perPage = 10;
    $scope.totalItems = [];;
    $scope.currentPage = 1;
    $scope.pageChanged = function(){
        loadList();
    };
    $scope.filterChanged = function(){
        loadList();
    };

    var loadList = function(){
        $http.get("profiles", {params : {p : $scope.currentPage}}).success(function(r){
			$document.scrollTop(0, 300);
			$scope.items = r.data;
			$scope.totalItems = r.recordsFiltered;
        });
    }
    loadList();
}]);

myCtrl.controller('DetailCtrl', ["$scope", '$stateParams', '$http', function($scope, $stateParams, $http){
	$http.get("profile", {params : {id : $stateParams.id}}).success(function(r){
		$scope.employee = r;
	});
}]);

