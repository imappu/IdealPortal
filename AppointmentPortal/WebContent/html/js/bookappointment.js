$(document).ready(DocReady);

function DocReady() {
	
	department = document.getElementById("department").value;
	date=document.getElementById("date").value;
	timeslot = document.getElementById("timeslot").value;

	$("#appointment-form").validate({
		errorClass : 'error',
		rules : {
			department : "required",
			date : "required",
			timeslot : "required",
			
		},

		messages : {
			color : "#RRGGBB",
			department : "Please select department",
			date : "Please select date",
			timeslot:"Please select timeslot",
		},

	});
	

	$("#date").datepicker({
		minDate : new Date(),maxDate: "+7D"
	});

}
