/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.File;
import java.util.ArrayList;
import prograpoo1.*;

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
    private LectorXML lectorXML;
    
    public AdministradorArchivos(){
        lectorXML =new LectorXML();
    }
    public ArrayList<Vehiculo> getFicherosVehiculos() {
        ArrayList<Vehiculo> lista = new ArrayList<>();
         ArrayList<String> aux;
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
             aux = lectorXML.getListaElementos(dirVehiculos.getAbsolutePath()+"\\"+dirVehiculos.list()[indice], "Vehiculo");
            Vehiculo nuevo;
            nuevo = new Vehiculo(aux.get(0),aux.get(1), aux.get(2), Integer.parseInt(aux.get(3)), Integer.parseInt(aux.get(4)), Double.parseDouble(aux.get(5)), aux.get(6), aux.get(7), Integer.parseInt(aux.get(8)));
            aux.clear();
            lista.add(nuevo);
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