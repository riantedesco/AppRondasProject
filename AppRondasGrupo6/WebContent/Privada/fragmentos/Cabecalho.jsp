<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	
	<!-- Incluir Bootstrap -->
	<link rel="stylesheet" href="../../resources/bootstrap/css/bootstrap.min.css">
	<!-- jQuery (necess�rio para os plugins Javascript do Bootstrap) -->
	<script src="../../resources/jquery/jquery-3.6.0.min.js"></script>
	<!-- Incluir plugins do Bootstrap -->
	<script src="../../resources/bootstrap/js/bootstrap.min.js"></script>
	<!-- Inclus�o da biblioteca de �cones Fontawesome -->
	<link href="../../resources/fontawesome/css/all.css" rel="stylesheet">
	<!-- Inclus�o da biblioteca de menus do Smartmenus -->
	<link href="../../resources/smartmenus/css/sm-core-css.css" rel="stylesheet" type="text/css" />
	<!-- Inclus�o do menu espec�fico a ser usado -->
	<link href="../../resources/smartmenus/css/sm-clean/sm-clean.css" rel="stylesheet" type="text/css" />
	<!-- Inclus�o de estilos meus -->
	<link rel="stylesheet" href="../resources/css/estilos.css">
</head>

<body>
	<br><h1 style="text-align: center;">PROJETO DE MONITORAMENTO POLICIAL</h1><br>

	<nav id="main-nav" class="main-nav">
		<ul id="main-menu" class="sm sm-clean">
			<li><a href="../Home/Home.jsp">Home</a></li>
					
			<li><a href="#">Cadastros</a>
				<ul>
					<li><a href="../Pessoa/PessoaServlet">Pessoas</a></li>
					<li><a href="../Locomocao/LocomocaoServlet">Locomo��es</a></li>
					<li><a href="../Localizacao/LocalizacaoServlet">Localiza��es</a></li>
					<li><a href="../Ocorrencia/OcorrenciaServlet">Ocorr�ncias</a></li>
					<li><a href="../Ronda/RondaServlet">Rondas</a></li>
					<li><a href="#">Mais...</a>
						<ul>
							<li><a href="#" class="disabled">Dados Adicionais</a></li>
						</ul>
					</li>
				</ul>
			</li>
			
			<li><a href="#">Relat�rios</a></li>
			
			<li><a href="#">Sobre</a>
				<ul class="mega-menu">
					<li>
						<div style="width: 400px; max-width: 100%; padding: 5px 24px;">
							<p>Este site armazena relat�rios sobre dados pessoais, respeitando a <strong>Lei Geral de Prote��o aos Dados</strong>.</p>
						</div>
					</li>
				</ul>
			</li>
			
			<li><a href="../UsuarioLogoutServlet">Sair</a></li>
		</ul>
	</nav>
	<br>
		
	<script type="text/javascript"
	src="../../resources/smartmenus/libs/jquery/jquery.js"></script>
	<script type="text/javascript"
	src="../../resources/smartmenus/jquery.smartmenus.js"></script>
	<script type="text/javascript">
		$(function() {
			$('#main-menu').smartmenus({
				subMenusSubOffsetX : 1,
				subMenusSubOffsetY : -8
			});
		});
	</script>
</body>
</html>