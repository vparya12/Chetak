var prefix = '/vparya12';

var dthNumberFlag = false;
var mobileNumberFlag = false;
var networkFlag = true;
var userNameFlag = false;
var altNumberFlag = false;
var amountFlag = false;
var validityFlag = false;
var paymentFlag = false;

var checkNumber= function(data){
	var reg = /^\d+$/;
	if(data==null || data==""){
		return false;
	}else{
		if(reg.test(data)){
			return true;
		}else{
			return false;
		}
	}
}

var checkAlphabets= function(){
	var reg = /^[a-zA-Z]*$/;
	var data = $("#network").val();
	if(reg.test(data)){
		return true;
	}else{
		return false;
	}
}

function countDigits(data){
	if(data.length==10){
		return true;
	}else{
		return false;
	}
}

var validateDthNumber = function(tagId,object){
	var data = $("#"+tagId).val();
	if(checkNumber(data)){
		if(data.length==16){
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
			dthNumberFlag = true;
		}else{
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
			return false;
		}
	}else{
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}
}

var validateMobileNumber= function(tagId,object){
	var data = $("#"+tagId).val();
	if(checkNumber(data)){
		if(countDigits(data)){
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
			mobileNumberFlag = true;
		}else{
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
			return false;
		}
	}else{
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}
}
var validateNetwork= function(tagId,object){
	var data = $("#"+tagId).val();
	if(data.length==0){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
		return false;
	}else{
		if(checkAlphabets()){
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
			networkFlag= true;
		}else{
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
			return false;
		}
	}
}
var validateAltNumber = function(tagId,object){
	var data = $("#"+tagId).val();
	if(data.length==0 || data==0){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
		altNumberFlag = true;
	}else{
		if(checkNumber(data)){
			if(countDigits(data)){
				$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
				altNumberFlag = true;
			}else{
				$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
				return false;
			}
		}else{
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
			return false;
		}
	}
}
var validateUserName= function(tagId,object){
	var data = $("#"+tagId).val();
	if(data.length==0){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}else{
		if(checkAlphabets()){
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
			userNameFlag = true;
		}else{
			$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
			return false;
		}
	}
}
var validateAmount= function(tagId,object){
	var data = $("#"+tagId).val();
	if( checkNumber(data)){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
		amountFlag = true;
	}else{
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}
}
var validateValidity= function(tagId,object){
	var data = $("#"+tagId).val();
	if( checkNumber(data)){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
		validityFlag = true;
	}else{
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}
}

var checkEmailId = function(tagId,object){
	var email = $("#"+tagId).val();
	var at="@";
	var dot=".";
	var lat=email.indexOf(at);
	var lstr=email.length;
	var ldot=email.indexOf(dot);
	var flag = true;
	if (email.indexOf(at)==-1 || email.indexOf(at)==0 || email.indexOf(at)==lstr || email.indexOf(dot)==-1 || email.indexOf(dot)==0 || email.indexOf(dot)!=(lstr-4)){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}else{
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
		signupEmailFlag = true;
	}
}

var checkPassword = function(tagId,object){
	var pass = $("#"+tagId).val();
	//Minimum eight characters, at least one letter and one number:
	// "^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{8,}$" ;
	//Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:
	// "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$"
	//-->Minimum eight characters, at least one letter, one number and one special character:
	//var reg = "^(?=.*[A-Za-z])(?=.*\d)(?=.*[$@$!%*#?&])[A-Za-z\d$@$!%*#?&]{8,}$"
	var reg = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	if(reg.test(pass)){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
		signupPasswordFlag= true;
	}else{
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}
}
/*
var checkConfirmPassword = function(tagId,object){
	var pass = $("#"+tagId).val();
	var reg = /^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,16}$/;
	if(reg.test(pass)){
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/checked.gif)");
		signupConfirmPasswordFlag= true;
		matchPassword();
	}else{
		$("#"+tagId).css("background-image","url(/vparya12/resources/img/unchecked.gif)");
		return false;
	}
}*//*
var matchPassword = function(){
	var pass1 =$("#signupPassword").val();
	var pass2 =$("#signupConfirmPassword").val();
	if(pass1===pass2 && signupPassword && signupConfirmPassowrd){
		signupPasswordFlag=true;
	}else{
		signupPasswordFlag = false;
	}
}*/
//To close New Mobile Form
var closeOpenForm = function(formId,divId,object){
	/*$("#"+formId+" form img").attr("src","");
	$("#resetButton").click();*/
	$(":reset").click();
	$("#"+divId).css("display","none");
}

//To Open Form
var openNewForm = function(){
	$("#newOverlay").css("display","block");
	$(":reset").click();
}

var openLoginForm = function(){
	$("#loginOverlay").css("display","block");
	$(":reset").click();
	
}

var openSignupForm = function(){
	$("#signupOverlay").css("display","block");
	$(":reset").click();
}

function formSubmit(){
	document.getElementById("logoutForm").submit();
}

$(document).ready(function(){
	$("#header p").click(function(){
		window.location = '/vparya12/welcome';
	})
	
	$("#dthTable tbody tr").each(function(){
		var days = $(this).find(".column12").text();
		if(days<0){
			$(this).css("color","#f8d9d9");
		}
	});
});
