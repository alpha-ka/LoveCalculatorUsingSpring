<!-- Spring MVC form tags copied from browser -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
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
	var userName=document.getElementById('yn').value;
	var crushName=document.getElementById('cn').value;
	if(userName.length < 3 || crushName < 3)
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
<h1 align="center">Love Calculator</h1>
<hr/>
<!--   onsubmit="return validateFields()"-->
<form:form action="process-homepage" method="get" modelAttribute="userInfoDTO" onsubmit="return validateFields()">

<div align="center">
	<p>
	<label for="yn">Your Name : </label>
	<!-- path attribute binds the form field to the bean property. 
	path name should be same as variable name in DTO table-->
	<form:input type="text" path ="userName" id="yn" />
	<form:errors path="userName" cssClass="error"></form:errors>
	</p>
	<p>
	<label for="cn">Crush Name : </label>
	<form:input type="text" path ="crushName" id="cn" />
	<form:errors path="crushName"  cssClass="error"></form:errors>
	</p>
	<p>
	<form:checkbox path="termsAndConditions" id="check"/>
	<label for="check">I am agreeing that this is for fun.</label>
	<form:errors path="termsAndConditions" cssClass="error"></form:errors>
	</p>
	<input type="submit" value="Calculate"/>
	</div>
</form:form>

</body>
</html>