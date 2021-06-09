<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listagem de Vigilantes de Rondas</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<h5>LISTAGEM DE VIGILNTES DE RONDAS</h5>
	<form action="RondaServlet">
		<input type="hidden" name="idRonda" value="${r.id}">
		
		<div class="col-md-3">
			<label for="vigilante">Vigilantes</label><br>
			<select name="vigilante" id="vigilante">
				<c:forEach items="${listaPessoa}" var="p" varStatus="index"> 
					<option value="${p.id}">${p.id} / ${p.nome}</option>
				</c:forEach>
			</select>
		</div>
	
		<button name="incluirVigilante"><i class="fas fa-plus"></i>Incluir</button>
		<button name="voltar"><i class="fas fa-plus"></i>Voltar</button>
		
		<table border= "1" class="table table-hover table-condensed">
			<thead>
		      <tr>
			      <td>Id</td>
			      <td>Nome</td>
			      <td></td>	      
		      </tr>
		   </thead>
		
		   <c:forEach items="${r.vigilantes}" var="v" varStatus="index"> 
			   <tr>
			      <td>${v.id}</td>
			      <td>${v.nome}</td>
			      <td><button name="excluirVigilante" value="${v.id}">Excluir</button></td>
			   </tr>
		   </c:forEach>
		</table>
	</form>
</body>
</html>