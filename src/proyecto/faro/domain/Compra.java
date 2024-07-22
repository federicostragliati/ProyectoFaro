package proyecto.faro.domain;

import java.math.BigDecimal;

public class Compra {

    private int id;
    private int idProveedor;
    private int cuitProveedor;
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

    public Compra(int id, int idProveedor, int cuitProveedor, int metodoDePagoPrimario, BigDecimal montoDePagoPrimario, int metodoDePagoSecundario, BigDecimal montoDePagoSecundario, BigDecimal montoFinal, boolean pagada, boolean entregada, boolean activo) {
        this.id = id;
        this.idProveedor = idProveedor;
        this.cuitProveedor = cuitProveedor;
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

    public int getCuitProveedor() {
        return cuitProveedor;
    }

    public void setCuitProveedor(int cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
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
