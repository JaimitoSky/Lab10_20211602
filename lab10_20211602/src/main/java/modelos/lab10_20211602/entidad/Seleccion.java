package modelos.lab10_20211602.entidad;

public class Seleccion {
    private int idSeleccion;
    private String nombre;
    private String tecnico;
    private int estadioId;

    public Seleccion(int idSeleccion, String nombre, String tecnico, int estadioId) {
        this.idSeleccion = idSeleccion;
        this.nombre = nombre;
        this.tecnico = tecnico;
        this.estadioId = estadioId;
    }

    public int getIdSeleccion() {
        return idSeleccion;
    }

    public void setIdSeleccion(int idSeleccion) {
        this.idSeleccion = idSeleccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTecnico() {
        return tecnico;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getEstadioId() {
        return estadioId;
    }

    public void setEstadioId(int estadioId) {
        this.estadioId = estadioId;
    }
}