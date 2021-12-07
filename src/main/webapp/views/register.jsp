<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:if test="${not empty error}">
	<div class="alert">
		${error}
</div>
		</c:if>

<html>
<body onload='document.loginForm.username.focus();'>

	<form name="register" action="/register" method="POST">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type='text' required name='username' value=''></td>
			</tr>
			<tr>
				<td>MailId:</td>
				<td><input type='mail' required name='Mail' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password'  name='password' pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
				title="Must contain at least one number and one uppercase and lowercase letter,
				 and at least 8 or more characters" required	 /></td>
			</tr>
			<tr>
				<td>PhoneNumber:</td>
				<td><input type="tel" required name="Phonenum" pattern="[0-9]{10}"></td>
			</tr>
			
		
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>