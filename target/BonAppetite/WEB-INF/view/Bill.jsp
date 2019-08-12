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
	border-radius: 3px;
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

.header {
	position: absolute;
	top: 35px;
	left: 30%;
	text-align: center;
	color: white;
	font-size: 85px;
	font-weight: bold;
	font-family: Georgia, serif;
}

.formheader {
	text-align: center;
	font-family: Georgia, serif;
	text-decoration-line: underline;
	text-decoration-style: solid;
	font-size: 20px;
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

.fielddesign {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	border-radius: 3px;
}

.submit {
	background-color: #2a8742;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 20%;
	opacity: 0.9;
	align-items: center;
	border-radius: 25px;
	margin-left: 40%;
}

.header {
	position: absolute;
	top: 35px;
	left: 30%;
	text-align: center;
	color: white;
	font-size: 85px;
	font-weight: bold;
	font-family: Georgia, serif;
}

.formheader {
	text-align: center;
	font-family: Georgia, serif;
	text-decoration-line: underline;
	text-decoration-style: solid;
	font-size: 20px;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 2px solid #948f8f;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

ul {
	list-style-type: none;
	position: absolute;
	top: 35px;
	right: 15px;
	padding: 10px 14px;
	overflow: hidden;
	background-color: #2a8742;
	float: right;
}

li {
	float: right;
	right: 15px;
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
<body onkeydown="return (event.keyCode != 116)">

	<ul>

		<li><a onclick="window.location.href = '/SpringMVC_sample/';">Logout</a></li>
	</ul>


	<h1 style="color: white;">
		<center>Thank you for ordering ${customer.fname}.</center>
	</h1>
	<div class="box">
		<table>
			<tr>
				<td><b>Bill No:</b></td>
				<td>${billNo}</td>
				<br>
			</tr>
			<tr>
				<td><b>customer name:</b></td>
				<td>${customer.fname}</td>
				<br>
			</tr>
			<tr>
				<td><b>Customer Phone:</b></td>
				<br>
				<td>${customer.phone}</td>
			</tr>

		</table>
		<br> <br> <b>PRODUCT DETAILS</b><br>
		<table id="orderDetailTable" align="center" border="1" width=100%>
			<tr>
				<td>FoodItemName</td>
				<td>Price</td>
				<td>Quantity</td>
				<td>Amount</td>
			</tr>
			<c:forEach items="${orderList}" var="orderList">
				<tr>

					<td>${orderList.foodItemName}</td>
					<td>${orderList.foodItemPrice}</td>
					<td>${orderList.quantity}</td>
					<td>${orderList.amount}</td>
				</tr>
			</c:forEach>
		</table>

		<br> <br> <b id="total"> </b><br> <br> <br> <input
			type="button" value="Next Customer"
			onclick="window.location.href = '/SpringMVC_sample/customerPhone';"
			class="submit">
	</div>

	<script>

		var table = document.getElementById("orderDetailTable"), sumVal = 0;

		for (var i = 1; i < table.rows.length; i++) {
			sumVal = sumVal + parseInt(table.rows[i].cells[3].innerHTML);
		}

		document.getElementById("total").innerHTML = "Your Total is= " + sumVal;
		console.log(sumVal);
	</script>
</body>
</html>
