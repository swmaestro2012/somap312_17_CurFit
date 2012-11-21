var slider;
var matchedUserImageAjax;
$(document).ready(function (){
	matchedUserImageAjax = function(id) {
		$.ajax({	
			type : 'GET',
			url : '/api/userLook/' + id,
			dataType: 'json',
			success : function(obj) {
				$(obj).each(function(i, v) {					
					if(v.code !== -4){
						$('#co-product').show();												
						$('#co-product').attr('src', v.look.imageUrl)						
						$('#co-product-name').html("").append('<h3>' + v.look.name + '</h3>');						
					}
					else if (v.code === -4){
						
					}				
				});
			},
			error : function() {
			}
		});
	}	
	slider = new Swipe(document.getElementById('slider'), {
		startSlide: 0,
		speed: 2000,
		auto: 6000,
		callback: function(event, index, elem) {
			matchedUserImageAjax($(elem).attr("data-id"));
	    }
	});	
});
