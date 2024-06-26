package modelos.lab10_20211602.entidad;

public class Estadio {
    private int idEstadio;
    private String nombre;
    private String provincia;
    private String club;

    public Estadio(int idEstadio, String nombre, String provincia, String club) {
        this.idEstadio = idEstadio;
        this.nombre = nombre;
        this.provincia = provincia;
        this.club = club;
    }

    public int getIdEstadio() {
        return idEstadio;
    }

    public void setIdEstadio(int idEstadio) {
        this.idEstadio = idEstadio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }
}