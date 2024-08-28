package dominio;

public class MetodoDePago {

    private int id;
    private String metodo;
    private boolean activo;

    public MetodoDePago() {
    }

    public MetodoDePago(String metodo, boolean activo) {
        this.metodo = metodo;
        this.activo = activo;
    }

    public MetodoDePago(int id, String metodo, boolean activo) {
        this.id = id;
        this.metodo = metodo;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


}
