<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 26/06/2024
  Time: 03:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nuevo Estadio</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Nuevo Estadio</h2>
    <form action="${pageContext.request.contextPath}/EstadioController?action=insert" method="post">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="form-group">
            <label for="provincia">Provincia:</label>
            <input type="text" class="form-control" id="provincia" name="provincia" required>
        </div>
        <div class="form-group">
            <label for="club">Club:</label>
            <input type="text" class="form-control" id="club" name="club" required>
        </div>
        <button type="submit" class="btn btn-primary">Registrar</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/EstadioController?action=list">Cancelar</a>
    </form>
</div>
</body>
</html>

