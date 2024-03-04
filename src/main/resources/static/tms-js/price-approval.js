
function getPriceMasterApproval() {
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/getprice-master-approval",
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			console.log(data);
			if (data1.status == "SUCCESS") {
				var data2 = data1.data;
				var table = $('#priceApprovalTable').DataTable({
					"destroy":true,"responsive": true, "lengthChange": true, "autoWidth": false, "pagingType": "full_numbers", "pageLength": 50,
					"buttons": ["csv", "excel"], "aaSorting": [],
					"language": { "emptyTable": "No Data available" },
					"aaData": data2,
					"aoColumns": [
						{ "mData": "id" },
						{ "mData": "specialtycode" },
						{ "mData": "packagecode" },
						{ "mData": "procedurecode" },
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
						{ "mData": "nrp" },
						{ "mData": "tier1" },
						{ "mData": "tier1" },
						{ "mData": "tier1" },
					],

				}).buttons().container().appendTo('#priceApprovalTable_wrapper .col-md-6:eq(0)');
			} else {
				var table = $('#priceApprovalTable').DataTable({
				}).buttons().container().appendTo('#priceApprovalTable_wrapper .col-md-6:eq(0)');
			}
		},
		error: function(e) {
		}
	});
}

function fill(value) {
	document.getElementById("deletePrice").value = value;
}

function ApproveSpecialityDialog() {
	id = document.getElementById("deletePrice").value;
	$.ajax({
		type: "POST",
		url: "" + $('#ctx').attr('content') + "/approvePriceMasterData",
		data: {
			"id": id,
		},
		success: function(data) {
			var data1 = jQuery.parseJSON(data);
			if (data1.status == "SUCCESS") {
				getPriceMasterApproval();
			}
			if (data1.status == "FAILURE") {
			}
		},
		error: function(e) {
			offRegister();
		}
	});
}