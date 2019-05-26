<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(session.getAttribute("message") != null) {
		out.print(session.getAttribute("message"));
	} 
%>
<% 
	response.setHeader("Cache-control", "no-cache, no-store");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "-1");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="resource/css/bootstrap.min.css">
	<title>Hortifrut</title>
	<style>
		body {
			background-image: linear-gradient(to bottom right, #669900, #336600, #339933);
			background-repeat: no-repeat;
			background-size: contain, cover;
			padding-bottom: 20%;
			overflow-y: hidden;
		}
		.lg-style {
		  width: 43%;
		  background-color: #336600;
		  border: 1px solid #086f08;	
		  padding:5px ,5px, 5px, 5px;
		  border-radius: 3px;
		  margin-top: 10%;
		  color:#FFFFFF;
		  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.62), 0 1px 11px 0 rgba(0, 0, 0, 0.67);
		}
		
		.form-style {
			padding: 25px;
		}
		
		.login-input-style {
			width:400px;
			border-radius: 0.10rem;
		}
		
		.label-admin {
			margin-bottom: 40px;
			text-shadow: 2px 2px 2px #000000;
		}
		
		.label-email {
			text-shadow: 1px 1px 2px black, 0 0 4px #101011, 0 0 5px darkblue;
		}
		
		.label-senha {
			text-shadow: 1px 1px 2px black, 0 0 4px #101011, 0 0 5px darkblue;
		}
		
		.widget_title_bar {
		    width: 299px;
			height: 3px;
			background-color: #07480599;
			margin-top: -35px;
			margin-bottom: 28px;
			margin-left: 51px;
			border: 1px solid #07480599;
		}
		
		.btn-enter {
			border-radius: 5px;
			border: 2px solid #1a4816;
			padding: 5px;
			width: 100%;
			height: 40px;
			background: #32471e;
			color: #FFFFFF;
			font-size: 16px;
			font-weight: bold;
			margin-top: 10px;
		}
		
		.alert-danger {
    		color: #f3f3f3;
    		background-color: #95000d;
    		border-color: #322325;
    		border-radius: 0px;
		}
		
		.alert-warning {
			color: #f3f3f3;
    		background-color: #ff9933;
    		border-color: #322325;
    		border-radius: 0px;
		}
		
		
		
	</style>
</head>
<body>
	<div class="container lg-style d-flex justify-content-center">
		
		<form action="LoginServlet" method="post" class="form-style">
			
		 <h2 class="label-admin d-flex justify-content-center">Painel Administrativo</h2>
		 <div class="widget_title_bar"></div>
			
		  <div class="form-group">
		    <label class="label-email" for="email">Email:</label>
		    <input type="email" class="form-control login-input-style" name="email" placeholder="Digite seu e-mail">
		  </div>
		  <div class="form-group">
		    <label class="label-senha" for="senha">Senha:</label>
		    <input type="password" class="form-control login-input-style" name="senha" placeholder="Digite sua senha">
		  </div>
		  <button type="submit" class="btn btn-enter">Entrar</button>
		</form>
	</div>
	
	<!-- jQuery library -->
	<script src="resource/js/jquery-3.3.1.min.js"></script>
	<!-- BootStrap JS library -->
	<script src="resource/js/bootstrap.min.js"></script>
</body>
</html>