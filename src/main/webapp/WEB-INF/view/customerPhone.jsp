<%@include file="/WEB-INF/view/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
		color: #ff0000;
	font-family: Arial, Helvetica;
	font-size: 12px;
	font-weight: 550;
}

body {
	background-image:
		url("https://media.gettyimages.com/photos/pasta-ingredients-picture-id635920906?s=2048x2048");
	height: 100%;
	background-position: center;
	background-repeat: no-repeat;
	background-size: auto;
	position: relative;
	background-position: center;
	padding: 200px;
	font-family: Arial, Helvetica;
}

* {
	box-sizing: border-box;
}

.box {
	background-color: white;
	padding: 20px;
}

.name, .address {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	border-radius:3px;
}

.submit {
	background-color: #2a8742;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 30%;
	opacity: 0.9;
	align-items: center;
	border-radius: 25px;
	margin-left: 35%;
}
.header{
  position: absolute;
  top: 35px;
 left:30%;
  text-align: center;
  color: white;
  font-size: 85px;
  font-weight: bold;
  font-family:Georgia, serif;
  }
  
  .formheader {
	text-align: center;
	font-family: Georgia, serif;
	text-decoration-line: underline;
	text-decoration-style: solid;
	font-size: 20px;
}
ul {
  list-style-type: none;
  position: absolute;
  top:35px;
  right: 15px;
  padding: 10px 14px;
  
  overflow: hidden;
  background-color: #2a8742;
  float:right;
}

li {
  float: right;
  right:15px;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover {
  background-color: #2a8742;
}
</style>
</head>
<body>
<ul>
  
    <li><a onclick="window.location.href = '/SpringMVC_sample/';">Logout</a></li>
</ul>

	<div class="header">Bon Appetite</div>

	<form action="/SpringMVC_sample/customer" method="post" >
		<div class="box">
			
			<div class="formheader">CUSTOMER DETAILS</div><br><br>
			
			<input type="hidden" name="customerId" id="id" />
			
			<br> <label>Phone</label>
			<input type="text" name="phone" placeholder="Enter your phone number" maxlength="10" pattern="^[0-9]*$" 


				class="name"/>
			
			<br> <br> <br> <input type="submit" value="FIND" Class="submit" />
		</div>
	</form>
</body>
</html>
