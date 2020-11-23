<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css"/> 
</head>
<body>
 <h3> Account id is <span style="color: 'purple'" >${accid }</span></h3>
 <h3> Account name is ${firstName }</h3>
 <h3> email id is ${email }</h3>
 <h3> Balance  is ${balance }</h3>

 
 <a href="transfer.html"><button>transfer money</button></a>
</body>
</html>