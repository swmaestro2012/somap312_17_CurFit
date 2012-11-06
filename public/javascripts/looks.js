

$(document).ready(function() {
	
	var $years_ = $('#years_');
	var $season_ = $('#season_');
	var $topBottom_ = $('#top-bottom_');
	var $helpInline = $('.help-inline');
	
	var selected  = {
		years : function() {
			return $('#years_').val(); 
		},
		season : function() {
			return $('#season_').find('.active').html();
		},
		topBottom : function() {
			return $('#top-bottom_').find('.active').html();
		},
		price : {
			0 : function() {
				return $('#price').find('input')[0].value
			},
			1 : function() {
				return $('#price').find('input')[1].value
			}
		}
	};

	var patterns = {
		years : /^[1-2][0-9]{3}$/,
		season : {
			"봄" : 0 ,
			"여름" : 1,
			"가을" : 2,
			"겨울" : 3
		},
		topBottom : {
			"상의" : 0,
			"하의" : 1
		}
	};
	
	var checkValues = function() {
		var checkList = {
			years : function() {
				$years_.focus();
				return $years_.val();
			},
			season : function() {
				
				return patterns.season[selected.season()];
			},
			topBottom : function() {			
				return patterns.topBottom[selected.topBottom()];
			}
		};				
		if(checkList.years().match(patterns.years) === null ){
			
			return false;
		}
		
		if(typeof checkList.season() === 'undefined'){
			
			$('#season').addClass('error');
			$('#season').find('.help-inline').show();
			$('#season').find('.help-inline').text("계절을 선택하세요");
			return false;
		}
		
		if(typeof checkList.topBottom() === 'undefined') {
			$('#top-bottom').addClass('error');
			$('#top-bottom').find('.help-inline').show();
			$('#top-bottom').find('.help-inline').text("상의/하의를 선택하세요");
			return false;
		}
		
		$('#years-form').val(checkList.years());
		$('#season-form').val(checkList.season());
		$('#top-bottom-form').val(checkList.topBottom());
		
		return true;
	};
	
	
	$years_
	.focus(function() {
		$helpInline.hide();
		$years_.next().show();
	})
	.bind('mouseup change keyup', function() {
		var $message = $years_.next();
		var $controlGroup = $message.parents('.control-group').removeClass('error success');
		
		if($years_.val().match(patterns.years)){
			$message.text('올바르게 입력하셨습니다.');
			$controlGroup.addClass('success');
		}
		else if ($years_.val() === ''){
			$message.text('숫자를 입력해주세요.');
			$controlGroup.addClass('error');
		}
		else {
			$message.text('1000 - 2999 사이의 값을 입력해주세요.');
			$controlGroup.addClass('error');
		}
	})
	.blur(function() {
		$helpInline.hide();
	});	

	
	$('#confirm-form').submit(function() {
		return checkValues();
	});
	$('#submit').click(function() {			
		$('#confirm-form').submit();
	});
	

});
	
