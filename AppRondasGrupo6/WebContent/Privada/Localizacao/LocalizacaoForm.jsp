<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edição de Localização</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	
	<form action= "LocalizacaoServlet" method= "post">
		<fieldset>
			<legend>Dados da Localização:</legend>
			
			<div class="row">
				<div class="col-md-1">
					<label for="id">Id:</label>
					<input type="text" readonly="readonly" name="id" id="id" value="${lz.id}" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label for="dataHora">Data e Hora:</label>
					<input type="datetime-local" class="form-control" name="dataHora" id="dataHora" pattern="YYYY-MM-DDThh:mm" 
					value="<fmt:formatDate value="${lz.dataHora}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${lz.dataHora}" pattern="HH:mm"/>">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">
					<label for="latitude">Latitude:</label> 
					<input type="number" name="latitude" id="latitude" value="${lz.latitude}" class="form-control" placeholder="Latitude">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">
					<label for="longitude">Longitude:</label> 
					<input type="number" name="longitude" id="longitude" value="${lz.longitude}" class="form-control" placeholder="Longitude">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label for="ronda">Ronda:</label><br>
					<select name="ronda" id="ronda">
						<c:forEach items="${listaRonda}" var="r" varStatus="index"> 
						    <option value="${r.id}">${r.id} / ${r.locomocao.descricao} / <fmt:formatDate value= "${r.dataHoraInicio}" pattern="dd/MM/yyyy HH:mm"/></option>
						</c:forEach>
					</select>
				</div>
			</div>
			<br>
			<button type= "submit" name="gravar"><i class="fas fa-save"></i> Gravar</button>
			<button type= "submit" name="cancelar"><i class="fas fa-undo"></i> Cancelar</button>
		</fieldset>
	</form>
</body>
</html>