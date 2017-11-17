<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Disco Form</title>
</head>
<body>
	<form action="DiscoController">
		<label>Title:</label><br />
		<input type="text" name="titulo" value="${disco.titulo}" /><br />
		
		<label>Date:</label><br />
		<input type="text" name="fecha" value="${disco.fecha}" /><br />
		
		<label>RecordingType:</label><br />
		<input type="text" name="tipograbacion" value="${disco.tipoGrabacion}" /><br />
		
		<label>Number Songs:</label><br />
		<input type="number" name="canciones" value="${disco.canciones}" /><br />
		<br />
		<input type="submit" name="btn_save" value="Save" />	
	</form>
</body>
</html>