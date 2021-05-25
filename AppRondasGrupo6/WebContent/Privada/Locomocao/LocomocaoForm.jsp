<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Edição de Locomoção</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>
	
	<form action= "LocomocaoServlet" method= "post">
		<fieldset>
			<legend>Dados da Locomoção:</legend>
			
			<div class="row">
				<div class="col-md-1">
					<label for="id">Id:</label>
					<input type="text" readonly="readonly" name="id" id="id" value="${lm.id}" class="form-control">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-7">
					<label for="descricao">Descrição:</label>
					<input type="text" name="descricao" id="descricao" value="${lm.descricao}" class="form-control" placeholder="Descrição">
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3">
					<label for="placa">Placa:</label> 
					<input type="text" name="placa" id="placa" value="${lm.placa}" class="form-control" placeholder="Placa">
				</div>
			</div>
			<br><br>
			<button type= "submit" name="gravar"><i class="fas fa-save"></i> Gravar</button>
			<button type= "submit" name="cancelar"><i class="fas fa-undo"></i> Cancelar</button>
		</fieldset>
	</form>
</body>
</html>