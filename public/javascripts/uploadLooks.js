$(document).ready(function() {	
	$('button[data-season]').click(function () {
		var seasonValue = $(this).attr('data-season');
		$('#form-season').val(seasonValue);
	});
	$('button[data-topBottom]').click(function () {
		var topBottomValue = $(this).attr('data-topBottom');
		$('#form-topBottom').val(topBottomValue);
	});	
});