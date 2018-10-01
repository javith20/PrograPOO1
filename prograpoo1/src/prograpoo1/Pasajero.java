/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograpoo1;

/**
 *
 * @author Javith
 */
public class Pasajero {
    private final String nombre;
    private final int cedula;
    private final Direccion direccion;
    private final String correo;
    private final int telefono;
    
    public Pasajero(String nombre, int cedula, Direccion direccion, String correo, int telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public int getTelefono() {
        return telefono;
    }
    
}
