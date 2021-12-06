<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Welcome to Spring Security Success Page</h3>




<div style="padding:50px;cursor: pointer;">
	<img alt="Loading img"  src="data:image/jpeg;base64,${product.base64imageFile}" height="400px" width="600px"/>
	<ul >
		<li> ${product.itemId} : ${product.itemName} </li>
		
		<li> ${product.itemDesc} </li>
		<li>  &#8377 ${product.itemPrice} </li>
	</ul>
</div>




<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>