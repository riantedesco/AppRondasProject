<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listagem de Locomoções</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<h5>LISTAGEM DE LOCOMOÇÕES</h5>
	<form action="LocomocaoServlet">
		<button name="incluir"><i class="fas fa-plus"></i>Incluir</button>
		<table border= "1" class="table table-hover table-condensed">
			<thead>
		      <tr>
			      <td>Id</td>
			      <td>Descrição</td>
			      <td>Placa</td>
			      <td></td>
			      <td></td>	      
		      </tr>
		   </thead>
		
		   <c:forEach items="${listaLocomocao}" var="lm" varStatus="index"> 
			   <tr>
			      <td>${lm.id}</td>
			      <td>${lm.descricao}</td>
			      <td>${lm.placa}</td>
			      <td><button name="alterar" value="${lm.id}">Alterar</button></td>
			      <td><button name="excluir" value="${lm.id}">Excluir</button></td>
			   </tr>
		   </c:forEach>
		</table>
	</form>
</body>
</html>