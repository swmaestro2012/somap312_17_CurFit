/*
	버그1. 검색 빨강파랑
	버그2. 검색 옆으로 늘어난다.
	할일1. 이미지 크기 줄이기. - 완료
	할일2. 검색구현 - 완료
	할일3. 라우트 시키기. - 완료
*/
$(document).ready(function() {
	var template = function(data){
		var tags =
			'<div class="products-container">' +
				'<a href="/dashboard/looks/' + data.id + '">' +
				'<img class="products-img" src="' + data.imageUrl + '">' +
				'<label class="products-label">'+ data.name +'</label>' +
				'</a>' +
			'</div>'
		return $('#result-contents').append(tags);		
	};
	var clearTag = function() {
		$('#result-contents').html("");
	}
	
	$('ul[id^=menu-nav]>li>a').click(function() {
		clearTag();
		var getVal = $(this).attr('data-season')
		if (typeof getVal === 'undefined'){
			var getVal = $(this).attr('data-tb');
			menuAjax({ lookType : getVal});
		}else{
			menuAjax({ season : getVal });
		}
	});

	var menuAjax = function(datas) {
		$.ajax({
			type : 'GET',
			url : '/api/looks',
			dataType: 'json',
			data : datas,
			success : function(obj) {
				$(obj).each(function(i, v) {
					if(v.code !== 2){
						console.log(v.name);
						template(v);
					}
					else if (v.code === 2){
						$('#result-contents').html("검색결과에 맞는 상품이 존재하지 않습니다.");
					}
				});
			},
			error : function() {
				alert('오류입니다..');
			}
		});		
	};
	
	
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
			"봄" : 0,
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
						
		/*
		$('#years-form').val(checkList.years());
		$('#season-form').val(checkList.season());
		$('#top-bottom-form').val(checkList.topBottom());
		*/
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
		if (checkValues()){
			clearTag();
			menuAjax({
				year : $('#years_').val(),
				season : patterns.season[selected.season()],
				lookType : patterns.topBottom[selected.topBottom()]			
			})
		}
	});	
});
	
