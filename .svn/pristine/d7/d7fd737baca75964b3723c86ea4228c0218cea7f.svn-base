
function getInvestigationMasterApproval() {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getinvestigation-master-approval",
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			console.log(data);
			if (data1.status == "SUCCESS") {
				var data2 = data1.data;
				var table = $('#implantApprovalTable').DataTable({
					"destroy":true,"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						{ "mData": "id" },
						{ "mData": "investigationcode" },
						{ "mData": "investigationname" },
						{ "mData": "state_name" },
						{ "mData": "approvalstatus" },
						{ "mData": "approved_by_userid" },
						{ "mData": "approval_date" },
						{
							"mData": "id", "render": function(data2, type, row) {
								if(row.approvalstatus==='Review Done'){
									return '';
								}else{
									return '<button  id="approveSpeciality" value="' + data2 + '" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="fill(this.value)">Review&nbsp;</button>';
								}
							}
						},
					
					],

				}).buttons().container().appendTo('#implantApprovalTable_wrapper .col-md-6:eq(0)');
			} else {
				var table = $('#implantApprovalTable').DataTable({
				}).buttons().container().appendTo('#implantApprovalTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
		}
	});
}

function fill(value) {
	document.getElementById("deleteImplant").value = value;
}

function ApproveImplantDialog() {
	id = document.getElementById("deleteImplant").value;
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/approveInvestigationMasterData",
		data: {
			"id": id,
		},
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				getInvestigationMasterApproval();
			}
			if (data1.status == "FAILURE") {
			}
		},
		error: function(e) {
			offRegister();
		}
	});
}