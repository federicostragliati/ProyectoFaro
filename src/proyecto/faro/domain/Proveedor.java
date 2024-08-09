package proyecto.faro.domain;

public class Proveedor {

    private int id;
    private String cuit;

    private String razonSocial;
    private String email;

    private String telefono;
    private String direccion;
    private boolean activo;

    public Proveedor() {
    }

    public Proveedor(int id, String cuit, String razonSocial, String email, String telefono, String direccion, boolean activo) {
        this.id = id;
        this.cuit = cuit;
        this.razonSocial = razonSocial;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
