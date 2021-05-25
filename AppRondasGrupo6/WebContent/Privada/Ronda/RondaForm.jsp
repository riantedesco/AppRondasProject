<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edição de Ronda</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	
	<form action= "RondaServlet" method= "post">
		<fieldset>
			<legend>Dados da Ronda:</legend>
			
			<div class="row">
				<div class="col-md-1">
					<label for="id">Id:</label>
					<input type="text" readonly="readonly" name="id" id="id" value="${r.id}" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label for="dataHoraInicio">Data e Hora Inicial:</label>
					<input type="datetime-local" class="form-control" name="dataHoraInicio" id="dataHoraInicio" pattern="YYYY-MM-DDThh:mm" 
					value="<fmt:formatDate value="${r.dataHoraInicio}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${r.dataHoraInicio}" pattern="HH:mm"/>">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label for="dataHoraFim">Data e Hora Final:</label>
					<input type="datetime-local" class="form-control" name="dataHoraFim" id="dataHoraFim" pattern="YYYY-MM-DDThh:mm" 
					value="<fmt:formatDate value="${r.dataHoraFim}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${r.dataHoraFim}" pattern="HH:mm"/>">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">
					<label for="latUltima">Latitude da Última Ronda:</label> 
					<input type="number" name="latUltima" id="latUltima" value="${r.latUltima}" class="form-control" placeholder="Latitude">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-2">
					<label for="lonUltima">Longitude da Última Ronda:</label> 
					<input type="number" name="lonUltima" id="lonUltima" value="${r.lonUltima}" class="form-control" placeholder="Longitude">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label for="dataHoraUltima">Data e Hora da Última Ronda:</label>
					<input type="datetime-local" class="form-control" name="dataHoraUltima" id="dataHoraUltima" pattern="YYYY-MM-DDThh:mm" 
					value="<fmt:formatDate value="${r.dataHoraUltima}" pattern="yyyy-MM-dd"/>T<fmt:formatDate value="${r.dataHoraUltima}" pattern="HH:mm"/>">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label for="locomocao">Locomocão:</label><br>
					<select name="locomocao" id="locomocao">
						<c:forEach items="${listaLocomocao}" var="lm" varStatus="index"> 
						    <option value="${lm.id}">${lm.id} / ${lm.descricao} / ${lm.placa}</option>
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