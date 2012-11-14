var insertTableInfo = function(data){
	var seasons = {
		0 : "봄",
		1 : "여름",
		2 : "가을",
		3 : "겨울"
	};
	
	var topBottoms = {
		0 : "상의",
		1 : "하의"
	}
	
	return (function() {
		$('#season-value').html(seasons[data.season]);
		$('#top-bottom-value').html(topBottoms[data.topBottom]);
	})();

	
}	

$(document).ready(function() {
	var sleep = function(source) {
		
	};
	$('.click').click(function() {
		var eventedObject = $(this).attr('href');
		var position = $(eventedObject).offset();
		$('html, body').animate( { scrollTop : position.top }, 1000);

	});
		
	$('.transparent').click(function() {
		$('.transparent').hide();
	});	
	
	$('li[class^=span3]>a').click(function() {
		$('.transparent').show();
		var src = $(this).children().attr('src');
		(function() {
				setTimeout(function() {
					$('#photo').attr('src', src);
					console.log(src);
				}, 1000);			
		})();
	});
});
