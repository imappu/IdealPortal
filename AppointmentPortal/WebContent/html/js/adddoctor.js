$(document).ready(DocReady);


function  DocReady(){

	doctorName=document.getElementById("doctorName").value;
	department=document.getElementById("department").value;
	qualification=document.getElementById("qualification").value;

	$("#adddoctor").validate({
			errorClass: 'error',
			rules: {
				doctorName:{
					required:true,
					regex:'^[A-Za-z]+$'
				},
				department:"required",
				qualification:{
					required:true,
					
				}
			},
			messages:{
				doctorName:"Please enter valid Doctor's name",
				department:"Please select department name",
				qualification:"Please enter valid qualification"
			},

			 submitHandler() {
			 }

 });
	
	}




