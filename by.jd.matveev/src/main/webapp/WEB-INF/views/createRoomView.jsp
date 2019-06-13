<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Room</title>
</head>
<body>

	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Create Room</h3>

	<p style="color: red;">${errorString}</p>

	<form method="POST"
		action="${pageContext.request.contextPath}/createRoom">
		<table border="0">
			<tr>
				<td>Number</td>
				<td><input type="text" name="number" value="${room.number}" /></td>
			</tr>
			<tr>
				<td>Capacity</td>
				<td><input type="text" name="capacity" value="${room.capacity}" /></td>
			</tr>
			<tr>
				<td>Smoking</td>
				<td><input type="checkbox" name="smoking" value="Y" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="roomList">Cancel</a></td>
			</tr>
		</table>
	</form>

	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>