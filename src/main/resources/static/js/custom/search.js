$(document).ready(function(){
	$('form#searchId').submit(function(event) {
		event.preventDefault();
		$.ajax({
			type: "POST",
			url: "/api/search/"+$("#searchTermId").val(),
			data: $('form#searchId').serialize(),
			success: function(response){
				var trHTML = '<thead><tr><th>code</th><th>Organisation Unit Name</th><th>x</th></tr></thead>';
				$("#searchResultsTableID tr").remove();
				$.each(response, function (i, item) {
					console.log("f - "+item.organisationUnitCode);
					trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'">Details</a></td></tr></table></td></tr>';
				});
				$('#searchResultsTableID').append(trHTML);
			},
			error: function(msg){
				console.log(msg);
			}

		});
	});
}); 