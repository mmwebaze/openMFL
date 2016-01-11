/*jslint white:true */
/*global angular */
(function() {
	var app = angular.module("mfl", []);

	app.controller("home", function($scope) {
		$scope.firstName = "John";
	});

	app.controller("orgunits", function($scope, $http) {

		$http.get('http://localhost:8080/api/organisationUnits/1').success(
				function(data) {
					$scope.greeting = data;
				});
	});
}());