<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>UpChart TravelBar</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" />
        
        
        <link href="${pageContext.request.contextPath}/css/toast.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/518bcdd6c6.js"></script>
        <!--script to include footer-->
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>
            var ajaxRequest=new XMLHttpRequest();
           function cartForm(event){
               var formData=new FormData();
               formData.append("itemId", event.target.elements.itemId.value);
               formData.append("qty", event.target.elements.qty.value);
              

            if(ajaxRequest){
                    ajaxRequest.open("POST","/cart/addItem");
                    ajaxRequest.onreadystatechange=function(){
                        if(ajaxRequest.readyState==4 && ajaxRequest.status==200){
                            var d=JSON.parse(ajaxRequest.responseText);
                            console.log(d["cart"][0]);
                            	document.getElementById("cart").innerHTML=d["cart"][0];
                            
                           	document.getElementById("desc").innerHTML=d["msg"][0];  
                            launch_toast();
                        }
                    }
                    ajaxRequest.send(formData);
                }
                return false;
           }
           function dec(id) 
            {
                    document.getElementById(id).value=parseInt(document.getElementById(id).value)-1;       
            }
            function inc(id) 
            {
                document.getElementById(id).value=parseInt(document.getElementById(id).value)+1;            
            }
            $(document).ready(function() {
					$("#cart").val(${cart})
				  $( ".card" ).hover(
				  function() {
				    $(this).addClass('shadow-lg').css('cursor', 'pointer'); 
				  }, function() {
				    $(this).removeClass('shadow-lg');
				  }
				);
				 
				});
				
				function launch_toast() {
				    var x = document.getElementById("toast")
				    x.className = "show";
				    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 5000);
				}
				
        </script>
     <style>
    .glass-button {
		   display: inline-block;
		   padding: 24px 32px;
		   border: 0;
		   text-decoration: none;
		   border-radius: 15px;
		 
		   border: 1px solid rgba(255,255,255,0.1);
		   backdrop-filter: blur(30px);
		   color: rgba(255,255,255,0.8);
		   font-size: 14px;
		   letter-spacing: 2px;
		   cursor: pointer;
		   text-transform: uppercase;
 }

 .glass-button:hover {
   background-color: rgba(255,255,255,0.2);
 }</style>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="#!">UpChart</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" id="about">About</a></li>
                        <li class="nav-item"><a class="nav-link" id="contact">Contact</a></li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Offers</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">All Services</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">Popular With Customers</a></li>
                                <li><a class="dropdown-item" href="#!">Seasonal</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="d-flex">
                        <button class="btn btn-outline-dark" type="button" data-toggle="modal"  data-target="#mycartModal" onclick="location.href='/cart'">
                            <i class="bi-cart-fill me-1"></i>
                            My Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill" id="cart">${cart}</span>
                        </button>
                    </form>
                </div>
            </div>
        </nav>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h1 class="display-4 fw-bolder">Travel in style</h1>
                    <p class="lead fw-normal text-white-50 mb-0">With the UpChart TravelBuddy Network</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <c:if test="${products!=null}">
			<c:forEach items="${products}" var="product">
                    <div class="col-md-4 mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="data:image/jpeg;base64,${product.base64imageFile}" onclick="location.href='/products/${product.itemId}';" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">${product.itemName}</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through"> &#8377 ${product.itemPrice+500}</span>
                                     &#8377 ${product.itemPrice}
                                </div>
                            </div>
                        <form name="addToCart"  id="addToCart" onSubmit="return cartForm(event)"  >
                            <input type="number" name="itemId" value="${product.itemId}"  hidden/>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            
                                <div class="d-flex justify-content-center"  >
                                
                                   <div class="input-group mb-3" style="width: 130px;height:20px" >
                                        <div class="input-group-prepend">
                                            <button type="button" class="btn btn" onclick="dec('qty${product.itemId}')">-</button>
                                        </div>
                                        
                                        <input type="number" style="text-align:right;background-color:#fff" class="form-control" name="qty" id="qty${product.itemId}" value="1" min="1"  max="10" aria-label="No.of.Tickets" readonly>
                                        <div class="input-group-append">
                                            <button type="button" class="btn btn " onclick="inc('qty${product.itemId}')" id="plus">+</button>
                                        </div>
                                      </div>
                                    </div>
                                 </div>
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center" >
	                                    <button class="btn btn-outline-dark"  type="submit">
	                                    
	                                    	<span class="add"><i class="fa fa-shopping-cart"></i>&nbsp;Add to cart<span>
	                                    	<span class="adding" style="display:none"><span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>Adding to Cart...<span>
											
	                                    </button>
	                                    
	                                </div>
                                </div>
                            </div>
                            
                        </form>
                        
                    </div>
                   
        </c:forEach>
        </c:if>
                </div>
            </div>
        </section>
        
        <div id="toast" ><div id="success"><div id="img" ><i class="fa fa-check icon"></i></div><div id="desc"></div></div></div>

    </body>
</html>
