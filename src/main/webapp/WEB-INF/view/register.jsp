<%@include file="/WEB-INF/view/includes.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: #ff0000;
}

body {
	font-family: Arial, Helvetica;
	background-color: #000080;
	padding-top: 10;
	padding: 220px;
	background-image:
		url("https://images.unsplash.com/photo-1460306855393-0410f61241c7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
}

* {
	box-sizing: border-box;
}

.box {
	padding: 46px;
	background-color: white;
}

.name {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	border-radius: 3px;
}

#pass {
	margin: 5px 0 22px 0;
	background: #f1f1f1;
	width: 100%;
	border-radius: 3px;
	border: none;
	padding: 15px;
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

.formheader {
	text-align: center;
	font-family: Georgia, serif;
	text-decoration-line: underline;
	text-decoration-style: solid;
	font-size: 20px;
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

#meter_wrapper {
	border: 1px solid grey;
	margin-left: 38%;
	margin-top: 20px;
	width: 200px;
	height: 35px;
	border-radius: 3px;
}

#meter {
	width: 0px;
	height: 35px;
	border-radius:
}

#pass_type {
	font-size: 20px;
	margin-top: 20px;
	margin-left: 45%;
	text-align: center;
	color: grey;
}
</style>

<!-- <script type="text/javascript" src="js/jquery.js"></script> -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">


	
	$(document).ready(function() {
		$("#pass").keyup(function() {
			check_pass();
		});
	});

	function check_pass() {
		var val = document.getElementById("pass").value;

		var meter = document.getElementById("meter");

		var no = 0;
		if (val != "") {
			// If the password length is less than or equal to 6
			if (val.length <= 6)
				no = 1;

			// If the password length is greater than 6 and contain any lowercase alphabet or any number or any special character
			if (val.length > 6
					&& (val.match(/[a-z]/) || val.match(/\d+/) || val
							.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/)))
				no = 2;

			// If the password length is greater than 6 and contain alphabet,number,special character respectively
			if (val.length > 6
					&& ((val.match(/[a-z]/) && val.match(/\d+/))
							|| (val.match(/\d+/) && val
									.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/)) || (val
							.match(/[a-z]/) && val
							.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/))))
				no = 3;

			// If the password length is greater than 6 and must contain alphabets,numbers and special characters
			if (val.length > 6 && val.match(/[a-z]/) && val.match(/\d+/)
					&& val.match(/.[!,@,#,$,%,^,&,*,?,_,~,-,(,)]/))
				no = 4;

			if (no == 1) {
				$("#meter").animate({
					width : '50px'
				}, 300);
				meter.style.backgroundColor = "red";
				document.getElementById("pass_type").innerHTML = "Very Weak";
			}

			if (no == 2) {
				$("#meter").animate({
					width : '100px'
				}, 300);
				meter.style.backgroundColor = "#F5BCA9";
				document.getElementById("pass_type").innerHTML = "Weak";
			}

			if (no == 3) {
				$("#meter").animate({
					width : '150px'
				}, 300);
				meter.style.backgroundColor = "#FF8000";
				document.getElementById("pass_type").innerHTML = "Good";
			}

			if (no == 4) {
				$("#meter").animate({
					width : '200px'
				}, 300);
				meter.style.backgroundColor = "#00FF40";
				document.getElementById("pass_type").innerHTML = "Strong";
			}
		}

		else {
			meter.style.backgroundColor = "white";
			document.getElementById("pass_type").innerHTML = "";
		}
	}

	function checkForm() {
		var pwd = document.getElementById("pass").value;
		var repwd = document.getElementById("confirm_password").value;
		if (pwd != repwd) {
			alert("password is not matching");
			return false;
		} else {
			return true;
		}
	}

	function myFunction() {
		var x = document.getElementById("pass");
		if (x.type === "password") {
			x.type = "text";
		} else {
			x.type = "password";
		}
	}
	
	
</script>
</head>
<body>
	<div class="header">Bon Appetite</div>
	<form:form action="/SpringMVC_sample/success_register" method="post"
		onsubmit="return checkForm()" modelAttribute="employee">
		<div class="box">
			<div class="formheader">EMPLOYEE REGISTERATION</div>
			<br>
			<br> <label>Name:</label><br>
			<form:input path="name" placeholder="Enter your last name"
				cssClass="name" />
			<form:errors path="name" cssClass="error"></form:errors>
			<br> <label>Age</label>
			<form:input path="age" placeholder="Enter your age" cssClass="name" pattern="^[0-9]*$"/>
			<form:errors path="age" cssClass="error"></form:errors>
			<br> <label>Email</label>
			<form:input path="email" placeholder="Enter your email"
				cssClass="name" />
			<form:errors path="email" cssClass="error"></form:errors>

			<td colspan="3"><c:choose>
					<c:when test="${hasMistakes}">
						<center>
							<h4 class="error">There is a user with same email id</h4>
						</center>
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose></td> <br> <label>Phone</label>
			<form:input path="phone" placeholder="Enter your phone number" pattern="^[0-9]*$"
				maxlength="10" cssClass="name" />
			<form:errors path="phone" cssClass="error"></form:errors>
			<br> <label>Password</label><br>
			<form:input path="password" type="password" id="pass"
				placeholder="Enter your password" cssClass="name" />
			<form:errors path="password" cssClass="error"></form:errors>

			<div id="meter_wrapper">
				<div id="meter"></div>
			</div>

			<br> <span id="pass_type"></span> <br>

			<!-- An element to toggle between password visibility -->
			<input type="checkbox" onclick="myFunction()">Show Password <br>
			<br>
			<br> <label>Confirm Password</label><br> <input
				name="confirm_password" type="password" id="confirm_password"
				placeholder="Re-enter password" class="name" /> <br> <input
				type="submit" value="REGISTER" class="submit" /> <br> <br>


			<center>
				<a href="/SpringMVC_sample/" style="text-align: center">Already have
					an account? Sign in</a>
			</center>
		</div>


	</form:form>
</body>
</html>