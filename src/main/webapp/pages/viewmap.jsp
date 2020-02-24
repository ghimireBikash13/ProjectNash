
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<h1>Patient List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		
		<th>Name</th>
		<th>Address</th>
		<th>Age</th>
		<th>DOB</th>
		<th>Phone</th>
		<th>Edit</th>
	</tr>
	<c:forEach var = "nashdo" items="${list}">
		<tr>
			<td>${nashdo.name}</td>
			<td>${nashdo.address}</td>
			<td>${nashdo.age}</td>
			<td>${nashdo.dOB}</td>
			<td>${nashdo.phone}</td>
			<%-- <td><a href="editpat/${nashdo.id}">Edit</a></td> --%>
		</tr>
	</c:forEach>
</table>
