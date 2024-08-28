package dominio;

import dominio.enums.Unidad;

import java.math.BigDecimal;

public class DetalleVenta {

    private int id;
    private int idVenta;
    private int idProducto;
    private String detalle;
    private Unidad unidad;
    private BigDecimal cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal precioPorCantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(int idVenta, int idProducto, String detalle, Unidad unidad, BigDecimal cantidad, BigDecimal precioUnitario, BigDecimal precioPorCantidad) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.detalle = detalle;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioPorCantidad = precioPorCantidad;
    }

    public DetalleVenta(int id, int idVenta, int idProducto, String detalle, Unidad unidad, BigDecimal cantidad, BigDecimal precioUnitario, BigDecimal precioPorCantidad) {
        this.id = id;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.detalle = detalle;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.precioPorCantidad = precioPorCantidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public BigDecimal getPrecioPorCantidad() {
        return precioPorCantidad;
    }

    public void setPrecioPorCantidad(BigDecimal precioPorCantidad) {
        this.precioPorCantidad = precioPorCantidad;
    }
}
