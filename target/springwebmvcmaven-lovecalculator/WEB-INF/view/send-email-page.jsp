<!-- Spring MVC form tags copied from browser -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Send Mail</title>
<style type="text/css">
.error{
color: red;
position: fixed;
text-align: left;
margin-left: 30 px;

}
</style>

</head>
<body>
<h2>Send Results To Your Email</h2>
<form:form action="processEmail" method="GET" modelAttribute="emailDTO">
<!--Model/Cookiee/Session way -> <h3>Hi ${userName}</h3>  
Now used @SessionAttributes way ${SessionAttributename.propertyname}-->
<h3>Hi ${userInfoDTO.userName}</h3>
<label for="e">Your email :</label>
<form:input path="email" id="e"/>

<input type="submit" value="Send"/>
<form:errors path="email" cssClass="error"></form:errors>

</form:form>

</body>
</html>