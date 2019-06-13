<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room List</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Room List</h3>

	<p style="color: red;">${errorString}</p>

	<table border="1" cellpadding="5" cellspacing="1">
		<tr>
			<th>Number</th>
			<th>Capacity</th>
			<th>Smoking</th>
		</tr>
		<c:forEach items="${roomList}" var="room">
			<tr>
				<td>${room.roomNumber}</td>
				<td>${room.roomCapacity}</td>
				<td>${room.smoking}</td>
				<td><a href="editRoom?number=${room.roomNumber}">Edit</a></td>
				<td><a href="deleteRoom?number=${room.roomNumber}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<a href="createRoom">Create Room</a>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>