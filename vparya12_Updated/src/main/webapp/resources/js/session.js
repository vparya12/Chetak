// To call login controller
var signupEmailFlag = false;
var signupPasswordFlag = false;
signupConfirmPassowrd = false;

var loginUser = function(){
	var loginData ={};
	loginData["username"]=$("#username").val();
	loginData["password"]=$("#password").val();
	$.ajax({
		type: 'POST',
		url:  prefix + '/createSession',
		data: JSON.stringify(loginData),
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		timeout: 100000,
		async: true,
		success: function(result) {
			if(result.session){
				if(result.userName!=null){
					$("#loggedUser").text(result.userName)
					$("#loggedUser").append('<a href="www.vparya12.com" onclick="return logout();">Logout</a>');
				}
				closeOpenForm('loginForm','loginOverlay',this);
				$(".success").text(result.data);
			}else{
				$(".error").text("Login Failed!");
			}
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.status + ' ' + jqXHR.responseText);
		}
   });
	
}

//To call signup controller
var signupUser = function(){
	var token = $('input[name="_csrfToken"]').val();
    $.ajaxSetup({
        beforeSend: function(xhr) {
            xhr.setRequestHeader("X-CSRF-TOKEN", token);
        }
    });
	if(userNameFlag && signupEmailFlag && mobileNumberFlag && signupPasswordFlag){
		var userData ={};
		userData["userName"]=$("#signupUserName").val();
		userData["mobileNumber"]=$("#signupMobileNumber").val();
		userData["emailId"]=$("#signupEmailId").val();
		userData["password"]=$("#signupPassword").val();
		userData["gender"]=$('input[name=gender]:checked').val();
		$.ajax({
			type: 'POST',
			url:  prefix + '/signup',
			data: JSON.stringify(userData),
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			timeout: 100000,
			async: true,
			success: function(result) {
				if(result.statusCode==200){
					$("#signupOverlay").css("display","none");
					$(".success").text(result.data);
				}else{
					$(".error").text("Signup Failed!")
				}
			},
			error: function(jqXHR, textStatus, errorThrown) {
				alert("Please Try Again");
			}
	   });
	}else{
		$(".error").text("Please fill form correctly.");
	}
}

var logout = function(){
	$.ajax({
		type: 'GET',
		url:  prefix + '/logout',
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		timeout: 100000,
		async: true,
		success: function(result) {
			if(result.session){
				$(".success").text("Unable to logout!");
			}else{
				$(".success").text(result.data);
				window.location="/vparya12/welcome"
			}
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert("Sorry! Please try again.");
		}
   });
	return false;
}


//var openLoginForm = function (){
//	$.ajax({
//		type: 'GET',
//		url:  prefix + '/login',
//		dataType: 'json',
//		contentType: 'application/json; charset=utf-8',
//		timeout: 100000,
//		async: true,
//		success: function(result) {
//			openLoginPage();
//			if(result.session){
//				$(".success").text(result.data);
//				closeOpenForm();
//			}else{
//				$(".error").text(result.data);
//			}
//		},
//		error: function(jqXHR, textStatus, errorThrown) {
//			alert("Sorry! Please try again.");
//		}
//   });
//	return false;
//}