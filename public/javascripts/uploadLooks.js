$(document).ready(function() {
	$('#add').addClass('active');
	$('button[data-season]').click(function () {
		var seasonValue = $(this).attr('data-season');
		$('#form-season').val(seasonValue);
	});
	$('button[data-topBottom]').click(function () {
		var topBottomValue = $(this).attr('data-topBottom');
		$('#form-topBottom').val(topBottomValue);
	});	
});

function readUrl(input) {
	if (input.files && input.files[0]){
		var reader = new FileReader()
		reader.onload = function(e){
			$('#preview').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}