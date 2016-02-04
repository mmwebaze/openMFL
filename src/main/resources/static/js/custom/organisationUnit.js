//$(document).ready(function(){
var geo = [];
//$.cookie.json = true;
//document.cookie = "coordinates=";

function getOrganisationUnitChildren(orgId){
	$.ajax({
		type: "POST",
		url: "/api/organisationUnitChildren/"+orgId,
		success: function(response){
			var trHTML = '<thead><tr><th>code</th><th>Organisation Unit Name</th><th>Owner</th><th>x</th></tr></thead>';
			$("#orgUnitResultsTableID tr").remove();
			$.each(response, function (i, item) {
				var owner = item.ownerName;
				if (owner === null)
					owner = '-';

				//trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-info btn-xs" href="/editorgunit?uuid='+item.uuid+'">Edit</a></td><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'">Details</a></td></tr></table></td></tr>';
				trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td>'+owner+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-info btn-xs" href="/editorgunit?uuid='+item.uuid+'">Edit</a></td><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'">Details</a></td></tr></table></td></tr>';
			});
			$('#orgUnitResultsTableID').append(trHTML);
		},
		error: function(msg){
			console.log(msg);
		}

	});
}
function getOrganisationUnitsByLevel(levelId){
	$.ajax({
		type: "POST",
		url: "/api/organisationUnits/"+levelId,
		success: function(response){
			var trHTML = '<thead><tr><th>code</th><th>Organisation Unit Name</th><th>Owner</th><th>x</th></tr></thead>';
			
			$("#orgUnitResultsTableID tr").remove();
			var i = 1;
			$.each(response, function (i, item) {
				//var geoJson = item.geoJson;
				if (item.geoJson === null){
					
				}
				else{
					//alert(item.geoJson);
					geo.push(item.id);
					//$.cookie("coordinates"+i, JSON.stringify(item.geoJson));
					//geo.push(",")
					
					
				}
				
				var owner = item.ownerName;
				if (owner === null)
					owner = '-';

				//trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-info btn-xs" href="/editorgunit?uuid='+item.uuid+'">Edit</a></td><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'">Details</a></td></tr></table></td></tr>';
				trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td>'+owner+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-info btn-xs" href="/editorgunit?uuid='+item.uuid+'">Edit</a></td><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'">Details</a></td></tr></table></td></tr>';
			});
			
			$('#orgUnitResultsTableID').append(trHTML);
			geo.pop();
			$('#coordinatesId').val(geo);
		},
		error: function(msg){
			console.log("**** "+msg);
		}

	});
	
}

$('form#manageOrgUnitsID').submit(function(event) {
	event.preventDefault();
	$.ajax({
		type: "POST",
		url: "/api/organisationUnitChildren/"+$("#organisationUnitParentID option:selected").val(),
		success: function(response){
			var trHTML = '<thead><tr><th>code</th><th>Organisation Unit Name</th><th>Owner</th><th>x</th></tr></thead>';
			$("#orgUnitResultsTableID tr").remove();
			$.each(response, function (i, item) {
				trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td>'+item.ownerName+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-info btn-xs" href="/editorgunit?uuid='+item.uuid+'">Edit</a></td><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'" data-toggle="modal" data-target="#basicModal">Details</a></td></tr></table></td></tr>';
			});
			$('#orgUnitResultsTableID').append(trHTML);
		},
		error: function(msg){
			console.log(msg);
		}

	});
});

$( "#levelId" ).change(function() {
	var id = parseInt($("#levelId option:selected").val());
	var url = '/api/organisationUnitLevel/'+(id + 1);

	$.ajax({
		type : 'GET',
		url	 : url,
		success : function(response){
			$('#unitId option').remove();
			$.each(response, function(i, item) {

				$('#unitId').append($("<option></option>").attr("value",item.id).text(item.orgUnitName));
			});
		},
		error: function(response){

		}
	});
	//getOrganisationUnitChildren(id);
	getOrganisationUnitsByLevel(id)
	
});

$( "#unitId" ).change(function() {
	getOrganisationUnitChildren($("#unitId option:selected").val());
	//console.log( $("#unitId option:selected").val() );
});


//}); 