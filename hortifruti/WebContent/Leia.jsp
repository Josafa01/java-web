<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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

		.card-style {
			margin-top: 98px;
			margin-left: 44px;
			text-align: center;
			background-color:#000;
			color: #FFFFFF;
		}
		
		.card-header-style {
			background-color: #003311;
			color: #66ff99;
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
	</style>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		  <a class="navbar-brand" href="#">HORTFRUT</a>
		  <ul class="navbar-nav ml-auto">
		    <li class="nav-item">
      			<a class="nav-link" href="LogOffServlet">Sair</a>
      			<div class="widget_title_bar"></div>
    		</li>
		  </ul>
		</nav>


		<div class="sidenav">
			<a href="Painel" data-filter="home">Home</a> 
			<a href="Cadastrar" class="a" data-filter="cadastrar">Cadastrar</a>
			<a href="#" class="a" data-filter="vendas">Vendas</a> 
			<a href="#" class="a" data-filter="busca">Busca</a> 
			<a href="#" class="a" data-filter="relatorio">Relatorio</a>
			<a href="Leia" class="active a" data-filter="relatorio">LEIA</a>
		</div>

		<div class="main">
			<div class="card card-style">
			  <div class="card-header card-header-style">Sobre o Sistema</div>
			  <div class="card-body">
			  	<p>O sistema em questão tem como intuito de ser didático sem nehuma aplicação real do mesmo.</p>
			  </div>
			  <div class="card-footer"></div>
			</div>
		</div>

	
	
</body>
</html>