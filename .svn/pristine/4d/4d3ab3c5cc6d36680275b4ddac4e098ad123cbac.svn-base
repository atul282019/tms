function getStateDataUrban() {
	var vartype = "S";
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/stateMaster",
		data: {
			"modeFlag": vartype
		},
		success: function(data) {
			newData = data;
			console.log(newData);
			$("#stateid option").remove();
			var obj = jQuery.parseJSON(data);
			var count = 0;
			for (var key in obj) {
				var values = obj[key];
				var x = document.getElementById("userState");
				if (count == 0) {
					var option = document.createElement("option");
					option.text = "Select State";
					option.value = "";
					x.add(option);
				}
				var option = document.createElement("option");
				option.text = values;
				option.value = key;
				x.add(option);

				count++;
			}
		},
		error: function(e) {
			alert('Error: ' + e);
		}
	});
}

function reCaptcha() {
	var requestUri = $('#ctx').attr('content');
	document.getElementById("captcha_id").src = "" + $('#ctx').attr('content') + "/captcha";
	document.getElementById("captcha").focus();

}

function signIn() {
	var loginId = document.getElementById("loginId").value;
	var password = document.getElementById("password").value;
	var e = document.getElementById("userState");
	var checkbox = document.getElementById("exampleCheck1");
	var userState = e.value;

	if (loginId == "") {
		alert("Please Enter Login Id");
		document.getElementById("userName").focus();
		return false;
	}
	else if (password == "") {
		alert("Please Enter Password");
		document.getElementById("password").focus();
		return false;
	}
	else if (userState == "") {
		alert("Please Select State");
		document.getElementById("userState").focus();
		return false;
	}
	else if (checkbox.checked == false) {
		alert("Please Select Eligibility Criteria & Data Policy.");
		return false;
	}

	onLogin();
	document.forms[0].action = "" + $('#ctx').attr('content') + "/usrHome";
	document.forms[0].method = "post";
	document.forms[0].submit();

}  	