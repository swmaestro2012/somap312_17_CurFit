var slider;
$(document).ready(function (){
	slider = new Swipe(document.getElementById('slider'), {
		startSlide: 1,
		speed: 400,
		auto: 3000,
		callback: function(event, index, elem) {
	    }
	});	
});