
function getPackageMasterApproval() {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getPackageMasterApproval",
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				var data2 = data1.data;
				var table = $('#packageApprovalTable').DataTable({
					"destroy":true,"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						{ "mData": "pkgid" },
						{ "mData": "specialtycode" },
						{ "mData": "packagecode" },
						{ "mData": "packagename" },
						{ "mData": "state_name" },
						{ "mData": "approvalstatus" },
						{ "mData": "approved_by" },
						{ "mData": "approval_date" },
						{
							"mData": "pkgid", "render": function(data2, type, row) {
								if(row.approvalstatus==='Review Done'){
									return '';
								}else{
									return '<button  id="approveSpeciality" value="' + data2 + '" class="btn btn-primary custom-btn" data-toggle="modal" data-target="#modal-sm" onclick="fill(this.value)">Review&nbsp;</button>';
								}
							}
						},
					],

				}).buttons().container().appendTo('#packageApprovalTable_wrapper .col-md-6:eq(0)');
			} else {
				var table = $('#packageApprovalTable').DataTable({
				}).buttons().container().appendTo('#packageApprovalTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
		}
	});
}

function fill(value) {
	document.getElementById("deleteid").value = value;
}

function ApprovePackageDialog() {
	packageid = document.getElementById("deleteid").value;
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/approvePackageMasterData",
		data: {
			"packageid": packageid,
		},
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				getPackageMasterApproval();
			}
			if (data1.status == "FAILURE") {
			}
		},
		error: function(e) {
			offRegister();
		}
	});
}