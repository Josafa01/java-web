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

		.card-waves {
			margin-top: 94px;
		    margin-left: 75px;
		    margin-right: 376px;
		    height: 483px;
		    border: 1px solid #cccccc;;
		}

		.card-round {
			margin-top: -483px;
		    margin-left: 850px;
		    height: 483px;
		    border: 1px solid #cccccc;
		}

		.card-header {
			background-color: #1B3409;
    		color: #7FBD32;
		}

		.card-body {
			background-color: #e9ecef;
		    color: #B0DC7A;
		    height: 86% !important;
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
			<a href="Painel" class="active a" data-filter="home">Home</a> 
			<a href="Cadastrar" class="a" data-filter="cadastrar">Cadastrar</a>
			<a href="#" class="a" data-filter="vendas">Vendas</a> 
			<a href="#" class="a" data-filter="busca">Busca</a> 
			<a href="#" class="a" data-filter="relatorio">Relatorio</a>
		</div>

		<div class="main">
			<div class="card-waves">
			  <div class="card-header">
			    Fluxo Diario
			  </div>
			  <div class="card-body">
			    <canvas id="primeiroGrafico" width="800" height="450"></canvas>

			  </div>
			</div>

			<div class="card-round" style="max-width: 18rem;">
			  <div class="card-header">Tipo Estoque</div>
			  <div class="card-body">
			    <canvas id="tipo_produto" width="800" height="1000"></canvas>

			  </div>
			</div>
		</div>

	<!-- jQuery library -->
	<script src="resource/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap JS library -->
	<script src="resource/js/bootstrap.min.js"></script>
	<!-- Chart JS library -->
	<script src="resource/js/Chart.min.js"></script>
	<script src="resource/js/script.js"></script>
	
	<script type="text/javascript">
		let primeiroGrafico = document.getElementById('primeiroGrafico').getContext('2d');                
		
		let chart = new Chart(primeiroGrafico, {
		    type: 'line',                    
			 data: {
		    labels: [1500,1600,1700,1750,1800,1850,1900,1950,1999,2050],
		    datasets: [{ 
		        data: [86,114,106,106,107,111,133,221,783,2478],
		        label: "Vendas",
		        borderColor: "#02402B",
		        fill: false
		      }, { 
		        data: [282,350,411,502,635,809,947,1402,3700,5267],
		        label: "Estoque",
		        borderColor: "#FF482C",
		        fill: false
		      }
		    ]
		  },
		  options: {
		    legend: {
            	labels: {
                	fontColor: "black",
            	}
        	},
		  }
		});
	</script>
	<script type="text/javascript">
		let tipo_produto = document.getElementById('tipo_produto').getContext('2d');
		
		let chart_prod = new Chart(tipo_produto, {
	    type: 'pie',
	    data: {
	      labels: ["Frutas", "Legumes", "Cereais"],
	      datasets: [{
	        backgroundColor: ["#248f24", "#0d3108","#336600"],
	        data: [2478,5267,734]
	      }]
	    },
	    options: {
	      legend: {
            labels: {
                fontColor: "black",
            }
        },
	   }
	});
	</script>
	
	
</body>
</html>