var slider;
var matchedUserImageAjax;
$(document).ready(function (){
	matchedUserImageAjax = function(id) {
		$.ajax({	
			type : 'GET',
			url : '/api/looks/' + id,
			dataType: 'json',
			success : function(obj) {
				$(obj).each(function(i, v) {
					if (typeof v.name === "undefined"){
						$('#co-product').hide();						
						$('#co-product-name').html("").append('<h3> 같이 코디된 상품이 없습니다. </h3>');
					}
					else if(v.code !== 2){
						$('#co-product').show();												
						$('#co-product').attr('src', v.imageUrl)						
						$('#co-product-name').html("").append('<h3>' + v.name + '</h3>');						
					}
					else if (v.code === 2){
						
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
			matchedUserImageAjax($(elem).attr("data-matchId"));
	    }
	});	
});