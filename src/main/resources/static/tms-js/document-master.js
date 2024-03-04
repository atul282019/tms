
function schemeChange() {
	$("#statecode").val('').trigger('change');
	$("#implantcode").val('').trigger('change');
	$("#procedureid").val('').trigger('change');
}
function saveDocumentMasterData() {
	var speciality = document.getElementById("speciality").value;
	var packageid = document.getElementById("packageid").value;
	var procedureid = document.getElementById("procedureid").value;
	var preauthdoc = document.getElementById("preauthdoc").value;
	var claimprocessingdoc = document.getElementById("claimprocessingdoc").value;
	var schemeid = document.getElementById("scheme").value;
	var statecode = document.getElementById("statecode").value;
	var documentid = document.getElementById("documentid").value;
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

	if (speciality == "") {
		document.getElementById("specialityError").innerHTML = "Please Select Speciality";
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

	if (preauthdoc == "") {
		document.getElementById("preauthdocError").innerHTML = "Please Enter Pre Auth Document Name";
		document.getElementById("preauthdoc").focus();
		return false;
	}else {
		document.getElementById("preauthdocError").innerHTML = "";
	}

	if (claimprocessingdoc == "") {
		document.getElementById("claimprocessingdocError").innerHTML = "Please Enter Claim Processing Document Name";
		document.getElementById("claimprocessingdoc").focus();
		return false;
	}else {
		document.getElementById("claimprocessingdocError").innerHTML = "";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/saveDocumentMasterData",
		data: {
			"procedurecode": procedureid,
			"schemeid": schemeid,
			"statecode": statecode,
			"claimprocessingdoc": claimprocessingdoc,
			"preauthorizationdoc": preauthdoc,
			"packagecode": packageid,
			"specialitycode": speciality,
			"documentid": documentid,

		},
		success: function(data) {
			offRegister();
			var obj = jQuery.parseJSON(data);
			if (obj.status == "SUCCESS") {
				document.getElementById("succmsg").innerHTML = "Data Saved Successfully";
				document.getElementById("succmsgdiv").style.display = "block";
				$('#succmsgdiv').delay(5000).fadeOut(400);
				document.getElementById("preauthdoc").value = "";
				document.getElementById("claimprocessingdoc").value = "";
				$("#statecode").val('').trigger('change');
				$("#scheme").val('').trigger('change');
				$("#procedureid").val('').trigger('change');
				$("#packageid").val('').trigger('change');
				$("#docBtn").html("Submit");
				getDocumentMasterData();
			} else if (obj.status == "FAILURE") {
				document.getElementById("failmsg").innerHTML = obj.message;
				document.getElementById("failmsgDiv").style.display = "block";
				$('#failmsgDiv').delay(5000).fadeOut(400);

			} else {
				offRegister();
				document.getElementById("failmsgDiv").style.display = "none";
				document.getElementById("succmsgdiv").style.display = "none";
			}
		},
		error: function(e) {
			offRegister();
			alert('API Gateway not respond. Please try again.');
		}

	});
}
function getDocumentMasterData() {
	var role = $('#role').val();
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getDocumentMasterData",
		success: function(data) {
			console.log("data--" + data)
			var data1 = jQuery.parseJSON(data);
			offRegister();
			if (data1.status == "SUCCESS") {
				var data2 = data1.data;
				console.log("Data " + data2);
				var i = 1;
				var table = $('#docTable').DataTable({
					"destroy": true, "responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						//{ "mData": null, render: function() { return i++; } },
						{ "mData": "docid" },
						{ "mData": "preauthorizationdoc" },
						{ "mData": "claimprocessingdoc" },
						{ "mData": "specialtycode" },
						{ "mData": "packagecode" },
						{ "mData": "procedurecode" },
						{ "mData": "state_name" },
						{ "mData": "status" },
						{ "mData": "approvalstatus" },
						{
							"mData": "docid", render: function(data2, type, row) {
								 if (row.statecode === row.ustate) {
									return '<button  id="editDocument" value="' + data2 + '" class="btn btn-primary custom-btn" onclick="editDocument(this)">Edit&nbsp;</button>';
								} else {
									return '';
								}
							}
						},
						{
							"mData": "docid", render: function(data2, type, row) {
								return '<button  id="deleteDocument" value="' + data2 + '" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="FillDocumentDialog(this.value)">Active/Inactive&nbsp;</button>';
							}
						},
						{ "mData": "scheme_name" },

					],

				}).buttons().container().appendTo('#docTable_wrapper .col-md-6:eq(0)');
			} else {
				var table = $('#docTable').DataTable({
				}).buttons().container().appendTo('#docTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
			offRegister();
			alert('Error: ' + e);
		}
	});
}

