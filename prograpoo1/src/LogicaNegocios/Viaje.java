/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Javith
 */
public class Viaje {
    private static int cantSulicitudes=0;
    private String ID;
    private ArrayList<Pasajero> listaPasajeros = new ArrayList<>();
    
    private Date Solicitud;
    private Date inicioDate;
    private Date finDate;
    private Vehiculo vehiculo;
    private Chofer chofer;

    public Viaje(String ID, Date Solicitud, Date inicioDate, Date finDate, Vehiculo vehiculo, Chofer chofer, String estado) {
        this.ID = ID;
        this.Solicitud = Solicitud;
        this.inicioDate = inicioDate;
        this.finDate = finDate;
        this.vehiculo = vehiculo;
        this.chofer = chofer;
        this.estado = estado;
        cantSulicitudes++;
        this.ID = "VIA-"+cantSulicitudes;
    }
    private String estado;

   

    public String getID() {
        return ID;
        
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public ArrayList<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public void setListaPasajeros(ArrayList<Pasajero> listaPasajeros) {
        this.listaPasajeros = listaPasajeros;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getSolicitud() {
        return Solicitud;
    }

    public void setSolicitud(Date Solicitud) {
        this.Solicitud = Solicitud;
    }

    public Date getInicioDate() {
        return inicioDate;
    }

    public void setInicioDate(Date inicioDate) {
        this.inicioDate = inicioDate;
    }

    public Date getFinDate() {
        return finDate;
    }

    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }
    
}
