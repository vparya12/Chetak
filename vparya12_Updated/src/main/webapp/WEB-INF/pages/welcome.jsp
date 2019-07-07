<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Tracker</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<!-- Stylesheet -->
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value="/resources/images/icons/logo.ico"/>"/>
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">

<!-- Script -->
<!--===============================================================================================-->
	<script type="text/javascript" src="<c:url value="/resources/js/jquery-3.2.0.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/common.js"/>"></script>
	<script type="text/javascript" src="<c:url value="/resources/js/session.js"/>"></script>

</head>
<body>
<!-- Overlay -->
<c:if test="${not empty login}">
<div id="loginOverlay">
Hi Ved
	<div id="commonForm" class="text-center">
	<div id="borderDiv">Login</div>	
	<hr>
		<%@include file="html/loginForm.html" %>
	</div>
</div>
</c:if>
<div id="signupOverlay">
	<div id="commonForm" class="text-center">	
		<div id="borderDiv">Signup</div>
		<hr>
		<%@include file="html/signupForm.html" %>
	</div>
</div>
<!-- Header -->
<div>
	<div id="header" class="navbar-fixed-top text-center text-primary">
		<p>Recharge Tracker</p>
	</div>
	<div class="text-right navbar-fixed-top text-primary" id="loggedUser">
		<c:url value="J_Spring_Security_Logout" var="logoutUrl"/>
		<form method="Post" action="${logoutUrl}" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		</form>
		<c:if test="${pageContext.request.userPrincipal.name!=null}">
			<h4 style="display: contents;">Welcome </h4>: ${pageContext.request.userPrincipal.name} |
			<a href="javascript:formSubmit()">Logout</a>
		</c:if>
		<c:if test="${pageContext.request.userPrincipal.name==null}">
			<a href="/vparya12/login">Login</a> |
			<a href="javascript:openSignupForm();">Register</a>
		</c:if>
	</div>
</div>
<!-- Heading 2 -->
<div class="text-center" id="container">
	<div class="success">
		<c:if test="${not empty msg}"> ${msg} </c:if> 
	</div>
		<div class="error">
		<c:if test="${not empty err}"> ${err} </c:if> 
	</div>
</div>
<div id="mainContainer">
	<!-- DTH Data -->
	<div class="text-center dataBox" id="dthDataBox">
		<div>
			<img class="imgDthButton" src="<c:url value="/resources/img/dth.PNG" />" width="7%" onclick="location.href='/vparya12/dths'"/>
		</div>
		<div class="text-center">
		<!-- ===========================================Dth======================================== -->
			<div class="table100 ver5 m-b-110">
				<div class="table100-head">
					<table>
						<thead>
							<tr class="row100 head">
								<th class="cell100 column1">Customer Id</th>
								<th class="cell100 column2">DTH Number</th>
								<th class="cell100 column3">Mobile Number</th>
								<th class="cell100 column4">Name</th>
								<th class="cell100 column5">Network</th>
								<th class="cell100 column7">Last R. Date</th>
								<th class="cell100 column8">Next R. Date</th>
								<th class="cell100 column9">R. Amount</th>
								<th class="cell100 column12">Days Left</th>
							</tr>
						</thead>
					</table>
				</div>

				<div class="table100-body js-pscroll">
					<table id="dthTable">
						<tbody>
							<c:forEach items="${dthList}" var="dth">
								<tr class="row100 body">
									<td class="cell100 column1">ATM ${dth.id}</td>
									<td class="cell100 column2">${dth.dthNumber}</td>
									<td class="cell100 column3">${dth.mobileNumber}</td>
									<td class="cell100 column4">${dth.userName}</td>
									<td class="cell100 column5">${dth.network}</td>
									<td class="cell100 column7">${dth.lastRechargedDate}</td>
									<td class="cell100 column8">${dth.nextRechargeDate}</td>
									<td class="cell100 column9">${dth.rechargeAmount}</td>
									<td class="cell100 column12">${dth.remainingDays}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- Mobile Data -->
	<div class="text-center dataBox" id="mobileDataBox">
		<div>
			<img class="imgMobileButton" src="<c:url value="/resources/img/mobile.PNG" />" width="4%" onclick="location.href='/vparya12/mobiles'"/>
		</div>
		<div class="text-center">
		<!-- ===========================================Mobile======================================== -->
			<div class="table100 ver5 m-b-110">
				<div class="table100-head">
					<table>
						<thead>
							<tr class="row100 head">
								<th class="cell100 column1">Customer Id</th>
								<th class="cell100 column3">Mobile Number</th>
								<th class="cell100 column4">Name</th>
								<th class="cell100 column5">Network</th>
								<th class="cell100 column7">Last R. Date</th>
								<th class="cell100 column8">Next R. Date</th>
								<th class="cell100 column9">R. Amount</th>
								<th class="cell100 column12">Days Left</th>
							</tr>
						</thead>
					</table>
				</div>
	
				<div class="table100-body js-pscroll">
					<table id="mobileTable">
						<tbody>
							<c:forEach items="${mobileList}" var="mobile">
							<tr class="row100 body">
								<td class="cell100 column1">ATM ${mobile.id}</td>
								<td class="cell100 column3">${mobile.mobileNumber}</td>
								<td class="cell100 column4">${mobile.userName}</td>
								<td class="cell100 column5">${mobile.network}</td>
								<td class="cell100 column7">${mobile.lastRechargedDate}</td>
								<td class="cell100 column8">${mobile.nextRechargeDate}</td>
								<td class="cell100 column9">${mobile.rechargeAmount}</td>
								<td class="cell100 column12">${mobile.remainingDays}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Fooetr -->
<div id="footer" class="navbar-fixed-bottom text-center">
<marquee behavior="alternate"><div>&#9993; : vparya12@gmail.com | &#x260E; : 09465104676 </div></marquee>
&copy; Ved Prakash Arya
</div>
<!--===============================================================================================-->	
<script src="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.min.js"/>"></script>
<script>
	$('.js-pscroll').each(function(){
		var ps = new PerfectScrollbar(this);

		$(window).on('resize', function(){
			ps.update();
		})
	});
</script>
</body>
</html>