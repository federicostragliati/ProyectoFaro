package proyecto.faro.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Cheque {

    private int id;
    private int idTransaccion;
    private Date fechaRecepcion;
    private int cuitEmisor;
    private String nombreEmisor;
    private String bancoProcedencia;
    private int nroCheque;
    private BigDecimal  importe;
    private Date fechaCheque;
    private Date fechaCobro;

    private Destino destino;
    private int cuitDestino;
    private boolean estado;
    private boolean activo; // verificar contra diseño de BBDD

    public Cheque() {
    }

    public Cheque(int id, int idTransaccion, Date fechaRecepcion, int cuitEmisor, String nombreEmisor, String bancoProcedencia, int nroCheque, BigDecimal importe, Date fechaCheque, Date fechaCobro, Destino destino, int cuitDestino, boolean estado, boolean activo) {
        this.id = id;
        this.idTransaccion = idTransaccion;
        this.fechaRecepcion = fechaRecepcion;
        this.cuitEmisor = cuitEmisor;
        this.nombreEmisor = nombreEmisor;
        this.bancoProcedencia = bancoProcedencia;
        this.nroCheque = nroCheque;
        this.importe = importe;
        this.fechaCheque = fechaCheque;
        this.fechaCobro = fechaCobro;
        this.destino = destino;
        this.cuitDestino = cuitDestino;
        this.estado = estado;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(int idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFechaRecepcion() {
        return fechaRecepcion;
    }

    public void setFechaRecepcion(Date fechaRecepcion) {
        this.fechaRecepcion = fechaRecepcion;
    }

    public int getCuitEmisor() {
        return cuitEmisor;
    }

    public void setCuitEmisor(int cuitEmisor) {
        this.cuitEmisor = cuitEmisor;
    }

    public String getNombreEmisor() {
        return nombreEmisor;
    }

    public void setNombreEmisor(String nombreEmisor) {
        this.nombreEmisor = nombreEmisor;
    }

    public String getBancoProcedencia() {
        return bancoProcedencia;
    }

    public void setBancoProcedencia(String bancoProcedencia) {
        this.bancoProcedencia = bancoProcedencia;
    }

    public int getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(int nroCheque) {
        this.nroCheque = nroCheque;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Date getFechaCheque() {
        return fechaCheque;
    }

    public void setFechaCheque(Date fechaCheque) {
        this.fechaCheque = fechaCheque;
    }

    public Date getFechaCobro() {
        return fechaCobro;
    }

    public void setFechaCobro(Date fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }

    public int getCuitDestino() {
        return cuitDestino;
    }

    public void setCuitDestino(int cuitDestino) {
        this.cuitDestino = cuitDestino;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
