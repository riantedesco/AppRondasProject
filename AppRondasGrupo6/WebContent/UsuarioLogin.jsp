<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Login do Usuário</title>
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>

<body>
	<form action="UsuarioLoginServlet" method="post">
		<div class="panel panel-default" style="width: 300px; margin: auto; margin-top: 25vh; "> 
		   <div class="panel-heading"> 
		      <label>AUTENTICAÇÃO</label>  
		   </div> 
		   
		   <div class="panel-body"> 
		   
		   		<label>Email</label>
		        <input type="email" id="inputEmail" name="inputEmail" 
		               class="form-control" placeholder="Email address" required autofocus>
		        <label>Senha</label>       
		        <input type="password" id="inputPassword" name="inputPassword" 
		               class="form-control" placeholder="Password" required>
		   </div> 
		   
		   <div class="panel-footer"> 
		      <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Login</button>
		      
		   </div> 
		</div> 
	</form>
	<p style="text-align: center;">${requestScope.mensagemLogin}</p>
</body>
</html>