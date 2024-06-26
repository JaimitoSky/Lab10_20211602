<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 26/06/2024
  Time: 04:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <style>
        body, html {
            height: 100%;
            margin: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            text-align: center;
        }
        .container {
            max-width: 800px;
        }
        .header {
            margin-bottom: 30px;
        }
        .content {
            padding: 20px;
            background-color: #f8f9fa;
            border-radius: 8px;
        }
        .btn-custom {
            margin: 10px;
        }
        .img-fluid {
            max-width: 50%;
            height: auto;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">

        <h1>¡Bienvenidos a la Gestión de Deportes!</h1>
        <img src="https://static.vecteezy.com/system/resources/previews/032/069/092/non_2x/soccer-player-dribbling-action-pose-character-cartoon-illustration-vector.jpg" class="img-fluid" alt="Sports Image">
    </div>
    <div class="content">
        <p>Un lugar donde se vive la pasión del futbol incluso afuera de la cancha !. Aquí podrás gestionar los jugadores y estadios sencillamente. ¡Nunca antes fue tan fácil ser un gestor deportivo!</p>
        <a class="btn btn-primary btn-custom" href="${pageContext.request.contextPath}/JugadorController?action=list">Gestionar Jugadores</a>
        <a class="btn btn-primary btn-custom" href="${pageContext.request.contextPath}/EstadioController?action=list">Gestionar Estadios</a>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
