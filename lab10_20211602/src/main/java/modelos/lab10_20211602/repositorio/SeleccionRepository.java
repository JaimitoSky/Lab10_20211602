package modelos.lab10_20211602.repositorio;

import modelos.lab10_20211602.entidad.Seleccion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeleccionRepository extends BaseRepository {
    public List<Seleccion> selectAllSelecciones() {
        List<Seleccion> selecciones = new ArrayList<>();
        String sql = "SELECT * FROM seleccion";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idSeleccion");
                String nombre = rs.getString("nombre");
                String tecnico = rs.getString("tecnico");
                int estadio_idEstadio = rs.getInt("estadio_idEstadio");

                Seleccion seleccion = new Seleccion(id, nombre, tecnico, estadio_idEstadio);
                selecciones.add(seleccion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return selecciones;
    }
}

