package dominio;

import dominio.enums.Destino;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cheque {

    private static int contador = 0;

    private int id;
    private int idTransaccion;
    private Date fechaRecepcion;
    private String cuitEmisor;
    private String nombreEmisor;
    private String bancoProcedencia;
    private String nroCheque;
    private BigDecimal  importe;
    private Date fechaCheque;
    private Date fechaCobro;

    private Destino destino;
    private String cuitDestino;
    private boolean estado;
    private boolean activo; // verificar contra diseño de BBDD

    public Cheque() {
        this.id = contador++;
    }

    public Cheque(int idTransaccion, Date fechaRecepcion, String cuitEmisor, String nombreEmisor, String bancoProcedencia, String nroCheque, BigDecimal importe, Date fechaCheque, Date fechaCobro, Destino destino, String cuitDestino, boolean estado, boolean activo) {
        this.id = contador++;
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

    public Cheque(int id, int idTransaccion, Date fechaRecepcion, String cuitEmisor, String nombreEmisor, String bancoProcedencia, String nroCheque, BigDecimal importe, Date fechaCheque, Date fechaCobro, Destino destino, String cuitDestino, boolean estado, boolean activo) {
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

    public String getCuitEmisor() {
        return cuitEmisor;
    }

    public void setCuitEmisor(String cuitEmisor) {
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

    public String getNroCheque() {
        return nroCheque;
    }

    public void setNroCheque(String nroCheque) {
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

    public String getCuitDestino() {
        return cuitDestino;
    }

    public void setCuitDestino(String cuitDestino) {
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

    @Override
    public String toString() {
        return "Cheque{" +
                "id=" + id +
                ", idTransaccion=" + idTransaccion +
                ", fechaRecepcion=" + fechaRecepcion +
                ", cuitEmisor='" + cuitEmisor + '\'' +
                ", nombreEmisor='" + nombreEmisor + '\'' +
                ", bancoProcedencia='" + bancoProcedencia + '\'' +
                ", nroCheque='" + nroCheque + '\'' +
                ", importe=" + importe +
                ", fechaCheque=" + fechaCheque +
                ", fechaCobro=" + fechaCobro +
                ", destino=" + destino +
                ", cuitDestino='" + cuitDestino + '\'' +
                ", estado=" + estado +
                ", activo=" + activo +
                '}';
    }
}
