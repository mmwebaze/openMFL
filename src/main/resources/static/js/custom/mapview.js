/*jslint white:true */
/*global angular */
(function () {

	var app = angular.module("demoapp", ['leaflet-directive']);

	app.controller("GeoJSONController", [ '$scope', '$http', 'leafletData', function($scope, $http, leafletData) {
		angular.extend($scope, {
			namibia: {
				lat: 22.57,
				lng: 17.08,
				zoom: 4
			},
			defaults: {
				scrollWheelZoom: false
			}
		});

		// Get the countries geojson data from a JSON
		$http.get("http://localhost:8080/api/organisationUnit/1fa9e5af-04c1-42cf-b60a-d9606176f9a8").success(function(data, status) {
			var jsonm = data;
			//var ob = $.parseJSON(data);
			console.log("J**** "+jsonm.geometery);
			angular.extend($scope, {
				geojson: {
					data: data,
					style: {
						fillColor: "green",
						weight: 2,
						opacity: 1,
						color: 'white',
						dashArray: '3',
						fillOpacity: 0.7
					}
				}
			});
		});
	} ]);
}());