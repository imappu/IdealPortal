function cancelappoint() {
	name = document.getElementById("firstname").value;
	contact = document.getElementById("contact").value;

	var uname = /^[a-zA-Z\-]+$/;
	var cont = /^[0-9]/;
	var conlen = contact.length;

	if (name == "") {

		alert("Enter Name");
		return false;
	}

	if (contact == "") {
		alert("Enter Contact Number");
		return false;
	}

	if (conlen != 10) {
		alert("Mobile number should be 10 digits");
		return false;
	}

	else {
		if (name.match(uname) && contact.match(cont) && conlen == 10) {
			alert('validation done');
			return true;
		}
	}
}
