$(document).ready(function(){
	$('form#searchId').submit(function(event) {
		event.preventDefault();
		$.ajax({
			type: "POST",
			//url: "/api/search/"+$("#searchTermId").val(),
			url: "/api/search/",
			data: $('form#searchId').serialize(),
			success: function(response){
				var trHTML = '<thead><tr><th>code</th><th>Organisation Unit Name</th><th>Organisation Unit Type</th><th>x</th></tr></thead>';
				$("#searchResultsTableID tr").remove();
				$.each(response, function (i, item) {
					//console.log("**"+(item.orgUnitType).typeName);
					var typeOrg = item.orgUnitType.typeName;
					if (typeOrg === null)
						typeOrg = '-';
					var owner = item.ownerName;
					if (owner === null)
						owner = '-';
					//trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td>'+typeOrg+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'" data-toggle="modal" data-target="#basicModal">Details</a></td></tr></table></td></tr>';
					trHTML += '<tr><td>'+item.organisationUnitCode+'</td><td>'+item.organisationUnitName+'</td><td>'+typeOrg+'</td><td><table cellpadding=10 class=table-bordered><tr><td><a class ="btn btn-success btn-xs" href="/vieworgunit?uuid='+item.uuid+'">Details</a></td></tr></table></td></tr>';
				});
				$('#searchResultsTableID').append(trHTML);
			},
			error: function(msg){
				console.log(msg);
			}

		});
	});
	
	/*$('#bootpopup').click(function(){
		alert("Details button clicked...")
	    var frametarget = $(this).attr('href');
	  var targetmodal = $(this).attr('target');
	  if (targetmodal == undefined) {
	    targetmodal = '#popupModal';
	  } else { 
	    targetmodal = '#'+targetmodal;
	  }
	  if ($(this).attr('title') != undefined) {
	    $(targetmodal+ ' .modal-header h3').html($(this).attr('title'));
	    $(targetmodal+' .modal-header').show();
	  } else {
	     $(targetmodal+' .modal-header h3').html('');
	    $(targetmodal+' .modal-header').hide();
	  }  
	    $(targetmodal).on('show', function () {
	        $('iframe').attr("src", frametarget );   
		});
	    $(targetmodal).modal({show:true});
	  return false;
	    
	});*/
}); 