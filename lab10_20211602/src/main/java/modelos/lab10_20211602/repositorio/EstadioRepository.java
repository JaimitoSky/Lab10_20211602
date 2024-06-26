package modelos.lab10_20211602.repositorio;

import modelos.lab10_20211602.entidad.Estadio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstadioRepository extends BaseRepository {
    public List<Estadio> selectAllEstadios() {
        List<Estadio> estadios = new ArrayList<>();
        String sql = "SELECT * FROM estadio";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idEstadio");
                String nombre = rs.getString("nombre");
                String provincia = rs.getString("provincia");
                String club = rs.getString("club");
                estadios.add(new Estadio(id, nombre, provincia, club));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estadios;
    }

    public void insertEstadio(Estadio estadio) throws SQLException {
        String sql = "INSERT INTO estadio (nombre, provincia, club) VALUES (?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, estadio.getNombre());
            preparedStatement.setString(2, estadio.getProvincia());
            preparedStatement.setString(3, estadio.getClub());
            preparedStatement.executeUpdate();
        }
    }

    public void deleteEstadio(int id) throws SQLException {
        String sql = "DELETE FROM estadio WHERE idEstadio = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
