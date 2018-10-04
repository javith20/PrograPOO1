/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.util.ArrayList;

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
   
    
    public AdministradorArchivos(){
    }
    public ArrayList<String> getFicherosVehiculos() {
        ArrayList<String> lista = new ArrayList<>();
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            lista.add(dirVehiculos.getAbsolutePath()+"\\"+dirVehiculos.list()[indice]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosPasajeros() {
         ArrayList<String> lista = new ArrayList<>();
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            lista.add("BaseDatos//Vehiculos//"+dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosChoferes() {
       ArrayList<String> lista = new ArrayList<>();
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            lista.add("BaseDatos//Vehiculos//"+dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosLicencias() {
        ArrayList<String> lista = new ArrayList<>();
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            lista.add("BaseDatos//Vehiculos//"+dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosDirecciones() {
       ArrayList<String> lista = new ArrayList<>();
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            lista.add("BaseDatos//Vehiculos//"+dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosMantenimientos() {
        ArrayList<String> lista = new ArrayList<>();
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            lista.add("BaseDatos//Vehiculos//"+dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosEmpresas() {
        ArrayList<String> lista = new ArrayList<>();
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            lista.add("BaseDatos//Vehiculos//"+dirVehiculos.list()[1]);
        }
        return lista;
    }
    
    
}