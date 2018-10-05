/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import LogicaNegocios.Vehiculo;
import LogicaNegocios.Direccion;
import LogicaNegocios.Pasajero;
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
    private LectorXML lectorXML;
    
    private  ArrayList<Vehiculo> vehiculos = new ArrayList<>(); 
    private  ArrayList<Pasajero> pasajeros = new ArrayList<>(); 
    private  ArrayList<Direccion> Direcciones = new ArrayList<>(); 
    
    public AdministradorArchivos(){
        lectorXML =new LectorXML();
        cargarDirecciones();
        cargarVehiculos();
        cargarPasajeros();
    }
    
    private void cargarVehiculos(){
         ArrayList<String> aux;
        for(int indice=0;dirVehiculos.list().length>indice;indice++){
            aux = lectorXML.getListaElementos(dirVehiculos.getAbsolutePath()+"\\"+dirVehiculos.list()[indice], "Vehiculo");
            Vehiculo nuevo;
            nuevo = new Vehiculo(aux.get(0),aux.get(1), aux.get(2), Integer.parseInt(aux.get(3)), Integer.parseInt(aux.get(4)), Double.parseDouble(aux.get(5)), aux.get(6), aux.get(7), aux.get(8));
            aux.clear();
            vehiculos.add(nuevo);
        }
    }
    
    private void cargarPasajeros(){
         ArrayList<String> aux;
        for(int indice=0;dirPasajeros.list().length>indice;indice++){
            aux = lectorXML.getListaElementos(dirPasajeros.getAbsolutePath()+"\\"+dirPasajeros.list()[indice], "Pasajero");
            Pasajero nuevo;
            nuevo = new Pasajero(aux.get(0),Integer.parseInt(aux.get(1)),filtradoDireciones(0,aux.get(2)).get(0),aux.get(3),Integer.parseInt(aux.get(4)));
            aux.clear();
            pasajeros.add(nuevo);
        }
    }
    
    private void cargarDirecciones(){
        ArrayList<String> aux;
        for(int indice=0;dirDirecciones.list().length>indice;indice++){
            aux = lectorXML.getListaElementos(dirDirecciones.getAbsolutePath()+"\\"+dirDirecciones.list()[indice], "Direccion");
            Direccion nuevo;
            System.out.print(aux);
            nuevo = new Direccion(aux.get(0),aux.get(1),aux.get(2),aux.get(3));
            aux.clear();
            Direcciones.add(nuevo);
        }
    }
    
    public ArrayList<Direccion> filtradoDireciones(int Criterio,String Busqueda){
       ArrayList<Direccion> auxDireccion = new ArrayList<>();
        for( int i=0 ; Direcciones.size()>i ; i++ ){
            switch (Criterio){
                case 0: {
                    if(0==Direcciones.get(i).getID().compareTo(Busqueda))
                        auxDireccion.add(Direcciones.get(i));
                    break;   
                }
                case 1: {
                    if(0==Direcciones.get(i).getProvincia().compareTo(Busqueda))
                        auxDireccion.add(Direcciones.get(i));
                    break;   
                }
                case 2: {
                    if(0==Direcciones.get(i).getCanton().compareTo(Busqueda))
                        auxDireccion.add(Direcciones.get(i));
                    break;   
                }
                case 3: {
                    if(0==Direcciones.get(i).getDistrito().compareTo(Busqueda))
                        auxDireccion.add(Direcciones.get(i));
                    break;   
                }
                case 4: {
                    if(0==Direcciones.get(i).getSegnas().compareTo(Busqueda))
                        auxDireccion.add(Direcciones.get(i));
                    break;   
                }
            }
            
        }
        return auxDireccion;
    }
    
     public ArrayList<Vehiculo> filtradoVehiculos(int Criterio,String Busqueda){
       ArrayList<Vehiculo> auxVehiculos = new ArrayList<>();
        for( int i=0 ; vehiculos.size()>i ; i++ ){
            switch (Criterio){
                case 0: {
                    if(0==vehiculos.get(i).getPlaca().compareTo(Busqueda))
                        auxVehiculos.add(vehiculos.get(i));
                    break;   
                }
                case 1: {
                    if(0==vehiculos.get(i).getColor().compareTo(Busqueda))
                        auxVehiculos.add(vehiculos.get(i));
                    break;   
                }
                case 2: {
                    if(0==vehiculos.get(i).getMarca().compareTo(Busqueda))
                        auxVehiculos.add(vehiculos.get(i));
                    break;   
                }
                case 3: {
                    if(0==String.valueOf(vehiculos.get(i).getCapacidad()).compareTo(Busqueda))
                        auxVehiculos.add(vehiculos.get(i));
                    break;   
                }
                case 4: {
                    if(0==vehiculos.get(i).getVin().compareTo(Busqueda))
                        auxVehiculos.add(vehiculos.get(i));
                    break;   
                }
                case 5: {
                    if(0==vehiculos.get(i).getSede().compareTo(Busqueda))
                        auxVehiculos.add(vehiculos.get(i));
                    break;   
                }
                case 6: {
                    if(0==String.valueOf(vehiculos.get(i).getEstado()).compareTo(Busqueda))
                        auxVehiculos.add(vehiculos.get(i));
                    break;   
                }
            }
            
        }
        return auxVehiculos;
    }
    
    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    
    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
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