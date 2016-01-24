$(document).ready(function(){
	/*var serviceValue = "";
	var serviceText = "";
	var valueSelected = "";
	var textSelected = "";
	$( "#orgUnitServices" ).change(function () {
		serviceValue = $("#orgUnitServices option:selected").val();
		serviceText = $("#orgUnitServices option:selected").text();
		//console.log(serviceValue+" - "+serviceText);
		//$("#orgUnitServices option:selected").remove();
	}).change();
	
	$( "#selectedOrgUnitServices" ).change(function () {
		valueSelected = $("#selectedOrgUnitServices option:selected").val();
		textSelected = $("#selectedOrgUnitServices option:selected").text();
		//$("#orgUnitServices option:selected").remove();
		//console.log(valueSelected+" - "+textSelected);
	}).change();
	
	$("#right").on('click', function(){
		$("#orgUnitServices option:selected").remove();
		if (serviceValue != "" && serviceText != "")
			$("#selectedOrgUnitServices").append('<option value='+serviceValue+'>'+serviceText+'</option>');
		serviceValue = "";
		serviceText = "";
		 $('#selectedOrgUnitServices option').prop('selected', true);
	});
	$("#left").on('click', function(){
		$("#selectedOrgUnitServices option:selected").remove();
		if (valueSelected != "" && textSelected != "")
			$("#orgUnitServices").append('<option value='+valueSelected+'>'+textSelected+'</option>');
		valueSelected = "";
		textSelected = "";
	});*/
	
	//console.log();
	$('#organisationUnitLevelID').val(parseInt($("#organisationUnitParentID option:selected").val()) + 1);
	
	$( "#organisationUnitParentID" ).change(function () {
		
		$('#organisationUnitLevelID').val(parseInt($("#organisationUnitParentID option:selected").val()) + 1);
	}).change();
	
	 $('.chosen-select').chosen({});
}); 