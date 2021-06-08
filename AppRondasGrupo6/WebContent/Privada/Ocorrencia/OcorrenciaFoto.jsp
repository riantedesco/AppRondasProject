<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição de Ocorrencia</title>
</head>

<body>
	<jsp:include page="../fragmentos/Cabecalho.jsp"></jsp:include>

	<form action="OcorrenciaServlet" method="post" enctype="multipart/form-data">
		<fieldset>
			<legend>Fotos da Ocorrencia:</legend>

			<div class="row">
				<div class="col-md-1">
					<label for="id">Id:</label> <input type="text" readonly="readonly"
						name="id" id="id" value="${o.id}" class="form-control">
				</div>
			</div>

			<div class="row">
				<div class="col-md-3">
					<label>Selecione a foto:</label> 
					
					<input type="file" id="foto" name="foto" /><br>
					<div id="areaImagem">
						<img name="imagem" id="imagem" width="200" height="200"
							src="../uploads/Foto${o.foto}.jpg" />
					</div>

				</div>
			</div>
			
			<button type="submit" name="gravarFoto">
				<i class="fas fa-save"></i> Gravar
			</button>
			<button type="submit" name="cancelar">
				<i class="fas fa-undo"></i> Cancelar
			</button>
		</fieldset>
	</form>
</body>
</html>