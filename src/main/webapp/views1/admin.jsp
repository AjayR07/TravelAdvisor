<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
    <link href="https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap4.min.css" rel="stylesheet" >
    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap4.min.js"></script>
     <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/forgotModal.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
 <link rel="stylesheet" href="css/header.css">
    <title>Trip Ad ~ Admin</title>
    <style>
        body {
            background: #ECE9E6;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #FFFFFF, #ECE9E6);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #FFFFFF, #ECE9E6); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */

}

.table {
  border-spacing: 0 0.85rem !important;
}

.table .dropdown {
  display: inline-block;
}

.table td,
.table th {
  vertical-align: middle;
  margin-bottom: 10px;
  border: none;
}

.table thead tr,
.table thead th {
  border: none;
  font-size: 12px;
  letter-spacing: 1px;
  text-transform: uppercase;
  background: transparent;
}

.table td {
  background: #fff;
}

.table td:first-child {
  border-top-left-radius: 10px;
  border-bottom-left-radius: 10px;
}

.table td:last-child {
  border-top-right-radius: 10px;
  border-bottom-right-radius: 10px;
}

.avatar {
  width: 2.75rem;
  height: 2.75rem;
  line-height: 3rem;
  border-radius: 50%;
  display: inline-block;
  background: transparent;
  position: relative;
  text-align: center;
  color: #868e96;
  font-weight: 700;
  vertical-align: bottom;
  font-size: 1rem;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

.avatar-sm {
  width: 2.5rem;
  height: 2.5rem;
  font-size: 0.83333rem;
  line-height: 1.5;
}

.avatar-img {
  width: 100%;
  height: 100%;
  -o-object-fit: cover;
  object-fit: cover;
}

.avatar-blue {
  background-color: #c8d9f1;
  color: #467fcf;
}

table.dataTable.dtr-inline.collapsed
  > tbody
  > tr[role="row"]
  > td:first-child:before,
table.dataTable.dtr-inline.collapsed
  > tbody
  > tr[role="row"]
  > th:first-child:before {
  top: 28px;
  left: 14px;
  border: none;
  box-shadow: none;
}

table.dataTable.dtr-inline.collapsed > tbody > tr[role="row"] > td:first-child,
table.dataTable.dtr-inline.collapsed > tbody > tr[role="row"] > th:first-child {
  padding-left: 48px;
}

table.dataTable > tbody > tr.child ul.dtr-details {
  width: 100%;
}

table.dataTable > tbody > tr.child span.dtr-title {
  min-width: 50%;
}

table.dataTable.dtr-inline.collapsed > tbody > tr > td.child,
table.dataTable.dtr-inline.collapsed > tbody > tr > th.child,
table.dataTable.dtr-inline.collapsed > tbody > tr > td.dataTables_empty {
  padding: 0.75rem 1rem 0.125rem;
}

div.dataTables_wrapper div.dataTables_length label,
div.dataTables_wrapper div.dataTables_filter label {
  margin-bottom: 0;
}

@media (max-width: 767px) {
  div.dataTables_wrapper div.dataTables_paginate ul.pagination {
    -ms-flex-pack: center !important;
    justify-content: center !important;
    margin-top: 1rem;
  }
}

.btn-icon {
  background: #fff;
}
.btn-icon .bx {
  font-size: 20px;
}

.btn .bx {
  vertical-align: middle;
  font-size: 20px;
}

.dropdown-menu {
  padding: 0.25rem 0;
}

.dropdown-item {
  padding: 0.5rem 1rem;
}

.badge {
  padding: 0.5em 0.75em;
}

.badge-success-alt {
  background-color: #d7f2c2;
  color: #7bd235;
}

.table a {
  color: #212529;
}

.table a:hover,
.table a:focus {
  text-decoration: none;
}

table.dataTable {
  margin-top: 12px !important;
}

.icon > .bx {
  display: block;
  min-width: 1.5em;
  min-height: 1.5em;
  text-align: center;
  font-size: 1.0625rem;
}

.btn {
  font-size: 0.9375rem;
  font-weight: 500;
  padding: 0.5rem 0.75rem;
}

.avatar-blue {
      background-color: #c8d9f1;
      color: #467fcf;
    }

    .avatar-pink {
      background-color: #fcd3e1;
      color: #f66d9b;
    }
    </style>
    <script>
        $(document).ready(function() {
            $("#example").DataTable({
                aaSorting: [],
                responsive: true,

                columnDefs: [
                {
                    responsivePriority: 1,
                    targets: 0
                },
                {
                    responsivePriority: 2,
                    targets: -1
                }
                ]
            });

            $(".dataTables_filter input")
                .attr("placeholder", "Search here...")
                .css({
                width: "300px",
                display: "inline-block"
                });

            $('[data-toggle="tooltip"]').tooltip();
            
           	$("#add").click(()=>{
		$('#myModal').modal('show');
});
       });

 </script>
    
  </head>
  <body>
     <div>
    <div class="header-blue">
        <nav class="navbar navbar-light navbar-expand-md navigation-clean-search">
          <div class="container-fluid">

            <h2 class=" navbar-text" style="color:greenyellow">Travel AD</h2>
            
                  <span class="navbar-text"> <a class="login" href="#"  style="color:rgb(255, 255, 255)">ADMIN DASHBOARD</a></span><a class="btn btn-light action-button" role="button" href="/logout">LogOut</a>
              </div>
        </nav>
        
        </div>
    </div>
</div>
    <div class="container " style="margin-top: 5%;" >
<div class="justify-content-end">
        <button type="button" class="btn btn-primary" id="add">Add New Events</button>
        <a href="/booking/export" style="text-decoration:none;color:white"><button type="button" class="btn btn-warning" id="export">Export Booking Details</button></a></div>
        <div class="row py-5">
          <div class="col-12">
            <table id="example" class="table table-hover responsive nowrap" style="width:100%">
              <thead>
                <tr>
                  <th>Event Name</th>
                  <th style="width:60px">Event Category</th>
                  <th>Unit</th>
                  <th>Cost</th>
                  <th>Availability</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${products}" var="product">
                <tr>
                  <td>
                    <a href="#">
                      <div class="d-flex align-items-center">
                        <div class="avatar  mr-3"> <img class="card-img-top" src="data:image/jpeg;base64,${product.base64imageFile}" onclick="location.href='/products/${product.itemId}';" alt="..." /></div>
      
                        <div class="">
                          <p class="font-weight-bold mb-0">${product.itemName}</p>
                          <p class="text-muted mb-0">TRIP_AD_${100+product.itemId}</p>
                        </div>
                      </div>
                    </a>
                  </td>
                  <td style="  overflow-x: hidden;"> ${product.itemCategory==1?"Water Sports":"Others"}</td>
                  <td>1/${product.unit}</td>
                  <td>${product.itemPrice}</td>
                  <td>
                    <div class="badge badge-success badge-success-alt">${product.itemAvailability}</div>
                  </td>
                  <td>
                    <div class="dropdown">
                      <button class="btn btn-sm btn-icon" type="button" id="dropdownMenuButton2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-ellipsis-h" data-toggle="tooltip" data-placement="top"
                              title="Actions"></i>
                          </button>
                      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton2">
                        <a class="dropdown-item" href="#"><i class="bx bxs-pencil mr-2"></i> Edit Profile</a>
                        <a class="dropdown-item text-danger" href="#"><i class="bx bxs-trash mr-2"></i> Remove</a>
                      </div>
                    </div>
                  </td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </div>
      </div>
      
      <div class="container text-center">
        <div class="row py-5">
          <div class="col-12">
            <h6 class="small text-danger"></h6>
          </div>
        </div>
      </div>
      
      
<div id="myModal" class="modal fade" data-backdrop="false">
	<div class="modal-dialog modal-confirm modal-dialog-centered"  >
		<div class="modal-content"style="background-color:black; opacity:1.5">
			<div class="modal-header">
				<div class="icon-box">
					<i class="material-icons">add_business</i>
				</div>				
				<h4 class="modal-title w-100">Add Event</h4>	
			</div>
			
			<form action="POST" action="/product/add" enctype="multipart/form-data">
				<div class="height-100 d-flex justify-content-center align-items-center">
				    <div class="position-relative">
				        <div class=" p-2 text-center">
				         	<div class="mb-3">
							  <label for="exampleFormControlInput1" class="form-label">Event Name</label>
							  <input type="text" class="form-control" name="ename" id="exampleFormControlInput1" placeholder="Event Name">
							</div>
							<div class="mb-3">
							  <label for="exampleFormControlTextarea1" class="form-label">Event Description</label>
							  <textarea class="form-control" name="edesc" id="exampleFormControlTextarea1" rows="3"></textarea>
							</div>
						<!--	<div class="mb-3">
							  <label for="exampleFormControlTextarea1" class="form-label">Event Category</label>
							  <select class="form-select" name="ecat" aria-label="Event Category">
							  <option selected>Open this select menu</option>
							  <option value="1">Water Sport</option>
							  <option value="2">Air Games</option>
							  <option value="3">Sight Seeing</option>
							</select>
							
							</div>-->
							 <label for="exampleFormControlTextarea1" class="form-label">Event Price</label>
							<div class="input-group mb-3">
							  <span class="input-group-text">$</span>
							  
							  <input type="text" name="price" class="form-control" aria-label="amount (with dot and two decimal places)"><span class="input-group-text">.00</span>
							</div>
							<div class="mb-3">
							  <label for="formFile" class="form-label">Upload Image</label>
							  <input class="form-control" type="file" name="eimage" id="formFile">
							</div>
				        </div>
				    </div>
				    
				</div>
				<div class="modal-footer">
					<button class="btn btn-success btn-block" type="submit">Add</button>
				</div>
			</form>
		</div>
	</div>
</div>  
  </body>
</html>
