<!-- Spring MVC form tags copied from browser -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
<style type="text/css">
.error{
color:red;
position:fixed;
text-align: left;
margin-left: 30px;
}
</style>
<!-- Client side validation -->
<script type="text/javascript">
function validateFields()
{
	var userId=document.getElementById('userId').value;
	if(userId.length < 1 )
		{
		alert("Please enter atleast one character.");
		return false;
		}
	else
		{
		return true;
		}
}


</script>
</head>
<body>
	<h1 align="center">Registration Form</h1>
	<hr />
	<!-- If we didn't mention method then by default it will be get -->
	<form:form action="process-registration" method="get"		modelAttribute="userRegistrationDTO" >
		<div align="center">

			<label for="userId">User ID :</label>
			<form:input path="userId" id="userId" />
			<form:errors path="userId" cssClass="error"></form:errors>
			<br> 
			<label for="un">User Name :</label>
			<form:input path="userName" id="un" />

			<br> 
			<label for="p">Password :</label>
			<form:password path="password" id="p" />

			<br> 
			<label for="c">Country :</label>
			<form:select path="country" id="c">
				<form:option value="IND" label="India"></form:option>
				<form:option value="USA" label="United States"></form:option>
				<form:option value="PAK" label="Pakistan"></form:option>
				<form:option value="SL" label="Sri Lanka"></form:option>
			</form:select>
			<br>
			<label for="h">Hobbies :</label>
			<form:checkbox path="hobbies" id="h" value="Cricket"/> Cricket
			<form:checkbox path="hobbies" id="h" value="Reading"/> Reading
			<form:checkbox path="hobbies" id="h" value="Travel"/> Travel
			<form:checkbox path="hobbies" id="h" value="Programming"/> Programming
			<form:checkbox path="hobbies" id="h" value="Games"/> Games
			<br>
			<label for="a">Age : </label>
			<form:input path="age" id="a"/>
			<br>
			<label for="g">Gender :</label>
			<form:radiobutton path="gender" id="g" value="Male"/> Male
			<form:radiobutton path="gender" id="g" value="Female"/> Female
					<br>
			
 <h1 align="center"> Communication</h1>
		<label>Email :</label>
		<form:input path="communicationDTO.email"/>
		<label>Phone :</label>
		<form:input path="communicationDTO.phone"/>
		<br>
		<br>
		
		<input type="submit" value="Register">
		</div>
	</form:form>

</body>
</html>