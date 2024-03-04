
function savePackageMasterData() {
	var schemeid = document.getElementById("scheme").value;
	var state_code = document.getElementById("statecode").value;
	var spacilityid = document.getElementById("speciality").value;
	var packagecode = document.getElementById("packagecode").value;
	var packagename = document.getElementById("packageName").value;
	var packageid = document.getElementById("packageid").value;
	var alphanumeric = /^[a-z0-9\s]+$/i; // alpha number with space only
	var onlySpace = /^$|.\S+./; // only space

	if (schemeid == "") {
		document.getElementById("pacSchemeError").innerHTML = "Please Select Scheme";
		document.getElementById("pacScheme").focus();
		return false;
	} else {
		document.getElementById("pacSchemeError").innerHTML = "";
	}

	if (state_code == "") {
		document.getElementById("pacStateError").innerHTML = "Please Select State";
		document.getElementById("pacState").focus();
		return false;
	} else {
		document.getElementById("pacStateError").innerHTML = "";
	}

	if (spacilityid == "") {
		document.getElementById("specialityError").innerHTML = "Please Select Speciality";
		document.getElementById("speciality").focus();
		return false;
	} else {
		document.getElementById("specialityError").innerHTML = "";
	}

	if (packagecode == "") {
		document.getElementById("packagecodeError").innerHTML = "Please Enter Package Code";
		document.getElementById("packagecode").focus();
		return false;
	} else if (!packagecode.match(alphanumeric) || !packagecode.match(onlySpace)) {
		document.getElementById("packagecodeError").innerHTML = "Package Code Consist Special Character";
		document.getElementById("packagecode").focus();
		return false;
	} else {
		document.getElementById("packagecodeError").innerHTML = "";
	}

	if (packagename == "") {
		document.getElementById("packageNameError").innerHTML = "Please Enter Package Name";
		document.getElementById("packageName").focus();
		return false;
	} else if (!packagename.match(alphanumeric) || !packagename.match(onlySpace)) {
		document.getElementById("packageNameError").innerHTML = "Package Name Consist Special Character";
		document.getElementById("packageName").focus();
		return false;
	} else {
		document.getElementById("packageNameError").innerHTML = "";
	}
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/savePackageMasterData",
		data: {
			"state_code": state_code,
			"schemeid": schemeid,
			"spacilitycode": spacilityid,
			"packagecode": packagecode,
			"packagename": packagename,
			"packageid": packageid,
		},
		success: function(data) {
			// console.log(data);
			offRegister();
			var obj = jQuery.parseJSON(data);
			if (obj.status == "SUCCESS") {
				document.getElementById("succmsg").innerHTML = "Data Saved Successfully";
				document.getElementById("succmsgdiv").style.display = "block";
				$('#succmsgdiv').delay(5000).fadeOut(1000);
				document.getElementById("packageName").value = "";
				document.getElementById("packagecode").value = "";
				$("#scheme").val('').trigger('change');
				$("#statecode").val('').trigger('change');
				$("#speciality").val('').trigger('change');
				$('#packagecode').attr('readonly', false);
				$("#btnPackageSave").html("Submit");
				getPackageMasterData();
			} else if (obj.status == "FAILURE") {
				document.getElementById("failmsg").innerHTML = obj.message;
				document.getElementById("failmsgDiv").style.display = "block";
				$('#failmsgDiv').delay(5000).fadeOut(2000);
			} else {
				offRegister();
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			offRegister();
			alert('API Gateway not respond. Please try again.');
		}
	});
}
function editSpeciality(value) {
	var row = jQuery(value).closest('tr')
	var packageid = row[0].children[0].innerHTML;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getPackageDetailByPackageId",
		data: {
			"packageid": packageid,
		},
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				$("#scheme").select2().val(data1.data.schemeid).trigger("change");
				$("#statecode").select2().val(data1.data.state_code).trigger("change");
				$.ajax(
					{
						type: "POST",
						url: "" + $('#ctx').attr('content') + "/getSpecialityBySchemeCoceAndStateCode",
						data: {
							"schemeid": data1.data.schemeid,
							"statecode": data1.data.state_code
						},
						success: function(data) {
							offRegister();
							newData = data;
							$("#speciality option").remove();
							var obj = jQuery.parseJSON(data);
							obj = obj.data;
							var count = 0;
							for (var key in obj) {
								var values = obj[key];
								var x = document.getElementById("speciality");
								if (count == 0) {
									var option = document.createElement("option");
									option.text = "Select Speciality";
									option.value = "";
									x.add(option);
								}
								var option = document.createElement("option");
								option.text = values.specialityname;
								option.value = values.specialitycode;
								if(data1.data.spacilitycode===values.specialitycode){
									option.selected=true;									
								}
								x.add(option);

								count++;
							}
						},
						error: function(e) {

						}
					});
				document.getElementById("packagecode").value = data1.data.packagecode;
				$('#packagecode').attr('readonly', true);
				document.getElementById("packageName").value = data1.data.packagename;
				document.getElementById("packageid").value = data1.data.packageid;
				$("#btnPackageSave").html("Update");
				offRegister();
			}
			if (data1.status == "FAILURE") {
				offRegister();
			}
		},
		error: function(e) {
			offRegister();
			alert('API Gateway not respond. Please try again.');
		}
	});
}

 
 function getPackageMasterData() {
	var role=$('#role').val();
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getPackageMasterData",
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				offRegister();
				var data1 = jQuery.parseJSON(data);
				var data2 = data1.data;
				var table = $('#packageTable').DataTable({
					"destroy": true, "responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						{ "mData": "pkgid" },
						//{ "mData": "specialtycode" },
						//{ "mData": "packagecode" },
						{ "mData": "specialityname" },
						{ "mData": "packagename" },
						{ "mData": "state_name" },
						{ "mData": "status" },
						{ "mData": "approvalstatus" },
						{
							"mData": "pkgid", render: function(data2, type, row) {
								if (row.statecode === row.ustate) {
									return '<button  id="editspeciality" class="btn btn-primary custom-btn" onclick="editSpeciality(this)">Edit&nbsp;</button>';
								} else {
									return '';
								}
							}
						},
						{
							"mData": "pkgid", render: function(data2, type, row) {

								return '<button  id="deletePackage" value="' + data2 + '" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="FillPackageDialog(this.value)">Active/Inactive&nbsp;</button>';

							}
						},

						{ "mData": "scheme_name" },
						{
							"mData": "statestatus",
							"render": function(data2, type, row) {
								if (role == '96' && row.statecode === '999') {
									return 'INACTIVE';
								} else if (data2 != null && data2 != "") {
									return 'INACTIVE';
								} else {
									return 'ACTIVE';
								}
							}
						},
					],

				}).buttons().container().appendTo('#packageTable_wrapper .col-md-6:eq(0)');
			} else {
				var table = $('#packageTable').DataTable({
				}).buttons().container().appendTo('#packageTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
			offRegister();
			alert('API Gateway not respond. Please try again.');
		}
	});
}

function FillPackageDialog(value) {
	document.getElementById("deletePackage").value = value;
}

function deletePackage() {
	packageid = document.getElementById("deletePackage").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deletePackageDetailBypackageId",
		data: {
			"packageid": packageid,
		},
		success: function(data) {
			offRegister();
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				getPackageMasterData();
			}
			if (data1.status == "FAILURE") {
			}
		},
		error: function(e) {
			offRegister();
			alert('API Gateway not respond. Please try again.');
		}
	});
}