<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1 align="center">Love Calculator</h1>
<hr/>

<form action="process-homepage" method="get">
<div align="center">
	<p>
	<label for="yn">Your Name : </label>
	<input type="text" name ="userName" id="yn'" />
	</p>
	<p>
	<label for="cn">Crush Name : </label>
	<input type="text" name ="crushName" id="y=cn'" />
	</p>
	<input type="submit" value="Calculate"/>
	</div>
</form>

</body>
</html>