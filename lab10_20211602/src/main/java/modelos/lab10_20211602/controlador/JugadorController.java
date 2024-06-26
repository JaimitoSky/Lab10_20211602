package modelos.lab10_20211602.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.lab10_20211602.entidad.Jugador;
import modelos.lab10_20211602.entidad.Seleccion;
import modelos.lab10_20211602.repositorio.JugadorRepository;
import modelos.lab10_20211602.repositorio.SeleccionRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "JugadorController", value = "/JugadorController")
public class JugadorController extends HttpServlet {
    private JugadorRepository jugadorRepository= new JugadorRepository();
    private SeleccionRepository seleccionRepository = new SeleccionRepository();
    @Override


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";  // Default action
        }
        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "list":
                listJugadores(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            doGet(request, response);
            return;
        }
        switch (action) {
            case "insert":
                try {
                    insertJugador(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;
            case "delete":
                try {
                    deleteJugador(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;
            default:
                doGet(request, response);
                break;
        }

    }

    private void listJugadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Jugador> listJugadores = jugadorRepository.selectAllJugadores();

        request.setAttribute("listJugadores", listJugadores);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jugador/list.jsp");
        dispatcher.forward(request, response);
    }
    private void deleteJugador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        jugadorRepository.deleteJugador(id);
        response.sendRedirect(request.getContextPath() + "/JugadorController?action=list");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Seleccion> listSelecciones = seleccionRepository.selectAllSelecciones();
        request.setAttribute("listSelecciones", listSelecciones);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jugador/newForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertJugador(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String posicion = request.getParameter("posicion");
        String club = request.getParameter("club");
        int sn_idSeleccion = Integer.parseInt(request.getParameter("sn_idSeleccion"));



        Jugador newJugador = new Jugador(0, nombre, edad, posicion, club, sn_idSeleccion, null);
        jugadorRepository.insertJugador(newJugador);
        response.sendRedirect(request.getContextPath() + "/JugadorController?action=list");
    }


}