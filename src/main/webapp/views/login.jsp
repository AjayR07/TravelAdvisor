<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<head>
    	<meta charset="utf-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/forgotModal.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/toast.css">
	
	
	<script>
	var myOtp;
	var uname;
	
	window.onload=function(){

	
		if("${path}".includes("/login")){
			document.getElementById("tab-1").checked=true;
		}
		else{
		document.getElementById("tab-2").checked=true;
		}

		
		if(${not empty error}){
		
			launch_toast();
		}
		
	}
	function launch_toast() {
    var x = document.getElementById("toast")
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", "");$("#desc").html("${error}");}, 5000);
}

		function onChange() {
		  const password = document.querySelector('input[name=pass1]');
		  const confirm = document.querySelector('input[name=pass2]');
		  if (confirm.value === password.value) {
		    confirm.setCustomValidity('');
		  } else {
		    confirm.setCustomValidity('Passwords do not match');
		  }
		}
		
		function modelCon(){
		$("#fp1").show();
		$("#fp2").hide();
		$("#fp3").hide();
		$('#myModal').modal('show');
		$('#my').hide();
		}
		
		function OTP(){
		uname=$("#uname").val();
		$.ajax({
					data:"uname="+uname,
					method:"GET",
					url:"http://localhost:8080/forgotPass"
				
				}).done((d)=>{
				
					var arr=d.split("-");
					myOtp=arr[0];
					$("#phoneno").html("******"+arr[1].slice(7));
				
					$("#fp1").hide();
					$("#fp2").show();
				});
		}
		
		function validateOTP(){
			var otp=$("#first").val()+$("#second").val()+$("#third").val()+$("#fourth").val()+$("#fifth").val()+$("#sixth").val();
			if(otp==myOtp){
				$("#fp2").hide();
				$("#fp3").show();
			}
			else{
				$("#desc").html("Invalid OTP");
				launch_toast();
			}
		
		}
		
		
		function reset(){
			var pass=$("#fp_p1").val();
			$.ajax({
					data:"uname="+uname+"&pass="+pass,
					method:"POST",
					url:"http://localhost:8080/resetPass"
				
				}).done((d)=>{
					alert("Password Resetted Successfully");
					$('#myModal').modal('hide');
					$('#my').show();
				});
			
		}
		
	</script>
</head>
<body >

<div class="row" id="my">
    <div class="col-md-6 mx-auto p-0">
        	
            <div class="login-box">
                <div class="login-snip"> 
                
                 <input id="tab-1" type="radio" name="tab" class="sign-in"  ><label for="tab-1" class="tab">Login</label> 
                <input id="tab-2" type="radio" name="tab" class="sign-up" ><label for="tab-2" class="tab">Sign Up</label>
                    <div class="login-space">
                        <div class="login">
                        <br>
                        <form name="login" action="/login" method="POST">
                            <div class="group"> <label for="user" class="label">Username</label> <input name='username' type="text" class="input" placeholder="Enter your username"> </div>
                            <br>
                            <div class="group"> <label for="pass" class="label">Password</label> <input name='password' type="password" class="input" data-type="password" placeholder="Enter your password"> </div>
                            <div class="group"> <input id="check" type="checkbox" class="check" checked> <label for="check"><span class="icon"></span> Keep me Signed in</label> </div>
                   
                            <div class="group"> <input type="submit" class="button" value="Sign In"> </div>
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        </form>
                            <div class="hr"></div>
                            <div class="foot" onclick="modelCon()"> <a href="#">Forgot Password?</a> </div>
                        </div>
                        <div class="sign-up-form">
                        <br>
                        <form name="register" action="/register" method="POST">
	                            <div class="group"> <label for="user1" class="label">Username</label> <input id="user1" name='username' type="text" class="input" placeholder="Create your Username" required> </div>
	                              <div class="group"> <label for="Mail1" class="label">Email Address</label> <input id="Mail1" name='Mail' type="text" class="input" placeholder="Enter your email address"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Enter a valid Email ID" required> </div>
	                              <div class="group"> <label for="phone" class="label">Phone Number</label> <input id="phone" type="tel" required class="input" name="Phonenum" pattern="[0-9]{10}" placeholder="Phone Number" required/> </div>
	                            <div class="group"> <label for="pass1" class="label">Password</label> <input id="pass1" type="password"   name='password' pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter,and at least 8 or more characters" required	 class="input" data-type="password" placeholder="Create your password"  > </div>
	                        <br><div class="group"> <input type="submit" class="button" value="Sign Up"> </div>
	                          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						</form>
                            <div class="hr"></div>
                            <div class="foot"> <label for="tab-1">Already Member?</label> </div>
                        </div>
                    </div>
                </div>
            
        </div>
    </div>
