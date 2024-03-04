
function schemeChange() {
	$("#statecode").val('').trigger('change');
}

function savePriceMasterData() {
	var state = document.getElementById("statecode").value;
	var scheme = document.getElementById("scheme").value;
	var specialitycode = document.getElementById("speciality").value;
	var packagecode = document.getElementById("packageid").value;
	var procedurecode = document.getElementById("procedureid").value;
	var price = document.getElementById("price").value;
	var tier1price = document.getElementById("tier1price").value;
	var tier2price = document.getElementById("tier2price").value;
	var tier3price = document.getElementById("tier3price").value;
	var priceid = document.getElementById("priceid").value;
	
	if (scheme == "") {
		document.getElementById("schemeError").innerHTML = "Please Select Scheme";
		document.getElementById("scheme").focus();
		return false;
	} else {
		document.getElementById("schemeError").innerHTML = "";
	}
	
	if (state == "") {
		document.getElementById("stateError").innerHTML = "Please Select State";
		document.getElementById("state").focus();
		return false;
	} else {
		document.getElementById("stateError").innerHTML = "";
	}
	
	if (specialitycode == "") {
		document.getElementById("specialityError").innerHTML = "Please Select Speciality";
		document.getElementById("speciality").focus();
		return false;
	} else {
		document.getElementById("specialityError").innerHTML = "";
	}
	
	if (packagecode == "") {
		document.getElementById("packageidError").innerHTML = "Please Select Package";
		document.getElementById("packageid").focus();
		return false;
	} else {
		document.getElementById("packageidError").innerHTML = "";
	}
	
	if (procedurecode == "") {
		document.getElementById("procedureidError").innerHTML = "Please Select Procedure";
		document.getElementById("procedureid").focus();
		return false;
	} else {
		document.getElementById("procedureidError").innerHTML = "";
	}
	if (price == "") {
		document.getElementById("priceError").innerHTML = "Please Enter Price";
		document.getElementById("price").focus();
		return false;
	} else {
		document.getElementById("priceError").innerHTML = "";
	}

	if (tier1price == "") {
		document.getElementById("tier1priceError").innerHTML = "Please Enter Tier 1 Price";
		document.getElementById("tier1price").focus();
		return false;
	} else {
		document.getElementById("tier1priceError").innerHTML = "";
	}

	if (tier2price == "") {
		document.getElementById("tier2priceError").innerHTML = "Please Enter Tier 2 Price";
		document.getElementById("tier2price").focus();
		return false;
	} else {
		document.getElementById("tier2priceError").innerHTML = "";
	}

	if (tier3price == "") {
		document.getElementById("tier3priceError").innerHTML = "Please Enter Tier 3 Price";
		document.getElementById("tier3price").focus();
		return false;
	} else {
		document.getElementById("tier3priceError").innerHTML = "";
	}

	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/savePriceMasterData",

		data: {
			"price": price,
			"statecode": state,
			"schemeid": scheme,
			"specialitycode": specialitycode,
			"packagecode": packagecode,
			"procedurecode": procedurecode,
			"tier1price": tier1price,
			"tier2price": tier2price,
			"tier3price": tier3price,
			"priceid":priceid,
		},
		success: function(data) {
			//console.log(data);
			offRegister();
			var obj = jQuery.parseJSON(data);
			if (obj.status == "SUCCESS") {
				document.getElementById("succmsg").innerHTML = "Data Saved Successfully";
				document.getElementById("succmsgdiv").style.display = "block";
				$('#succmsgdiv').delay(5000).fadeOut(400);

				document.getElementById("price").value = "";
				document.getElementById("tier1price").value = "";
				document.getElementById("tier2price").value = "";
				document.getElementById("tier3price").value = "";
				
				$("#scheme").val('').trigger('change');
				$("#statecode").val('').trigger('change');
				$("#speciality").val('').trigger('change');
				$("#packageid").val('').trigger('change');
				$("#procedureid").val('').trigger('change');
				$("#priceBtn").html("Submit");
				getPriceMasterData();
				
			}else if (obj.status == "FAILURE") {
				document.getElementById("failmsg").innerHTML = obj.message;
				document.getElementById("failmsgDiv").style.display = "block";
				$('#failmsgDiv').delay(5000).fadeOut(2000);
			}else {
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

function getPriceMasterData() {
	var role=$('#role').val();
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getPriceMasterData",
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				offRegister();
				var data2 = data1.data;
				var i = 1;
				var table = $('#priceTable').DataTable({
					"destroy":true,"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"],"aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						//{ "mData": null, render: function() { return i++; } },
						{ "mData": "priceid" },
						{ "mData": "specialityname" },
						{ "mData": "packagename" },
						{ "mData": "procedurename" },
						{ "mData": "scheme_name" },
						{ "mData": "price" },
						{ "mData": "status" },
						{ "mData": "approvalstatus"},
					    { "mData": "priceid", render: function (data2, type, row) { 
                       		 if(row.statecode===row.ustate){
								return '<button  id="editPrice" value="'+data2+'" class="btn btn-primary custom-btn" onclick="editPrice(this)">Edit&nbsp;</button>';
							}else{
								return '';
							}
                        }
                        },
                        { "mData": "priceid", render: function (data2, type, row) {
                    	   return '<button  id="deletePrice" value="'+data2+'" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="FillPriceDialog(this.value)">Active/Inactive&nbsp;</button>';
               			}},
               			{ "mData": "tier1" },
               			{ "mData": "tier2" },
						{ "mData": "tier3" },
					],

				}).buttons().container().appendTo('#priceTable_wrapper .col-md-6:eq(0)');
			}else {
				var table = $('#priceTable').DataTable({
				}).buttons().container().appendTo('#priceTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
			offRegister();
			alert('Error: ' + e);
		}
	});
} 


function editPrice(value){
	  var row = jQuery(value).closest('tr')
      var priceid = row[0].children[0].innerHTML;
     onRegister();
      $.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/getPriceMasterDetailForEditByPriceId",
		 data: {
			"priceid":priceid,
			},
           success: function(data){
			offRegister();
			console.log("data--"+data)
            var data1 = jQuery.parseJSON(data);
            console.log("data--"+data1.data);
            console.log("data--"+data1.data.packagecode);
			if(data1.status=="SUCCESS"){
			document.getElementById("priceid").value=data1.data.priceid;
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
			document.getElementById("price").value=data1.data.price;
			document.getElementById("tier1price").value=data1.data.tier1price;
			document.getElementById("tier2price").value=data1.data.tier2price;
			document.getElementById("tier3price").value=data1.data.tier3price;
			$("#priceBtn").html("Update");
      		}
      		if(data1.status=="FAILURE"){
			offRegister();
			
			}
        },
        error: function(e){
	      offRegister();
         }
    });
  }
  
  function FillPriceDialog(value){
	document.getElementById("deletePrice").value=value;
}
   function deletePrice() {
     priceid  = document.getElementById("deletePrice").value;
      onRegister();
      $.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/deletePriceMasterByPriceId",
		 data: {
			"priceid":priceid,
		},
           success: function(data){
	 		offRegister();
            var data1 = jQuery.parseJSON( data );
			if(data1.status=="SUCCESS"){	
			getPriceMasterData();
      		}
      		if(data1.status=="FAILURE"){
			}
        },
        error: function(e){
	      offRegister();
         }
    });
      
}
