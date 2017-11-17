<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Disco list</title>
</head>
<body>
<table border="1">
		<tr>
			<th>
			  <form action="DiscoController">
			  		<input type="submit" name="btn_new"
			  		value="New "/>
			  </form>
			  <a href="DiscoReport">Print report</a>
			</th>
			<td>IdDisco</td>
			<td>Title</td>
			<td>Date</td>
			<td>RecordingType</td>
			<td>Number Songs</td>
			
		</tr>
		 <c:forEach var="disco" items="${discos}">
		 	 <tr>
		 	 	<td>
		 	 		<form action="DiscoController">
		 	 			<input type="hidden" name="id" value="${disco.id}">
		 	 			<input type="submit" name="btn_edit" value="Edit"/>
		 	 			 <input type="submit" name="btn_delete" value="Delete"/>
		 	 		</form>
		 	 	</td>
		 	 	<td>${disco.id}</td>
		 	 	<td>${disco.titulo}</td>
		 	 	<td>${disco.fecha}</td>
		 	 	<td>${disco.tipoGrabacion}</td>
		 	 	<td>${disco.canciones}</td>
		 	 </tr>	
		 </c:forEach>
	</table>
</body>
</html>