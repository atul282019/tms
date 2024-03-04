function getSpeciality() {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getForPreAuthSpecialityMasterData",
		success: function(data) {
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
				x.add(option);
				count++;
			}
		},
		error: function(e) {
			alert('Error: ' + e);
		}
	});
}

function primaryPreAuthDiagnose() {
	var txnid = document.getElementById("txnid").value;
	var primaryDiagnosis = document.getElementById("primaryDiagnosis").value;
	var icdCode = document.getElementById("pidcCodee").value;

	if (primaryDiagnosis == "") {
		document.getElementById("primaryDiagnosisError").innerHTML = "Please Enter Primary Diagnosis.";
		document.getElementById("primaryDiagnosis").focus();
		return false;
	} else {
		document.getElementById("primaryDiagnosisError").innerHTML = "";
	}

	if (icdCode == "") {
		document.getElementById("picdCodeError").innerHTML = "Please Select ICD Code";
		document.getElementById("pidcCodee").focus();
		return false;
	} else {
		document.getElementById("picdCodeError").innerHTML = "";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchPrimaryDiagnosis",
		data: {
			"txnid": txnid,
			"icdCode": icdCode,
			"icdDesc": primaryDiagnosis
		},
		success: function(response) {
			offRegister()
			newData = response;
			var data1 = jQuery.parseJSON(newData);
			var data2 = data1.data;
			if (data1.message == "SUCCESS") {

				$('#primarydaignoseData').DataTable({
					"responsive": true,
					"lengthChange": true,
					"autoWidth": false,
					"paging": false,
					"destroy": true,
					"searching": false,
					"lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "icdDesc" },
						{ "mData": "icdCode" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteDaignoseData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
				document.getElementById("primaryDiagnosis").value = "";
				$("#pidcCodee").val('').trigger('change');
			} else if (data1.message == "FAILURE") {
				document.getElementById("pdiagnosisfailmsg").innerHTML = newData.message;
				document.getElementById("pdiagnosisFailmsgDiv").style.display = "block";
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}
	});
}

function getDaignoseData() {
	var txnid = document.getElementById("txnid").value;
	if ($.fn.DataTable.isDataTable('#primarydaignoseData')) {
    	$("#primarydaignoseData").dataTable().fnClearTable();
		$("#primarydaignoseData").dataTable().fnDraw();
		$("#primarydaignoseData").dataTable().fnDestroy();
	}
	$('#primarydaignoseData tbody').empty();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getPrimaryDaignoseData",
		data: {
			"txnid": txnid
		},
		success: function(data) {
			newData = data;
			var data1 = jQuery.parseJSON(newData);
			var data2 = data1.data;
			if (data2.length != 0 && data1.message == "SUCCESS") {
				$('#primarydaignoseData').DataTable({
					"responsive": true,
					"lengthChange": true,
					"autoWidth": false,
					"paging": false,
					"searching": false,
					"lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, "info": false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "icdDesc" },
						{ "mData": "icdCode" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteDaignoseData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else if (data1.message == "FAILURE") {
				alert('Api not Responding, Please try Again Later..!');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function deleteDaignoseData(deleteDaignoseData) {
	const myArray = deleteDaignoseData.split("^^");
	var txnid = myArray[0];
	var tempId = myArray[1];
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deletePrimaryDaignoseData",
		data: {
			"txnid": txnid,
			"tempId": tempId,
		},
		success: function(data) {
			newData = data;
			var data1 = jQuery.parseJSON(newData);
			var data2 = data1.data;
			if (data2.length != 0 && data1.message == "SUCCESS") {
				$('#primarydaignoseData').DataTable({
					"responsive": true,
					"lengthChange": true,
					"autoWidth": false,
					"paging": false,
					"destroy": true,
					"searching": false,
					"lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "icdDesc" },
						{ "mData": "icdCode" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteDaignoseData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function secondaryPreAuthDiagnose() {
	var txnid = document.getElementById("txnid").value;
	var secondaryDiagnosis = document.getElementById("secondaryDiagnosis").value;
	var icdCode = document.getElementById("idcCodee").value;

	if (secondaryDiagnosis == "") {
		document.getElementById("secondaryDiagnosisError").innerHTML = "Please Enter Secondary Diagnosis.";
		document.getElementById("secondaryDiagnosis").focus();
		return false;
	} else {
		document.getElementById("secondaryDiagnosisError").innerHTML = "";
	}

	if (icdCode == "") {
		document.getElementById("icdCodeError").innerHTML = "Please Select ICD Code";
		document.getElementById("idcCodee").focus();
		return false;
	} else {
		document.getElementById("icdCodeError").innerHTML = "";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchSecondaryDiagnosis",
		data: {
			"txnid": txnid,
			"icdCode": icdCode,
			"icdDesc": secondaryDiagnosis
		},
		success: function(response) {
			offRegister()
			newData = response;
			var data1 = jQuery.parseJSON(newData);
			var data2 = data1.data;
			if (data1.message == "SUCCESS") {
				$('#secondarydaignoseData').DataTable({
					"responsive": true,
					"lengthChange": true,
					"autoWidth": false,
					"paging": false,
					"destroy": true,
					"searching": false,
					"lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "icdDesc" },
						{ "mData": "icdCode" }, {
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteSecondaryDaignoseData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
				document.getElementById("secondaryDiagnosis").value = "";
				$("#idcCodee").val('').trigger('change');
			} else if (data1.message == "FAILURE") {
				document.getElementById("sdiagnosisfailmsg").innerHTML = newData.message;
				document.getElementById("sdiagnosisFailmsgDiv").style.display = "block";
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}
	});
}



function getSecondaryDaignoseData() {
	var txnid = document.getElementById("txnid").value;
	if ($.fn.DataTable.isDataTable('#secondarydaignoseData')) {
    	$("#secondarydaignoseData").dataTable().fnClearTable();
		$("#secondarydaignoseData").dataTable().fnDraw();
		$("#secondarydaignoseData").dataTable().fnDestroy();
	}
	$('#secondarydaignoseData tbody').empty();
	
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getSecondaryDaignoseData",
		data: {
			"txnid": txnid
		},
		success: function(data) {
			newData = data;
			var data1 = jQuery.parseJSON(newData);
			var data2 = data1.data;
			if (data2.length != 0 && data1.message == "SUCCESS") {
				$('#secondarydaignoseData').DataTable({
					"bDestroy": true,
					"responsive": true,
					"lengthChange": true,
					"autoWidth": false,
					"paging": false,
					"searching": false,
					"lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, "info": false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "icdDesc" },
						{ "mData": "icdCode" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteSecondaryDaignoseData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else if (data1.message == "FAILURE") {
				alert('Api not Responding, Please try Again Later..!');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function deleteSecondaryDaignoseData(deleteDaignoseData) {
	const myArray = deleteDaignoseData.split("^^");
	var txnid = myArray[0];
	var tempId = myArray[1];
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deleteSecondaryDaignoseData",
		data: {
			"txnid": txnid,
			"tempId": tempId,
		},
		success: function(data) {
			newData = data;
			var data1 = jQuery.parseJSON(newData);
			var data2 = data1.data;
			if (data2.length != 0 && data1.message == "SUCCESS") {
				$('#secondarydaignoseData').DataTable({
					"responsive": true,
					"lengthChange": true,
					"autoWidth": false,
					"paging": false,
					"destroy": true,
					"searching": false,
					"lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "icdDesc" },
						{ "mData": "icdCode" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteSecondaryDaignoseData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function checkAddDocAdminssionDetail() {
	var allowedFiles = [".pdf"];
	var fileUpload = document.getElementById("file").value;
	var lblError = document.getElementById("lblError");
	var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
	var fileInput = document.getElementById("file");
	if (!regex.exec(fileUpload)) {
		lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
		document.getElementById("file").value = "";
		return false;
	} else if (fileInput.files[0].size > (1024 * 1024)) {
		document.getElementById("lblError").innerHTML = "File Size must be Less Than 2 MB";
		document.getElementById("file").value = "";
		return false;
	} else {
		lblError.innerHTML = "";
		return true;
	}
}

function addDocAdminssionDetail() {
	var allowedFiles = [".pdf"];
	var fileUpload = document.getElementById("file").value;
	var lblError = document.getElementById("lblError");
	var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
	var fileInput = document.getElementById("file");
	if (!regex.exec(fileUpload)) {
		lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
		document.getElementById("file").value = "";
		return false;
	} else if (fileInput.files[0].size > (1024 * 1024)) {
		document.getElementById("lblError").innerHTML = "File Size must be Less Than 2 MB";
		document.getElementById("file").value = "";
		return false;
	} else {
		lblError.innerHTML = "";
	}
	onRegister();

	var formData = new FormData(admissionDocUpload);
	formData.append("adddocFile", file.files[0]);
	formData.append("documenttxt", $('#documentid option:selected').text());
	formData.append("txnId", $('#txnid').val());

	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/admission_upload_and_process",
		data: formData,
		processData: false,
		contentType: false,
		success: function(data) {
			offRegister()
			newData = data;
			var data2 = newData.data;
			console.log("txnid" + data2)
			document.getElementById("admissionDocUpload").reset();
			if (data2.length != 0 && newData.message == "SUCCESS") {
				$("#addDocAdminssionDetailData").dataTable().fnClearTable();
				$("#addDocAdminssionDetailData").dataTable().fnDraw();
				$("#addDocAdminssionDetailData").dataTable().fnDestroy();
				$('#addDocAdminssionDetailData').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "paging": false, "searching": false, "lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "documenttxt" },
						{ "mData": "documentname" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnId + '^^' + data2.tempId + '"  onclick="deleteadmissionFile(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else if (newData.message == "FAILURE") {
				alert('Api not Responding, Please try Again Later..!');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function deleteadmissionFile(deleteDaignoseData) {
	const myArray = deleteDaignoseData.split("^^");
	var txnid = myArray[0];
	var tempId = myArray[1];
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deleteAdmissionFileData",
		data: {
			"txnid": txnid,
			"tempId": tempId,
		},
		success: function(data) {
			newData = data;
			if (newData == "SUCCESS") {
				$("#addDocAdminssionDetailData").dataTable().fnClearTable();
				$("#addDocAdminssionDetailData").dataTable().fnDraw();
				$("#addDocAdminssionDetailData").dataTable().fnDestroy();
				window.setTimeout(function() { getAdmissionFileData(txnid) }, 100);
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function getAdmissionFileData(txnid) {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getAdmissionFileData",
		data: {
			"txnid": txnid
		},
		success: function(data) {
			newData = data;
			var data2 = newData.data;
			console.log("txnid" + data2)
			if (data2.length != 0 && newData.message == "SUCCESS") {
				$("#addDocAdminssionDetailData").dataTable().fnClearTable();
				$("#addDocAdminssionDetailData").dataTable().fnDraw();
				$("#addDocAdminssionDetailData").dataTable().fnDestroy();
				$('#addDocAdminssionDetailData').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "paging": false, "searching": false, "lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "documenttxt" },
						{ "mData": "documentname" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data.txnId + '^^' + data2.tempId + '"  onclick="deleteadmissionFile(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else if (newData.message == "FAILURE") {
				alert('Api not Responding, Please try Again Later..!');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}


function preAuthTreatmentProtocal() {

	var txnid = document.getElementById("txnid").value;
	var patientId = document.getElementById("patientId").value;
	var procedureid = document.getElementById("procedureid").value;
	var speciality = document.getElementById("speciality").value;
	var packageid = document.getElementById("packageid").value;
	var ichiCode = document.getElementById("ichiCode").value;
	var investigationActive = $('#investigationActive option:selected').toArray().map(item => item.value).join();
	var presentIllnesHistory = document.getElementById("presentIllnesHistory").value;

	var iCode = document.getElementById("ichiCode");
	var ichiCodetxt = iCode.options[iCode.selectedIndex].text;

	var procid = document.getElementById("procedureid");
	var procedureidText = procid.options[procid.selectedIndex].text;

	var spec = document.getElementById("speciality");
	var specialityText = spec.options[spec.selectedIndex].text;

	var pckgid = document.getElementById("packageid");
	var packageidText = pckgid.options[pckgid.selectedIndex].text;

	var investigationActivetxt = $('#investigationActive option:selected').toArray().map(item => item.text).join();

	if (speciality == "") {
		document.getElementById("specialityError").innerHTML = "Please Select Specility";
		document.getElementById("speciality").focus();
		return false;
	} else {
		document.getElementById("specialityError").innerHTML = "";
	}

	if (packageid == "") {
		document.getElementById("packageidError").innerHTML = "Please Select Package";
		document.getElementById("packageid").focus();
		return false;
	} else {
		document.getElementById("packageidError").innerHTML = "";
	}

	if (procedureid == "") {
		document.getElementById("procedureidError").innerHTML = "Please Select Procedure";
		document.getElementById("procedureid").focus();
		return false;
	} else {
		document.getElementById("procedureidError").innerHTML = "";
	}

	if (ichiCode == "") {
		document.getElementById("ichiCodeError").innerHTML = "Please Select ICHI Code";
		document.getElementById("ichiCode").focus();
		return false;
	} else {
		document.getElementById("ichiCodeError").innerHTML = "";
	}


	if (jQuery("#implantdiv").css('display') == 'block') {
		if ($('#implantCode').val() == "") {
			document.getElementById("implantCodeError").innerHTML = "Please Select Implant";
			document.getElementById("implantCode").focus();
			return false;
		} else {
			document.getElementById("implantCodeError").innerHTML = "";
		}
	}

	if (jQuery("#stratdiv").css('display') == 'block') {
		if ($('#stratCode').val() == "") {
			document.getElementById("stratCodeError").innerHTML = "Please Select Stratification";
			document.getElementById("stratCode").focus();
			return false;
		} else {
			document.getElementById("stratCodeError").innerHTML = "";
		}
	}

	if ($('#fruit_name').has('option').length > 1) {
		if (investigationActive == null || investigationActiveError == "") {
			document.getElementById("investigationActiveError").innerHTML = "Please Select Investigation";
			document.getElementById("investigationActive").focus();
			return false;
		} else {
			document.getElementById("investigationActiveError").innerHTML = "";
		}
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchPreAuthTreatmentProtocal",

		data: {
			"txnid": txnid,
			"procedureid": procedureid,
			"speciality": speciality,
			"ichiCode": ichiCode,
			"packageid": packageid,
			"investigationActive": investigationActive,
			"presentIllnesHistory": presentIllnesHistory,
			"specialitytxt": specialityText,
			"packageidtxt": packageidText,
			"ichiCodetxt": ichiCodetxt,
			"procedureidtxt": procedureidText,
			"investigationActivetxt": investigationActivetxt

		},
		success: function(data) {
			offRegister()
			newData = data;
			var data2 = newData.data;
			if (newData.message == "SUCCESS") {
				$("#treatMentProtocalTable").dataTable().fnClearTable();
				$("#treatMentProtocalTable").dataTable().fnDraw();
				$("#treatMentProtocalTable").dataTable().fnDestroy();
				$('#treatMentProtocalTable').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "paging": false, "searching": false, "lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "specialitytxt" },
						{ "mData": "packageidtxt" },
						{ "mData": "procedureidtxt" },
						{ "mData": "ichiCodetxt" },
						{ "mData": "investigationActivetxt" },
						{ "mData": "price" },
						{ "mData": "stratificationstatus" },
						{ "mData": "implantstatus" },
						{ "mData": "erupistatus" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteprotoColData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}

						},
						{ "mData": "presentIllnesHistory" },
						{ "mData": "proceduretypetxt" },
						{ "mData": "procedurelabeltxt" },
						{ "mData": "inclusiveStractsText" },
						{ "mData": "inclusiveStractsCost" },
						{ "mData": "inclusiveImplantText" },
						{ "mData": "inclusiveImplantCost" },
					]
				})
				$("#speciality").val('').trigger('change');
				$("#packageid").val('').trigger('change');
				$("#procedureid").val('').trigger('change');
				$("#ichiCode").val('').trigger('change');
				$("#investigationActive").val('').trigger('change');
				document.getElementById("presentIllnesHistory").value = "";
				document.getElementById("stratificationCost").value = "";
				document.getElementById("implantCost").value = "";
				document.getElementById("implantdiv").style.display = "none";
				document.getElementById("stratdiv").style.display = "none";
				getStratMasterData();
				getImplantMasterDataByState();
				getPackageCost(txnid);
				getDocumentMasterDataBySpecPackProcCode();
				getInvestigationDocumentForProcedures();
			} else if (newData.message == "FAILURE" && data != null) {
				document.getElementById("tfailmsg").innerHTML = newData.data;
				document.getElementById("tfailmsgDiv").style.display = "block";
				$('#tfailmsgDiv').delay(5000).fadeOut(400);
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}
	});
}

//////////////////////////////////

function getProcedureForStratification() {

	var txnid = document.getElementById("txnid").value;

	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getProcedureForStratification",
		data: {
			"txnid": txnid,
		},

		success: function(data) {
			newData = data;
			console.log(newData);
			$("#stratProcCode option").remove();
			// console.log("-------"+obj);
			var count = 0;
			var x = document.getElementById("stratProcCode");

			for (let i = 0; i < newData.data.length; i++) {
				var childArray = newData.data[i].procedureidtxt;
				var childArray2 = newData.data[i].procedureid;
				if (count == 0) {
					var option = document.createElement("option");
					option.text = "Select Procedure";
					option.value = "";
					x.add(option);
				}

				var option = document.createElement("option");
				option.text = childArray;
				option.value = childArray2;
				x.add(option);
				count++;
			}
		},
		error: function(e) {
			alert('Error: ' + e);
		}
	});
}

function getProcedureForImplant() {

	var txnid = document.getElementById("txnid").value;

	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getProcedureForImplant",
		data: {
			"txnid": txnid,
		},

		success: function(data) {
			newData = data;
			console.log(newData);
			$("#implantProcCode option").remove();
			var count = 0;
			var x = document.getElementById("implantProcCode");

			for (let i = 0; i < newData.data.length; i++) {
				var childArray = newData.data[i].procedureidtxt;
				var childArray2 = newData.data[i].procedureid;
				if (count == 0) {
					var option = document.createElement("option");
					option.text = "Select Procedure";
					option.value = "";
					x.add(option);
				}

				var option = document.createElement("option");
				option.text = childArray;
				option.value = childArray2;
				x.add(option);
				count++;
			}
		},
		error: function(e) {
			alert('Error: ' + e);
		}
	});
}

function getProcedureForErupi() {

	var txnid = document.getElementById("txnid").value;

	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getProcedureForErupi",
		data: {
			"txnid": txnid,
		},

		success: function(data) {
			newData = data;
			console.log(newData);
			$("#erupiProcName option").remove();
			var count = 0;
			var x = document.getElementById("erupiProcName");

			for (let i = 0; i < newData.data.length; i++) {
				var childArray = newData.data[i].procedureidtxt;
				var childArray2 = newData.data[i].procedureid;
				if (count == 0) {
					var option = document.createElement("option");
					option.text = "Select Procedure";
					option.value = "";
					x.add(option);
				}

				var option = document.createElement("option");
				option.text = childArray;
				option.value = childArray2;
				x.add(option);
				count++;
			}
		},
		error: function(e) {
			alert('Error: ' + e);
		}
	});
}

//////////////////////////////


function getprotoColData(txnid) {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getprotoColData",
		data: {
			"txnid": txnid
		},
		success: function(data) {
			newData = data;
			var data2 = newData.data;
			if (data2.length != 0 && newData.message == "SUCCESS") {
				$("#treatMentProtocalTable").dataTable().fnClearTable();
				$("#treatMentProtocalTable").dataTable().fnDraw();
				$("#treatMentProtocalTable").dataTable().fnDestroy();
				$('#treatMentProtocalTable').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "paging": false, "searching": false, "lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "specialitytxt" },
						{ "mData": "packageidtxt" },
						{ "mData": "procedureidtxt" },
						{ "mData": "ichiCodetxt" },
						{ "mData": "investigationActivetxt" },
						{ "mData": "price" },
						{ "mData": "stratificationstatus" },
						{ "mData": "implantstatus" },
						{ "mData": "erupistatus" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnid + '^^' + data2.tempId + '"  onclick="deleteprotoColData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						},
						{ "mData": "presentIllnesHistory" },
						{ "mData": "proceduretypetxt" },
						{ "mData": "procedurelabeltxt" },
						{ "mData": "inclusiveStractsText" },
						{ "mData": "inclusiveStractsCost" },
						{ "mData": "inclusiveImplantText" },
						{ "mData": "inclusiveImplantCost" },
					]
				})
			} else if (data2.length == 0 && newData.message == "SUCCESS") {
				$("#treatMentProtocalTable").dataTable().fnClearTable();
			} else if (newData.message == "FAILURE") {
				alert('Api not Responding, Please try Again Later..!');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function deleteprotoColData(deleteprotoColData) {
	const myArray = deleteprotoColData.split("^^");
	var txnid = myArray[0];
	var tempId = myArray[1];
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deleteprotoColData",
		data: {
			"txnid": txnid,
			"tempId": tempId,
		},
		success: function(data) {
			newData = data;
			if (newData == "SUCCESS") {
				$("#daignoseData").dataTable().fnClearTable();
				$("#daignoseData").dataTable().fnDraw();
				$("#daignoseData").dataTable().fnDestroy();
				getPackageCost(txnid);
				window.setTimeout(function() { getprotoColData(txnid) }, 100);
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}


function preAuthExamination() {
	var txnid = document.getElementById("txnid").value;
	var tempretureRadio = document.getElementById("c").checked;
	var temperature = document.getElementById("temperature").value;
	var temperatureParameter;

	var option = document.getElementsByName('temperatureParameter');

	if (!(option[0].checked || option[1].checked)) {
		//alert("Please Select Temperature");
		document.getElementById("examinationError").innerHTML = "Please Select Temperature";
		document.getElementById("c").focus();
		return false;
	}
	if (temperature == "" || temperature == null) {
		//alert("Please Enter Temperature");
		document.getElementById("examinationError").innerHTML = "Please Enter Temperature";
		document.getElementById("temperature").focus();
		return false;
	}
	if (tempretureRadio == true) {
		temperatureParameter = "C";
	} else {
		temperatureParameter = "F";
	}
	var pluseRate = document.getElementById("pluseRate").value;
	var bpLt = document.getElementById("bpLt").value;
	var bpht = document.getElementById("bpht").value;
	var bpRt = document.getElementById("bpRt").value;
	var bpRth = document.getElementById("bpRth").value;
	var height = document.getElementById("height").value;
	var weight = document.getElementById("weight").value;
	var bmi = document.getElementById("bmi").value;
	var pallorradio = document.getElementById("pallor1").checked;

	if (pluseRate == "") {
		document.getElementById("examinationError").innerHTML = "Please Enter Pulse Rate";
		document.getElementById("pluseRate").focus();
		return false;
	}
	if (bpLt == "") {
		document.getElementById("examinationError").innerHTML = "Please Enter BP Lt.Arm";
		document.getElementById("bpLt").focus();
		return false;
	}
	if (bpht == "") {
		document.getElementById("examinationError").innerHTML = "Please Enter BP Lt.Arm";
		document.getElementById("bpht").focus();
		return false;
	}
	if (bpRt == "") {
		document.getElementById("examinationError").innerHTML = "Please Enter BP Rt.Arm";
		document.getElementById("bpRt").focus();
		return false;
	}
	if (bpRth == "") {
		document.getElementById("examinationError").innerHTML = "Please Enter BP Rt.Arm";
		document.getElementById("bpRth").focus();
		return false;
	}
	else {
		document.getElementById("examinationError").innerHTML = "";
	}

	var pallor;
	if (pallorradio == true) {
		pallor = "Y";
	} else {
		pallor = "N";
	}

	var cyanosisradio = document.getElementById("cyanosis1").checked;
	var cyanosis;
	if (cyanosisradio == true) {
		cyanosis = "Y";
	} else {
		cyanosis = "N";
	}

	var clubOfFingertoes;
	if (document.getElementById("cyanosis1").checked) {
		clubOfFingertoes = "Y";
	} else {
		clubOfFingertoes = "N";
	}

	var lymphadenopathy;
	if (document.getElementById("lymphadenopathy1").checked) {
		lymphadenopathy = "Y";
	} else {
		lymphadenopathy = "N";
	}

	var oedemaInFeet;
	if (document.getElementById("oedemaInFeet1").checked) {
		oedemaInFeet = "Y";
	} else {
		oedemaInFeet = "N";
	}

	var malnutrition;
	if (document.getElementById("malnutrition1").checked) {
		malnutrition = "Y";
	} else {
		malnutrition = "N";
	}

	var dehydration;
	if (document.getElementById("dehydration1").checked) {
		dehydration = "Y";
	} else {
		dehydration = "N";
	}

	var respirationRate = document.getElementById("respirationRate").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchPreAuthData",
		data: {
			"txnid": txnid,
			"temperatureParameter": temperatureParameter,
			"temperature": temperature,
			"pluseRate": pluseRate,
			"bpLt": bpLt + '/' + bpht,
			"bpRt": bpRt + '/' + bpRth,
			"height": height,
			"weight": weight,
			"bmi": bmi,
			"pallor": pallor,
			"cyanosis": cyanosis,
			"clubOfFingertoes": clubOfFingertoes,
			"lymphadenopathy": lymphadenopathy,
			"oedemaInFeet": oedemaInFeet,
			"malnutrition": malnutrition,
			"dehydration": dehydration,
			"respirationRate": respirationRate,
		},
		success: function(data) {
			offRegister();
			if (data == "SUCCESS") {
				document.getElementById("succmsg").innerHTML = "Data Saved ";
				document.getElementById("succmsgdiv").style.display = "block";
				$('.nav > .active').next('li').find('a').trigger('click');
			} else if (data == "FAILURE") {
				document.getElementById("failmsg").innerHTML = data1.message;
				document.getElementById("failmsgDiv").style.display = "block";
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}
	});
}

function preAuthPersonalHistory() {
	var txnid = document.getElementById("txnid").value;
	var appetite = document.getElementById("appetite").value;
	var diet = document.getElementById("diet").value;
	var bowels = document.getElementById("bowels").value;
	var nutrition = document.getElementById("nutrition").value;

	if (appetite == "") {
		document.getElementById("personalHistoryError").innerHTML = "Please Select Apptite";
		document.getElementById("appetite").focus();
		return false;
	}
	if (diet == "") {
		document.getElementById("personalHistoryError").innerHTML = "Please Select Diet";
		document.getElementById("diet").focus();
		return false;
	}
	if (bowels == "") {
		document.getElementById("personalHistoryError").innerHTML = "Please Select Bowels";
		document.getElementById("bowels").focus();
		return false;
	}
	if (nutrition == "") {
		document.getElementById("personalHistoryError").innerHTML = "Please Select Nutrition";
		document.getElementById("nutrition").focus();
		return false;
	}

	var knownAllergies = $('input[name="knownAllergies"]:checked').val();
	var alergictomed = $('input[name="allergic"]:checked').val();
	var alertosub = $('input[name="medicine"]:checked').val();
	if (typeof knownAllergies === "undefined") {
		document.getElementById("personalHistoryError").innerHTML = "Please Checked knownAllergies";
		document.getElementById("knownAllergies").focus();
		return false;
	}
	if (knownAllergies === "N") {
		alergictomed = "N";
		alertosub = "N";
	}

	var habit = $('input[name="habit"]:checked').val();
	if (typeof habit === "undefined") {
		document.getElementById("personalHistoryError").innerHTML = "Please Checked Habit";
		document.getElementById("habit").focus();
		return false;
	}

	var alcohol = $('input[name="alcohol"]:checked').val();
	if (typeof alcohol === "undefined") {
		alcohol = "N";
	}

	var tobacco = $('input[name="tobacco"]:checked').val();
	if (typeof tobacco === "undefined") {
		tobacco = "N";
	}

	var druguse = $('input[name="drug"]:checked').val();
	if (typeof druguse === "undefined") {
		druguse = "N";
	}

	var beetelnut = $('input[name="betel"]:checked').val();
	if (typeof beetelnut === "undefined") {
		beetelnut = "N";
	}

	var betelleaf = $('input[name="Leaf"]:checked').val();
	if (typeof betelleaf === "undefined") {
		betelleaf = "N";
	}
	if (habit === "N") {
		alcohol = "N";
		tobacco = "N"; tobacco = "N"; druguse = "N"; beetelnut = "N"; betelleaf = "N";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchPreAuthPersonalHistory",
		data: {
			"txnid": txnid,
			"appetite": appetite,
			"diet": diet,
			"bowels": bowels,
			"nutrition": nutrition,
			"knownAllergies": knownAllergies,
			"addictions": habit,
			"alergictomed": alergictomed,
			//"alergictomeddesc":alergictomeddesc,
			"alertosub": alertosub,
			// "alerttosubdesc":alerttosubdesc,
			"alcohol": alcohol,
			"druguse": druguse,
			"beetelnut": beetelnut,
			"betelleaf": betelleaf,
			/*"pack":pack,
			"years":years,*/
			"tobacco": tobacco,
		},
		success: function(data) {
			offRegister();
			if (data == "SUCCESS") {
				document.getElementById("historysuccmsg").innerHTML = "Data  Saved";
				document.getElementById("historysuccmsgdiv").style.display = "block";
				$('.nav > .active').next('li').find('a').trigger('click');
			} else if (data == "FAILURE") {
				document.getElementById("historyfailmsg").innerHTML = data1.message;
				document.getElementById("historyfailmsgDiv").style.display = "block";
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}
	});
}

function preAuthPastFamilyHistory() {
	var txnid = document.getElementById("txnid").value;
	var array = [];
	var fharray = [];

	if (document.getElementById("PH1").checked) {
		array.push("PH1");
	}

	if (document.getElementById("PH2").checked) {
		array.push("PH2");
	}

	if (document.getElementById("PH3").checked) {
		array.push("PH3");
	}

	if (document.getElementById("PH4").checked) {
		array.push("PH4");
	}

	if (document.getElementById("PH5").checked) {
		array.push("PH5");
	}

	if (document.getElementById("PH7").checked) {
		array.push("PH7");
	}

	if (document.getElementById("PH8").checked) {
		array.push("PH8");
	}

	if (document.getElementById("PH9").checked) {
		array.push("PH9");
	}

	if (document.getElementById("PH10").checked) {
		array.push("PH10");
	}

	if (document.getElementById("PH11").checked) {
		array.push("PH11");
	}

	if ($('#PH12').is(":checked")) {
		array.push("PH12");
	}

	if (document.getElementById("PH13").checked) {
		array.push("PH13");
	}

	if (document.getElementById("FH1").checked) {
		fharray.push("FH1");
	}

	if (document.getElementById("FH2").checked) {
		fharray.push("FH2");
	}

	if (document.getElementById("FH3").checked) {
		fharray.push("FH3");
	}

	if (document.getElementById("FH4").checked) {
		fharray.push("FH4");
	}

	if (document.getElementById("FH5").checked) {
		fharray.push("FH5");
	}

	if (document.getElementById("FH6").checked) {
		fharray.push("FH6");
	}

	if (document.getElementById("FH7").checked) {
		fharray.push("FH7");
	}

	if (document.getElementById("FH8").checked) {
		fharray.push("FH8");
	}

	if (document.getElementById("FH9").checked) {
		fharray.push("FH9");
	}

	if (document.getElementById("FH11").checked) {
		fharray.push("FH11");
	}

	if (document.getElementById("FH12").checked) {
		fharray.push("FH12");
	}

	var pastHistoryOthr = document.getElementById("otherifAnyHistorytxt").value;
	var familyHistoryOthr = document.getElementById("anyotherfamilyHistorytxt").value;

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchPastFamilyHistory",
		data: {
			"txnid": txnid,
			"ph": array,
			"pastHistoryOthr": pastHistoryOthr,
			"fh": fharray,
			"familyHistoryOthr": familyHistoryOthr,
		},
		success: function(data) {
			offRegister();
			if (data == "SUCCESS") {
				document.getElementById("familysuccmsg").innerHTML = "Data  Saved";
				document.getElementById("familysuccmsgdiv").style.display = "block";
				$('.nav > .active').next('li').find('a').trigger('click');
			} else if (data == "FAILURE") {
				document.getElementById("familyfailmsg").innerHTML = data1.message;
				document.getElementById("familyfailmsgDiv").style.display = "block";
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}
	});
}

function preAuthAdmissionDetails() {
	var txnid = document.getElementById("txnid").value;
	var caseType = document.getElementById("caseType").value;
	var treatmentDate = document.getElementById("treatmentDate").value;
	var admissionDt = document.getElementById("admissionDt").value;
	var remarks = document.getElementById("remarks").value;
	var patientId = document.getElementById("patientId").value;
	var autoApprovalFlag = document.getElementById("autoApprovalFlag").value;
	var enhFlag = document.getElementById("enhFlag").value;
	var isCovidCase = document.getElementById("isCovidCase").value;
	var crtUsr = document.getElementById("crtUsr").value;
	var hospGrade = document.getElementById("hospGrade").value;

	if (caseType == "") {
		document.getElementById("admissionDetailError").innerHTML = "Please Select Admission Type";
		document.getElementById("caseType").focus();
		return false;
	}

	if (treatmentDate == "") {
		document.getElementById("admissionDetailError").innerHTML = "Please Select Treatment Date";
		document.getElementById("treatmentDate").focus();
		return false;
	}

	if (admissionDt == "") {
		document.getElementById("admissionDetailError").innerHTML = "Please Select Adminssion Date";
		document.getElementById("admissionDt").focus();
		return false;
	}

	var option = document.getElementsByName('medico');
	if (!(option[0].checked || option[1].checked)) {
		document.getElementById("admissionDetailError").innerHTML = "Please Checked Medico Legal Case";
		document.getElementById("medico1").focus();
		return false;
	}

	var medicoLegalCase = $('input[name="medico"]:checked').val();
	if (typeof medicoLegalCase === "undefined") {
		document.getElementById("personalHistoryError").innerHTML = "Please Checked knownAllergies";
		document.getElementById("knownAllergies").focus();
		return false;
	}

	var firLmc = document.getElementById("firLmc").value;
	var policeStation = document.getElementById("policeStation").value;
	if (medicoLegalCase == "Y") {
		if (firLmc == "") {
			document.getElementById("admissionDetailError").innerHTML = "Please Enter Fir LMC Number";
			document.getElementById("firLmc").focus();
			return false;
		}
		if (policeStation == "") {
			document.getElementById("admissionDetailError").innerHTML = "Please Enter police Station";
			document.getElementById("policeStation").focus();
			return false;
		}
	} else {
		document.getElementById("admissionDetailError").innerHTML = "";
		firLmc = ""
		policeStation = ""
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchPreAuthAdmissionDetail",
		data: {
			"txnid": txnid,
			"patientId": patientId,
			"autoApprovalFlag": autoApprovalFlag,
			"enhFlag": enhFlag,
			"isCovidCase": isCovidCase,
			"crtUsr": crtUsr,
			"hospGrade": hospGrade,
			"caseType": caseType,
			"treatmentDate": treatmentDate,
			"admissionDt": admissionDt,
			"legalCaseCheck": medicoLegalCase,
			"legalCaseNo": firLmc,
			"policeStatName": policeStation,
			"remarks": remarks,
		},
		success: function(data) {
			offRegister();
			if (data == "SUCCESS") {
				document.getElementById("adminssionsuccmsg").innerHTML = "Data  Saved";
				document.getElementById("adminssionsuccmsgdiv").style.display = "block";
				$('.nav > .active').next('li').find('a').trigger('click');
			} else if (data == "FAILURE") {
				document.getElementById("adminssionfailmsg").innerHTML = data1.message;
				document.getElementById("adminssionfailmsgDiv").style.display = "block";
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}

	});
}


function stratificationDetails() {
	var stratCodelst = $('#stratCode').val();
	var txnid = document.getElementById("txnid").value;
	var procedureid = document.getElementById("procedureid").value;
	var speciality = document.getElementById("speciality").value;
	var packageid = document.getElementById("packageid").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchStratificationDetail",
		data: {
			"txnid": txnid,
			"speciality": speciality,
			"procedureid": procedureid,
			"packageid": packageid,
			"stratCode": stratCodelst
		},
		success: function(data) {
			offRegister();
			if (data.message == "SUCCESS") {
				$('#stratificationCost').val(data.data);
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}

	});
}

function getImplantDetailByImplantId() {
	var txnid = document.getElementById("txnid").value;
	var implantCode = $('#implantCode').val();
	var procedureid = document.getElementById("procedureid").value;
	var speciality = document.getElementById("speciality").value;
	var packageid = document.getElementById("packageid").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchImplantDetail",
		data: {
			"txnid": txnid,
			"speciality": speciality,
			"procedureid": procedureid,
			"packageid": packageid,
			"implantCode": implantCode
		},
		success: function(data) {
			offRegister();
			if (data.message == "SUCCESS") {
				$('#implantCost').val(data.data);
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}

	});
}

function checkErupiInvestigationDetail() {
	var allowedFiles = [".pdf"];
	var fileUpload = document.getElementById("invfile").value;
	var lblError = document.getElementById("investError");
	var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
	var fileInput = document.getElementById("invfile");
	if (!regex.exec(fileUpload)) {
		lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
		document.getElementById("invfile").value = "";
		return false;
	} else if (fileInput.files[0].size > (1024 * 1024)) {
		document.getElementById("investError").innerHTML = "File Size must be Less Than 2 MB";
		document.getElementById("invfile").value = "";
		return false;
	} else {
		lblError.innerHTML = "";
		return true;
	}
}

function erupiInvestigationDetail() {
	var allowedFiles = [".pdf"];
	var fileUpload = document.getElementById("invfile").value;
	var lblError = document.getElementById("investError");
	var regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
	var fileInput = document.getElementById("invfile");
	if (!regex.exec(fileUpload)) {
		lblError.innerHTML = "Please upload files having extensions: <b>" + allowedFiles.join(', ') + "</b> only.";
		document.getElementById("invfile").value = "";
		return false;
	} else if (fileInput.files[0].size > (1024 * 1024)) {
		document.getElementById("investError").innerHTML = "File Size must be Less Than 2 MB";
		document.getElementById("invfile").value = "";
		return false;
	} else {
		lblError.innerHTML = "";
	}
	onRegister();

	var formData = new FormData(investigationAttachmentDetail);
	formData.append("invfile", fileInput.files[0]);
	formData.append("txnId", $('#txnid').val());
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/catchInvestigationDetail",
		data: formData,
		processData: false,
		contentType: false,
		success: function(data) {
			offRegister();
			newData = data;
			var data2 = newData.data;
			console.log("txnid" + data2)
			document.getElementById("investigationAttachmentDetail").reset();
			if (data2.length != 0 && newData.message == "SUCCESS") {
				$("#investigationDetailData").dataTable().fnClearTable();
				$("#investigationDetailData").dataTable().fnDraw();
				$("#investigationDetailData").dataTable().fnDestroy();
				$('#investigationDetailData').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "paging": false, "searching": false, "lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "fileName" },
						{ "mData": "aattachName" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnId + '^^' + data2.tempId + '"  onclick="deleteInvestigationData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else if (newData.message == "FAILURE") {
				alert('Api not Responding, Please try Again Later..!');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}

	});
}

function getInvestigationData(txnid) {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getInvestigationFileData",
		data: {
			"txnid": txnid
		},
		success: function(data) {
			newData = data;
			var data2 = newData.data;
			console.log("txnid" + data2)
			if (data2.length != 0 && newData.message == "SUCCESS") {
				$("#investigationDetailData").dataTable().fnClearTable();
				$("#investigationDetailData").dataTable().fnDraw();
				$("#investigationDetailData").dataTable().fnDestroy();
				$('#investigationDetailData').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "paging": false, "searching": false, "lengthMenu": false,
					"language": { "emptyTable": "No Data available" },
					"searching": false, info: false,
					"aaData": data2,
					"aoColumns": [
						{ "mData": "fileName" },
						{ "mData": "aattachName" },
						{
							"mData": function(data2, type, row) {
								return '<button type="button" value="' + data2.txnId + '^^' + data2.tempId + '"  onclick="deleteInvestigationData(this.value)" class="btn btn-sm btn-primary btn-floting" style="border-radius: 50%;" data-toggle="modal" data-keyboard="false" data-backdrop="static" data-target="#modal-revoke" style="background: #2c2d6e;"><i class="fa fa-minus"></i></button>';
							}
						}
					]
				})
			} else if (newData.message == "FAILURE") {
				alert('Api not Responding, Please try Again Later..!');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}

function deleteInvestigationData(deleteDaignoseData) {
	const myArray = deleteDaignoseData.split("^^");
	var txnid = myArray[0];
	var tempId = myArray[1];
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deleteInvestigationFileData",
		data: {
			"txnid": txnid,
			"tempId": tempId,
		},
		success: function(data) {
			newData = data;
			if (newData == "SUCCESS") {
				$("#investigationDetailData").dataTable().fnClearTable();
				$("#investigationDetailData").dataTable().fnDraw();
				$("#investigationDetailData").dataTable().fnDestroy();
				window.setTimeout(function() { getInvestigationData(txnid) }, 100);
			} else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function() {
			alert('Api not Responding, Please try Again Later..!');
		}
	});
}


function preAuthFinalSubmit() {
	var txnid = document.getElementById("txnid").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/finalSubmitPreAuth",
		data: {
			"txnid": txnid,
		},
		success: function(data) {
			offRegister();
			console.log("final submit" + data)
			var obj = jQuery.parseJSON(data);
			var obj2 = obj.data;
			if (obj.status == "SUCCESS") {
				document.getElementById("finalsuccmsg").innerHTML = "" + obj2.message;
				document.getElementById("finalsuccmsgdiv").style.display = "block";
				// $('#succmsgdiv').delay(5000).fadeOut(400);
			}
			else if (obj.status == "FAILURE") {
				document.getElementById("finalfailmsg").innerHTML = "" + obj2.message;
				document.getElementById("finalfailmsgDiv").style.display = "block";
				// $('#failmsgDiv').delay(5000).fadeOut(400);
				//window.location.reload();
			}
			else {
				alert('API Gateway not respond. Please try again.');
			}
		},
		error: function(e) {
			alert('API Gateway not respond. Please try again.');
		}

	});
}

function getStratMasterData() {
	var userstate = document.getElementById("userstate").value;
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getStratificationMasterDataPreAuth",
		data: {
			"statecode": userstate,
		},
		success: function(data) {
			newData = data;
			//console.log(newData);
			$("#stratCode option").remove();
			var obj = jQuery.parseJSON(data);
			obj = obj.data;
			for (var key in obj) {
				var values = obj[key];
				var x = document.getElementById("stratCode");
				var option = document.createElement("option");
				option.text = values.stratification_options;
				option.value = values.stratification_code;
				x.add(option);
			}
		},
		error: function(e) {
			alert('Error: ' + e);
		}
	});
}


function getpreview() {
	var txnid = document.getElementById("txnid").value;
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/perview",
		data: {
			"txnid": txnid,
		},
		success: function(data) {
			newData = data;
			console.log(newData);

			$('#primaryDiagnosisMap').empty();
			var primaryDiagnosisData = '';
			$.each(newData.data.primaryDiagnosisMap, function(key, value) {
				primaryDiagnosisData += '<div class="row">';
				primaryDiagnosisData += '	<div class="col-12 col-md-6 preauth-data text-left">';
				primaryDiagnosisData += '	<span>Daignosis </span>';
				primaryDiagnosisData += '		<strong>' + value.icdDesc + '</strong>';
				primaryDiagnosisData += '	</div>';

				primaryDiagnosisData += '	<div class="col-12 col-md-6 preauth-data text-left">';
				primaryDiagnosisData += '		<span>Daignosis Code </span>';
				primaryDiagnosisData += '		<strong>' + value.icdCode + '</strong>';
				primaryDiagnosisData += '	</div>';
				primaryDiagnosisData += '</div>';
			});
			$('#primaryDiagnosisMap').append(primaryDiagnosisData);

			$('#secondaryDiagnosisMap').empty();
			var secondaryDiagnosisData = '';
			$.each(newData.data.secondaryDiagnosisMap, function(key, value) {
				secondaryDiagnosisData += '<div class="row">';
				secondaryDiagnosisData += '	<div class="col-12 col-md-6 preauth-data text-left">';
				secondaryDiagnosisData += '	<span>Daignosis </span>';
				secondaryDiagnosisData += '		<strong>' + value.icdDesc + '</strong>';
				secondaryDiagnosisData += '	</div>';

				secondaryDiagnosisData += '	<div class="col-12 col-md-6 preauth-data text-left">';
				secondaryDiagnosisData += '		<span>Daignosis Code </span>';
				secondaryDiagnosisData += '		<strong>' + value.icdCode + '</strong>';
				secondaryDiagnosisData += '	</div>';
				secondaryDiagnosisData += '</div>';
			});
			$('#secondaryDiagnosisMap').append(secondaryDiagnosisData);

			$('#treatmentProtocolMap').empty();
			var treatmentProtocolData = '';
			$.each(newData.data.treatmentProtocolMap, function(key, value) {
				treatmentProtocolData += '<div class="row">';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Package </span>';
				treatmentProtocolData += '		<strong>' + value.packageidtxt + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Procedure </span>';
				treatmentProtocolData += '		<strong>' + value.procedureidtxt + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Procedure Label</span>';
				treatmentProtocolData += '		<strong>' + value.procedurelabeltxt + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Speciality </span>';
				treatmentProtocolData += '		<strong>' + value.specialitytxt + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>ICHI Code / Description </span>';
				treatmentProtocolData += '		<strong>' + value.ichiCodetxt + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Investigations </span>';
				treatmentProtocolData += '		<strong>' + value.investigationActivetxt + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>History Of Present Illness </span>';
				treatmentProtocolData += '		<strong>' + value.presentIllnesHistory + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Package Cost</span>';
				treatmentProtocolData += '		<strong>' + value.price + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Package Type</span>';
				treatmentProtocolData += '		<strong>' + value.proceduretypetxt + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Can Add Stratifications</span>';
				treatmentProtocolData += '		<strong>' + value.stratificationstatus + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Can Add Implant</span>';
				treatmentProtocolData += '		<strong>' + value.implantstatus + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Can Create Erupi Voucher</span>';
				treatmentProtocolData += '		<strong>' + value.erupistatus + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Added Stratifications (/ saperated) </span>';
				treatmentProtocolData += '		<strong>' + value.inclusiveStractsText + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Total Stratifications Cost </span>';
				treatmentProtocolData += '		<strong>' + value.inclusiveStractsCost + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Added Implants (/ saperated) </span>';
				treatmentProtocolData += '		<strong>' + value.inclusiveImplantText + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '	<div class="col-12 col-md-3 preauth-data text-left">';
				treatmentProtocolData += '		<span>Total Implants Cost </span>';
				treatmentProtocolData += '		<strong>' + value.inclusiveImplantCost + '</strong>';
				treatmentProtocolData += '	</div>';

				treatmentProtocolData += '</div>';
			});
			$('#treatmentProtocolMap').append(treatmentProtocolData);

			// filling general finding start  				
			if (newData.data.examinationMap != null) {
				$("#tempretureViewC").html(newData.data.examinationMap.temperatureParameter);
				$("#tempretureView").html(newData.data.examinationMap.temperature);
				$("#bprtViewh").html(newData.data.examinationMap.bpRt);
				$("#bmiView").html(newData.data.examinationMap.bmi);
				$("#clubbingView").html(newData.data.examinationMap.clubOfFingertoes);
				$("#malnutritionView").html(newData.data.examinationMap.malnutrition);
				$("#pulseView").html(newData.data.examinationMap.pluseRate);
				$("#heightView").html(newData.data.examinationMap.height);
				$("#pallorVIew").html(newData.data.examinationMap.pallor);
				$("#lymphadenopathyView").html(newData.data.examinationMap.lymphadenopathy);
				$("#dehydrationView").html(newData.data.examinationMap.dehydration);
				$("#btltH").html(newData.data.examinationMap.bpLt);
				$("#weightView").html(newData.data.examinationMap.weight);
				$("#cyanosisView").html(newData.data.examinationMap.cyanosis);
				$("#oedemaView").html(newData.data.examinationMap.oedemaInFeet);
				$("#respirationView").html(newData.data.examinationMap.respirationRate);
			}
			// filling general finding ends//

			// filling personal history start
			if (newData.data.patientPersonalHistoryMap != null) {
				$("#appetiteView").text(newData.data.patientPersonalHistoryMap.appetite);
				$("#dietView").text(newData.data.patientPersonalHistoryMap.diet);
				$("#bowelsView").text(newData.data.patientPersonalHistoryMap.bowels);
				$("#nutritionVIew").text(newData.data.patientPersonalHistoryMap.nutrition);
				$("#knowView").text(newData.data.patientPersonalHistoryMap.knownAllergies);
				$("#AllergiToMedicine").text(newData.data.patientPersonalHistoryMap.alergictomed);
				$("#AllergiToSubtance").text(newData.data.patientPersonalHistoryMap.alertosub);
				$("#habitsView").text(newData.data.patientPersonalHistoryMap.addictions);
				$("#AlcoholView").text(newData.data.patientPersonalHistoryMap.alcohol);
				$("#tobaccoView").text(newData.data.patientPersonalHistoryMap.tobacco);
				$("#drugView").text(newData.data.patientPersonalHistoryMap.druguse);
				$("#betalNutView").text(newData.data.patientPersonalHistoryMap.beetelnut);
				$("#betalLeafView").text(newData.data.patientPersonalHistoryMap.betelleaf);
			}
			// filling personal history ends


			// filling past and family histroy start
			if (newData.data.patientHospDiagnosisMap != null) {
				$.each(newData.data.patientHospDiagnosisMap.ph, function(index, value) {
					if (value === "PH1") {
						document.getElementById("pDiabetesView").style.display = "block";
						document.getElementById("pDiabetesView2").style.display = "none";
					}
					if (value === "PH2") {
						document.getElementById("pHypertensionView").style.display = "block";
						document.getElementById("pHypertensionView2").style.display = "none";
					}
					if (value === "PH3") {
						document.getElementById("pCADView").style.display = "block";
						document.getElementById("pCADView2").style.display = "none";
					}
					if (value === "PH4") {
						document.getElementById("pAsthmaView").style.display = "block";
						document.getElementById("pAsthmaView2").style.display = "none";
					}
					if (value === "PH5") {
						document.getElementById("pTuberculosisView").style.display = "block";
						document.getElementById("pTuberculosisView2").style.display = "none";
					}
					if (value === "PH7") {
						document.getElementById("pStrokeView").style.display = "block";
						document.getElementById("pStrokeView2").style.display = "none";
					}
					if (value === "PH8") {
						document.getElementById("pCancersView").style.display = "block";
						document.getElementById("pCancersView2").style.display = "none";
					}
					if (value === "PH9") {
						document.getElementById("pbloodView").style.display = "block";
						document.getElementById("pbloodView2").style.display = "none";
					}
					if (value === "PH10") {
						document.getElementById("purgeriesView").style.display = "block";
						document.getElementById("purgeriesView2").style.display = "none";
					}

					if (value === "PH11") {
						document.getElementById("otherhist").style.display = "block";
						$("#pastHistoryOthr").val(newData.data.patientHospDiagnosisMap.pastHistoryOthr);
					}

					if (value === "PH12") {
						document.getElementById("eEndocrineView").style.display = "block";
						document.getElementById("eEndocrineView2").style.display = "none";
					}

					if (value === ("PH13")) {
						document.getElementById("notappliView").style.display = "block";
						document.getElementById("notappliView2").style.display = "none";
					}
				});

				$.each(newData.data.patientHospDiagnosisMap.fh, function(index, value) {
					if (value === "FH1") {
						document.getElementById("fdiabetesView").style.display = "block";
						document.getElementById("fdiabetesView2").style.display = "none";
					}
					if (value === "FH2") {
						document.getElementById("fhipertensionView").style.display = "block";
						document.getElementById("fhipertensionView2").style.display = "none";
					}
					if (value === "FH3") {
						document.getElementById("fheartView").style.display = "block";
						document.getElementById("fheartView2").style.display = "none";
					}
					if (value === "FH4") {
						document.getElementById("fStrikeView").style.display = "block";
						document.getElementById("fStrikeView2").style.display = "none";
					}
					if (value === "FH5") {
						document.getElementById("fcancersView").style.display = "block";
						document.getElementById("fcancersView2").style.display = "none";
					}
					if (value === "FH6") {
						document.getElementById("ftuberculosisView").style.display = "block";
						document.getElementById("ftuberculosisView2").style.display = "none";
					}
					if (value === "FH7") {
						document.getElementById("fasthmaView").style.display = "block";
						document.getElementById("fasthmaView2").style.display = "none";
					}
					if (value === "FH8") {
						document.getElementById("fanyotherView").style.display = "block";
						document.getElementById("fanyotherView2").style.display = "none";
					}
					if (value === "FH9") {
						document.getElementById("fpsychiatristViiw").style.display = "block";
						document.getElementById("fpsychiatristViiw2").style.display = "none";
					}
					if (value === "FH11") {
						document.getElementById("otherhistfh").style.display = "block";
						$("#familyHistoryOthr").val(newData.data.patientHospDiagnosisMap.familyHistoryOthr);
					}
					if (value === "FH12") {
						document.getElementById("notapplifhView").style.display = "block";
						document.getElementById("notapplifhView2").style.display = "none";
					}
				});
			}
			// filling past and family history ends

			//  Admission Details Starts

			if (newData.data.preAuth != null) {
				$("#admissionType").html(newData.data.preAuth.caseType);
				$("#treatmentDateView").html(newData.data.preAuth.treatmentDate);
				$("#admissionDateView").html(newData.data.preAuth.admissionDt);
				$("#medicoView").html(newData.data.preAuth.legalCaseCheck);
				$("#FIRView").html(newData.data.preAuth.legalCaseNo);
				$("#policeView").html(newData.data.preAuth.policeStatName);
				$("#totaCostView").html(newData.data.preAuth.totPckgAmt);
				$("#incentiveView").html("110%");
				$("#remarksView").html(newData.data.preAuth.remarks);
			}
			// Admission Details ends

			$('#admissionDetailDocument').empty();
			var admissionDetailData = '';
			$.each(newData.data.admissionDetailDocument, function(key, value) {
				admissionDetailData += '		<tr>';
				admissionDetailData += '			<td>' + value.documentname + '</td>';
				admissionDetailData += '			<td>' + value.documenttxt + '</td>';
				admissionDetailData += '     </tr>';
			});
			$('#admissionDetailDocument').append(admissionDetailData);

			$('#investigationDetails').empty();
			var investigationData = '';
			$.each(newData.data.investigationDetails, function(key, value) {
				investigationData += '		<tr>';
				investigationData += '			<td>' + value.aattachName + '</td>';
				investigationData += '			<td>' + value.fileName + '</td>';
				investigationData += '     </tr>';
			});
			$('#investigationDetails').append(investigationData);

		},
		error: function(e) {
			alert('Error: ' + e);
		}
	});
}