function editDocument(value) {
	var row = jQuery(value).closest('tr')
	var documentid = row[0].children[0].innerHTML;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getDocumetMasterDetailForEditByDocumentId",
		data: {
			"documentid": documentid,
		},
		success: function(data) {
			offRegister();
			console.log("data--" + data)
			var data1 = jQuery.parseJSON(data);
			console.log("data--" + data1.data);
			console.log("data--" + data1.data.packagecode);
			if (data1.status == "SUCCESS") {

				document.getElementById("documentid").value = data1.data.documentid;
				$("#scheme").select2().val(data1.data.schemeid).trigger("change");
				$("#statecode").select2().val(data1.data.statecode).trigger("change");
				//$("#speciality").select2().val(data1.data.specialitycode).trigger("change");
				
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
								if (data1.data.specialitycode === values.specialitycode) {
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
						"specilitycode": data1.data.specialitycode,
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
				$.ajax({
					 type: "POST",
					 url:""+$('#ctx').attr('content')+"/getprocedureMasterBySpecilityCodeAndPackageCodeByState",
			         data: { 
							"statecode": data1.data.statecode,
							"specilitycode": data1.data.specialitycode, 
							"packagecode":data1.data.packagecode,
			       		 },
			           success: function(data){
			            newData = data;
						$("#procedureid option").remove();
			            var obj = jQuery.parseJSON( data );
			            obj = obj.data;
			            // console.log("-------"+obj);
			        	 var count=0;
			         	for (var key in obj) {
			             var values =  obj[key];
			             var x = document.getElementById("procedureid");
			             if(count==0){
			             var option = document.createElement("option");
			             option.text ="Select Procedure";
			             option.value = "";
			             x.add(option);
			             }
			             var option = document.createElement("option");
			             option.text = values.procedurename;
			             option.value = values.procedurecode;
			             
			             if (data1.data.procedurecode === values.procedurecode) {
								option.selected = true;
							}
			             x.add(option);
			
			             count++;
			             }   
			         },
			         error: function(e){
			             alert('Error: ' + e);
			         }
			         
			    });
				
				
				$("#packageid").select2().val(data1.data.packagecode).trigger("change");
				$("#packageid").select2().val(data1.data.packagecode).trigger("change");
				$("#procedureid").select2().val(data1.data.procedurecode).trigger("change");
				document.getElementById("preauthdoc").value = data1.data.preauthorizationdoc;
				document.getElementById("claimprocessingdoc").value = data1.data.claimprocessingdoc;
				document.getElementById("documentid").value = data1.data.documentid;

				if (data1.data.status === 1) {
					$("#one").prop("checked", true);
				} else {
					$("#zero").prop("checked", true);
				}

				$("#docBtn").html("Update");

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


function FillDocumentDialog(value) {
	document.getElementById("deleteDocument").value = value;
}
function deleteDocument() {
	documentid = document.getElementById("deleteDocument").value;
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/deleteDocumentMasterByDocumentId",
		data: {
			"documentid": documentid,
		},
		success: function(data) {
			offRegister();
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {

				getDocumentMasterData();

			}
			if (data1.status == "FAILURE") {
			}
		},
		error: function(e) {
			offRegister();
		}
	});

}

