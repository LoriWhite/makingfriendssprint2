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
<title>SETTIME</title>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
            	$("#datepicker").datepicker({
            		  minDate: 0,
            		 dateFormat: 'yy-mm-dd'
            		});

            });
        </script>
        <c:if test="${not empty mintime}">
    <script>
    alert("Atleast 30 minutes should be available");
</script>
</c:if>

<c:if test="${not empty totime}">
    <script>
    alert("Set valid to time");
</script>
</c:if>
<c:if test="${not empty fromtime}">
    <script>
    alert("Set valid From time");
</script>
</c:if>
<c:if test="${not empty datetime}">
    <script>
    alert("Select Valid Date");
</script>
</c:if>
      <style>
table.ex1 {
    border-collapse: separate;
    border-spacing: 10px;
    margin: 0 auto;
}
td{
	background-color:black;
}
body {
      font: 20px Montserrat, sans-serif;
      line-height: 1.8;
     
  }
  p {font-size: 16px;}
  .margin {margin-bottom: 45px;}
  
  .container-fluid {
      padding-top: 70px;
      padding-bottom: 70px;
  }
  .navbar {
      padding-top: 15px;
      padding-bottom: 15px;
      border: 0;
      border-radius: 0;
      margin-bottom: 0;
      font-size: 12px;
      letter-spacing: 5px;
  }
  .navbar-nav  li a:hover {
      color: #1abc9c !important;
  }
</style>

</head>
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
  </div>
  
<div class="container-fluid bg-1 text-center">
<form action="timeinsert" method="post">
<table class = "ex1">
<tr>
<th>DATE</th>
	<td><input type ="text" name = "date1" placeholder="yyyy-mm-dd" id = "datepicker"/></td>
</tr>

<tr>
<th>FROM</th>
	<td><input type ="text" name ="from" placeholder="00:00"/></td>
	
<th>TO</th>
	<td><input type ="text" name = "to" placeholder="23:59"/></td>
</tr>
<tr>
<td align="center"><input type ="submit" value ="SUBMIT"/></td>
</tr>
<tr>
<td><input type="hidden" name="uname" value='${uname}'/></td>
</tr>
</table>
</form>
<img src="https://68.media.tumblr.com/ae7ca1e08107060274e0ec1e868b6142/tumblr_o7f437VYMQ1vqb4g5o1_500.gif" class="img-responsive img-circle margin" style="display:inline" alt="time" width="350" height="350">
</div>
</body>
</html>