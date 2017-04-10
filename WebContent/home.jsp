<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>HOME</title>
<style>
.btn {
    margin-right: 5px;
}
</style>
<style>
table.ex1 {
    border-collapse: separate;
    border-spacing: 20px;
}
</style>
</head>
<c:if test="${not empty updatedmessage}">
    <script>
    alert("Profile saved");
</script>
</c:if>

<body>
<div class = "container">
<div class = "page-header">
<h1>Welcome !</h1>
    <div class="btn-toolbar pull-right">
    	<table align ="right" style="margin-top:10px" class = "ex1">
    	<tr>
        <form action="profile" method="get">
		<td><input type ="submit" name="PROFILE" button class ="btn btn-info" value ="PROFILE"/></td>
		</form>
		<form action="logout" method="post">
		<td><input type ="submit" name="LOGOUT" button class ="btn btn-info" value ="LOGOUT"/></td>
		</form>
         </tr>
        </table>
    </div>
 </div>

 <h3 align ="left">Hello, </h3>
 <h3>${uname}</h3>
 <table align ="Center" style="margin-top:50px" class = "ex1">
 <tr>
 <form action="matchuser" method="post">
<td align="left"><input type ="submit" name="MATCH" button class ="btn btn-info" value ="MATCH"/></td>
</form>
<form action="meet" method="post">
<td align="center"><input type ="submit" name="MEET" button class ="btn btn-info" value ="MEET"/></td>
</form>
<form action="notification" method="post">
<td align="right"><input type ="submit" name="NOTIFICATIONS" button class ="btn btn-info" value ="NOTIFICATIONS"/></td>
</form>
</tr>
</table>
 </div>
</body>
</html>