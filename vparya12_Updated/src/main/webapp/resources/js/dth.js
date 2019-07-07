
//To fetch Dth data but current not in use
var getDthData = function(){
	 $.ajax({
	        type: 'GET',
	        url:  prefix + '/dths',
	        dataType: 'json',
	        timeout: 100000,
	        async: true,
	        success: function(result) {
	        	location.href = "/vparya12/ved.html"
	        	$.each(result.resultList, function(index,dth){
	        		$("#dthTable").append("<tr><td>"+dth.dthNumber+"</td></tr>");
	        	});
	        },
	        error: function(jqXHR, textStatus, errorThrown) {
	            alert(jqXHR.status + ' ' + jqXHR.responseText);
	        },
	        done: function(e){
	        	alert("Done!");
	        }
	   });
}

// To call the save controller
var saveNewDth = function(){
	if(dthNumberFlag && mobileNumberFlag && userNameFlag && altNumberFlag && amountFlag && validityFlag){
		var token = $('input[name="_csrfToken"]').val();
	    $.ajaxSetup({
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("X-CSRF-TOKEN", token);
	        }
	    });
		var dthData ={};
		dthData["dthNumber"]= $("#dthNumber").val();
		dthData["mobileNumber"]=$("#mobileNumber").val();
		dthData["network"]=$("#network").val();
		dthData["alternativeNumber"]=$("#altNumber").val();
		dthData["userName"]=$("#userName").val();
		dthData["validDays"]=$("#validity").val();
		//dthData["payment"]=$('input[name=payment]:checked').val();
		dthData["balance"] = $("#balance").val();
		dthData["rechargeAmount"]=$("#amount").val();
		$.ajax({
			type: 'POST',
			url:  prefix + '/saveDth',
			data: JSON.stringify(dthData),
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			timeout: 100000,
			async: true,
			success: function(result) {
				$("#overlay").css("display","none");
				$(".success").text(result.data);
				window.location.reload(false); 
			},
			error: function(jqXHR, textStatus, errorThrown) {
				alert(jqXHR.status + ' ' + jqXHR.responseText);
			}
	   });
	}else{
		alert("Please fill the form properly.")
	}
	
}

//to call update controller
var updateDth = function(){
		var token = $('input[name="_csrfToken"]').val();
	    $.ajaxSetup({
	        beforeSend: function(xhr) {
	            xhr.setRequestHeader("X-CSRF-TOKEN", token);
	        }
	    });
		var dthData ={};
		dthData["dthNumber"]= $("#editDthNumber").val();
		dthData["mobileNumber"]=$("#editMobileNumber").val();
		dthData["network"]=$("#editNetwork").val();
//		dthData["alternativeNumber"]=$("#editAltNumber").val();
		dthData["userName"]=$("#editUserName").val();
		dthData["validDays"]=$("#editValidity").val();
		dthData["paidBalance"]=$("#editPaidBalance").val();
		dthData["rechargeAmount"]=$("#editAmount").val();
		var id = $("#editId").val();
		dthData["id"] = id.substr(3,(id.length));
		
		$.ajax({
			type: 'POST',
			url:  prefix + '/updateDth',
			data: JSON.stringify(dthData),
			dataType: 'json',
			contentType: 'application/json; charset=utf-8',
			timeout: 100000,
			async: true,
			success: function(result) {
				$("#overlay").css("display","none");
				$(".success").text(result.data);
				window.location.reload(false); 
			},
			error: function(jqXHR, textStatus, errorThrown) {
				alert("Please Try Again!");
			},
			done: function(e){
				alert("Done!");
			}
	   });
}
//To call recharge controller
var rechargeDth = function(){
	var dthData = {};
	dthData["validDays"]=$("#editValidity").val();
	dthData["payment"]=$('input[name=editPayment]:checked').val();
	dthData["rechargeAmount"]=$("#editAmount").val();
	var id = $("#editId").val();
	dthData["id"] = id.substr(3,(id.length));
	
	$ajax({
		type: 'POST',
		url: prefix + '/rechargeDth',
		data: JSON.stringify(dthData),
		dataType: 'json',
		contentType: 'application/json; charset=utf-8',
		timeout: 100000,
		async: true,
		success: function(result){
			
		},
		error: function(jqXHR, textStatus, errorThrown) {
			alert(jqXHR.status + ' ' + jqXHR.responseText);
		},
		done: function(e){
			alert("Done!");
		}
	});
}


$(document).ready(function(){
	$("#dthTable tbody tr").click(function(event){
		$(event.target).closest("tr").each(function(){
			var id = $(this).find(".column1").text();
			var dthNumber = $(this).find(".column2").text();
			var mobileNumber = $(this).find(".column3").text();
			var userName = $(this).find(".column4").text();
			var network = $(this).find(".column5").text();
//			var altNumber = $(this).find(".column6").text();
			var last = $(this).find(".column7").text();
			var next = $(this).find(".column8").text();
			var amount = $(this).find(".column9").text();
			var validity = $(this).find(".column10").text();
			var balance = $(this).find(".column11").text();
			//puting value
    		 $("#editId").val(id);
    		 $("#editDthNumber").val(dthNumber);
      		 $("#editMobileNumber").val(mobileNumber);
      		 $("#editNetwork").val(network);
      		 $("#editUserName").val(userName);
//      		 $("#editAltNumber").val(altNumber);
      		 $("#editAmount").val(amount);
      		 $("#editValidity").val(validity);
      		 $("#editBalance").val(balance);
      		 $("#editPaidBalance").attr("placeholder","Paid Amount");
      		/*if(paid){
      			 $("#radioYes").prop("checked",true);
      		 }else{
      			 $("#radioNo").prop("checked",true);
      		 }*/
			$("#editOverlay").css("display","block");
		})
	});
});
