package proyecto.faro.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Remito {

    private int id;
    private int linea;
    private int idVenta;
    private Date fechaEntrega;
    private int idCliente;
    private String nombreCliente;

    private int cuitCliente;
    private int nroFactura;
    private int idProducto;
    private int detalleProducto;
    private BigDecimal cantidadProducto;

    public Remito() {
    }

    public Remito(int id, int linea, int idVenta, Date fechaEntrega, int idCliente, String nombreCliente, int cuitCliente, int nroFactura, int idProducto, int detalleProducto, BigDecimal cantidadProducto) {
        this.id = id;
        this.linea = linea;
        this.idVenta = idVenta;
        this.fechaEntrega = fechaEntrega;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.cuitCliente = cuitCliente;
        this.nroFactura = nroFactura;
        this.idProducto = idProducto;
        this.detalleProducto = detalleProducto;
        this.cantidadProducto = cantidadProducto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(int cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(int detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public BigDecimal getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigDecimal cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
}
