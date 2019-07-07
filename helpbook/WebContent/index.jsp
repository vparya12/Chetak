<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>helpbook</title>
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons
    ================================================== -->
<link rel="shortcut icon" href="img/favicon.ico" type="image/x-icon">
<link rel="apple-touch-icon" href="img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114.png">

<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome/css/font-awesome.css">

<!-- Scripts -->
<script src="js/jquery-3.2.0.min.js"></script>


<!-- Stylesheet
    ================================================== -->
<link rel="stylesheet" href="css/login_style.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css">
<link href='http://fonts.googleapis.com/css?family=Lato:400,700,900,300'
	rel='stylesheet' type='text/css'>
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800,600,300'
	rel='stylesheet' type='text/css'>


</head>
<body id="page-top"">
	
	
	<header id="header">
	
		<div class="intro">
		<div style="padding-left: 10px; border-bottom: 2px solid #656c6d;border-left: 2px solid #656c6d;border-right: 2px solid #656c6d;display: -webkit-flex;background:gray; padding-left: 46%; border-bottom-right-radius: 30px; border-bottom-left-radius: 30px; margin-top: 0px">
		<div style="width: auto; font-size: x-large; color: #000000; padding-top: 2px;">helpbook</div>
		<a href="#" id="login"
			style="width: auto; font-size: medium; margin-left: 400px; padding: 4px;">Login</a>
		<a href="#" id="signup"
			style="width: auto; font-size: medium; margin-left: 3px; padding: 4px;">Signup</a>
	</div>
			<div class="container">
				<div class="row">
					<div class="intro-text">
						<h1>
							Hello, I'm <span class="name">Ved Prakash Arya</span>
						</h1>
						<p>UX Designer & Backend Developer</p>
						<a href="#about" class="btn btn-default btn-lg page-scroll">Learn
							More</a>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Overlay -->
	<div style="border: 2px solid blue; opacity: 70;display: -webkit-box; height:100%;margin-top:-1390px;">
	<div id="vedLoginBox" style="border: 1px solid green; display: -webkit-box;">
		<div id="vedLogin" style="border: 2px solid green; width: 500px;height:270px; margin-top: 0%;">
			<form method="post" action="LoginServlet" class="login">
				<p>
					<label for="login">Email:</label> <input type="text" name="login"
						id="login" placeholder="example@domain.com"
						value="vparya12@gmail.com">
				</p>
				<p>
					<label for="password">Password:</label> <input type="password"
						name="password" id="password" placeholder="*********"
						value="vparya12">
				</p>
				<p class="login-submit">
					<button type="submit" class="login-button">Login</button>
				</p>
				<p style="text-align:end;">				
					<a href="#" style="color: #00a1d2;">Forgot your
						password?</a>
					<input type="reset"	name="cancel" id="LoginCancel" value="Cancel" >
				</p>
			</form>
		</div>
		</div>
		<div id="vedSignupBox" style="border:2px solid yellow;display: -webkit-box;margin-left: 25%;">
		<div id="vedSignup" style="width:500px;height:580px; margin-top: 0%;">
			<form method="post" action="RegistrationServlet" class="signup">
				<p>
					<label for="signup">First Name:</label>
					<input type="text" name="firstName" id="firstName" placeholder="First Name">
				</p>
				
				<p>
					<label for="signup">Last Name:</label>
					<input type="text" name="lastName" id="lastName" placeholder="Last Name">
				</p>
				<p>
					<label for="email">Email:</label> <input type="email"
						name="email" id="email" placeholder="Email_Id" style="width:300px;">
				</p>
				<p>
					<label for="password">Password:</label> <input type="password"
						name="password" id="password" placeholder="**********" >
				</p>
				<p>
					<label for="college">College:</label> <input type="text"
						name="college" id="college" placeholder="College Name">
				</p>
				<p>
					<label for="mobile">Mobile:</label> <input type="text"
						name="mobile" id="mobile" placeholder="Mobile Number">
				</p>
				<p>
					<label for="dob">DOB:</label> <input type="date" name="dob" id="dob">
				</p>
				<p>
					<label for="gender">Gender:</label>					
					<input type="radio"	name="gender" id="gender" value="Male" style="margin-top:12px; selected="true">Male
					<input type="radio"	name="gender" id="gender" value="Female">Female
				</p>
				<p>	<center>				
					<input type="reset"	name="cancel" id="SignupCancel" value="Cancel" style="margin-right:5%;margin-left:16%;">
					<input type="submit"name="submit" id="Register" value="Register">
					</center>
				</p>
			</form>
		</div>
		</div>
	</div>
	
</body>
<script>
	$('#login').click(function(event) {
		$("#vedSignupBox").css({
			"margin-top" : "0%",
			"margin-left" : "0%"
		});
		$("#vedLoginBox").css({
			"margin-top" : "130%",
			"margin-left" : "32%"
		});

	});
	$("#LoginCancel").click(function(event) {
		$("#vedSignupBox").css({
			"margin-top" : "0%",
			"margin-left" : "25%"
		});
		$("#vedLoginBox").css({
			"margin-top" : "0%",
			"margin-left" : "0%"
		});
		$("#vedSignupBox").css({
			"margin-top" : "0%",
			"margin-left" : "25%"
		});

	});
	
	$('#signup').click(function(event) {

		$("#vedLoginBox").css({
			"margin-top" : "0%",
			"margin-left" : "0%"
		});
		$("#vedSignupBox").css({
			"margin-top" : "110%",
			"margin-left" : "-6%"
		});


	});
	$("#SignupCancel").click(function(event) {
		$("#vedSignupBox").css({
			"margin-top" : "0%",
			"margin-left" : "0%"
		});
	});
</script>
</html>