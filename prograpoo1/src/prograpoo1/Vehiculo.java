/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograpoo1;

import java.util.ArrayList;

/**
 *
 * @author Javith
 */
public class Vehiculo {
    private String placa;
    private int agnoFabricacion;
    private String color;
    private String marca;
    private int capacidad;
    private double kilometraje;
    private String vin;
    private String sede;
    private int estado;
    private ArrayList<Mantenimiento> historialMantenimiento;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAgnoFabricacion() {
        return agnoFabricacion;
    }

    public void setAgnoFabricacion(int agnoFabricacion) {
        this.agnoFabricacion = agnoFabricacion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Mantenimiento> getHistorialMantenimiento() {
        return historialMantenimiento;
    }

    public void setHistorialMantenimiento(ArrayList<Mantenimiento> historialMantenimiento) {
        this.historialMantenimiento = historialMantenimiento;
    }
    public void enviarMantenimiento(){
        
    
    }
    public void finalizarMantenimiento(){
    
    }
}
