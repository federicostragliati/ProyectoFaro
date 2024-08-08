package proyecto.faro.domain;

import java.math.BigDecimal;

public class DetalleCompra {

    private int id;
    private int idCompra;
    private int idProducto;
    private BigDecimal cantidad;
    private BigDecimal costoUnitario;

    private BigDecimal costoPorCantidad;

    public DetalleCompra(int id, int idCompra, int idProducto, BigDecimal cantidad, BigDecimal costoUnitario, BigDecimal costoPorCantidad) {
        this.id = id;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.costoPorCantidad = costoPorCantidad;
    }

    public DetalleCompra() {
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
}
