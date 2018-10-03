/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;

/**
 *
 * @author Javith
 */
public class AdministradorArchivos {

    private final File dirVehiculos = new File("BaseDatos//Vehiculos//");
    private final File dirPasajeros = new File("BaseDatos//Pasajeros//");
    private final File dirChoferes = new File("BaseDatos//Choferes//");
    private final File dirLicencias = new File("BaseDatos//Licencias//");
    private final File dirDirecciones = new File("BaseDatos//Direcciones//");
    private final File dirMantenimientos = new File("BaseDatos//Mantenimientos//");
    private final File dirEmpresas = new File("BaseDatos//Empresas//");
    String[] ficherosVehiculos = dirVehiculos.list();
    String[] ficherosPasajeros = dirPasajeros.list();
    String[] ficherosChoferes = dirChoferes.list();
    String[] ficherosLicencias = dirLicencias.list();
    String[] ficherosDirecciones = dirDirecciones.list();
    String[] ficherosMantenimientos = dirMantenimientos.list();
    String[] ficherosEmpresas = dirEmpresas.list();
    
    public AdministradorArchivos(){
    }
    public String[] getFicherosVehiculos() {
        return ficherosVehiculos;
    }

    public String[] getFicherosPasajeros() {
        return ficherosPasajeros;
    }

    public String[] getFicherosChoferes() {
        return ficherosChoferes;
    }

    public String[] getFicherosLicencias() {
        return ficherosLicencias;
    }

    public String[] getFicherosDirecciones() {
        return ficherosDirecciones;
    }

    public String[] getFicherosMantenimientos() {
        return ficherosMantenimientos;
    }

    public String[] getFicherosEmpresas() {
        return ficherosEmpresas;
    }
    
    
}