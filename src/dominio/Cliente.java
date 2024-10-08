package dominio;

public class Cliente {

    private int id;
    private String cuitCliente;
    private String nombre;
    private String email;
    private String telefono;
    private boolean activo;

    public Cliente() {
    }

    public Cliente( String cuitCliente, String nombre, String email, String telefono, boolean activo) {
        this.cuitCliente = cuitCliente;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
    }

    public Cliente(int id, String cuitCliente, String nombre, String email, String telefono, boolean activo) {
        this.id = id;
        this.cuitCliente = cuitCliente;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(String cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return cuitCliente + " - " + nombre;
    }
}
