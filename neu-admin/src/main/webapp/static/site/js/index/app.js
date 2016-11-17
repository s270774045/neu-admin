var myApp = angular.module('myApp', ['ngAnimate', 'ui.router', 'ui.bootstrap', 'duScroll', 'uiRouterStyles', 'myCtrl']);
myApp.config(['$stateProvider', '$urlRouterProvider',  '$locationProvider', '$httpProvider', 
    function($stateProvider, $urlRouterProvider, $locationProvider, $httpProvider){
  $locationProvider.html5Mode(false);
  $urlRouterProvider.otherwise("/");
  $stateProvider
  .state("list", {
  	url: "/",
  	templateUrl: "profile/list.html",
  	data: {
  	  pageTitle: "首页",
      css: "static/site/css/index/list.css"
  	},
  	controller: "ListCtrl"
  }).state("detail", {
    url: "/profile/:id",
    templateUrl: "profile/detail.html",
    data: {
      pageTitle: "详细",
      css: "static/site/css/index/detail.css"
    },
    controller: "DetailCtrl"
  });
  
  
  $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
  $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
  //Override $http service's default transformRequest
  $httpProvider.defaults.transformRequest = [function(data) {
    /**
     * The workhorse; converts an object to x-www-form-urlencoded serialization.
     * @param {Object} obj
     * @return {String}
     */
    var param = function(obj) {
      var query = '';
      var name, value, fullSubName, subName, subValue, innerObj, i;
      for (name in obj) {
        value = obj[name];
        if (value instanceof Array) {
          for (i = 0; i < value.length; ++i) {
            subValue = value[i];
            fullSubName = name + '[' + i + ']';
            innerObj = {};
            innerObj[fullSubName] = subValue;
            query += param(innerObj) + '&';
          }
        } else if (value instanceof Object) {
          for (subName in value) {
            subValue = value[subName];
            fullSubName = name + '[' + subName + ']';
            innerObj = {};
            innerObj[fullSubName] = subValue;
            query += param(innerObj) + '&';
          }
        } else if (value !== undefined && value !== null) {
          query += encodeURIComponent(name) + '='
              + encodeURIComponent(value) + '&';
        }
      }
      return query.length ? query.substr(0, query.length - 1) : query;
    };
    return angular.isObject(data) && String(data) !== '[object File]'
        ? param(data)
        : data;
  }];
}]);

myApp.run(['$rootScope', '$document', function($rootScope, $document){
  $rootScope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    $document.scrollTop(0);
  });
}]);
myApp.directive('title', ['$rootScope', '$timeout',
  function($rootScope, $timeout) {
    return {
      link: function() {
        var listener = function(event, toState) {
          $timeout(function() {
            $rootScope.title = '员工培养追踪评价系统';
            if(toState.data && toState.data.pageTitle) {
              $rootScope.title += ' - ' + toState.data.pageTitle;
            }
          });
        };
        $rootScope.$on('$stateChangeSuccess', listener);
      }
    };
  }
]);
myApp.filter('unsafe', ['$sce', function($sce){
    return function(text){
    	if(!text) return text;
		var s = text.replace(/&lt;/g, '<')
			.replace(/&gt;/g, '>')
			.replace(/&#40;/g, '(')
			.replace(/&#41;/g, ')')
			.replace(/&#39;/g, '\'')
			.replace(/&quot;/g, '"');
		return $sce.trustAsHtml(s);
    }
}]);
myApp.filter('id2text',function(){
    return function(id, json){
        for(var i in json){
        	var obj = json[i];
            if(id == obj.id){
                return obj.text;
            }
        }
        return null;
    }
});