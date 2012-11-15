$(document).ready(function() {
	$('#share').click(function() {
		var imgSource = $('#photo').attr('src');
		$('#facebook-upload').val(imgSource);
		$('form').submit();
	});
});