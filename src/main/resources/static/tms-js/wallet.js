

function walletBalance() {
	 // var hhid = document.getElementById("hhid");
	 var hhid = "ITIT000090055";
      onRegister();
      $.ajax({
        type: "POST",
        url: ""+$('#ctx').attr('content')+"/getWalletBalance",
      
        data: {
          "hhid": hhid,
        },
        success: function (data) {
//          console.log(data);
          offRegister();
          var obj = jQuery.parseJSON(data);
//          console.log("----------"+obj)
          if(data.length===0){
          document.getElementById("walletBlance").innerHTML=obj[0].total_balance_amount;
          }
          else{
				document.getElementById("walletBlance").innerHTML="0.00";
		}
        },
        error: function (e) {
			offRegister();
        
        }

      });
}




function getRegisteredPatientList() {
  	$.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/getRegisteredPatient",
           success: function(data){
            var data1 = jQuery.parseJSON( data );
			
			if(data1.status=="SUCCESS"){
			var data2 = data1.data;
			console.log("Data "+ data2);
			 var i=1;
             var table = $('#example1').DataTable( {	
			 "responsive": true, "lengthChange": true, "autoWidth": false,"pagingType": "full_numbers","pageLength": 50,
             "buttons": [ "csv", "excel"],
             "language": {"emptyTable": "No Data available"  },
	         "aaData": data2,
      		  "aoColumns": [ 
	 			{"mData": null, render: function(){return i++;}   },
				{ "mData": "txnid"},
      		    { "mData": "id_name"},
      		    { "mData": "id_number"},
      		    { "mData": "schemename"},
      		    { "mData": "authmode"},          
      		    
      		    { "mData": null,
                        render: function () {
                             return '<a  href="#" id="viewPreAuth" onclick="viewPreAuth(this)">Initiate Preauth</a>';
  
                        }
                      },
				],
				
      		}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
      		}
      		else{
			 var table = $('#example1').DataTable( {	
      		}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
			}
        },
        error: function(e){
            alert('Error: ' + e);
         }
    });
} 
 
  function viewPreAuth(value) {
      var row = jQuery(value).closest('tr')
      var txnid = row[0].children[1].innerHTML;
      var txnid = txnid.trim();
      localStorage.setItem("txnid", txnid);
      window.location.href = ""+$('#ctx').attr('content')+"/preauth";
   
  }
  
  
        
function getPatientCountTodatAndTotal() {
	
  	$.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/getPatientCountTodatAndTotal",
		  data: {
       
        },
           success: function(data){
            var data1 = jQuery.parseJSON( data );
			if(data1.status=="SUCCESS"){
			var data2 = data1.data;
			console.log("Data "+ data2);
          	document.getElementById("todayRegisteredPatient").innerHTML=data2[0].todaypatient;
          	document.getElementById("totalRegisteredPatient").innerHTML=data2[0].totalpatient;
      		}
      		else{
			 	alert('API Gateway not respond. Please try again.');
			}
        },
        error: function(e){
			alert('API Gateway not respond. Please try again.');
         }
    });
} 
 
