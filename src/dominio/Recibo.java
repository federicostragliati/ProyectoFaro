package dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Recibo {

    private static int contador = 0;

    private int id;
    private int idVenta;
    private Date fechaRecibo;
    private int idCliente;
    private String nombreCliente;
    private String cuitCliente;

    private String textoDineroRecibido;
    private BigDecimal nroDineroRecibido;

    private Date fechaPago;
    private String factura;
    private int metodoDePagoPrimario;
    private BigDecimal montoDePagoPrimario;

    private int metodoDePagoSecundario;
    private BigDecimal montoDePagoSecundario;

    private BigDecimal montoFinal;

    public Recibo() {
    }

    public Recibo(int idVenta, Date fechaRecibo, int idCliente, String nombreCliente, String cuitCliente, String textoDineroRecibido, BigDecimal nroDineroRecibido, Date fechaPago, String factura, int metodoDePagoPrimario, BigDecimal montoDePagoPrimario, int metodoDePagoSecundario, BigDecimal montoDePagoSecundario, BigDecimal montoFinal) {
        this.id = contador++;
        this.idVenta = idVenta;
        this.fechaRecibo = fechaRecibo;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.cuitCliente = cuitCliente;
        this.textoDineroRecibido = textoDineroRecibido;
        this.nroDineroRecibido = nroDineroRecibido;
        this.fechaPago = fechaPago;
        this.factura = factura;
        this.metodoDePagoPrimario = metodoDePagoPrimario;
        this.montoDePagoPrimario = montoDePagoPrimario;
        this.metodoDePagoSecundario = metodoDePagoSecundario;
        this.montoDePagoSecundario = montoDePagoSecundario;
        this.montoFinal = montoFinal;
    }

    public Recibo(int id, int idVenta, Date fechaRecibo, int idCliente, String nombreCliente, String cuitCliente, String textoDineroRecibido, BigDecimal nroDineroRecibido, Date fechaPago, String factura, int metodoDePagoPrimario, BigDecimal montoDePagoPrimario, int metodoDePagoSecundario, BigDecimal montoDePagoSecundario, BigDecimal montoFinal) {
        this.id = id;
        this.idVenta = idVenta;
        this.fechaRecibo = fechaRecibo;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.cuitCliente = cuitCliente;
        this.textoDineroRecibido = textoDineroRecibido;
        this.nroDineroRecibido = nroDineroRecibido;
        this.fechaPago = fechaPago;
        this.factura = factura;
        this.metodoDePagoPrimario = metodoDePagoPrimario;
        this.montoDePagoPrimario = montoDePagoPrimario;
        this.metodoDePagoSecundario = metodoDePagoSecundario;
        this.montoDePagoSecundario = montoDePagoSecundario;
        this.montoFinal = montoFinal;
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

    public Date getFechaRecibo() {
        return fechaRecibo;
    }

    public void setFechaRecibo(Date fechaRecibo) {
        this.fechaRecibo = fechaRecibo;
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

    public String getTextoDineroRecibido() {
        return textoDineroRecibido;
    }

    public void setTextoDineroRecibido(String textoDineroRecibido) {
        this.textoDineroRecibido = textoDineroRecibido;
    }

    public BigDecimal getNroDineroRecibido() {
        return nroDineroRecibido;
    }

    public void setNroDineroRecibido(BigDecimal nroDineroRecibido) {
        this.nroDineroRecibido = nroDineroRecibido;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public int getMetodoDePagoPrimario() {
        return metodoDePagoPrimario;
    }

    public void setMetodoDePagoPrimario(int metodoDePagoPrimario) {
        this.metodoDePagoPrimario = metodoDePagoPrimario;
    }

    public BigDecimal getMontoDePagoPrimario() {
        return montoDePagoPrimario;
    }

    public void setMontoDePagoPrimario(BigDecimal montoDePagoPrimario) {
        this.montoDePagoPrimario = montoDePagoPrimario;
    }

    public int getMetodoDePagoSecundario() {
        return metodoDePagoSecundario;
    }

    public void setMetodoDePagoSecundario(int metodoDePagoSecundario) {
        this.metodoDePagoSecundario = metodoDePagoSecundario;
    }

    public BigDecimal getMontoDePagoSecundario() {
        return montoDePagoSecundario;
    }

    public void setMontoDePagoSecundario(BigDecimal montoDePagoSecundario) {
        this.montoDePagoSecundario = montoDePagoSecundario;
    }

    public BigDecimal getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(BigDecimal montoFinal) {
        this.montoFinal = montoFinal;
    }
}
