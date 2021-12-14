<mvc:resources mapping="/resources/**" location="/resources/" />

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Trip Ad</title>
  </head>
  <body>
  
    <!--FONT AWESOME-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<!--GOOGLE FONTS-->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+Display:wght@100;200;300;400;500;600;800&display=swap" rel="stylesheet"> 
<link href="https://fonts.googleapis.com/css2?family=Titillium+Web:wght@600&display=swap" rel="stylesheet"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/modal.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myHeader.css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<style>

  body{
  margin: 0;
  width:100%;
  overflow-x: hidden;
  background-color: #061221;
  color:#fff;
  font-family: 'Noto Sans Display', sans-serif;
  }
  
  a,li,button,i,.button{
  text-decoration: none;
  outline: none !important;
  list-style: none;
  transition: 0.5s;
  }
  .title{
  font-size:2.5em;
  font-weight:600;
  }
  
  .sub-title{
  font-size:1.3em;
  font-weight:400;
  }
  
  .btn1,.btn2{
  padding:20px;
  text-align:center;
  border:0;
  border-radius:40px;
  display:block;
  width:150px;
  margin:2vh 0;

  }
  
  .btn1{
    background-color: #d9e4f5;
    background-image: linear-gradient(315deg, #d9e4f5 0%, #f5e3e6 74%);
    color:#191714;
    box-shadow: 20px 20px 50px #f5e3e6, 
              -30px -30px 60px #d9e4f5;
  }
  
  .btn1:hover{
    color:#cd2027;
  }
  
  
  /*TOP NAVIGATION*/
  header{
  position:fixed;
  top:2rem;
  width:100%;
  z-index:99999;
  transition:0.5s;
  }
  
  .topnav {
  overflow: hidden;
  background-color: #fde7f9;
  background-image: linear-gradient(315deg, #fde7f9 0%, #aacaef 74%);
  width:80%;
  margin:auto; 
  box-shadow:0px 6px 16px -6px #fde7f9;
  transition:0.5s;
  }
  
  .topnav a {
  float: left;
  display: block;
  color: rgba(6, 18, 33, 0.8);
  text-align: center;
  padding: 24px 16px;
  margin:auto 1rem;
  text-decoration: none;
  font-size: 17px;
  position:relative;
  }
  
  .logo{
  width:40px;
  position:absolute;
  top:1rem;
  background-color:#fff;
  border-radius:5px;
  }
  
  #icon{
  float:right;
  }
  
  #active{
  display:flex;
  font-weight:bold;
  font-family: 'Titillium Web', sans-serif;
  }
  
  #active:hover{
  color:#fff;
  }
  
  .topnav .icon {
  display: none;
  }
 
  
  .topnav a:hover {
  color: #cd2027;
  }
 
  
  @media screen and (max-width: 1120px) {
  .logo{
  width:20px;
  position:static;
  }

  .topnav a:not(:first-child){
  display: none;
  }
  .topnav a.icon {
  float: right;
  display: block;
  }
  #active{
  display:none;
  }
  }
  
  @media screen and (max-width: 1120px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
  position: absolute;
  right: 0;
  top: 0;
  }
  .topnav.responsive a {
  float: none;
  display: block;
  text-align: left;
  padding: 14px 16px;
  }
  .topnav.responsive .dropdown {float: none;}
  .topnav.responsive .dropdown-content {position: relative;}
  .topnav.responsive .dropdown .dropbtn {
  display: block;
  width: 100%;
  text-align: left;
  }
  }
  
  /*BANNER*/
  .banner{
  width:120%;
  display:flex;
  position:relative;
  
  }
  
  .banner section{
  height:100vh;
  width:85%;
  position:relative;
  }
  
  .banner .left_section{
  width:100%;
  }
  
  .banner .left_section section{
  background-color: transparent;
  background-color: #2234ae;
  background-image: linear-gradient(315deg, #2234ae 0%, #191714 74%);

  transform: skew(20deg);
  position:absolute;
  left:-15%;
  width:100%;
  }
  
  .banner .left_section span{
  transform: skew(-20deg);
  position:absolute;
  top:30vh;
  left:20vw;
  width:50%;
  color:#fff;
  letter-spacing:0.08em;
  z-index:11111111;
  }
  
  .banner .left_section span h4{
  line-height:1.6em;
  font-weight:400 !important;
  }
  .banner {
  width:100%;
background:  url("https://wallpaperaccess.com/full/2499987.jpg");
  background-attachment:fixed;
  background-size:cover;
  background-position:right;
}
  
  @media (max-width:1120px){
  .banner{
  background-attachment:local;
  }
  .banner .left_section section{
  left:-40%;
  }
  .banner .left_section span{
  left:30vw;
  width:130%;
  }
  }
  
  @media (max-width:420px){
  .banner .left_section section{
  left:-58%;
  }
  .banner .left_section span{
  left:45vw;
  width:120%;
  }
  }
  
  .slideInRight {
  -webkit-animation-name: slideInRight;
  animation-name: slideInRight;
  -webkit-animation-duration: 1s;
  animation-duration: 1s;
  -webkit-animation-fill-mode: both;
  animation-fill-mode: both;
  }
  @-webkit-keyframes slideInRight {
  0% {
  -webkit-transform: translateX(100%);
  transform: translateX(100%);
  visibility: visible;
  }
  100% {
  -webkit-transform: translateX(0);
  transform: translateX(0);
  }
  }
  @keyframes slideInRight {
  0% {
  -webkit-transform: translateX(100%);
  transform: translateX(100%);
  visibility: visible;
  }
  100% {
  -webkit-transform: translateX(0);
  transform: translateX(0);
  }
  } 
  </style>
<script>



window.onload=function(){
		
		if(${ not empty regStatus}){
			$('#myModal').modal('show');
		}
		
	}
</script>
</head>
<body>
  <!-- Navigation Bar -->
  <header id="header">
  <div class="topnav" id="myTopnav">
  <a href="#"><img class="logo" src="https://media.istockphoto.com/vectors/letter-logo-in-a-circle-impossible-line-style-vector-id1222709954?k=20&m=1222709954&s=612x612&w=0&h=1uPd1AZzD40UMoFU1GSD8x5zCai1IeOH7nHYJ0ToMZw=" alt=""></a>
  <a id="active">Trip Ad</a>
  <a href="#">Home</a>
    <a href="#about">About</a>
    <a href="#contact">Contact</a>
    <a href="/register">Register</a>
    <a href="${pageContext.request.contextPath}/login">Login</a>
    <a href="#about" style="float:right;padding: 24px 2px;"><i class="fa fa-search"></i></a>
    <a href="${pageContext.request.contextPath}/login" style="float:right;padding: 24px 2px;"><i class="fa fa-user-circle-o"></i></a>
    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="NavBar()">&#9776;</a>
  </div>
  </header>

	
    <div class="banner">
      <section class="left_section">
        <section>
          <span>
            <h1 class="title">To Fuel Your Wanderlust </h1><br>
            <h4 style="margin-bottom:70px">The journey of thousand miles begins with a single step...</h4><br>
            <p  class="btn1" style="width:200px" style="color:#2234AE">Let's Get Started</p>
          </span>
	</section>
      </section>
      <section class="right_section">
      </section>
    </div>

<h1 class="text-center" style="padding-top:3%;font-size:60px;font-family:Manrope;"> Why us?</h1>
<div  class="row">

	<div class="col-7" style="padding:15%;padding-top:5%;font-family:Manrope;justify-content: center; font-size:25px;">
		<p style="font-size:60px;font-weight:bold">We take care of your trips</p> Traveling is fun and exciting. OfCourse we don't want you to have any trouble for schedules, ticket booking, etc.., We are the ones who take care of all your needs.
	</div>
	
	<div class="col-5">
		<img src="https://stories.freepiklabs.com/storage/22085/trip-pana-2143.png" >
	</div>

</div>

<img src="https://cdn.dribbble.com/users/648922/screenshots/7085082/media/2930078d78c4de20c72bfdbf4d3eb8b8.png?compress=1&resize=1600x1200" style="width:100%">

<h1 class="text-center" style="padding-top:3%;font-size:60px;font-family:Manrope;"> Exclusive Tickets</h1>
<div  class="row" style="padding:3%;padding-right:5%">
	
	<div class="col" >
		<img src="https://images.unsplash.com/photo-1516901941577-95fa3e26798b?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fHdhdGVyJTIwc3BvcnRzfGVufDB8MXwwfHw%3D&auto=format&fit=crop&w=490&q=60" style="border-radius:30px;">
	</div>
	
	<div class="col">
		<img src="https://images.unsplash.com/photo-1614094723471-ed6e2cf28cad?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=490&q=60" style="border-radius:30px;">
	</div>
	<div class="col" >
		<img src="https://images.unsplash.com/photo-1507608443039-bfde4fbcd142?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8aG90JTIwYWlyJTIwYmFsbG9vbnN8ZW58MHx8MHx8&auto=format&fit=crop&w=490&q=60" style="border-radius:30px;">
	</div>

</div>


        <%@ include file="footer.html" %>
        
<div id="myModal" class="modal fade">
	<div class="modal-dialog modal-confirm modal-dialog-centered">
		<div class="modal-content">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">&#xE876;</i>
				</div>				
				<h4 class="modal-title w-100">Awesome!</h4>	
			</div>
			<div class="modal-body">
				<p class="text-center">Your User Registration has been confirmed. Check your email for details.</p>
			</div>
			<div class="modal-footer">
				<button class="btn btn-success btn-block" data-dismiss="modal">OK</button>
			</div>
		</div>
	</div>
</div>  

  </body>


  <script>
    function NavBar() {
      var x = document.getElementById("myTopnav");
      if (x.className === "topnav") {
        x.className += " responsive";
      }
      else {
        x.className = "topnav";
      }
    }

    window.onscroll = function() {scrollFunction()};
    function scrollFunction() {
      if (document.body.scrollTop > 80 || document.documentElement.scrollTop > 80) {
        document.getElementById("myTopnav").style.width = "100%";
        document.getElementById("myTopnav").style.backgroundColor = "rgba(6, 18, 33, 1)";
        document.getElementById("header").style.position = "fixed";
        document.getElementById("header").style.top = "0%";
      } 
      else {
        document.getElementById("myTopnav").style.width = "80%";
        document.getElementById("myTopnav").style.backgroundColor = "rgba(6, 18, 33, 0.8)";
        document.getElementById("header").style.position = "fixed";
        document.getElementById("header").style.top = "2rem";
      }
    }

  </script>
</html>
