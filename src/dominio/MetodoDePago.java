package dominio;

public class MetodoDePago {

    private static int contador = 0;

    private int id;
    private String metodo;
    private boolean activo;

    public MetodoDePago() {
    }

    public MetodoDePago(String metodo, boolean activo) {
        this.id = contador++;
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

    @Override
    public String toString() {
        return "MetodoDePago{" +
                "id=" + id +
                ", metodo='" + metodo + '\'' +
                ", activo=" + activo +
                '}';
    }

}
