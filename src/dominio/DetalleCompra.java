package dominio;

import java.math.BigDecimal;

public class DetalleCompra {

    private static int contador = 0;

    private int id;
    private int idCompra;
    private int idProducto;

    private String detalle;
    private BigDecimal cantidad;
    private BigDecimal costoUnitario;

    private BigDecimal costoPorCantidad;

    public DetalleCompra() {
    }

    public DetalleCompra(int idCompra, int idProducto, String detalle, BigDecimal cantidad, BigDecimal costoUnitario, BigDecimal costoPorCantidad) {
        this.id = contador++;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoPorCantidad = costoPorCantidad;
    }

    public DetalleCompra(int id, int idCompra, int idProducto, String detalle, BigDecimal cantidad, BigDecimal costoUnitario, BigDecimal costoPorCantidad) {
        this.id = id;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoPorCantidad = costoPorCantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public BigDecimal getCostoPorCantidad() {
        return costoPorCantidad;
    }

    public void setCostoPorCantidad(BigDecimal costoPorCantidad) {
        this.costoPorCantidad = costoPorCantidad;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" +
                "id=" + id +
                ", idCompra=" + idCompra +
                ", idProducto=" + idProducto +
                ", detalle='" + detalle + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                ", costoPorCantidad=" + costoPorCantidad +
                '}';
    }
}