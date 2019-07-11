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
body {
  overflow-y: visible;
}

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
	position: fixed;
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


#btn-save, #btn-back {
    width: 400px;
    height: 47px;
    margin-top: 30px;
    margin-left: 9px;
    margin-right: 0px;
}

.style-form {
	margin-left: 17%;
    margin-top: 13%;
}


#inputName, #inputSobrenome, #inputIdade,
#inputEmail, #inputTelefone, #inputCidade,
#inputBairro, #inputRua {

	border: none;
    border-radius: 0;
    background-color: transparent;
    border-bottom: 5px solid #336538;
    box-shadow: 0 0 0 0;
    margin-top:45px;
    width: 516px;
}

.hd {
	text-align: center;
	margin-bottom: 30px;
	margin-top: -83px;
}

.alert-style {
	height: 63px;
    width: 97%;
	text-align: center;
}

#id {
	margin-top: -100000px;
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
		
		
		<div class="container style-form">
		
		<header class="hd">
			<h1 class="title_page_cad">Cliente Desativado</h1>	
		</header>
		
		<form id="tarefasForm" method="POST" action="ClientesAdd">
		  <input type="text" readonly="readonly" id="id" name="id" value="${cli.id}" />
		  <div class="form-row">
		    <div class="form-group col-md-6">
		      <input type="text" class="form-control" readonly="readonly" id="inputName" name="nome" placeholder="Nome" value="${cli.nome}"/>
		    </div>
		    <div class="form-group col-md-6">
		      <input type="text" class="form-control" readonly="readonly"  id="inputSobrenome" name="sobrenome" placeholder="Sobrenome" value="${cli.sobrenome}" /> 
		    </div>
		  </div>
		  
		  <div class="form-row">
		  	<div class="form-group col-md-6">
		      <input type="text" class="form-control"  readonly="readonly" id="inputIdade" name="idade" placeholder="Idade" value="${cli.idade}" /> 
		    </div>
		    <div class="form-group col-md-6">
		      <input type="email" class="form-control"  readonly="readonly" id="inputEmail" name="email" placeholder="E-mail" value="${cli.email}" />
		    </div>
		  </div>
		 
		 <div class="form-row">
		  	<div class="form-group col-md-6">
		      <input type="text" class="form-control" readonly="readonly"  id="inputTelefone" name="telefone" placeholder="Telefone" value="${cli.telefone}" /> 
		    </div>
		    <div class="form-group col-md-6">
		      <input type="text" class="form-control"  readonly="readonly" id="inputCidade" name="cidade" placeholder="Cidade" value="${cli.cidade}" />
		    </div>
		  </div>
		  
		  <div class="form-row">
		  	<div class="form-group col-md-6">
		      <input type="text" class="form-control"  readonly="readonly" id="inputBairro" name="bairro" placeholder="Bairro" value="${cli.bairro}" /> 
		    </div>
		    <div class="form-group col-md-6">
		      <input type="text" class="form-control"  readonly="readonly" id="inputRua" name="rua" placeholder="Rua" value="${cli.rua}" />
		    </div>
		  </div>
		  
		</form>
	</div>
		

	<!-- jQuery library -->
	<script src="resource/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap JS library -->
	<script src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/script.js"></script>

</body>
</html>