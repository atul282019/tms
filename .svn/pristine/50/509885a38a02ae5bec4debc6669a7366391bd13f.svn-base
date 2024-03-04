 
 function onSchemeChange(){
	
	  document.getElementById('abhaDiv').style.display="none";
	  document.getElementById('aadhaarDiv').style.display="none";
	  document.getElementById('pmjayDiv').style.display="none";
	  document.getElementById('mobileDiv').style.display="none";
	  
	  var memberType = document.getElementById("id_name").value;
	
	 if(memberType =="1" ){
		document.getElementById('aadhaarDiv').style.display="block";
		var aadhar = document.getElementById("id_number").value;
	       if (aadhar == "") {
		    document.getElementById('aadhaarError').innerHTML ="Please Enter Aadhaar Number.";
	        document.getElementById("id_name").focus();
	        return false;
	      }
	      else{
			document.getElementById('aadhaarError').innerHTML ="";
		}
	
		}
	
	if(memberType =="2" ){
		document.getElementById('abhaDiv').style.display="block";
		var abhaNumber = document.getElementById("abhaNumber").value;
	       if (abhaNumber == "") {
		    document.getElementById('abhaNumberError').innerHTML ="Please Enter ABHA Number.";
	        document.getElementById("abhaNumber").focus();
	        return false;
	      }
	      else{
			document.getElementById('abhaNumberError').innerHTML ="";
		}
	
	}
	
	if(memberType =="3" ){
		document.getElementById('pmjayDiv').style.display="block";
		var pmjayId = document.getElementById("pmjayId").value;
	       if (pmjayId == "") {
		    document.getElementById('pmjayIdError').innerHTML ="Please Enter PMJAY Id.";
	        document.getElementById("id_name").focus();
	        return false;
	      }
	      else{
			document.getElementById('pmjayIdError').innerHTML ="";
		}
	
	}
	if(memberType =="4" ){
		document.getElementById('mobileDiv').style.display="block";
		var mobileNumber = document.getElementById("mobileNumber").value;
	       if (mobileNumber == "") {
		    document.getElementById('aadhaarError').innerHTML ="Please Enter Mobile Number.";
	        document.getElementById("mobileNumber").focus();
	        return false;
	      }
	      else{
			document.getElementById('mobileNumberError').innerHTML ="";
		}
	
	}
}
 function captureFace() {
	
      var aadhar = document.getElementById("id_number").value;
      var memberType = document.getElementById("id_name").value;
      var scheme = document.getElementById("schemename").value;
      
       if (scheme == "") {
		document.getElementById('schemenameError').innerHTML ="Please Select Scheme";
        document.getElementById("schemename").focus();
        return false;
      }
      else{
		document.getElementById('schemenameError').innerHTML ="";
	 }
	 if (memberType == "") {
		document.getElementById('id_nameError').innerHTML ="Please Select Member Type";
        document.getElementById("id_number").focus();
        return false;
      }
      else{
		document.getElementById('id_nameError').innerHTML ="";
	}
	
	if(memberType =="1" ){
	  var aadhar = document.getElementById("id_number").value;
       if (aadhar == "") {
	    document.getElementById('aadhaarError').innerHTML ="Please Enter Aadhaar Number.";
        document.getElementById("id_name").focus();
        return false;
      }
      else{
		document.getElementById('aadhaarError').innerHTML ="";
	}
	
	}
	
	if(memberType =="2" ){
		
		var abhaNumber = document.getElementById("abhaNumber").value;
       if (abhaNumber == "") {
	    document.getElementById('abhaNumberError').innerHTML ="Please Enter ABHA Number.";
        document.getElementById("abhaNumber").focus();
        return false;
      }
      else{
		document.getElementById('abhaNumberError').innerHTML ="";
	}
	
	}
	
	if(memberType =="3" ){
		
		var pmjayId = document.getElementById("pmjayId").value;
       if (pmjayId == "") {
	    document.getElementById('pmjayIdError').innerHTML ="Please Enter PMJAY Id.";
        document.getElementById("id_name").focus();
        return false;
      }
      else{
		document.getElementById('pmjayIdError').innerHTML ="";
	}
	
	}
	if(memberType =="4" ){
		var mobileNumber = document.getElementById("mobileNumber").value;
       if (mobileNumber == "") {
	    document.getElementById('aadhaarError').innerHTML ="Please Enter Mobile Number.";
        document.getElementById("mobileNumber").focus();
        return false;
      }
      else{
		document.getElementById('mobileNumberError').innerHTML ="";
	}
	
	}
	
       onScan();
      $.ajax({
        type: "POST",
        url: ""+$('#ctx').attr('content')+"/faceCaptureReq",
        data: {
          "aadhar": aadhar,
          "abhaNumber":abhaNumber,
          "pmjayId":pmjayId,
          "mobileNumber":mobileNumber,
          "bioType": 'P',
        },
        success: function (data) {
          console.log(data);
           offScan();
          var obj = jQuery.parseJSON(data);
          if (obj['status'] == "Y") {
             document.getElementById("face_id").src="data:image/jpeg;base64,"+obj['facePht'];
		    document.getElementById("pidData").value=obj['pidData'];
            
			document.getElementById("face_id").style.display = "block"
			
            //document.getElementById("faceIdCheck").style.display = "block";
            //document.getElementById("faceIdCancel").style.display = "none";
           // document.getElementById("radioI").disabled = true;
           // document.getElementById("radioF").disabled = true;
           //  document.getElementById("faceSeccess").value = "Y";
           document.getElementById("finger").disabled = true;
           document.getElementById("iris").disabled = true;

           document.getElementById("authType").value = "K";
           document.getElementById("faceBtn").disabled = true;
           document.getElementById("faceBtn").style.display = "inline";
           $(':input[type="submit"]').prop('disabled', false);
           $('#errorFaceKyc').hide('slow');
           
           bioBasedKyc('P');
          } 
           else if(obj['status'] == "N"){
   			 $(':input[type="submit"]').prop('disabled', true);
            document.getElementById("face_id").style.display = "none"
            $('#errorFaceKyc').html("Face Photo Capture Failed.");
            $('#errorFaceKyc').show('slow');

          }
          else {
   			 $(':input[type="submit"]').prop('disabled', true);
            document.getElementById("face_id").style.display = "none"
            $('#errorFaceKyc').html("Face Photo Capture Failed.");
            $('#errorFaceKyc').show('slow');

          }
        },
        error: function (e) {
			$(':input[type="submit"]').prop('disabled', true);
            offScan();
            alert('API Gateway not respond. Please try again.');
        }

      });
    }

    
    
     function bioBasedKyc(bioValue) {
                          
              var aadhar = document.getElementById("id_number").value;
              //var aadhar = document.getElementById("aadhar").value;
              var pidData = document.getElementById("pidData").value;

              if (pidData == "") {
                alert("Please Caputre Biometric.");
                return false;
              }
              onScan();
              $.ajax({
                type: "POST",
                url: ""+$('#ctx').attr('content')+"/bioBasedKyc",
                data: {
                  "aadhar": aadhar,
                  "pidData": pidData,
                  "bioType": bioValue
                },
                success: function (data) {
                  console.log(data);
                  offScan();
                  var obj = jQuery.parseJSON(data);
                  if (obj['status'] == "Y") {
	
					document.getElementById("ekyDetail").style.display="block";
                    document.getElementById("succmsg").innerHTML="ekyc Successfully completed.";
			        document.getElementById("succmsgdiv").style.display="block";
			        $('#succmsgdiv').delay(5000).fadeOut(400);
			 
                    $('#kycName').html(obj['kycName']);
                    $('#kycGender').html(obj['kycGender']);
                    $('#kycDob').html(obj['kycDob']);
					document.getElementById("phtId").src = "data:image/jpeg;base64," + obj['pht'];
					$('#kycAdr1').html(obj['kycAdr']);
					
                   //document.getElementById("phtId_1").value = "data:image/jpeg;base64," + obj['pht'];
                   $('#kycFname').html(obj['kycFname']);
                   document.getElementById("uidtoken").value = obj['uidToken'];  
                   document.getElementById("pht").value = obj['pht'];
                  
                   // document.getElementById("vtc_s").value = obj['vtc_s'];
                   document.getElementById("district_name_s").value = obj['district_name_s'];
                   document.getElementById("state_name_s").value = obj['state_name_s'];
                   document.getElementById("post_s").value = obj['post_s'];
                   //document.getElementById("uid_auth_type").value = '2';
                  // document.getElementById("verification_status").value = 'C';

                   
                  } 
                  else if (obj['status'] == "Y") {
						document.getElementById("failmsg").innerHTML="Beneficiary eKYC Authentication Failed.";
					    document.getElementById("failmsgDiv").style.display="block";
					    $('#failmsgDiv').delay(5000).fadeOut(400);
					    $(':input[type="submit"]').prop('disabled', true);
					}
                  else {
					 offScan(); 
					document.getElementById("failmsg").innerHTML="Beneficiary eKYC Authentication Failed.";
				    document.getElementById("failmsgDiv").style.display="block";
				    $('#failmsgDiv').delay(5000).fadeOut(400);
				    $(':input[type="submit"]').prop('disabled', true);
                  
                  }
                },
                error: function (e) {
	 				 $(':input[type="submit"]').prop('disabled', true);
              		 alert('API Gateway not respond. Please try again.');
                }

              });
  }





