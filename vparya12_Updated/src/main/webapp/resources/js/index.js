var prefix = '/vparya12';

var openMobile = function() {
        $.ajax({
        type: 'GET',
        url:  prefix + '/mobiles',
        dataType: 'json',
        timeout: 100000,
        async: true,
        success: function(result) {
            alert(result.data);
            window.location.href="mobileData";
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        },
        done: function(e){
        	alert("Done!");
        }
   });
}
jQuery(document).ready(function($) {
	
	function getWelcome(){
		window.location.href="welcome";
	}
});