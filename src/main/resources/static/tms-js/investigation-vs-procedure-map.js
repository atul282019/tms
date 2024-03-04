
function schemeChange(){
	
	 $( "#statecode" ).val('').trigger('change');	
	 $( "#investigationcode" ).val('').trigger('change');	
	 $( "#procedureid" ).val('').trigger('change');		
}
  function getInvestigationMasterForProcMappingData() {
	
	var schemeid = document.getElementById("scheme").value;
	var statecode = document.getElementById("statecode").value;
	
	onRegister();
  	$.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/getInvestigationMasterForProcMappingData",
		  data: {    
				"schemeid":schemeid,
				"statecode":statecode,
       		 },
            success: function(data){
			offRegister();
            newData = data;
            //console.log(newData);
			$("#investigationid option").remove();
            var obj = jQuery.parseJSON( data );
            obj = obj.data;
             //console.log("-------"+obj);
        	 var count=0;
         	for (var key in obj) {

             var values =  obj[key];
             var x = document.getElementById("investigationid");
             if(count==0){
             var option = document.createElement("option");
             option.text ="Select Investigation";
             option.value = "";
             x.add(option);
             }
             var option = document.createElement("option");
             option.text = values.investigationcode+' | '+values.investigationname;
             option.value = values.investigationcode;
             x.add(option);

             count++;
             }   
         },
         error: function(e){
            // alert('Error: ' + e);
         }
    });
} 
function saveInvestigationProcedureMapping() {
	
	  var schemecode = document.getElementById("scheme").value;
	  var statecode = document.getElementById("statecode").value;
      var investigationcode = document.getElementById("investigationid").value;
      var procedurecode = document.getElementById("procedureid").value;
     
     
	 if (schemecode=="") {
		document.getElementById("schemeidError").innerHTML="Please Select Scheme";
		document.getElementById("schemeid").focus();
		return false;
	  }else{
		document.getElementById("schemeidError").innerHTML="";
	  }
	  
	   if (statecode=="") {
		document.getElementById("statecodeError").innerHTML="Please Select State";
		document.getElementById("statecode").focus();
		return false;
	  }else{
		document.getElementById("statecodeError").innerHTML="";
	  }
    if(investigationcode ==""){
		document.getElementById("investigationidError").innerHTML="Please Select Investigation Code";
		document.getElementById("investigationid").focus();
		return false;
	}
	else{
		document.getElementById("investigationidError").innerHTML="";
	}
	 if(procedurecode ==""){
		document.getElementById("procedureidError").innerHTML="Please Select Procedure COde";
		document.getElementById("procedureid").focus();
		return false;
	}
	else{
		document.getElementById("procedureidError").innerHTML="";
	}
      onRegister();
      $.ajax({
        type: "POST",
        url: ""+$('#ctx').attr('content')+"/saveInvestigationProcedureMapping",
      
        data: {
	          "schemeid": schemecode,
	          "statecode": statecode,   
	          "investigationcode": investigationcode,
	          "procedurecode": procedurecode,  
	          "status": 1,   
        },
        success: function (data) {
         // console.log(data);
          offRegister();
          var obj = jQuery.parseJSON(data);
          if (obj.status == "SUCCESS") {
	
             document.getElementById("succmsg").innerHTML="Data Saved Successfully";
			 document.getElementById("succmsgdiv").style.display="block";
			 $('#succmsgdiv').delay(5000).fadeOut(1000);
            
		     $( "#scheme" ).val('').trigger('change');	
			 $( "#statecode" ).val('').trigger('change');	
			 $( "#investigationid" ).val('').trigger('change');	
			 $( "#procedureid" ).val('').trigger('change');		
				
     	  }
          else if(obj.status=="FAILURE"){
				 document.getElementById("failmsg").innerHTML=obj.message;
				 document.getElementById("failmsgDiv").style.display="block";
				 $('#failmsgDiv').delay(5000).fadeOut(2000);
				 			}
           else {
	        offRegister();
	        alert('API Gateway not respond. Please try again.');
        
          }
        },
        error: function (e) {
			offRegister();
         	alert('API Gateway not respond. Please try again.');
        }

      });
}

function getInvestigationProcedureMappingData(){
	
	onRegister();
  	$.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/getInvestigationProcedureMappingData",
           success: function(data){
			//console.log("data--"+data)
			offRegister();
            var data1 = jQuery.parseJSON( data );
			if(data1.status=="SUCCESS"){
			var data2 = data1.data;
			//console.log("Data "+ data2);
			 var i=1;
             var table = $('#investigationProcedureMapping').DataTable( {	
			 "responsive": true, "lengthChange": true, "autoWidth": false,"pagingType": "full_numbers","pageLength": 50,
             "buttons": [ "csv", "excel"],
             "language": {"emptyTable": "No Data available"  },
	         "aaData": data2,
      		  "aoColumns": [ 
	 			{"mData": null, render: function(){return i++;}   },
				{ "mData": "investigationcode"},
      		    { "mData": "procedurecode"},
      		    { "mData": "investigationname"},
      		    { "mData": "procedurename"},
				],
				
      		}).buttons().container().appendTo('#investigationProcedureMapping_wrapper .col-md-6:eq(0)');
      		}
      		else{
			 var table = $('#implantTable').DataTable( {	
      		}).buttons().container().appendTo('#investigationProcedureMapping_wrapper .col-md-6:eq(0)');
			}
        },
        error: function(e){
			offRegister();	
            
         }
    });
	
}
     