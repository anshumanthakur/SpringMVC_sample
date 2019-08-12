<html>
	<head>
		<!-- to make the page responsive -->
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style type="text/css">
		* {
  box-sizing: border-box;
}

.head1{
	height:0px;
	padding: 40px;
  	background: #1abc9c;
  
  }
  
.head1 h2{
	margin-top:-25px;
	font-style: oblique;
  	font-size:50px;
  	margin-left:60px;
}

.head1 .home {
	
	 background-color: #1c87c9;
         border: none;
         color: white;
         text-align: center;
         text-decoration: none;
         font-size: 20px;
        padding:10px;
        border-radius:5px;
        	margin-left:660px;
         cursor: pointer;
         margin-top:-95px;
}
a{
		text-decoration:none;
	
}
.head1 .about {
	font-size:25px;
	margin-top:-90;
	margin-left:785px;
	
}

.head1 .contact {
	font-size:25px;
	margin-top:-30;
	margin-left:900px;
	
}

.head1 .login {
	 
	 margin-top:-35px;
      padding:10px;  
	margin-left:1040px;
	 background-color: #1c87c9;
	   border: none;
         color: white;
          text-align: center;
         text-decoration: none;
         font-size: 20px;
           border-radius:5px;
         
              cursor: pointer;
}

.head1 .register {
	 
	 margin-top:-43px;
      padding:10px;  
	margin-left:1150px;
	 background-color: #1c87c9;
	   border: none;
         color: white;
          text-align: center;
         text-decoration: none;
         font-size: 20px;
           border-radius:5px;
         
              cursor: pointer;
}
.bodypart .text_img {
	 position: absolute;
        z-index: 999;
        margin: 0 auto;
        position: absolute;
        z-index: 999;
        margin: 0 auto;
        left: 0;
        right: 0;        
        text-align: center;
        top: 40%; /* Adjust this value to move the positioned div up and down */
        font-size:50px;
        font-family: Arial,sans-serif;
        color: #fff;
        width: 60%; /* Set the width of the positioned div */
    }       
       
.footer {
	position:absolute;
	
		bottom:-275px;
	padding: 100px;
  	background: #1abc9c;
  	width:99%;
  	
  	
	
}       
       
		
		</style>
	</head>
	
	<body>
		<div class="head1">
		
			<h2 >Bon Appetit</h2>
			<button class="home" onclick="window.location.href = 'http://localhost:8080/webpro/home.jsp';">HOME</button>
			<div class="about">
			<a style="color:white;" href="http://localhost:8080/webpro/about.jsp" >about us</a>
			</div>
			<div class="contact">
			<a style="color:white;" href="http://localhost:8080/webpro/contact.jsp" >contact us</a>
			</div>
			
			<button   class="login" onclick="window.location.href = 'http://localhost:8080/webpro/login.jsp';">LOGIN</button>
		
			
			<button  class="register" onclick="window.location.href = 'http://localhost:8080/webpro/register.jsp';">REGISTER</button>
			
		</div>
		
		<div class="bodypart">
			<img style=" position:absolute; width:1503px;height:600px;" src="https://images.unsplash.com/photo-1460306855393-0410f61241c7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80"/>
		
			<div class="text_img">
				<p>Hello im a demo project. </p>
				<p>Trying to learn some concept.Hope it goes well.</p>
			</div>
		</div>
		
		<div class="footer">
			<div class="part1">
				<i class="fa fa-map-marker" style="font-size:28px;">&nbsp;&nbsp;Thomson Reuters<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;yamalur,bangalore-38</i>
				<br><br><i class="fa fa-phone" style="font-size:28px">&nbsp;&nbsp;+918970132247</i>
				<br><br><i class="fa fa-envelope" style="font-size:28px">&nbsp;&nbsp;deekshithash10@gmail.com</i>
			</div>
		</div>
		
		
		
		
		
	</body>
</html>
