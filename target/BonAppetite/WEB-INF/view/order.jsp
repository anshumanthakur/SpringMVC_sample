<%@include file="/WEB-INF/view/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="ISO-8859-1">
<title>Order Food</title>


<script type="text/javascript">
	window.onload = function() {
		document.onkeydown = function(e) {
			return (e.which || e.keyCode) != 116;
		};
	}
	var x;
	function myNewFunction() {
		var foodDetail = document.getElementById("foodName").value;
		var slashIndex = foodDetail.indexOf("/");
		var hashIndex = foodDetail.indexOf("#");
		var foodId = foodDetail.substring(slashIndex + 1, hashIndex);
		document.getElementById("foodId").value = foodId;
		var price;
		price = foodDetail.substring(0, slashIndex);
		document.getElementById("foodPrice").value = parseInt(price);
		var foodName = foodDetail.substring(hashIndex + 1);
		document.getElementById("food_name").value = foodName;

	}

	function onRowClick() {
		var price;
		var table = document.getElementById("orderDetailTable");
		var rows = table.getElementsByTagName("tr");
		for (i = 0; i < rows.length; i++) {
			var currentRow = table.rows[i];
			var createClickHandler = function(row) {
				return function() {
					var id = row.getElementsByTagName("td")[1].innerHTML;
					price = row.getElementsByTagName("td")[4].innerHTML;
					var name = row.getElementsByTagName("td")[2].innerHTML;
					document.getElementById("foodName").value = price + "/"
							+ id + "#" + name;
					document.getElementById("quantity").value = row
							.getElementsByTagName("td")[3].innerHTML;
					document.getElementById("comment").value = row
							.getElementsByTagName("td")[6].innerHTML;

					document.getElementById("update").value = 1;
					document.getElementById("orderId").value = row
							.getElementsByTagName("td")[0].innerHTML;
					;
				};
			};
			currentRow.onclick = createClickHandler(currentRow);
		}
		var quantity = parseInt(document.getElementById("quantity").value)
		document.getElementById("total").innerHTML = "your total is"
				+ (parseInt(price) * parseInt(quantity));
	}
	function onStart() {
		document.getElementById("orderId").value = 0;
		document.getElementById("update").value = 0;
	}
</script>

<style type="text/css">
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
<body onLoad="onStart()">

	<ul>

		<li><a onclick="window.location.href = '/SpringMVC_sample/';">Logout</a></li>
	</ul>
	<div class="header">Bon Appetite</div>
	<div class="box">
		<form:form action="/SpringMVC_sample/success" method="post"
			modelAttribute="order">
			<div class="formheader">ORDER DETAILS</div>
			<br>
			<br>

			<label>Food Name</label>
			<br>
			<select name="foodName" id="foodName" placeholder="Select Food Item"
				class="fielddesign" onchange="myNewFunction();">
				<c:forEach items="${FoodMenu}" var="FoodMenu">
					<option
						value="${FoodMenu.foodItemPrice}/${FoodMenu.foodItemId}#${FoodMenu.foodItemName}">${FoodMenu.foodItemName}</option>
				</c:forEach>
			</select>
			<label>Quantity</label>
			<br>
			<form:select path="quantity" id="quantity" cssClass="fielddesign"
				onchange="Function()">
				<%
					for (int i = 1; i < 10; i += 1) {
				%>
				<option value="<%=i%>">
					<%
						out.print(i);
					%>
				</option>
				<%
					}
				%>
			</form:select>

			<label>Comments</label>
			<br>
			<form:textarea path="comment" id="comment"
				placeholder="Any Customization Required" cssClass="fielddesign" />

			<form:input type="hidden" path="foodItemName" id="food_name" />
			<form:input type="hidden" path="foodItemId" id="foodId" />
			<input type="hidden" name="foodPrice" id="foodPrice" />
			<input type="hidden" name="update" id="update" />
			<input type="hidden" name="orderId" id="orderId" />

			<input type="submit" value="Add" onclick="myNewFunction()"
				class="submit">
		</form:form>

		<br> <br> <b id="total"> </b><br> <br> <br>

		<p id="total"></p>
		<br> <br>
		<p id="name"></p>

		<table id="orderDetailTable" align="center" border="1" width=100%>
			<tr>
				<td>Order Id</td>
				<td>food item id</td>
				<td>Food Name</td>
				<td>quantity</td>
				<td>price</td>
				<td>total amount</td>
				<td>comment</td>
			</tr>
			<c:forEach items="${orderList}" var="orderList">
				<tr>

					<td>${orderList.orderId}</td>
					<td>${orderList.foodItemId}</td>
					<td>${orderList.foodItemName}</td>
					<td>${orderList.quantity}</td>
					<td>${orderList.foodItemPrice}</td>
					<td>${orderList.amount}</td>
					<td>${orderList.comment}</td>
					<td onclick="onRowClick()">update</td>
					<td><a href="<c:url value='/delete/${orderList.orderId}' />">delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<br> <br> <input type="submit" value="Generate Bill"
			onclick="window.location.href = '/SpringMVC_sample/bill';"
			class="submit">

	</div>
</body>
</html>
