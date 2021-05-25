<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listagem de Localizações</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<h5>LISTAGEM DE LOCALIZAÇÕES</h5>
	<form action="LocalizacaoServlet">
		<button name="incluir"><i class="fas fa-plus"></i>Incluir</button>
		<table border= "1" class="table table-hover table-condensed">
			<thead>
		      <tr>
			      <td>Id</td>
			      <td>Data e Hora</td>
			      <td>Latitude</td>
			      <td>Longitude</td>
			      <td>Ronda</td>
			      <td></td>
			      <td></td>	      
		      </tr>
		   </thead>
		
		   <c:forEach items="${listaLocalizacao}" var="lz" varStatus="index"> 
			   <tr>
			      <td>${lz.id}</td>
			      <td><fmt:formatDate value= "${lz.dataHora}" pattern="dd/MM/yyyy HH:mm"/></td>
			      <td>${lz.latitude}</td>
			      <td>${lz.longitude}</td>
			      <td>${lz.ronda.id} / ${lz.ronda.locomocao.descricao} / <fmt:formatDate value= "${lz.ronda.dataHoraInicio}" pattern="dd/MM/yyyy HH:mm"/></td>
			      <td><button name="alterar" value="${lz.id}">Alterar</button></td>
			      <td><button name="excluir" value="${lz.id}">Excluir</button></td>
			   </tr>
		   </c:forEach>
		</table>
	</form>
</body>
</html>