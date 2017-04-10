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
<title align ="center">LOGIN</title>
</head>
<c:if test="${not empty loginError}">
    <script>alert("Incorrect Username or Password.Try Again!");
</script>
</c:if>
<style>
.btn {
    margin: 10px auto;
}
</style>
<body>
<div class="container">
<div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" align="left" href="#">MakingFriends.com</a>
    </div>
<div class="page-header">

<h3>LOGIN</h3>
</div>
<form action="login" method="post">
<table>
<tr>
<th>USERNAME</th>
	<td><input type = "text" name = "username"/></td>
</tr>
<tr>
<th>PASSWORD</th>
	<td><input type = "password" name = "password"/></td>
</tr>
</table>
<div class="col-md-4 text-center">
<input type ="submit" class ="btn btn-info" value ="LOGIN"/>
</div>
</form>
</div>
</body>
</html>