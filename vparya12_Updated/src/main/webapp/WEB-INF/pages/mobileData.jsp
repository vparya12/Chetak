<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBpC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%-- <meta name="_csrf" content="${_csrf.token}"> --%>
<%-- <meta name="_csrf_header" content="${_csrf.headerName}"> --%>
<!-- Stylesheet -->
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="<c:url value="/resources/img/favicon.ico"/>"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/vendor/perfect-scrollbar/perfect-scrollbar.css" />">
	<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/main.css" />">
	<link href="<c:url value="/resources/css/bootstrap.min.css" />"	rel="stylesheet">
	<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/common.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/mobile.css" />" rel="stylesheet">

<!-- Script -->
<!--===============================================================================================-->
<script type="text/javascript"	src="<c:url value="/resources/js/jquery-3.2.0.min.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/common.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/session.js"/>"></script>
<script type="text/javascript"	src="<c:url value="/resources/js/mobile.js"/>"></script>

<title>Tracker</title>
</head>
<body>
<!-- Overlay -->
<div id="newOverlay">
	<div id="commonForm">
	<div id="borderDiv">New Form</div>
	<hr>
		<%@include file="html/mobileNewForm.html" %>
	</div>
</div>
<div id="editOverlay">
	<div id="commonForm">
	<div id="borderDiv">Update Form</div>
	<hr>
		<%@include file="html/mobileUpdateForm.html" %>
	</div>
</div>
<!-- Header -->
<div>
	<div id="header" class="navbar-fixed-top text-center text-primary"><p>Recharge Tracker</p></div>
	<div class="text-right navbar-fixed-top text-primary" id="loggedUser">
		<c:url value="J_Spring_Security_Logout" var="logoutUrl"/>
		<form method="Post" action="${logoutUrl}" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" >
		</form>
		<c:if test="${pageContext.request.userPrincipal.name!=null}">
			<h4 style="display: contents;">Welcome </h4> : ${pageContext.request.userPrincipal.name} |
			<a href="javascript:formSubmit()">Logout</a>
		</c:if>
	</div>
</div>
<!-- Heading 2 -->
<div class="text-center" id="container">
	<div class="mobile success"></div>
<!-- Data Div -->
	<div class="text-center" id="dataBox" style="display:initial;">
		<div>
			<img class="imgDthButton" src="<c:url value="/resources/img/dth.PNG" />" width="7%" onclick="location.href='/vparya12/dths'"/>
			<img class="imgNewButton" src="<c:url value="/resources/img/new.jpg" />" width="7%" onclick='openNewForm()'/>
		</div>
		<div class="text-center dataBox">
			<div class="table100 ver5 m-b-110">
				<div class="table100-head">
					<table>
						<thead>
							<tr class="row100 head">
								<th class="cell100 column1">Customer Id</th>
								<th class="cell100 column3">Mobile Number</th>
								<th class="cell100 column4">Name</th>
								<th class="cell100 column5">Network</th>
								<th class="cell100 column6">Alt Number</th>
								<th class="cell100 column7">Last R. Date</th>
								<th class="cell100 column8">Next R. Date</th>
								<th class="cell100 column9">R. Amount</th>
								<th class="cell100 column10">Validity</th>
								<th class="cell100 column11">Balance</th>
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
								<%@include file="html/mobileDataList.html" %>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- Footer -->
<div id="footer" class="navbar-fixed-bottom text-center">
<marquee behavior="alternate"><div>&#9993; : vparya12@gmail.com | &#x260E; : 09465104676 </div>
</marquee>
&copy;Ved Prakash Arya
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