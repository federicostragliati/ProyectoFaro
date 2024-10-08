package dominio;

import java.math.BigDecimal;
import java.util.Date;

public class Compra {

    private int id;
    private int idProveedor;
    private String cuitProveedor;
    private Date fechaCompra;
    private int metodoDePagoPrimario;
    private BigDecimal montoDePagoPrimario;
    private int metodoDePagoSecundario;
    private BigDecimal montoDePagoSecundario;
    private BigDecimal montoFinal;
    private boolean pagada;
    private boolean entregada;
    private boolean activo;

    public Compra() {
    }

    public Compra(int idProveedor, String cuitProveedor, Date fechaCompra, int metodoDePagoPrimario, BigDecimal montoDePagoPrimario, int metodoDePagoSecundario, BigDecimal montoDePagoSecundario, BigDecimal montoFinal, boolean pagada, boolean entregada, boolean activo) {
        this.idProveedor = idProveedor;
        this.cuitProveedor = cuitProveedor;
        this.fechaCompra = fechaCompra;
        this.metodoDePagoPrimario = metodoDePagoPrimario;
        this.montoDePagoPrimario = montoDePagoPrimario;
        this.metodoDePagoSecundario = metodoDePagoSecundario;
        this.montoDePagoSecundario = montoDePagoSecundario;
        this.montoFinal = montoFinal;
        this.pagada = pagada;
        this.entregada = entregada;
        this.activo = activo;
    }

    public Compra(int id, int idProveedor, String cuitProveedor, Date fechaCompra, int metodoDePagoPrimario, BigDecimal montoDePagoPrimario, int metodoDePagoSecundario, BigDecimal montoDePagoSecundario, BigDecimal montoFinal, boolean pagada, boolean entregada, boolean activo) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.cuitProveedor = cuitProveedor;
        this.fechaCompra = fechaCompra;
        this.metodoDePagoPrimario = metodoDePagoPrimario;
        this.montoDePagoPrimario = montoDePagoPrimario;
        this.metodoDePagoSecundario = metodoDePagoSecundario;
        this.montoDePagoSecundario = montoDePagoSecundario;
        this.montoFinal = montoFinal;
        this.pagada = pagada;
        this.entregada = entregada;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(String cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
