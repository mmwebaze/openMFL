/*jslint white:true */
/*global angular */
(function () {

	var app = angular.module("demoapp", ['leaflet-directive']);
	var x = document.getElementById('coordinatesId').value;

	console.debug("<>"+x)
	var url = "/api/geoJson/"+x

//	alert(url);
	app.controller("GeoJSONController", [ '$scope', '$http', 'leafletData', function($scope, $http, leafletData) {
		angular.extend($scope, {
			namibia: {
				lat: -22.560881,
				lng: 17.065755,
				zoom: 5
			},
			defaults: {
				scrollWheelZoom: false
			}
		});

		// Get the countries geojson data from a JSON
		//"http://localhost:8080/api/organisationUnit/7e46cd0e-e1ca-4f96-a905-83221981ff97"
		$http.get(url).success(function(data, status) {
			var jsonm = data;
			//var ob = $.parseJSON(data);
			//alert(jsonm)
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