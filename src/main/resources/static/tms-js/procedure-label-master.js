function saveProcedureLblMasterData() {
	var procedure_label_name = document.getElementById("procedure_label_name").value;
	var reimbursementpercentage = document.getElementById("reimbursementpercentage").value;
	var onlySpace = /^$|.*\S+.*/; // only space
	var alphanumeric = /^[a-z0-9\s]+$/i;
	var numberReg = /^\d+$/; // only number

	var status =$('input[name=radio7]:checked').val();
	var procedurelblid = document.getElementById("procedurelblid").value;
	if(status==""){
		status=1;
	}
	
	if (procedure_label_name == "") {
		document.getElementById("procedure_label_nameError").innerHTML = "Please Enter Procedure Level";
		document.getElementById("procedure_label_name").focus();
		return false;
	}else if(!procedure_label_name.match(alphanumeric) || !procedure_label_name.match(onlySpace)){
		document.getElementById("procedure_label_nameError").innerHTML="Please Enter Valid Procedure Level";
		document.getElementById("procedure_label_name").focus();
		return false;
	}else {
		document.getElementById("procedure_label_nameError").innerHTML = "";
	}
	
	if (reimbursementpercentage == "") {
		document.getElementById("reimbursementpercentageError").innerHTML = "Please Enter Reimbursement %";
		document.getElementById("reimbursementpercentage").focus();
		return false;
	}else if(!reimbursementpercentage.match(numberReg)){
		document.getElementById("reimbursementpercentageError").innerHTML="Please Enter Valid Reimbursement";
		document.getElementById("reimbursementpercentage").focus();
		return false;
	}else if(reimbursementpercentage.length > 3 || reimbursementpercentage >100 ){
		document.getElementById("reimbursementpercentageError").innerHTML="Reimbursement should be less than 100";
		document.getElementById("reimbursementpercentage").focus();
		return false;
	}else {
		document.getElementById("reimbursementpercentageError").innerHTML = "";
	}
	
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/saveProcedureLabelMasterData",
		data: {
			"procedure_label_name": procedure_label_name,
			"reimbursementpercentage": reimbursementpercentage,
			"procedurelblid":procedurelblid,
			"status":status,
		},
		success: function(data) {
			// console.log(data);
			offRegister();
			var obj = jQuery.parseJSON(data);
			if (obj.status == "SUCCESS") {
				document.getElementById("succmsg").innerHTML = "Data Saved Successfully";
				document.getElementById("succmsgdiv").style.display = "block";
				$('#succmsgdiv').delay(5000).fadeOut(100);
				document.getElementById("reimbursementpercentage").value = "";
				document.getElementById("reimbursementpercentage").value = "";
				$("#saveProcLblButton").html("Submit");
				getProcedureLavelMasterData();
			}else if (obj.status == "FAILURE") {
				document.getElementById("failmsg").innerHTML = obj.message;
				document.getElementById("failmsgDiv").style.display = "block";
				$('#failmsgDiv').delay(5000).fadeOut(400);
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



function getProcedureLavelMasterData() {
	onRegister();
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getProcedureLabelMasterData",
		success: function(data) {
			//console.log("data--"+data)
			var data1 = jQuery.parseJSON(data);
			offRegister();
			if (data1.status == "SUCCESS") {
				var data2 = data1.data;
				//console.log("Data "+ data2);
				var i = 1;
				$("#procedureLavelTable").dataTable().fnClearTable();
				$("#procedureLavelTable").dataTable().fnDraw();
				$("#procedureLavelTable").dataTable().fnDestroy();
				var table = $('#procedureLavelTable').DataTable({
					"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						//{ "mData": null, render: function() { return i++; } },
						{ "mData": "procedurelblid" },
						{ "mData": "procedure_label_name" },
						{ "mData": "reimbursement_percentage" },
					    { "mData": "procedurelblid", render: function (data2, type, row) {
                             return '<button  id="editProcedureLabel" value="'+data2+'" class="btn btn-primary custom-btn" onclick="editProcedureLabel(this)">Edit&nbsp;</button>';
                        }
                      },
                      { "mData": "procedurelblid", render: function (data2, type, row) {
                    	return '<button  id="deleteProcedure" value="'+data2+'" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="FillProcedureDialog(this.value)">Inactive&nbsp;</button>';
               		}},
					],
				}).buttons().container().appendTo('#procedureLavelTable_wrapper .col-md-6:eq(0)');
			}
			else {
				var table = $('#procedureLavelTable').DataTable({
				}).buttons().container().appendTo('#procedureLavelTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
			offRegister();
			alert('Error: ' + e);
		}
	});
} 


function editProcedureLabel(value){
	
	  var row = jQuery(value).closest('tr')
      var procedurelblid = row[0].children[0].innerHTML;
   
     onRegister();
      $.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/getProcedureLabelDetailByProcedureLabelId",
		 data: {
			"procedurelblid":procedurelblid,
		},
           success: function(data){
			offRegister();
			console.log("data--"+data)
            var data1 = jQuery.parseJSON(data);
            console.log("data--"+data1.data);
            //console.log("data--"+data1.data.packagecode);
			if(data1.status=="SUCCESS"){
			//$("#version").select2().val(data1.data.version).trigger("change");
			document.getElementById("procedure_label_name").value=data1.data.procedure_label_name;
			document.getElementById("reimbursementpercentage").value=data1.data.reimbursementpercentage;
			document.getElementById("procedurelblid").value=data1.data.procedurelblid;
			document.getElementById("radiodiv").style.display="block";
			
			//$('#packagecode').attr('readonly', true);
			
			if(data1.data.status===1){
				$("#one").prop("checked", true);
			}else{
				$("#zero").prop("checked", true);
			}
			
			$("#saveProcLblButton").html("Update");
			getProcedureLavelMasterData();
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
  
  
  function FillProcedureDialog(value){
	document.getElementById("procedurelblid").value=value;
}
   function deleteProcedure() {
     procedurelblid  = document.getElementById("procedurelblid").value;
      onRegister();
      $.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/deleteProcedureLabelDetailByProcedureLabelId",
		 data: {
			"procedurelblid":procedurelblid,
		},
           success: function(data){
	 		offRegister();
            var data1 = jQuery.parseJSON( data );
			if(data1.status=="SUCCESS"){
				
			getProcedureLavelMasterData();
			
      		}
      		if(data1.status=="FAILURE"){
			}
        },
        error: function(e){
	      offRegister();
         }
    });
      
}
