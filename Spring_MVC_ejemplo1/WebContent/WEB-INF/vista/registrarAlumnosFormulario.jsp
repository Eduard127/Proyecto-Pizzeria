<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario de Registro</title>
</head>
<body>
	
	<form:form action="confirmarRegistroAlumno" modelAttribute="elAlumno">
	
	Nombre <form:input path="nombre"/>
	<form:errors path="nombre" style="color:red"/>
	
	<br/><br/>
	
	Apellido <form:input path="apellido"/>
	<form:errors path="apellido" style="color:red"/>
	
	<br/><br/>
	
	Edad <br/>
	<form:input path="edad"/>
	<form:errors path="edad" style="color:red"/>
	
	<br/><br/>
	
	Email<br/>
	<form:input path="email"/>
	<form:errors path="email" style="color:red"/>
	
	<br/><br/>
	
	Codigo Postal<br/>
	<form:input path="codigoPostal"/>
	<form:errors path="codigoPostal" style="color:red"/>
	
	<br/><br/>
	
	Electivas <br/>
	<form:select path="electivas">
	
		<form:option value="Karate" label="Karate"/>
		<form:option value="MMA" label="MMA"/>
		<form:option value="Danza" label="Danza"/>
		<form:option value="Cocina" label="Cocina"/>
	
	</form:select>
	
	<br/><br/>

	Escoja la ciudad donde va a hacer sus estudios:<br/>
	
	Villavicencio <form:radiobutton path="ciudadEstudios" value="Villavicencio"/>
	Bucaramanga <form:radiobutton path="ciudadEstudios" value="Villavicencio"/>
	Bogota <form:radiobutton path="ciudadEstudios" value="Villavicencio"/>
	SantaMarta <form:radiobutton path="ciudadEstudios" value="Villavicencio"/>
	Medellin <form:radiobutton path="ciudadEstudios" value="Villavicencio"/>	
	<form:errors path="ciudadEstudios" style="color:red"/>
	
	<br/><br/>
	
	Escoja el o los idiomas que le gustaria aprender:<br/>
	
	<form:checkbox path="idiomas" value="Ingles"/> Ingles  <br/>
	<form:checkbox path="idiomas" value="Frances"/> Frances <br/>
	<form:checkbox path="idiomas" value="Ruso"/> Ruso <br/>
	<form:checkbox path="idiomas" value="Portugues"/> Portugues <br/>
	<form:checkbox path="idiomas" value="Coreano"/> Coreano 
	
	<br/><br/>
	
	<input type="submit" value="Enviar">
	
	</form:form>
	

</body>
</html>