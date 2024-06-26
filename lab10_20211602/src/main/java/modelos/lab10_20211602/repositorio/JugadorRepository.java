package modelos.lab10_20211602.repositorio;

import modelos.lab10_20211602.entidad.Jugador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JugadorRepository extends BaseRepository {

    public List<Jugador> selectAllJugadores() {
        List<Jugador> jugadores = new ArrayList<>();
        String sql = "SELECT j.idJugador, j.nombre, j.edad, j.posicion, j.club, j.sn_idSeleccion, s.nombre AS nombreSeleccion FROM jugador j JOIN seleccion s ON j.sn_idSeleccion = s.idSeleccion";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("idJugador");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                String posicion = rs.getString("posicion");
                String club = rs.getString("club");
                int sn_idSeleccion = rs.getInt("sn_idSeleccion");
                String nombreSeleccion = rs.getString("nombreSeleccion");

                Jugador jugador = new Jugador(id, nombre, edad, posicion, club, sn_idSeleccion, nombreSeleccion);
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugadores;
    }

    public void insertJugador(Jugador jugador) throws SQLException {
        String sql = "INSERT INTO jugador (nombre, edad, posicion, club, sn_idSeleccion) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, jugador.getNombre());
            preparedStatement.setInt(2, jugador.getEdad());
            preparedStatement.setString(3, jugador.getPosicion());
            preparedStatement.setString(4, jugador.getClub());
            preparedStatement.setInt(5, jugador.getSn_idSeleccion());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteJugador(int id) throws SQLException {
        String sql = "DELETE FROM jugador WHERE idJugador = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }
    }

}
