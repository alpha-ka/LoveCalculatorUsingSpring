<!-- Spring MVC form tags copied from browser -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- JSTL Core Tags -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Success</title>
</head>
<body>
	<h1 align="center">Your registration is Success</h1>
	<hr />
	Here the details which you entered :
	<br> User ID : ${userRegistrationDTO.userId}
	<br> User Name : ${userRegistrationDTO.userName}
	<br> Password : ${userRegistrationDTO.password}
	<br> Country : ${userRegistrationDTO.country}
	<br>
	<!-- To access for each we need jstl core dependency and jstl core tag-->
	Hobbies :
	<c:forEach var="hobby" items="${userRegistrationDTO.hobbies}">
  ${hobby}
  </c:forEach>



	<br> Gender : ${userRegistrationDTO.gender}
	<br>
	Age : ${userRegistrationDTO.age}
	<br>
 <h1 align="center"> Communication</h1>
<br>
	Email : ${userRegistrationDTO.communicationDTO.email}
	<br>
	Phone : ${userRegistrationDTO.communicationDTO.phone}

</body>
</html>