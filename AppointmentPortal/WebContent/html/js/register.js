$(document).ready(DocReady);

function DocReady() {

	firstname = document.getElementById("firstname").value;
	lastname = document.getElementById("lastname").value;
	contact = document.getElementById("contact").value;
	email = document.getElementById("email").value;
	password = document.getElementById("password").value;
	password_confirm = document.getElementById("password_confirm").value;
	dob = document.getElementById("dob").value;
	gender = document.getElementById("gender").value;
	address = document.getElementById("address").value;

	$("#register-form").validate({
		errorClass : 'error',
		rules : {
			firstname : "required",
			// lastname: "required",
			contact : {
				required : true,
				regex : "[0-9]{10}"
			},
			email : {
				required : true,
				email : true
			},
			password : {
				minlength : 5
			},
			password_confirm : {
				minlength : 5,
				equalTo : "#password"
			},

			dob : "required"
		},

		messages : {
			color : "#RRGGBB",
			firstname : "Please enter your first name",
			lastname : "Please enter your last name",
			contact : "Please enter valid contact number",
			email : "Please enter a valid email address",
			password_confirm : "password did not match",
			dob : "Please enter your date of birth"
		},

	});

	/**
	 * @param Name, Function, String message.
	 * name: The name of the method used to identify it and referencing it
	 * Function:The actual method implementation, returning true if an element is valid
	 * 			
	 * 			@param: First argument: the current value of the validated element
	 * 					
	 * 					Second argument: the element to be validated
	 * 					
	 * 					Third argument: parameters specified for the method
	 */
	$.validator.addMethod("regex", function(value, element, regexp) {
		var re = new RegExp(regexp);
		return this.optional(element) || re.test(value);
	}, "Please check your input.");

	$("#dob").datepicker({
		maxDate : new Date()
	});

}
