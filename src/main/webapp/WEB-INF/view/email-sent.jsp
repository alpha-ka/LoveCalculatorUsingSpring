<!-- Spring MVC form tags copied from browser -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Email sent</title>
</head>
<body>

<form:form modelAttribute="emailDTO">
<!--Model/Cookiee/Session way -> <h3>Hi ${userName}</h3>  
Now used @SessionAttributes way ${SessionAttributename.propertyname}-->
<h3>Hi ${userInfoDTO.userName}</h3>
<h5>Email successfully sent to ${emailDTO.email}</h5>
</form:form>
</body>
</html>