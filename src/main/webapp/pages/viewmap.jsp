
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Patient List</h1>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Address</th>
		<th>Age</th>
		<th>DOB</th>
		<th>Phone</th>
		<th>Edit</th>
		<!-- <th>Delete</th> -->
	</tr>
	<c:forEach var="nashdo" items="${list}">
		<tr>
			<td>${nashdo.id}</td>
			<td>${nashdo.name}</td>
			<td>${nashdo.address}</td>
			<td>${nashdo.age}</td>
			<td>${nashdo.dOB}</td>
			<td>${nashdo.phone}</td>
			<td><a href="editpage?id=${nashdo.id}">Edit</a></td>
			<!--  <td><a href="editpage/${doedit.id}">Delete</a></td>-->
		</tr>
	</c:forEach>
</table>
