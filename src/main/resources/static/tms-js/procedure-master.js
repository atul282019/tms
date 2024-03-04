
function saveProcedureMasterData() {
	var schemeid = document.getElementById("scheme").value;
	var statecode = document.getElementById("statecode").value;
	var specialtycode = document.getElementById("speciality").value;
	var packagecode = document.getElementById("packageid").value;
	var procedureCode = document.getElementById("procedureCode").value;
	var ProcedureName = document.getElementById("ProcedureName").value;
	var stratificationStatus = document.getElementById("stratificationStatus").value;
	var implantStaus = document.getElementById("implantStaus").value;
	var moreThanOneImplantStatus = document.getElementById("moreThanOneImplantStatus").value;
	var specialConditionsStatus = document.getElementById("specialConditionsStatus").value;
	var ispublic = document.getElementById("ispublic").value;
	var reservationTertiaryHospitalsStatus = document.getElementById("reservationTertiaryHospitalsStatus").value;
	var levelofCare = document.getElementById("levelofCare").value;
	var los = document.getElementById("los").value;
	var autoApprovedStatus = document.getElementById("autoApprovedStatus").value;
	var enhancementApplicableStatus = document.getElementById("enhancementApplicableStatus").value;
	var dayCareStatus = document.getElementById("dayCareStatus").value;
	var procedureLabelName = $("#procedureLabelName option:selected").text();
	var procedurelabelname_code = document.getElementById("procedureLabelName").value;
	var medicalorSurgical = $("#medicalorSurgical option:selected").text();
	var medicalorsurgical_code = document.getElementById("medicalorSurgical").value;

	var procedureid = document.getElementById("procedureid").value;
	var alphanumeric = /^[a-z0-9\s]+$/i; // alpha number with space only
	var onlySpace = /^$|.\S+./; // only space

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

	if (specialtycode == "") {
		document.getElementById("specialtycodeError").innerHTML = "Please Select Speciality";
		document.getElementById("specialtycode").focus();
		return false;
	} else {
		document.getElementById("specialtycodeError").innerHTML = "";
	}

	if (packagecode == "") {
		document.getElementById("packagecodeError").innerHTML = "Please Select Package";
		document.getElementById("packagecode").focus();
		return false;
	} else {
		document.getElementById("packagecodeError").innerHTML = "";
	}
	if (procedureCode == "") {
		document.getElementById("procedureCodeError").innerHTML = "Please Enter Procedure Code";
		document.getElementById("procedureCode").focus();
		return false;
	} else if (!procedureCode.match(alphanumeric) || !procedureCode.match(onlySpace)) {
		document.getElementById("procedureCodeError").innerHTML = "Procedure Code Consist Special Character";
		document.getElementById("procedureCode").focus();
		return false;
	} else {
		document.getElementById("procedureCodeError").innerHTML = "";
	}

	if (ProcedureName == "") {
		document.getElementById("ProcedureNameError").innerHTML = "Please Enter Procedure Name";
		document.getElementById("ProcedureName").focus();
		return false;
	} else if (!ProcedureName.match(alphanumeric) || !ProcedureName.match(onlySpace)) {
		document.getElementById("ProcedureNameError").innerHTML = "Procedure Name Consist Special Character";
		document.getElementById("ProcedureName").focus();
		return false;
	} else {
		document.getElementById("ProcedureNameError").innerHTML = "";
	}

	if (stratificationStatus == "") {
		document.getElementById("stratificationStatusError").innerHTML = "Please Select Stratification Status";
		document.getElementById("stratificationStatus").focus();
		return false;
	} else {
		document.getElementById("stratificationStatusError").innerHTML = "";
	}

	if (implantStaus == "") {
		document.getElementById("implantStausError").innerHTML = "Please Select Implant Status";
		document.getElementById("implantStaus").focus();
		return false;
	} else {
		document.getElementById("implantStausError").innerHTML = "";
	}

	if (moreThanOneImplantStatus == "") {
		document.getElementById("moreThanOneImplantStatusError").innerHTML = "Please Enter More Than One Implant Status";
		document.getElementById("moreThanOneImplantStatus").focus();
		return false;
	} else {
		document.getElementById("moreThanOneImplantStatusError").innerHTML = "";
	}

	if (specialConditionsStatus == "") {
		document.getElementById("specialConditionsStatusError").innerHTML = "Please Select Special Conditions Status";
		document.getElementById("specialConditionsStatus").focus();
		return false;
	} else {
		document.getElementById("specialConditionsStatusError").innerHTML = "";
	}

	if (reservationTertiaryHospitalsStatus == "") {
		document.getElementById("reservationTertiaryHospitalsStatusError").innerHTML = "Please Select Reservation Tertiary HospitalsS tatus";
		document.getElementById("reservationTertiaryHospitalsStatus").focus();
		return false;
	} else {
		document.getElementById("reservationTertiaryHospitalsStatusError").innerHTML = "";
	}

	if (levelofCare == "") {
		document.getElementById("levelofCareError").innerHTML = "Please Select Level Of Care";
		document.getElementById("levelofCare").focus();
		return false;
	} else {
		document.getElementById("levelofCareError").innerHTML = "";
	}

	if (los == "") {
		document.getElementById("losError").innerHTML = "Please Enter LOS";
		document.getElementById("los").focus();
		return false;
	} else {
		document.getElementById("losError").innerHTML = "";
	}

	if (autoApprovedStatus == "") {
		document.getElementById("autoApprovedStatusError").innerHTML = "Please Auto Approved Status";
		document.getElementById("autoApprovedStatusStaus").focus();
		return false;
	} else {
		document.getElementById("autoApprovedStatusError").innerHTML = "";
	}

	if (autoApprovedStatus == "") {
		document.getElementById("autoApprovedStatusError").innerHTML = "Please Select Auto Approved Status";
		document.getElementById("autoApprovedStatusStaus").focus();
		return false;
	} else {
		document.getElementById("autoApprovedStatusError").innerHTML = "";
	}

	if (procedureLabelName == "") {
		document.getElementById("procedureLabelNameError").innerHTML = "Please Enter Procedure Label Name";
		document.getElementById("procedureLabelName").focus();
		return false;
	} else {
		document.getElementById("procedureLabelNameError").innerHTML = "";
	}

	if (enhancementApplicableStatus == "") {
		document.getElementById("enhancementApplicableStatusError").innerHTML = "Please Select Enhancement Applicable Status";
		document.getElementById("enhancementApplicableStatus").focus();
		return false;
	} else {
		document.getElementById("enhancementApplicableStatusError").innerHTML = "";
	}

	if (medicalorSurgical == "") {
		document.getElementById("medicalorSurgicalError").innerHTML = "Please Select Medical or Surgical";
		document.getElementById("medicalorSurgical").focus();
		return false;
	} else {
		document.getElementById("medicalorSurgicalError").innerHTML = "";
	}

	if (dayCareStatus == "") {
		document.getElementById("dayCareStatusError").innerHTML = "Please Select Day Care Status";
		document.getElementById("dayCareStatus").focus();
		return false;
	} else {
		document.getElementById("dayCareStatusError").innerHTML = "";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/saveProcedureMasterData",
		data: {
			"statecode": statecode,
			"schemeid": schemeid,
			"specialtycode": specialtyname,
		//	"packagecode": packagecode,
		//	"procedurecode": procedureCode,
			"procedurename": ProcedureName,
			"implantstatus": implantStaus,
			"stratificationstatus": stratificationStatus,
			"multipleprocedures": moreThanOneImplantStatus,
			"specialconditionsstatus": specialConditionsStatus,
			"ispublic": ispublic,
			"hospStatus": reservationTertiaryHospitalsStatus,
			"levelofcare": levelofCare,
			"los": los,
			"autoapprovedstatus": autoApprovedStatus,
			"procedurelabel": procedureLabelName,
			"enhanceStatus": enhancementApplicableStatus,
			"medicalorsurgical": medicalorSurgical,
			"daycareprocedure": dayCareStatus,
			"procedurelabelname_code": procedurelabelname_code,
			"medicalorsurgical_code": medicalorsurgical_code,
			"procedureid": procedureid,

		},
		success: function(data) {
			var obj = jQuery.parseJSON(data);
			if (obj.data == "SUCCESS") {
				document.getElementById("succmsg").innerHTML = "Data Saved Successfully";
				document.getElementById("succmsgdiv").style.display = "block";
				$('#succmsgdiv').delay(5000).fadeOut(400);
				document.getElementById("procedureCode").value = "";
				document.getElementById("ProcedureName").value = "";
				document.getElementById("procedureLabelName").value = "";
				document.getElementById("enhancementApplicableStatus").value = "";
				document.getElementById("medicalorSurgical").value = "";
				document.getElementById("dayCareStatus").value = "";
				$("#schemeid").val('').trigger('change');
				$("#statecode").val('').trigger('change');
				$("#speciality").val('').trigger('change');
				$("#packageid").val('').trigger('change');
				$("#stratificationStatus").val('').trigger('change');
				$("#implantStaus").val('').trigger('change');
				$("#specialConditionsStatus").val('').trigger('change');
				$("#reservationPublicHospitalsStaus").val('').trigger('change');
				$("#reservationTertiaryHospitalsStatus").val('').trigger('change');
				$("#levelofCare").val('').trigger('change');
				$("#los").val('').trigger('change');
				$("#autoApprovedStatus").val('').trigger('change');
				$("#procedureLabelName").val('').trigger('change');
				$("#enhancementApplicableStatus").val('').trigger('change');
				$("#medicalorSurgical").val('').trigger('change');
				$("#dayCareStatus").val('').trigger('change');
				$('#procedureCode').attr('readonly', false);
				$("#btnProcedureSave").html("Submit");
				getProcedureMasterData();
				offRegister();
			} else if (obj.data == "FAILURE") {
				document.getElementById("failmsg").innerHTML = data1.message;
				document.getElementById("failmsgDiv").style.display = "block";
				$('#failmsgDiv').delay(5000).fadeOut(400);
				offRegister();
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

function getProcedureMasterData() {
	var role = $('#role').val();
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getProcedureMasterData",
		success: function(data) {
			console.log("data--" + data)
			var data1 = jQuery.parseJSON(data);
			var data2 = data1.data;
			if (data1.status == "SUCCESS") {
				offRegister();
				var data2 = data1.data;
				var i = 1;
				var table = $('#procedureTable').DataTable({
					"destroy":true,"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						//{"mData": null, render: function(){return i++;}   },
						{ "mData": "procedureid" },
						{ "mData": "specialityname" },
						//{ "mData": "packagecode" },
						{ "mData": "packagename" },
						//{ "mData": "procedurecode" },
						{ "mData": "procedurename" },
						{ "mData": "state_name" },
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
						{ "mData": "status" },
						{ "mData": "approvalstatus" },
						{
							"mData": "procedureid",
							"render": function(data2, type, row) {
								if (row.statecode === row.ustate) {
									return '<button  id="editspeciality" class="btn btn-primary custom-btn" onclick="editProcedure(this)">Edit&nbsp;</button>';
								} else {
									return '';
								}
							}
						},
						{
							"mData": "procedureid",
							"render": function(data2, type, row) {
								return '<button  id="deleteSpeciality" value="' + data2 + '" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="FillDialog(this.value)">Active/Inactive&nbsp;</button>';
							}
						},
						{ "mData": "stratificationstatus" },
						{ "mData": "implantstatus" },
						{ "mData": "specialconditionsstatus" },
						{ "mData": "reservationtertiaryhospitalsstatus" },
						{ "mData": "reservationtertiaryhospitalsstatus" },
						{ "mData": "levelofcare" },
						{ "mData": "los" },
						{ "mData": "autoapprovedstatus" },
						{ "mData": "procedurelabel" },
						{ "mData": "enhancementapplicablestatus" },
						{ "mData": "medicalorsurgical" },

					],

				}).buttons().container().appendTo('#procedureTable_wrapper .col-md-6:eq(0)');
			}
			else {
				var table = $('#procedureTable').DataTable({
				}).buttons().container().appendTo('#procedureTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
			offRegister();
			alert('Error: ' + e);
		}
	});
}


function editProcedure(value) {
	var row = jQuery(value).closest('tr')
	var procedureid = row[0].children[0].innerHTML;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getProcMasterForEditByProcId",
		data: {
			"procedureid": procedureid,
		},
		success: function(data) {
			console.log(data);
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				document.getElementById("procedureid").value = data1.data.procedureid;
				$("#scheme").select2().val(data1.data.schemeid).trigger("change");
				$("#statecode").select2().val(data1.data.statecode).trigger("change");

				//fill speciality
				$.ajax(
					{
						type: "POST",
						url: "" + $('#ctx').attr('content') + "/getSpecialityBySchemeCoceAndStateCode",
						data: {
							"schemeid": data1.data.schemeid,
							"statecode": data1.data.statecode
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
								if (data1.data.specialtycode === values.specialitycode) {
									option.selected = true;
								}
								x.add(option);

								count++;
							}
						},
						error: function(e) {

						}
					});
				
					$.ajax({
					type: "POST",
					url: "" + $('#ctx').attr('content') + "/getPackageMasterBySpecilityCode",
					data: {
						"specilitycode": data1.data.specialtycode,
					},
					success: function(data) {
						newData = data;
						$("#packageid option").remove();
						var obj = jQuery.parseJSON(data);
						obj = obj.data;
						// console.log("-------"+obj);
						var count = 0;
						for (var key in obj) {
							var values = obj[key];
							var x = document.getElementById("packageid");
							if (count == 0) {
								var option = document.createElement("option");
								option.text = "Select Package";
								option.value = "";
								x.add(option);
							}
							var option = document.createElement("option");
							option.text = values.packagename;
							option.value = values.packagecode;
							if (data1.data.packagecode === values.packagecode) {
								option.selected = true;
							}
							x.add(option);

							count++;
						}
					},
					error: function(e) {
						alert('Error: ' + e);
					}
				});

				document.getElementById("procedureCode").value = data1.data.procedurecode;
				$('#procedureCode').attr('readonly', true);
				document.getElementById("ProcedureName").value = data1.data.procedurename;

				$("#stratificationStatus").select2().val(data1.data.stratificationStatus).trigger("change");
				$("#implantStaus").select2().val(data1.data.implantstatus).trigger("change");
				$("#moreThanOneImplantStatus").select2().val(data1.data.multipleprocedures).trigger("change");
				$("#specialConditionsStatus").select2().val(data1.data.specialconditionsstatus).trigger("change");
				$("#ispublic").select2().val(data1.data.ispublic).trigger("change");
				$("#reservationPublicHospitalsStaus").select2().val(data1.data.hospStatus).trigger("change");
				$("#reservationTertiaryHospitalsStatus").select2().val(data1.data.hospStatus).trigger("change");
				$("#levelofCare").select2().val(data1.data.levelofcare).trigger("change");

				$("#autoApprovedStatus").select2().val(data1.data.autoapprovedstatus).trigger("change");
				$("#procedureLabelName").select2().val(data1.data.procedurelabelname_code).trigger("change");

				$("#enhancementApplicableStatus").select2().val(data1.data.enhanceStatus).trigger("change");

				$("#medicalorSurgical").select2().val(data1.data.medicalorsurgical_code).trigger("change");

				$("#dayCareStatus").select2().val(data1.data.daycareprocedure).trigger("change");

				document.getElementById("los").value = data1.data.los;
				$("#btnProcedureSave").html("Update");
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


function FillDialog(value) {
	document.getElementById("deleteProcedure").value = value;
}

function deleteProcedure() {
	procedureid = document.getElementById("deleteProcedure").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deleteProcMasterByProcId",
		data: {
			"procedureid": procedureid,
		},
		success: function(data) {
			offRegister();
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				getProcedureMasterData();
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