<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 25/06/2024
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="modelos.lab10_20211602.entidad.Jugador" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Lista Jugadores</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h2>Lista Jugadores</h2>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/HomeController">Regresar al Home</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/JugadorController?action=new">Nuevo Jugador</a>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Edad</th>
            <th>Posición</th>
            <th>Club</th>
            <th>Selección</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Jugador> listJugadores = (List<Jugador>) request.getAttribute("listJugadores");
            for (int i = 0; i < listJugadores.size(); i++) {
                Jugador jugador = listJugadores.get(i);
        %>
        <tr>
            <td><%= jugador.getIdJugador() %></td>
            <td><%= jugador.getNombre() != null ? jugador.getNombre() : "No disponible" %></td>
            <td><%= jugador.getEdad() != 0 ? jugador.getEdad() : "No disponible" %></td>
            <td><%= jugador.getPosicion() != null ? jugador.getPosicion() : "No disponible" %></td>
            <td><%= jugador.getClub() != null ? jugador.getClub() : "Jugador no tiene un club" %></td>
            <td><%= jugador.getNombreSeleccion() != null ? jugador.getNombreSeleccion() : "No disponible" %></td>
            <td>
                <form action="${pageContext.request.contextPath}/JugadorController" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= jugador.getIdJugador() %>">
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirmDeleteModal" data-id="<%= jugador.getIdJugador() %>">Borrar</button>
                </form>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<!-- Modal -->
<div class="modal fade" id="confirmDeleteModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirmar Eliminación</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                ¿Está seguro de que desea eliminar este jugador?
            </div>
            <div class="modal-footer">
                <form id="deleteForm" action="${pageContext.request.contextPath}/JugadorController" method="post">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" id="deleteId">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-danger">Borrar</button>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script>
    $('#confirmDeleteModal').on('show.bs.modal', function (event) {
        var button = $(event.relatedTarget);
        var id = button.data('id');
        var modal = $(this);
        modal.find('#deleteId').val(id);
    });
</script>
</body>
</html>
