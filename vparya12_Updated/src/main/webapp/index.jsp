<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBpC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>
		Tracker
	</title>
<meta>
<!-- Stylesheet -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
</head>

<body background="<c:url value="/resources/img/background.jpg" />" onload="javascript:progress();">
<h2></h2>
<div class="text-center">
	<h3>Recharge Tracker</h3>
	<div class="text-left" style="margin:2% auto;font-size: 16px;color: #F8F0BB;width:50%;">
	It is an web appliction to keep track all recharge details.
	It has following features.
		<ul>
		<li>Signup :- Register yourself before using this to enable all features.</li> 
		<li>Login :- Login with same credential.</li>
		<li>Add New :- Authorized user can add new records in any category i.e Mobile or DTH</li>
		<li>Update Record :- Authorized user can update any old/wrong records.</li>
		<li>Recharge :- Any valid user can easily directed to recharge site with all pre-loaded data.</li>
		<li>Recharge and History facility will come in version 2.0
		</ul>
	</div>
	<div id="developer" class="text-center">
		<img class="img-circle" alt="Developer" src="<c:url value="/resources/img/developer.PNG" />">
	</div>
	<div id="myProgress">
  		<div id="myBar">10%</div>
  		<div class="text-left" style="margin:2% auto;font-size: 16px;color: #1c1c1e;width:70%;">
  		&#9993; : <a href="https://www.google.com/gmail/about/" style="color: #1c1c1e;" target="_blank">vparya12@gmail.com</a>
		<br>&#x260E; : 09465104676
		</div>
	</div>
</div>
<!-- Fooetr -->
<div id="footer" class="navbar-fixed-bottom text-center">
&copy; Ved Prakash Arya</div>
</body>
<script>
function progress() {
    var bar = document.getElementById("myBar");
    var width = 10;
    var id = setInterval(frame, 50);
    function frame() {
        if (width >= 100) {
            clearInterval(id);
            window.location = '/vparya12/welcome';
        } else {
            width++;
            bar.style.width = width + '%';
            bar.innerHTML = width * 1 + '%';
        }
    }
}
</script>
</html>
