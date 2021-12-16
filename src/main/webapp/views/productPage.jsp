<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/myHeader.css">
</head>
<body style="background-color:black;">
<div class="card" style="width: 90%;margin:auto;margin:5%;opacity:.9">
    <!-- Sale badge-->
    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
    <div class="row" style="padding:5%">
    <div class="col">
	    <!-- Product image-->
	    <img class="card-img-top"  src="data:image/jpeg;base64,${product.base64imageFile}" alt="..." width="500" height="400">
    </div>
    <div class="col">
	    <!-- Product details-->
	    <div class="card-body p-4">
	        <div class="text-center">
	            <!-- Product name-->
	            <h1 class="fw-bolder">${product.itemName}</h1>
	            <!-- Product Desc-->
	            <p class="card-body">${product.itemDesc}</p>
	            <!-- Product reviews-->
	            <div class="d-flex justify-content-center small text-warning mb-2">
	                <div class="bi-star-fill"></div>
	                <div class="bi-star-fill"></div>
	                <div class="bi-star-fill"></div>
	                <div class="bi-star-fill"></div>
	                <div class="bi-star-fill"></div>
	            </div> 
	            <!-- Product price-->
	            <p style="font-size:24px">Price :
	            <span class="text-muted text-decoration-line-through">&#8377 ${product.itemPrice+500}</span>
	            &#8377 ${product.itemPrice}</p>
	        </div>
	    </div>
    </div>
    </div>
    
    
    <!-- Product actions
    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
    </div>-->
</div>
      </body>                  
