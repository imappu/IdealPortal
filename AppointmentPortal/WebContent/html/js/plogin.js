 $(document).ready(DocReady);

function  DocReady(){

	username=document.getElementById("username").value;
	password =document.getElementById("password").value;
	
 $("#patientLogin").validate({
 	errorClass: 'error',
 	rules: {

 	username:"required",
 	password : {
 				required:true,
				minlength : 5
 				},

 	},

 	messages: {
      username: "<br>"+ "Please enter username",
      password:"<br>"+"Valid password is required"
 	},

 	
 });
}