</div>
<div id="toast" ><div id="error"><div id="img" ><i class="fa fa-times icon"></i></div><div id="desc">${error}</div></div></div>

<div id="myModal" class="modal fade" data-backdrop="false">
	<div class="modal-dialog modal-confirm modal-dialog-centered"  >
		<div class="modal-content"style="background-color:black; opacity:.8">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">lock</i>
				</div>				
				<h4 class="modal-title w-100">Forgot Password</h4>	
			</div>
			<div id="fp1">
				<div class="modal-body ">
					<div class="login-space" style="color:black; min-height: 100px;">
						<div class="group" id=""> 
							<label for="user" class="label">Username</label> 
							<input name='username' type="text" class="input" id="uname" placeholder="Enter your username"> 
						</div>
						
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-success btn-block"  onclick="OTP()">Send OTP</button>
				</div>
			</div>
			<div id="fp2">
				<div class="height-100 d-flex justify-content-center align-items-center">
				    <div class="position-relative">
				        <div class=" p-2 text-center">
				            <h6>Please enter the one time password <br> to verify your account</h6>
				            <div> <span>A code has been sent to</span> <small id="phoneno">*******9897</small> </div>
				            <div id="otp" class="inputs d-flex flex-row justify-content-center mt-2"> <input class="m-2 text-center form-control rounded" type="text" id="first" maxlength="1" /> <input class="m-2 text-center form-control rounded" type="text" id="second" maxlength="1" /> <input class="m-2 text-center form-control rounded" type="text" id="third" maxlength="1" /> <input class="m-2 text-center form-control rounded" type="text" id="fourth" maxlength="1" /> <input class="m-2 text-center form-control rounded" type="text" id="fifth" maxlength="1" /> <input class="m-2 text-center form-control rounded" type="text" id="sixth" maxlength="1" /> </div>
				            <div class="mt-4"> <button class="btn btn-danger px-4 validate" onclick="validateOTP()">Validate</button> </div>
				        </div>
				    </div>
				</div>
			</div>
			<div id="fp3">
				<div class="height-100 d-flex justify-content-center align-items-center">
				    <div class="position-relative">
				        <div class=" p-2 text-center">
				         	<div class="login-space" style="color:black; min-height: 100px;">
						
							  <div class="group"> <label for="fp_p1" class="label">Password</label> <input  type="password" id="fp_p1"  name='password' pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter,and at least 8 or more characters" required	 class="input" data-type="password" placeholder="Create your password"  > </div>
							    <div class="group"> <label for="fp_p1" class="label">Confirm Password</label> <input id="fp_p2" type="password"   name='Confirm password' pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain at least one number and one uppercase and lowercase letter,and at least 8 or more characters" required	 class="input" data-type="password" placeholder="Confirm your password"  > </div>
						
					
							</div>
				        </div>
				    </div>
				    
				</div>
					<div class="modal-footer">
						<button class="btn btn-success btn-block"  onclick="reset()">Reset</button>
					</div>
			</div>
		</div>
	</div>
</div>  
</body>
