<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listagem de Ocorrências</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<h5>LISTAGEM DE OCORRÊNCIAS</h5>
	<form action="OcorrenciaServlet">
		<button name="incluir"><i class="fas fa-plus"></i>Incluir</button>
		<table border= "1" class="table table-hover table-condensed">
			<thead>
		      <tr>
			      <td>Id</td>
			      <td>Data e Hora</td>
			      <td>Título</td>
			      <td>Descrição</td>
			      <td>Latitude</td>
			      <td>Longitude</td>
			      <td>Foto</td>
			      <td>Ronda</td>
			      <td></td>
			      <td></td>	      
		      </tr>
		   </thead>
		
		   <c:forEach items="${listaOcorrencia}" var="o" varStatus="index"> 
			   <tr>
			      <td>${o.id}</td>
			      <td><fmt:formatDate value= "${o.dataHora}" pattern="dd/MM/yyyy HH:mm"/></td>
			      <td>${o.titulo}</td>
			      <td>${o.descricao}</td>
			      <td>${o.latitude}</td>
			      <td>${o.longitude}</td>
			      <td><button name="alterarFoto" value="${o.id}">Foto</button></td>
			      <td>${o.ronda.id} / ${o.ronda.locomocao.descricao} / <fmt:formatDate value= "${o.ronda.dataHoraInicio}" pattern="dd/MM/yyyy HH:mm"/></td>
			      <td><button name="alterar" value="${o.id}">Alterar</button></td>
			      <td><button name="excluir" value="${o.id}">Excluir</button></td>
			   </tr>
		   </c:forEach>
		</table>
	</form>
</body>
</html>