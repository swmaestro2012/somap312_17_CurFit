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
	window.onresize = function() {
		var height = $(window).height();
		var imgHeight = height - 100;
		var imgWidth = (imgHeight / 1.78);
		$('#photo').height(imgHeight)
				   .width(imgWidth);
		$('#photo-overwrap').css("margin-left", -(imgWidth / 2) + 'px');		
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
//		$('#photo').attr('src', "/assets/images/loading.gif");		
		var src = $(this).children().attr('src');
		var height = $(window).height();
		var imgHeight = height - 100;
		var imgWidth = imgHeight / 1.78;

		$('#photo').attr('src', src)
		           .height(imgHeight)
		           .width(imgWidth);
		$('#photo-overwrap').css("margin-left", -(imgWidth / 2) + 'px');		

		
		
	});
});
