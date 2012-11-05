/*
 * 목표1. 변수로 담아둔 아이들 가변값도 받아주는지 테스트해보기.
 * 목표2, Submit 잘 작동시키기. 
 */

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
			return $('#topBottom_').find('.active').html();
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
			$('#season').find('.help-inline').text("계절을 선택하세요").css({ 'color' : '#B94A48' });			
			return false;
		}
		
		if(typeof checkList.topBottom() === 'undefined') {
			$('#top-bottom').find('.help-inline').text("상의/하의를 선택하세요").css({ 'color' : '#B94A48' });
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

	$('#submit').click(function() {	
		$('#confirm-form').submit(function() {
			return checkValues();
		});	
	});
	

});
	
