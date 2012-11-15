window.fbAsyncInit = function() {                                                                                                                                             
    FB.init({                                                                                                                                                                   
      appId      : '551594578199655', // App ID
      status     : true, // check login status
      cookie     : true, // enable cookies to allow the server to access the
							// session
      xfbml      : true  // parse XFBML
    });                                                                                                                                                                         
  };
  


$(document).ready(function() {	
	$('#facebook-caption').click(function () {
		var imgSource = $('#photo').attr('src');
		var message = $('#facebook-caption').val();                                                                                                                
	    FB.login(function (response) {                                                                                                                                            
	    	if (response.authResponse) {                                                                                                                                           
	    		var access_token = FB.getAuthResponse()['accessToken'];                                                                                                             
	            FB.api('https://graph.facebook.com/me/photos', 'post', {                                                                                                            
	               message: message,                                                                                                                                                
	               status: 'success',                                                                                                                                               
	               access_token: access_token,                                                                                                                                      
	               url: imgSource                                                                                     
	            }, function (response) {                                                                                                                                            
	                  if (!response || response.error) {                                                                                                                            
	                     alert('Error occured:' + response);                                                                                                                        
	                  } else {                                                                                                                                                      
	                     alert('Successfully posted on wall.');                                                                                                                     
	                  }                                                                                                                                                             
	               });                                                                                                                                                              
	         } else {                                                                                                                                                               
	            alert('Interrupted.');                                                                                                                                              
	         }                                                                                                                                                                      
	      }, { scope: 'user_photos,photo_upload,publish_stream,offline_access' });                                                                                                  
	}	
});