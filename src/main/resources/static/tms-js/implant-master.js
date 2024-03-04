
function saveImplantMasterData() {
	var implantname = document.getElementById("implantname").value;
	var price = document.getElementById("price").value;
	var implantCode = document.getElementById("implantCode").value;
	var statecode = document.getElementById("statecode").value;
	var schemeid = document.getElementById("schemeid").value;
	var onlySpace = /^$|.*\S+.*/; // only space
	var alphanumeric = /^[a-z0-9\s]+$/i;
	var numberReg = /^\d+$/; // only number
	var implantid = document.getElementById("implantid").value;

	if (schemeid == "") {
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
	if (price == "") {
		document.getElementById("priceError").innerHTML = "Please Enter Price";
		document.getElementById("price").focus();
		return false;
	} else {
		document.getElementById("priceError").innerHTML = "";
	}

	if (implantname == "") {
		document.getElementById("implantnameError").innerHTML = "Please Enter Implant Name";
		document.getElementById("implantname").focus();
		return false;
	} else if (!implantname.match(alphanumeric) || !implantname.match(onlySpace)) {
		document.getElementById("implantnameError").innerHTML = "Please Enter Valid Implant Name";
		document.getElementById("implantname").focus();
		return false;
	} else {
		document.getElementById("implantnameError").innerHTML = "";
	}

	if (implantCode == "") {
		document.getElementById("implantCodeError").innerHTML = "Please Enter Implant Code";
		document.getElementById("implantCode").focus();
		return false;
	} else if (!implantCode.match(alphanumeric) || !implantCode.match(onlySpace)) {
		document.getElementById("implantCodeError").innerHTML = "Please Enter Valid Implant Code";
		document.getElementById("implantCode").focus();
		return false;
	} else {
		document.getElementById("implantnameError").innerHTML = "";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/saveImplantIDMasterData",
		data: {
			"implantname": implantname,
			"price": price,
			"implantcode": implantCode,
			"schemeid": schemeid,
			"statecode": statecode,
			"implantid": implantid,

		},
		success: function(data) {
			offRegister();
			var obj = jQuery.parseJSON(data);
			if (obj.status == "SUCCESS") {
				$('#infoOtp').html("Data Saved successfully");
				document.getElementById("succmsg").innerHTML = "Data Saved Successfully";
				document.getElementById("succmsgdiv").style.display = "block";
				$('#succmsgdiv').delay(5000).fadeOut(400);
				document.getElementById("implantname").value = "";
				document.getElementById("price").value = "";
				document.getElementById("implantCode").value = "";
				$("#schemeid").val('').trigger('change');
				$("#statecode").val('').trigger('change');
				$("#implantBtn").html("Submit");
				getImplantMasterData();
			} else if (obj.status == "FAILURE") {
				offRegister();
				document.getElementById("failmsg").innerHTML = obj.message;
				document.getElementById("failmsgDiv").style.display = "block";
				$('#failmsgDiv').delay(5000).fadeOut(400);
			} else {
				offRegister();
				document.getElementById("failmsgDiv").style.display = "none";
				document.getElementById("succmsgdiv").style.display = "none";
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			offRegister();
			alert('API Gateway not respond. Please try again.');
		}

	});
}

function getImplantMasterData() {
	var role = $('#role').val();
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getImplantIDMasterData",
		success: function(data) {
			console.log("data--" + data)
			offRegister();
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				var data2 = data1.data;
				//console.log("Data "+ data2);
				var i = 1;
				var table = $('#implantTable').DataTable({
					"destroy": true, "responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						//{"mData": null, render: function(){return i++;}   },
						{ "mData": "implantid" },
						{ "mData": "implantcode" },
						{ "mData": "implantname" },
						{ "mData": "implantprice" },
						{ "mData": "scheme_name" },
						{ "mData": "state_name" },
						{ "mData": "status" },
						{ "mData": "approvalstatus" },
						{
							"mData": "implantid", render: function(data2, type, row) {
								if (row.statecode === row.ustate) {
									return '<button  id="editImplant" value="' + data2 + '" class="btn btn-primary custom-btn" onclick="editImplant(this)">Edit&nbsp;</button>';
								} else {
									return '';
								}
							}
						},
						{
							"mData": "implantid", render: function(data2, type, row) {
								return '<button  id="deleteImplant" value="' + data2 + '" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="FillImplantDialog(this.value)">Active/Inactive&nbsp;</button>';
							}
						},
					],
				}).buttons().container().appendTo('#implantTable_wrapper .col-md-6:eq(0)');
			}
			else {
				var table = $('#implantTable').DataTable({
				}).buttons().container().appendTo('#implantTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
			offRegister();
			alert('Error: ' + e);
		}
	});
}

function editImplant(value) {
	var row = jQuery(value).closest('tr')
	var implantid = row[0].children[0].innerHTML;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getImplantMasterDetailForEditByImplantId",
		data: {
			"implantid": implantid,
		},
		success: function(data) {
			offRegister();
			console.log("data--" + data)
			var data1 = jQuery.parseJSON(data);
			console.log("data--" + data1.data);
			console.log("data--" + data1.data.packagecode);
			if (data1.status == "SUCCESS") {
				document.getElementById("implantid").value = data1.data.implantid;
				$('#implantCode').attr('readonly', true);
				$("#scheme").select2().val(data1.data.schemeid).trigger("change");
				$("#statecode").select2().val(data1.data.statecode).trigger("change");
				document.getElementById("price").value = data1.data.price;
				document.getElementById("implantname").value = data1.data.implantname;
				document.getElementById("implantCode").value = data1.data.implantcode;
				$("#implantBtn").html("Update");
			}
			if (data1.status == "FAILURE") {
				offRegister();
			}
		},
		error: function(e) {
			offRegister();
		}
	});
}


function FillImplantDialog(value) {
	document.getElementById("deleteImplant").value = value;
}
function deleteImplant() {
	implantid = document.getElementById("deleteImplant").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deleteImplantMasterByImplantId",
		data: {
			"implantid": implantid,
		},
		success: function(data) {
			offRegister();
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {

				getImplantMasterData();

			}
			if (data1.status == "FAILURE") {
			}
		},
		error: function(e) {
			offRegister();
		}
	});

}


