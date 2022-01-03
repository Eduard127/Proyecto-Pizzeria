<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/miestilos.css/">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <p>hola ${param.nombreAlumno }. Bienvenido al curso de Spring 
 
 <br></p>
 
 <h2>Atencion a Todos</h2>
 
 <p>${mensajeClaro }</p>
 
 <p>hola todos, esto deberia estar en negro</p>
 
 
 
 <!-- la etiqueta ${pageContext.request.contextPath} nos posiciona en la carpeta web content, de hay toca darle la ruta del archivo -->
 <img alt="foto" width="300px" height="250px" src="${pageContext.request.contextPath}/recursos/imgs/EspacioRaspado3.png">
</body>
</html>