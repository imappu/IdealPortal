$(document).ready(DocReady);

function DocReady() {

	username = document.getElementById("username").value;
	password = document.getElementById("password").value;

	$("#adminLogin").validate({
		errorClass : 'error',
		rules : {

			username : "required",
			password : {
				required : true
			},

		},

		messages : {
			username : "<br>" + "Please enter username",
			password : "<br>" + "Valid password is required"
		},

	});
}
