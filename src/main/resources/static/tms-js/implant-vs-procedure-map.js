
function schemeChange(){
	 $( "#statecode" ).val('').trigger('change');	
	 $( "#implantcode" ).val('').trigger('change');	
	 $( "#procedureid" ).val('').trigger('change');		
}
  function getImplantForProcedureMapByState() {
		var schemeid = document.getElementById("scheme").value;
		var statecode = document.getElementById("statecode").value;
  		$.ajax({
		 type: "POST",
		 url:""+$('#ctx').attr('content')+"/getImplantForProcedureMapByState",
         data: {    
				"schemeid":schemeid,
				"statecode":statecode,
       		 },
           success: function(data){
            newData = data;
			$("#implantid option").remove();
            var obj = jQuery.parseJSON( data );
            obj = obj.data;
    		 var x = document.getElementById("implantid");
             var option = document.createElement("option");
             option.text ="Select Implant";
             option.value = "";
             x.add(option);
         	for (var key in obj) {
	             var values =  obj[key];
	             var option = document.createElement("option");
	             option.text = values.implantname;
	             option.value = values.implantcode;
	             x.add(option);
             }   
         },
         error: function(e){
             alert('Error: ' + e);
         }
    });
 } 
 function saveImpProcMapping(){
	
	var schemecode = document.getElementById("scheme").value;
	var statecode = document.getElementById("statecode").value;
	var implantcode = document.getElementById("implantid").value;
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
	  
	   if (implantcode=="") {
		document.getElementById("implantidError").innerHTML="Please Select Implant";
		document.getElementById("implantid").focus();
		return false;
	  }else{
		document.getElementById("implantidError").innerHTML="";
	  }
	  
	    if (procedurecode=="") {
		document.getElementById("procedureidError").innerHTML="Please Select Procedure";
		document.getElementById("procedureid").focus();
		return false;
	  }else{
		document.getElementById("procedureidError").innerHTML="";
	  }
	  
	onRegister();
	 	$.ajax({
		type: "POST",
	     url:""+$('#ctx').attr('content')+"/saveImpProcMapping",
         data: {    
				"implantcode":implantcode,
				"procedurecode":procedurecode,
				"schemeid":schemecode,
				"statecode":statecode,
				"status":1,
       		 },
    	 
            success: function(data){
	  		offRegister();
            newData = data;
			var data1 = jQuery.parseJSON(newData);
			console.log(data1)
			if(data1.status=="SUCCESS"){
				 document.getElementById("succmsg").innerHTML="Data Saved Successfully";
				 document.getElementById("succmsgdiv").style.display="block";
				 document.getElementById("failmsgDiv").style.display="none";
				 
			     
			     $( "#scheme" ).val('').trigger('change');	
				 $( "#statecode" ).val('').trigger('change');	
				 $( "#implantid" ).val('').trigger('change');	
				 $( "#procedureid" ).val('').trigger('change');		
				
				 $('#succmsgdiv').delay(5000).fadeOut(1000);
			
				}else if(data1.status=="FAILURE"){
				 document.getElementById("failmsg").innerHTML=data1.message;
				 document.getElementById("failmsgDiv").style.display="block";
				 document.getElementById("succmsgdiv").style.display="none";
				 $('#failmsgDiv').delay(5000).fadeOut(2000);
				}else{
				 document.getElementById("failmsgDiv").style.display="none";
				 document.getElementById("succmsgdiv").style.display="none";
				 document.getElementById("FailedError").innerHTML="API Gateway not respond. Please try again.";
			}
         },
         error: function(e){
	  		 offRegister();
           
         }
    });				
}


function getImplantProcedureMappingData(){
	onRegister();
  	$.ajax({
		type: "POST",
		 url:""+$('#ctx').attr('content')+"/getImpProcMapppingTableData",
           success: function(data){
			//console.log("data--"+data)
            var data1 = jQuery.parseJSON( data );
			if(data1.status=="SUCCESS"){
			offRegister();
			var data2 = data1.data;
			//console.log("Data "+ data2);
			 var i=1;
             var table = $('#implantVsProcedureMapping').DataTable( {	
			 "responsive": true, "lengthChange": true, "autoWidth": false,"pagingType": "full_numbers","pageLength": 50,
             "buttons": [ "csv", "excel"],
             "language": {"emptyTable": "No Data available"  },
	         "aaData": data2,
      		  "aoColumns": [ 
	 			{"mData": null, render: function(){return i++;}   },
				{ "mData": "implantcode"},
				{ "mData": "procedurecode"},
				{ "mData": "implantname"},
      		    { "mData": "procedurename"},
      		  
				],
				
      		}).buttons().container().appendTo('#implantVsProcedureMapping_wrapper .col-md-6:eq(0)');
      		}
      		else{
			 var table = $('#SpecialityTable').DataTable( {	
      		}).buttons().container().appendTo('#implantVsProcedureMapping_wrapper .col-md-6:eq(0)');
			}
        },
        error: function(e){
	      offRegister();  
         }
    });
    
  }  
     