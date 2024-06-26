<%--
  Created by IntelliJ IDEA.
  User: jaimi
  Date: 26/06/2024
  Time: 03:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="modelos.lab10_20211602.entidad.Estadio" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Lista Estadios</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Lista Estadios</h2>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/HomeController">Regresar al Home</a>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/EstadioController?action=new">Nuevo Estadio</a>
    <table class="table table-striped">
    <table class="table table-striped">
        <thead>
        <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Provincia</th>
            <th>Club</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Estadio> listEstadios = (List<Estadio>) request.getAttribute("listEstadios");
            for (int i = 0; i < listEstadios.size(); i++) {
                Estadio estadio = listEstadios.get(i);
        %>
        <tr>
            <td><%= estadio.getIdEstadio() %></td>
            <td><%= estadio.getNombre() != null ? estadio.getNombre() : "No disponible" %></td>
            <td><%= estadio.getProvincia() != null ? estadio.getProvincia() : "No disponible" %></td>
            <td><%= estadio.getClub() != null ? estadio.getClub() : "No tiene propietario" %></td>
            <td>
                <form action="${pageContext.request.contextPath}/EstadioController" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= estadio.getIdEstadio() %>">
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#confirmDeleteModal" data-id="<%= estadio.getIdEstadio() %>">Borrar</button>
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
                ¿Está seguro de que desea eliminar este estadio?
            </div>
            <div class="modal-footer">
                <form id="deleteForm" action="${pageContext.request.contextPath}/EstadioController" method="post">
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

