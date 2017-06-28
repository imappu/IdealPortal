<!DOCTYPE html>
<html lang="en">
<head>
<title>View Appointments</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="view.css">
</head>
<body>
<%@ page import="com.application.entity.AppointmentRegister" %>  
<%@ page import="com.application.entity.Patient" %>  
<%@ page import="java.util.*" %>  

<div class="container">
		<center>
		<h2 style="color: green;">Appointment Table</h2>
		</center>
			<%
			
			Object appointmentRegisterObject=request.getAttribute("list");
			Object patientRegisterObject=request.getAttribute("patientDetails");
			List<AppointmentRegister> appointmentlist=(List<AppointmentRegister>)appointmentRegisterObject; 
			List<Patient> patientList=(List<Patient>)patientRegisterObject; 
			
			%>
			
		<table class="table table-bordered" style="border-radiusazimuth: 5px;">
			<thead>
				<tr>
					<th>Appointment ID</th>
					<th>Patient Name</th>
					<th>Department Name</th>
					<th>Doctor Name</th>
					<th>Date</th>
					<th>Slot-01</th>
					<th>Slot-02</th>
					<th>Slot-03</th>
					<th>Slot-04</th>
				</tr>
			</thead>
			
			<%
				for (int appointmentlistsize = 0; appointmentlistsize < appointmentlist.size(); appointmentlistsize++) {
			%>

			<tbody>
				<tr>
					<td><%out.print(appointmentlist.get(appointmentlistsize).getAid()); %></td>
					<td><%out.print(patientList.get(0).getFirstName().toString()); %></td>
					<td><%out.print(appointmentlist.get(appointmentlistsize).getDepartment()); %></td>
					<td><%out.print(appointmentlist.get(appointmentlistsize).getDoctorname()); %></td>
					<td><%out.print(appointmentlist.get(appointmentlistsize).getBookeddate()); %></td>
					<%String slot="";
					String loggedInUser= request.getSession().getAttribute("username").toString();%>
					
					
						
					<td><%
					if( loggedInUser.equals(appointmentlist.get(appointmentlistsize).getSlot01()))
					{
					out.print("10AM-11AM");}
					else{out.print("---");}%>
					</td>
					
					<td><%
					if( loggedInUser.equals(appointmentlist.get(appointmentlistsize).getSlot02()))
					{
					out.print("11AM-12PM");}
					else{out.print("---");}%>
					</td>
					
					<td><%
					if(loggedInUser.equals(appointmentlist.get(appointmentlistsize).getSlot03()))
					{
					out.print("12PM-13M");}
					else{out.print("---");}%>
					</td>
					
					
					<td><%
					if( loggedInUser.equals(appointmentlist.get(appointmentlistsize).getSlot04()))
					{
					out.print("13PM-14PM");}
					else{out.print("---");}%>
					</td>
					
			</tbody>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>
