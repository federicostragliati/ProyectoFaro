package dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Remito {

    private static int contador = 0;

    private int id;
    private int linea;
    private int idVenta;
    private Date fechaEntrega;
    private int idCliente;
    private String nombreCliente;

    private String cuitCliente;
    private String nroFactura;
    private int idProducto;
    private String detalleProducto;
    private BigDecimal cantidadProducto;

    public Remito() {
    }

    public Remito(int linea, int idVenta, Date fechaEntrega, int idCliente, String nombreCliente, String cuitCliente, String nroFactura, int idProducto, String detalleProducto, BigDecimal cantidadProducto) {
        this.id = contador++;
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

    public Remito(int id, int linea, int idVenta, Date fechaEntrega, int idCliente, String nombreCliente, String cuitCliente, String nroFactura, int idProducto, String detalleProducto, BigDecimal cantidadProducto) {
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

    public String getCuitCliente() {
        return cuitCliente;
    }

    public void setCuitCliente(String cuitCliente) {
        this.cuitCliente = cuitCliente;
    }

    public String getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(String nroFactura) {
        this.nroFactura = nroFactura;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDetalleProducto() {
        return detalleProducto;
    }

    public void setDetalleProducto(String detalleProducto) {
        this.detalleProducto = detalleProducto;
    }

    public BigDecimal getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(BigDecimal cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    @Override
    public String toString() {
        return "Remito{" +
                "id=" + id +
                ", linea=" + linea +
                ", idVenta=" + idVenta +
                ", fechaEntrega=" + fechaEntrega +
                ", idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", cuitCliente='" + cuitCliente + '\'' +
                ", nroFactura='" + nroFactura + '\'' +
                ", idProducto=" + idProducto +
                ", detalleProducto='" + detalleProducto + '\'' +
                ", cantidadProducto=" + cantidadProducto +
                '}';
    }
}
