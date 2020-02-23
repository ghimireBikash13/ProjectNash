<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>

</head>
<body>
	<h2>Customer Sign up</h2>

	<f:form id="signupForm" modelAttribute="patients" action="nashhos"
		method="post">
		<table align="center">


			<tr>
				<td><f:label path="name">Name: </f:label></td>
				<td><f:input path="name" name="name" id="name" /></td>
			</tr>

			<tr>
				<td><f:label path="address">Address: </f:label></td>
				<td><f:input path="address" name="address" id="address" /></td>
			</tr>

			<tr>
				<td><f:label path="age">Age: </f:label></td>
				<td><f:input path="age" name="age" id="age" /></td>
			</tr>

			<tr>
				<td><f:label path="dOB">DOB: </f:label></td>
				<td><f:input path="dOB" name="dOB" id="dOB" /></td>
			</tr>


			<tr>
				<td><f:label path="phone">Phone: </f:label></td>
				<td><f:input path="phone" name="phone" id="phone" /></td>
			</tr>

			<tr>
				<td></td>
				<td align="left"><f:button id="signup" name="signup">Sign Up</f:button></td>
			</tr>
			<tr></tr>

		</table>

	</f:form>
</body>
</html>