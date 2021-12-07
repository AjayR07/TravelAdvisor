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
        <!--script to include footer-->
        
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script>
            // $(document).ready(function () {
            //     $("#addToCart").on("submit",function(e)
            //      {
            //         var arr= $("#addToCart").serialize();
            //         console.log(arr);
            //         $.ajax({
            //             data:arr,
            //             url:"cart/additem",
            //             method:"POST"
            //         })
            //         e.preventDefault();
            //         return false;
            //     });
            // })
           
           function dec(id) 
            {
                    document.getElementById(id).value=parseInt(document.getElementById(id).value)-1;       
            }
            function inc(id) 
            {
                document.getElementById(id).value=parseInt(document.getElementById(id).value)+1;            
            }
        </script>
     
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
                        <button class="btn btn-outline-dark" type="button" data-toggle="modal" data-target="#mycartModal">
                            <i class="bi-cart-fill me-1"></i>
                            Cart
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
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
                        <form name="addToCart"  id="addToCart" method="post" action="/cart/addItem"  >
                            <input type="number" name="itemId" value="${product.itemId}"  hidden/>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="d-flex justify-content-center"  >
                                     
                                   <div class="input-group mb-3" style="width: 130px;height: 40px;" >
                                        <div class="input-group-prepend">
                                            <button type="button" class="btn btn-outline-primary" onclick="dec('qty${product.itemId}')">-</button>
                                        </div>
                                        <input type="number" class="form-control" name="qty" id="qty${product.itemId}" value="1" min="1"  max="10" aria-label="No.of.Tickets" readonly>
                                        <div class="input-group-append">
                                            <button type="button" class="btn btn-primary" onclick="inc('qty${product.itemId}')" id="plus">+</button>
                                        </div>
                                      </div>
                                    </div>
                                 </div>
                                <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                    <div class="text-center" ><input class="btn btn-outline-dark mt-auto" type="submit" value="Add to cart"/></div>
                                </div>
                            </div>
                        </form>
                        
                    </div>
                   
        </c:forEach>
        </c:if>
                </div>
            </div>
        </section>
        <%@ include file="footer.html" %>
    </body>
</html>
