/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
import java.util.Date;
/**
 *
 * @author curso
 */
public class Mantenimiento {
    private String idServicio;
    private Date fechaInicio;
    private Date fechaFin;
    private double montoPagado;
    private String detalle;
    private int tipoServicio;
    private Empresa empresa;
    private static int cantMantenimiento;

    public String getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(String idServicio) {
        this.idServicio = idServicio;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public double getMontoPagado() {
        return montoPagado;
    }

    public void setMontoPagado(double montoPagado) {
        this.montoPagado = montoPagado;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(int tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public static int getCantMantenimiento() {
        return cantMantenimiento;
    }

    public static void setCantMantenimiento(int cantMantenimiento) {
        Mantenimiento.cantMantenimiento = cantMantenimiento;
    }

    public Mantenimiento(String idServicio, double montoPagado, String detalle, int tipoServicio, Empresa empresa) {
        Calendar calendario;
        calendario = Calendar.getInstance();
        
        this.idServicio = idServicio;
        this.fechaInicio = calendario.getTime();
        this.montoPagado = montoPagado;
        this.detalle = detalle;
        this.tipoServicio = tipoServicio;
        this.empresa = empresa;
    }
    
    
}
