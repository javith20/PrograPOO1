/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Roles;

import LogicaNegocios.Viaje;
import java.util.ArrayList;

/**
 *
 * @author Javith
 */
public class Usuario {
    private final String nombre;
    private final String correo;
    private final String tipo;
    private final String contrasena;
    private ArrayList<Viaje> listaSolicitudes;

    public Usuario(String nombre, String correo, String tipo,String contra, ArrayList<Viaje> lista) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
        this.contrasena = contra;
        this.listaSolicitudes = lista;
    }
    
    
    public Usuario(String nombre, String correo, String tipo,String contra) {
        this.nombre = nombre;
        this.correo = correo;
        this.tipo = tipo;
        this.contrasena = contra;
        this.listaSolicitudes =new ArrayList<>();
    }
    public Usuario() {
        this.nombre = "NULL";
        this.correo = "NULL";
        this.tipo = "NULL";
        this.contrasena = "NULL";
        this.listaSolicitudes =new ArrayList<>();
    }

    public ArrayList<Viaje> getListaSolicitudes() {
        return listaSolicitudes;
    }
    
    public void EnlistarViaje(Viaje viaje) {
         listaSolicitudes.add(viaje);
    }
    
    public String getContrasena() {
        return contrasena;
    }
    
    public String getNombre() {
        return nombre;
    }


    public String getCorreo() {
        return correo;
    }


    public String getTipo() {
        return tipo;
    }

    
}
