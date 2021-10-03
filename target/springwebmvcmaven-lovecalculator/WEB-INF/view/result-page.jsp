<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<hr/>
<h2>The Love Calculator Predicts:</h2>
<br>
${userInfoDTO.userName} and ${userInfoDTO.crushName} are ${userInfoDTO.result}.

sessionresult:${sessionScope.userInfoDTO.result}
<br>
<br>
<!-- Passing value in URL path
<a href="/springwebmvcmaven-lovecalculator/sendEmail/${userInfoDTO.userName}">Send the result to Your Email</a>
Now we are already stored value in Cookie so not need to pass value in Path
 -->
<a href="/springwebmvcmaven-lovecalculator/sendEmail">Send the result to Your Email</a>

</body>
</html>