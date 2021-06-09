<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listagem de Rondas</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<h5>LISTAGEM DE RONDAS</h5>
	<form action="RondaServlet">
		<button name="incluir"><i class="fas fa-plus"></i>Incluir</button>
		<table border= "1" class="table table-hover table-condensed">
			<thead>
		      <tr>
			      <td>Id</td>
			      <td>Data e Hora Inicial</td>
			      <td>Data e Hora Final</td>
			      <td>Latitude da Última Ronda</td>
			      <td>Longitude da Última Ronda</td>
			      <td>Data e Hora da Última Ronda</td>
			      <td>Locomocão</td>
			      <td>Vigilantes</td>
			      <td></td>
			      <td></td>	      
		      </tr>
		   </thead>
		
		   <c:forEach items="${listaRonda}" var="r" varStatus="index"> 
			   <tr>
			      <td>${r.id}</td>
			      <td><fmt:formatDate value= "${r.dataHoraInicio}" pattern="dd/MM/yyyy HH:mm"/></td>
			      <td><fmt:formatDate value= "${r.dataHoraFim}" pattern="dd/MM/yyyy HH:mm"/></td>
			      <td>${r.latUltima}</td>
			      <td>${r.lonUltima}</td>
			      <td><fmt:formatDate value= "${r.dataHoraUltima}" pattern="dd/MM/yyyy HH:mm"/></td>
			      <td>${r.locomocao.id} / ${r.locomocao.descricao} / ${r.locomocao.placa}</td>
			      <td><button name="vigilantes" value="${r.id}">Vigilantes</button></td>
			      <td><button name="alterar" value="${r.id}">Alterar</button></td>
			      <td><button name="excluir" value="${r.id}">Excluir</button></td>
			   </tr>
		   </c:forEach>
		</table>
	</form>
</body>
</html>