
function getSpecialityMasterApproval() {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getSpecialityMasterApproval",
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				var data2 = data1.data;
				var table = $('#SpecialityApprovalTable').DataTable({
					"destroy":true,"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						{ "mData": "specialityid" },
						{ "mData": "specialitycode" },
						{ "mData": "specialityname" },
						{ "mData": "specialitytype" },
						{ "mData": "state_name" },
						{ "mData": "approvalstatus" },
					/*	{ "mData": "approved_status" },*/
						{ "mData": "approved_by" },
						{ "mData": "approval_date" },
						
						{
							"mData": "id", "render": function(data2, type, row) {
								if(row.approvalstatus==='Review Done'){
									return '';
								}
								
								else{
									return '<button  id="approveSpeciality" value="' + data2 + '" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="fill(this.value)">Review&nbsp;</button>';
								}
							}
						},
					],

				}).buttons().container().appendTo('#SpecialityApprovalTable_wrapper .col-md-6:eq(0)');
			} else {
				var table = $('#SpecialityApprovalTable').DataTable({
				}).buttons().container().appendTo('#SpecialityApprovalTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
		}
	});
}

function fill(value) {
	document.getElementById("deleteid").value = value;
}

function ApproveSpecialityDialog() {
	id = document.getElementById("deleteid").value;
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/approveSpecialityMasterData",
		data: {
			"id": id,
		},
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				getSpecialityMasterApproval();
			}
			if (data1.status == "FAILURE") {
			}
		},
		error: function(e) {
			offRegister();
		}
	});
}