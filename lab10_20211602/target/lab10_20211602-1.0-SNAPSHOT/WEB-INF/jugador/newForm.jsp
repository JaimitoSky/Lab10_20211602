<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 25/06/2024
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="modelos.lab10_20211602.entidad.Seleccion" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Nuevo Jugador</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Nuevo Jugador</h2>
    <form action="${pageContext.request.contextPath}/JugadorController?action=insert" method="post">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="form-group">
            <label for="edad">Edad:</label>
            <input type="number" class="form-control" id="edad" name="edad" required>
        </div>
        <div class="form-group">
            <label for="posicion">Posición:</label>
            <input type="text" class="form-control" id="posicion" name="posicion" required>
        </div>
        <div class="form-group">
            <label for="club">Club:</label>
            <input type="text" class="form-control" id="club" name="club" required>
        </div>
        <div class="form-group">
            <label for="sn_idSeleccion">Selección Nacional:</label>
            <select class="form-control" id="sn_idSeleccion" name="sn_idSeleccion" required>
                <%
                    List<Seleccion> listSelecciones = (List<Seleccion>) request.getAttribute("listSelecciones");
                    for (int i = 0; i < listSelecciones.size(); i++) {
                        Seleccion seleccion = listSelecciones.get(i);
                %>
                <option value="<%= seleccion.getIdSeleccion() %>"><%= seleccion.getNombre() %></option>
                <% } %>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Registrar</button>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/JugadorController?action=list">Cancelar</a>
    </form>
</div>
</body>
</html>
