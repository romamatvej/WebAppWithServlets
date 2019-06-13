<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>Edit Room</title>
   </head>
   <body>
 
      <jsp:include page="_header.jsp"></jsp:include>
      <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Edit Room</h3>
 
      <p style="color: red;">${errorString}</p>
 
      <c:if test="${not empty room}">
         <form method="POST" action="${pageContext.request.contextPath}/editRoom">
            <input type="hidden" name="number" value="${room.roomNumber}" />
            <table border="0">
               <tr>
                  <td>Number</td>
                  <td style="color:red;">${room.roomNumber}</td>
               </tr>
               <tr>
                  <td>Capacity</td>
                  <td><input type="text" name="capacity" value="${room.roomCapacity}" /></td>
               </tr>
               <tr>
                  <td>Smoking</td>
                  <td><input type="checkbox" name="smoking" value="Y" /></td>
               </tr>
               <tr>
                  <td colspan = "2">
                      <input type="submit" value="Submit" />
                      <a href="${pageContext.request.contextPath}/roomList">Cancel</a>
                  </td>
               </tr>
            </table>
         </form>
      </c:if>
 
      <jsp:include page="_footer.jsp"></jsp:include>
 
   </body>
</html>