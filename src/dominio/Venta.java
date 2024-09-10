package dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Venta {

    private int id;
    private int IdCliente;
    private String CuitCliente;
    private Date fechaVenta;
    private int descuentos;
    private int metodoDePagoPrimario;
    private BigDecimal montoDePagoPrimario;
    private int metodoDePagoSecundario;
    private BigDecimal montoDePagoSecundario;
    private BigDecimal montoFinal;
    private boolean pagada;
    private boolean entregada;
    private boolean activo;

    public Venta() {
    }

    public Venta(int idCliente, String cuitCliente, Date fechaVenta, int descuentos, int metodoDePagoPrimario, BigDecimal montoDePagoPrimario, int metodoDePagoSecundario, BigDecimal montoDePagoSecundario, BigDecimal montoFinal, boolean pagada, boolean entregada, boolean activo) {
        IdCliente = idCliente;
        CuitCliente = cuitCliente;
        this.fechaVenta = fechaVenta;
        this.descuentos = descuentos;
        this.metodoDePagoPrimario = metodoDePagoPrimario;
        this.montoDePagoPrimario = montoDePagoPrimario;
        this.metodoDePagoSecundario = metodoDePagoSecundario;
        this.montoDePagoSecundario = montoDePagoSecundario;
        this.pagada = pagada;
        this.entregada = entregada;
        this.montoFinal = montoFinal;
        this.activo = activo;
    }

    public Venta(int id, int idCliente, String cuitCliente, Date fechaVenta, int descuentos, int metodoDePagoPrimario, BigDecimal montoDePagoPrimario, int metodoDePagoSecundario, BigDecimal montoDePagoSecundario, BigDecimal montoFinal, boolean pagada, boolean entregada, boolean activo) {
        this.id = id;
        IdCliente = idCliente;
        CuitCliente = cuitCliente;
        this.fechaVenta = fechaVenta;
        this.descuentos = descuentos;
        this.metodoDePagoPrimario = metodoDePagoPrimario;
        this.montoDePagoPrimario = montoDePagoPrimario;
        this.metodoDePagoSecundario = metodoDePagoSecundario;
        this.montoDePagoSecundario = montoDePagoSecundario;
        this.pagada = pagada;
        this.entregada = entregada;
        this.montoFinal = montoFinal;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int idCliente) {
        IdCliente = idCliente;
    }

    public String getCuitCliente() {
        return CuitCliente;
    }

    public void setCuitCliente(String cuitCliente) {
        CuitCliente = cuitCliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(int descuentos) {
        this.descuentos = descuentos;
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

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public boolean isEntregada() {
        return entregada;
    }

    public void setEntregada(boolean entregada) {
        this.entregada = entregada;
    }

    public BigDecimal getMontoFinal() {
        return montoFinal;
    }

    public void setMontoFinal(BigDecimal montoFinal) {
        this.montoFinal = montoFinal;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
