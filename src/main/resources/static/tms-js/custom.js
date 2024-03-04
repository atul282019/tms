
/* JS For upload documents table */
	
var tbody = $('#addTableRow2').children('tbody');
	
	var table = tbody.length ? tbody : $('#addTableRow2');   
    $(document).on("click", "#addTableBtn2", function() {
      $('.saveTable2').attr('disabled', 'disabled');
      //Add row
      $("#addTableRow2").append('<tr><td><select class="form-control form-control-sm"><option>-- Select --</option><option>Aadhaar Card</option><option>ABHA Card</option></select></td><td><input type="file" class="custom-btn-sm btn-secondary"></td><td class="text-right"><button type="button" class="btn btn-sm RemoveTable2" title="Remove"><i class="fas fa-trash text-primary"></i></button><button type="button" class="btn btn-sm mr-1" id="addTableBtn2"><i class="fas fa-plus text-primary"></i></button></td></tr>');
    });
    $(document).on("click", ".RemoveTable2", function() {
      $(this).parent().parent().remove();
    })


    $('.saveTable2').attr('disabled', 'disabled');
    $('#addTableRow2 input').on('input', function () {
      $('.saveTable2').attr('disabled', 'disabled');
      var empty = false;
      $(this).closest("tr").find('input, select').each(function () {
        if ($(this).val() == '') {
          empty = true;
        }
      });
  
      if (empty) {
          $(this).parent().children('.saveTable2').attr('disabled', 'disabled');
      } else {
          $(this).parent().children('.saveTable2').removeAttr('disabled');
      }
    });

    $(document).on("click", ".saveTable2", function() {
      $(this).hide();
      $(this).parent().children(".editTable2").show();
      $(this).parent().parent().addClass("readonlyTable");
      $("#addTableRow2 .form-control").attr("readonly", true);
      var readonly_select = $('#addTableRow2 select');
      $(readonly_select).attr('readonly', true).attr('data-original-value', $(readonly_select).val()).on('change', function(i) {
        $(i.target).val($(this).attr('data-original-value'));
      });
    });
	
/* JS For upload documents table */

/* JS For upload documents Datatable */
$(function () {
  $(".table-document").DataTable({
    "responsive": true, 
    "lengthChange": false, 
    "autoWidth": false, 
    "searching": false,    
    "paging": false,
    "ordering": false,      
    "info": false,
  }).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');        
});

/* JS For upload documents Datatable */

/* JS For Get OTP */
$("#getOtp").on('click', function() {
  $("#getotpwrap").fadeIn(); 
});

$("#scanyourFinger").on('click', function() {
  $("#scanyourFingerwrap").fadeIn(); 
});

$("#captureyourBiometric").on('click', function() {
  $("#captureyourBiometricwrap").fadeIn(); 
});

$("#scanyourFace").on('click', function() {
  $("#scanyourFacewrap").fadeIn(); 
});
/* JS For Get OTP */
