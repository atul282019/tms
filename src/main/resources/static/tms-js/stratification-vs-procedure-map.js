
function schemeChange() {
	$("#statecode").val('').trigger('change');
	$("#stratificationcode").val('').trigger('change');
	$("#procedureid").val('').trigger('change');
}

function getStratificationForProcedureMapByState() {
	var schemeid = document.getElementById("schemeid").value;
	var statecode = document.getElementById("statecode").value;
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getStratificationForProcedureMapByState",
		data: {
			"schemeid": schemeid,
			"statecode": statecode,
		},
		success: function(data) {
			newData = data;
			$("#stratificationcode option").remove();
			var obj = jQuery.parseJSON(data);
			obj = obj.data;
			var x = document.getElementById("stratificationcode");
			var option = document.createElement("option");
			option.text = "Select Stratification";
			option.value = "";
			x.add(option);

			for (var key in obj) {
				var values = obj[key];
				var option = document.createElement("option");
				option.text = values.stratificationdescription + ' - ' + values.stratificationdetails;
				option.value = values.stratificationcode;
				x.add(option);
			}
		},
		error: function(e) {
			//  alert('Error: ' + e);
		}
	});
}

function saveStratificationProcMapping() {

	var schemecode = document.getElementById("schemeid").value;
	var statecode = document.getElementById("statecode").value;
	var stratificationcode = document.getElementById("stratificationcode").value;
	var procedurecode = document.getElementById("procedureid").value;

	if (schemecode == "") {
		document.getElementById("schemeidError").innerHTML = "Please Select Scheme";
		document.getElementById("schemeid").focus();
		return false;
	} else {
		document.getElementById("schemeidError").innerHTML = "";
	}

	if (statecode == "") {
		document.getElementById("statecodeError").innerHTML = "Please Select State";
		document.getElementById("statecode").focus();
		return false;
	} else {
		document.getElementById("statecodeError").innerHTML = "";
	}

	if (stratificationcode == "") {
		document.getElementById("stratificationcodeError").innerHTML = "Please Select Implant";
		document.getElementById("stratificationcode").focus();
		return false;
	} else {
		document.getElementById("stratificationcodeError").innerHTML = "";
	}

	if (procedurecode == "") {
		document.getElementById("procedureidError").innerHTML = "Please Select Procedure";
		document.getElementById("procedureid").focus();
		return false;
	} else {
		document.getElementById("procedureidError").innerHTML = "";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/saveStratProcMapping",
		data: {
			"stratificationcode": stratificationcode,
			"procedurecode": procedurecode,
			"schemecode": schemecode,
			"statecode": statecode,
		},

		success: function(data) {
			offRegister();
			newData = data;
			var data1 = jQuery.parseJSON(newData);
			console.log(data1)
			if (data1.status == "SUCCESS") {
				document.getElementById("succmsg").innerHTML = "Data Saved Successfully";
				document.getElementById("succmsgdiv").style.display = "block";
				document.getElementById("failmsgDiv").style.display = "none";

				$("#schemeid").val('').trigger('change');
				$("#statecode").val('').trigger('change');
				$("#stratificationcode").val('').trigger('change');
				$("#procedureid").val('').trigger('change');

				$('#succmsgdiv').delay(5000).fadeOut(1000);

			} else if (data1.status == "FAILURE") {
				document.getElementById("failmsg").innerHTML = data1.message;
				document.getElementById("failmsgDiv").style.display = "block";
				document.getElementById("succmsgdiv").style.display = "none";
				$('#failmsgDiv').delay(5000).fadeOut(2000);
			} else {
				document.getElementById("failmsgDiv").style.display = "none";
				document.getElementById("succmsgdiv").style.display = "none";
				document.getElementById("FailedError").innerHTML = "API Gateway not respond. Please try again.";
			}
		},
		error: function(e) {
			offRegister();
			alert('Error: ' + e);
		}
	});
}


function getStratProcMapppingTableData() {
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getStratProcMapppingTableData",
		success: function(data) {
			//console.log("data--"+data)
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				offRegister();
				var data2 = data1.data;
				//console.log("Data "+ data2);
				var i = 1;
				var table = $('#stratificationVsProcedureMapping').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						{ "mData": null, render: function() { return i++; } },
						{ "mData": "stratificationcode" },
						{ "mData": "procedurecode" },
						{ "mData": "stratificationdetails" },
						{ "mData": "procedurename" },

					],

				}).buttons().container().appendTo('#stratificationVsProcedureMapping_wrapper .col-md-6:eq(0)');
			}
			else {
				var table = $('#SpecialityTable').DataTable({
				}).buttons().container().appendTo('#stratificationVsProcedureMapping_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
			offRegister();
			alert('Error: ' + e);
		}
	});

}
