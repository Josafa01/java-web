<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%=session.getAttribute("email")%>
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

.style-table {
	margin-top: 20%;
	margin-left: 10%;
}

.title-table-cli {
	margin-top: 12%;
	margin-bottom: -10%;
	margin-left: 15%;
}

#btn-add {
	margin-top: 190%;
	margin-bottom: -243%;
	margin-left: 119%;
}

#btn-del {
    margin-top: 136%;
    margin-bottom: -243%;
    margin-left: 82%;
    width: 134px;
    height: 35px;
    color: #FFF;
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
			<a href="Leia" data-filter="relatorio">LEIA</a>
		</div>

	<div class="container">
		<h2 class="title-table-cli d-flex justify-content-center">Tabela de Clientes</h2>
		<div class="d-flex justify-content-start">
			<a href="ClientesDel">
				<button type="button" class="btn btn-info" id="btn-del">Desativados</button>
			</a>
		</div>
		<div class="d-flex justify-content-end">
			<a href="ClientesAdd">
				<button type="button" class="btn btn-success" id="btn-add">Adicionar</button>
			</a>
		</div>
		<table class="table table-dark table-striped style-table">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Sobrenome</th>
					<th>idade</th>
					<th>E-mail</th>
					<th>Telefone</th>
					<th>Cidade</th>
					<th>Bairro</th>
					<th>Rua</th>
					<th>Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clientes}" var="cli">
					<tr>
						<td><c:out value="${cli.nome}" /></td>
						<td><c:out value="${cli.sobrenome}" /></td>
						<td><c:out value="${cli.idade}" /></td>
						<td><c:out value="${cli.email}" /></td>
						<td><c:out value="${cli.telefone}" /></td>
						<td><c:out value="${cli.cidade}" /></td>
						<td><c:out value="${cli.bairro}" /></td>
						<td><c:out value="${cli.rua}" /></td>
						<td>
							<div class="btn-group">
								<a href="ClientesTable?action=edit&user=${cli.id}" class="btn btn-primary">Editar</a> 
								<a href="ClientesTable?action=delete&user=${cli.id}" class="btn btn-danger">Excluir</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>


	<!-- jQuery library -->
	<script src="resource/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap JS library -->
	<script src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/script.js"></script>
	
</body>
</html>