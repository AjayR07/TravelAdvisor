<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/cart.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/modal.css">
	
	<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
	
	<style>
		.squaredThree {
			  width: 20px;
			  position: relative;
			  margin: 20px auto;
			  label {
			    width: 20px;
			    height: 20px;
			    cursor: pointer;
			    position: absolute;
			    top: 0;
			    left: 0;
			    background: linear-gradient(top, #222 0%, #45484d 100%);
			    border-radius: 4px;
			    box-shadow: inset 0px 1px 1px rgba(0,0,0,0.5), 0px 1px 0px rgba(255,255,255,.4);
			    &:after {
			      content: '';
			      width: 9px;
			      height: 5px;
			      position: absolute;
			      top: 4px;
			      left: 4px;
			      border: 3px solid #fcfff4;
			      border-top: none;
			      border-right: none;
			      background: transparent;
			      opacity: 0;
			      transform: rotate(-45deg);
			    }
			    &:hover::after {
			      opacity: 0.3;
			    }
			  }
			  input[type=checkbox] {
			  
			    visibility: hidden;
			    &:checked + label:after {
			      opacity: 1;
			    }    
			  }
			}
			.img-responsive {
			    width: 100%;
			    height:100%;
			}
	</style>
	<script>
		const formatter = new Intl.NumberFormat('en-US', {
		   minimumFractionDigits: 0,      
		   maximumFractionDigits: 0,
		});
		var rzr_orderId;
		var saveBooking=(response,sum,products)=>{
		
			console.log("Success");
			    console.log(response.razorpay_payment_id);
		
					$.ajax({
							data:"json="+JSON.stringify({'total':sum,'products':products}),
							method:"POST",
							url:"http://localhost:8080/addTobookingDetails"
						}).done((d)=>{
							console.log(d);
							$('#myModal').modal('show');
						});
		}
		function openCheckout(products,sum){
			
			var options = {
			    "key": "rzp_test_xTD1haela80DyW", // Enter the Key ID generated from the Dashboard
			    "amount": sum, 
			    "currency": "INR",
			    "name": "Travel Ad",
			    "description": "Your Travel Buddy",
			    "image": "https://media.istockphoto.com/vectors/letter-logo-in-a-circle-impossible-line-style-vector-id1222709954?k=20&m=1222709954&s=612x612&w=0&h=1uPd1AZzD40UMoFU1GSD8x5zCai1IeOH7nHYJ0ToMZw=",
			    "order_id": rzr_orderId, 
			    "callback_url": "http://localhost:8080/booking",
			    "handler": function(response){saveBooking(response,sum,products);},
			    "prefill": {
			        "name": "${userName}",
			        "email": "${mail}",
			        "contact": "${contactNum}"
			    },
			    "notes": {
			        "address": "Trip Ad, Ram Nagar, Chennai"
			    },
			    "theme": {
			        "color": "#3399cc"
			    }
			};
			var rzp1 = new Razorpay(options);
			rzp1.on('payment.failed', function (response){
			     //   alert(response.error.description);
			   
			});
			rzp1.open();
	    	
		}
		
		$(document).ready(function(){
			
			$("#checkout").click((e)=>{
				var sum=0;
				var products = $("input[name='products']:checked").map(function () {
						sum+=parseFloat($("#"+this.value).val());
					    return parseInt(this.value);
					}).get();
				
				sum=Math.ceil(sum*1.05);
				
				sum=sum*100;
				sum=Math.floor(sum)
				console.log(products);
				console.log(sum);
				
				$.ajax({
					data:"amount="+sum,
					method:"GET",
					url:"http://localhost:8080/booking"
				
				}).done((d)=>{
				rzr_orderId=d;
				openCheckout(products,sum);
				});
			})
		});
	
		
		window.onload=()=>{
			changer();
			if(${cart.products.size()==0}){
				$("#checkout").attr("disabled", true);
			}
		}

		var changer=()=>{
				var list = $("input[name='products']:checked").map(function () {return parseFloat($("#"+this.value).val());}).get();
				var sum=0;
				list.forEach(function(num){sum+=parseFloat(num) || 0;});
		
				$("#tp").html(sum);
				$("#tpt").html("GST (5%) - &#8377;"+(formatter.format(sum*0.05)));
				$("#tot").html(formatter.format(sum*1.05));
		}
	
	</script>
</head>
<body>


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
				<p class="text-center">Your booking has been confirmed. Check your email for details.</p>
			</div>
			<div class="modal-footer">
				<button class="btn btn-success btn-block" data-dismiss="modal" onclick="location.reload();">OK</button>
			</div>
		</div>
	</div>
</div>  
<div class="card" style="min-height:600px;margin-top:3%;margin-bottom:3%" >
    <div class="row" style="min-height:600px;">
        <div class="col-md-8 cart">
            <div class="title">
                <div class="row">
                    <div class="col">
                        <h1><b>My Shopping Cart</b></h1>
                    </div>
                    <div class="col align-self-center text-right text-muted">${cart.products.size()} items</div>
                </div>
            </div>
            <c:choose>
	            <c:when test="${cart.products.size()>0}">
	            	<c:forEach items="${cart.products}" var="product">
	            		<div class="row border-top border-bottom">
			                <div class="row main align-items-center">
			                	<div class="col-1">
			          				<div class="squaredThree">
								      <input type="checkbox"  id="squaredThree" name="products" class="checkbox" value="${product.cartProductId}" checked onchange="changer()" />
								      <input type="text" id="${product.cartProductId}" value="${product.totalCost}" hidden>
								    </div>
								</div>
			                    <div class="col-2"><img class="img-fluid"  src="data:image/jpeg;base64,${product.item.base64imageFile}" height="300px" width="300px"></div>
			                    <div class="col-4">
			                        <div class="row text-muted" style="font-style:italic;font-weight: lighter;font-size:12px" onclick="location.href='products/${product.item.itemId}'">#UC00${product.item.itemId}</div>
			                        <div class="row">${product.item.itemName}</div>
			                    </div>
			                    <div class="col-2"> <a href="#" style="color:grey">-</a><a href="#" >${product.quantity}</a><a href="#" style="color:grey">+</a> </div>
			                    <div class="col-3"> &#8377 ${product.totalCost} <span class="close">&#10005;</span></div>
			                </div>
			            </div>
	            	</c:forEach>
	            </c:when>
	            <c:otherwise>
	            <div class="row" style="height:70%">
		            <div class="col-2">
		            </div> 
		            <div class="col">
		            	<img src="https://image.freepik.com/free-vector/empty-concept-illustration_114360-1188.jpg" class="img-responsive"  alt="Responsive Image"/>
		            </div>
		            <div class="col-2">
	            	</div>
	            </div>
	            	 
	            </c:otherwise>
            </c:choose>
          
            <div class="back-to-shop" onclick="location.href='products/all'" style="cursor:pointer"><a href="#">&leftarrow;</a><span class="text-muted">Back to shop</span></div>
        </div>
        <div class="col-md-4 summary" style="min-height:620px;">
            <div>
                <h5><b>Summary</b></h5>
            </div>
            <hr>
            <div class="row">
            
                <div class="col" style="padding-left:0;">ITEMS </div>
                <div class="col text-right">&#8377;<span id="tp"> </span></div>
            </div>
            <form>
                <p>TAX CHARGES</p> <select>
                    <option class="text-muted" id="tpt"> 
                    
                     </option>
                </select>
           <!--     <p>GIVE CODE</p> <input id="code" placeholder="Enter your code">-->
            </form>
            <div class="row" style="border-top: 1px solid rgba(0,0,0,.1); padding: 2vh 0;">
                <div class="col">TOTAL PRICE</div>
                <div class="col text-right">&#8377; <span id="tot"> </span></div>
            </div> <button class="btn" style="font-size:15px" id="checkout">CHECKOUT</button>
        </div>
    </div>
</div>


</body>