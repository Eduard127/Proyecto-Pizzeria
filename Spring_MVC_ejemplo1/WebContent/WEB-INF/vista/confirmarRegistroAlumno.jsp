<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmacion Registro</title>
<Style type="text/css">

Strong{
	color:red;
}

</Style>
</head>
<body>

el Alumno con nombre <Strong>${elAlumno.nombre}</Strong>, apellido <Strong>${elAlumno.apellido}</Strong> y edad <strong>${elAlumno.edad}</strong> se ha registrado satisfactoriamente,
a escojido <Strong>${elAlumno.electivas}</Strong> como materias electivas de manera presencial en la ciudad de <Strong>${elAlumno.ciudadEstudios}</Strong>, con codigo postal <strong>${elAlumno.codigoPostal}</strong> y estudiara
los siguientes idiomas en el trascurso de la carrera:<br/>
<Strong>${elAlumno.idiomas}</Strong> <br/>
su Email es: <strong>${elAlumno.email}</strong>
 
</body>
</html>