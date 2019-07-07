var prefix = '/vparya12';

var RestGet = function() {
        $.ajax({
        type: 'GET',
        url:  prefix + '/getButton',
        dataType: 'json',
        timeout: 100000,
        async: true,
        success: function(result) {
            alert(result.data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        },
        done: function(e){
        	alert("Done!");
        }
   });
}

var RestPut = function() {

    var JSONObject= {
        'time': Date.now(),
        'message': 'User PUT call !!!'
    };
    var mobileObj = {}
    mobileObj["mobileNumber"]=$("#mobileNumber").val();
    mobileObj["userName"]=$("#userName").val();

    $.ajax({
        type: 'PUT',
        url:  prefix + '/putButton',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(mobileObj),
        dataType: 'json',
        timeout: 100000,
        async: true,
        success: function(result) {
        	alert(result.data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        },
        done: function(e){
        	alert("Done!");
        }
    });
}

var RestPost = function() {
    var mobileObj = {};
    mobileObj["mobileNumber"]=$("#mobileNumber").val();
    mobileObj["userName"]=$("#userName").val();
    
        $.ajax({
        type: 'POST',
        url:  prefix + '/postButton',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(mobileObj),
        timeout: 100000,
        async: true,
        success: function(result) {
        	alert(result.data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        },
        done: function(e){
        	alert("Done!");
        }
    });
}

var RestDelete = function() {
    var mobileObj = {};
    mobileObj["mobileNumber"]=$("#mobileNumber").val();
    mobileObj["userName"]=$("#userName").val();
	
        $.ajax({
        type: 'DELETE',
        url:  prefix + '/deleteButton',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(mobileObj),
        timeout: 100000,
        async: true,
        success: function(result) {
        	alert(result.data);
        },
        error: function(jqXHR, textStatus, errorThrown) {
            alert(jqXHR.status + ' ' + jqXHR.responseText);
        },
        done: function(e){
        	alert("Done!")
        }
    });
}