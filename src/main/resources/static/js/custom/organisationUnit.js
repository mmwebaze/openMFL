//$(document).ready(function(){

	$('form#manageOrgUnitsID').submit(function(event) {
		event.preventDefault();
		$.ajax({
			type: "POST",
			url: "/api/organisationUnitChildren/"+$("#organisationUnitParentID option:selected").val(),
			//data: $('form#manageOrgUnitsID').serialize(),
			success: function(response){
				//console.log(response);
				var trHTML = '<thead><tr><th>code</th><th>Organisation Unit Name</th><th>Owner</th><th>x</th></tr></thead>';
				$("#orgUnitResultsTableID tr").remove();
				$.each(response, function (i, item) {
					trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td>'+item.ownerName+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-info btn-xs" href="/editorgunit?uuid='+item.uuid+'">Edit</a></td><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'">Details</a></td></tr></table></td></tr>';
				});
				$('#orgUnitResultsTableID').append(trHTML);
			},
			error: function(msg){
				console.log(msg);
			}

		});
	});

	/*$('form#addOrgUnitFormID').submit(function(event) {
		event.preventDefault();
		console.log($('form#addOrgUnitFormID').serialize());
		$.ajax({
			type: "POST",
			url: "/api/addOrganisationUnit",
			data: $('form#addOrgUnitFormID').serialize(),
			success: function(response){

				//console.log(response);
			},
			error: function(msg){
				console.log(msg);
			}
		});
	});*/

	$( "#levelId" ).change(function() {
		var id = parseInt($("#levelId option:selected").val())+1;
		var url = '/api/organisationUnitLevel/'+id;

		$.ajax({
			type : 'GET',
			url	 : url,
			success : function(response){
				$('#unitId option').remove();
				$.each(response, function(i, item) {
					
					$('#unitId').append($("<option></option>").attr("value",item.id).text(item.orgUnitName));
					//console.log(item.id);
				});
			},
			error: function(response){

			}
		})
	});

	$( "#unitId" ).change(function() {
		$.ajax({
			type: "POST",
			url: "/api/organisationUnitChildren/"+$("#unitId option:selected").val(),
			//data: $('form#manageOrgUnitsID').serialize(),
			success: function(response){
				//console.log(response);
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
		console.log( $("#unitId option:selected").val() );
	});

//}); 