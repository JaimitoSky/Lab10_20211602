package modelos.lab10_20211602.controlador;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelos.lab10_20211602.entidad.Estadio;
import modelos.lab10_20211602.repositorio.EstadioRepository;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EstadioController", value = "/EstadioController")
public class EstadioController extends HttpServlet {
    private EstadioRepository estadioRepository = new EstadioRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "list":
                listEstadios(request, response);
                break;
            case "delete":
                try {
                    deleteEstadio(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
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
                    insertEstadio(request, response);
                } catch (SQLException e) {
                    throw new ServletException(e);
                }
                break;
            default:
                doGet(request, response);
                break;
        }
    }

    private void listEstadios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Estadio> listEstadios = estadioRepository.selectAllEstadios();
        request.setAttribute("listEstadios", listEstadios);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/estadio/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/estadio/newForm.jsp");
        dispatcher.forward(request, response);
    }

    private void insertEstadio(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        String nombre = request.getParameter("nombre");
        String provincia = request.getParameter("provincia");
        String club = request.getParameter("club");

        Estadio newEstadio = new Estadio(0, nombre, provincia, club);
        estadioRepository.insertEstadio(newEstadio);
        response.sendRedirect(request.getContextPath() + "/EstadioController?action=list");
    }

    private void deleteEstadio(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        estadioRepository.deleteEstadio(id);
        response.sendRedirect(request.getContextPath() + "/EstadioController?action=list");
    }
}