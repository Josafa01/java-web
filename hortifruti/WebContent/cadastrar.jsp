<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%= session.getAttribute("email") %>
<% 
	response.setHeader("Cache-control", "no-cache, no-store");
	response.setHeader("pragma", "no-cache");
	response.setHeader("Expires", "-1");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resource/css/bootstrap.min.css">
<link rel="stylesheet" href="resource/css/template.css" />
<title>hortifruti</title>
<style>
.main {
	margin-left: 160px;
	font-size: 28px;
	padding: 0px 10px;
}

.navbar {
	padding: 0.5rem 1rem;
}

.navbar-brand {
	margin-left: 63px;
	font-family: fantasy;
	font-size: 30px
}

.navbar-dark .navbar-brand {
	color: #EEF8E3;
}

.user-logged {
	position: absolute;
	z-index: 9999;
	top: 24px;
	left: 76%;
	color: #eef8e3de;
	font-size: 25px;
}

.align-card-deck {
	margin-top: 21%;
    margin-left: 26%;
    margin-right: 4%;
}

.link-a-cad{
	color:#ffffff;
	font-weight:bold;
	text-decoration:none; 
}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class="navbar-brand" href="#">HORTFRUT</a>
		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a class="nav-link" href="LogOffServlet">Sair</a>
				<div class="widget_title_bar"></div></li>
		</ul>
	</nav>
	
	<div class="sidenav">
			<a href="Painel" data-filter="home">Home</a> 
			<a href="Cadastrar" class="active" data-filter="cadastrar">Cadastrar</a>
			<a href="#" data-filter="vendas">Vendas</a> 
			<a href="#" data-filter="busca">Busca</a> 
			<a href="#" data-filter="relatorio">Relatorio</a>
		</div>

	<div class="card-deck align-card-deck">
		<div class="card bg-warning">
			<div class="card-body text-center">
				<td><a class="link-a-cad" href="ClientesTable?action=ShowAll">Cadastro de Clientes</a></td>
			</div>
		</div>
		<div class="card bg-success">
			<div class="card-body text-center">
				<td><a class="link-a-cad" href="ProdutosTable?action=ShowAll">Cadastro de Produtos</a></td>
			</div>
		</div>
		<div class="card bg-danger">
		    <div class="card-body text-center">
		      <td><a class="link-a-cad" href="VendedorTable?action=ShowAll">Cadastro de Vendedor</a></td>
		    </div>
		</div> 
	</div>

	<!-- jQuery library -->
	<script src="resource/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap JS library -->
	<script src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/script.js"></script>

</body>
</html>