/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import LogicaNegocios.Chofer;
import LogicaNegocios.Vehiculo;
import LogicaNegocios.Direccion;
import LogicaNegocios.Empresa;
import LogicaNegocios.Licencia;
import LogicaNegocios.Mantenimiento;
import LogicaNegocios.Pasajero;
import LogicaNegocios.Viaje;
import java.io.File;
import java.text.SimpleDateFormat;
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
    private final File dirViajes = new File("BaseDatos//Viajes//");
    
    private LectorXML lectorXML;
    private SimpleDateFormat formatoString = new SimpleDateFormat("dd/MM/yyyy");
    
    private ArrayList<Vehiculo> vehiculos = new ArrayList<>();
    private ArrayList<Pasajero> pasajeros = new ArrayList<>();
    private ArrayList<Direccion> Direcciones = new ArrayList<>();
    private ArrayList<Licencia> Licencias = new ArrayList<>();
    private ArrayList<Chofer> choferes = new ArrayList<>();
    private ArrayList<Empresa> empresas = new ArrayList<>();
    private ArrayList<Mantenimiento> mantenimientos = new ArrayList<Mantenimiento>();
    private ArrayList<Viaje> viajes = new ArrayList<>();
    
    public AdministradorArchivos() {
        lectorXML = new LectorXML();
        cargarDirecciones();
        cargarVehiculos();
        cargarPasajeros();
    }

    private void cargarVehiculos() {
        ArrayList<String> aux;
        for (int indice = 0; dirVehiculos.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirVehiculos.getAbsolutePath() + "\\" + dirVehiculos.list()[indice], "Vehiculo");
            Vehiculo nuevo;
            nuevo = new Vehiculo(aux.get(0), aux.get(1), aux.get(2), Integer.parseInt(aux.get(3)), Integer.parseInt(aux.get(4)), Double.parseDouble(aux.get(5)), aux.get(6), aux.get(7), aux.get(8));
            aux.clear();
            vehiculos.add(nuevo);
        }
    }

    private void cargarPasajeros() {
        ArrayList<String> aux;
        for (int indice = 0; dirPasajeros.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirPasajeros.getAbsolutePath() + "\\" + dirPasajeros.list()[indice], "Pasajero");
            Pasajero nuevo;
            nuevo = new Pasajero(aux.get(0), Integer.parseInt(aux.get(1)), aux.get(2), aux.get(3), Integer.parseInt(aux.get(4)));
            aux.clear();
            pasajeros.add(nuevo);
        }
    }
    
    private void cargarDirecciones() {
        ArrayList<String> aux;
        for (int indice = 0; dirDirecciones.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirDirecciones.getAbsolutePath() + "\\" + dirDirecciones.list()[indice], "Direccion");
            Direccion nuevo;
            System.out.print(aux);
            nuevo = new Direccion(aux.get(0), aux.get(1), aux.get(2), aux.get(3));
            aux.clear();
            Direcciones.add(nuevo);
        }
    }

    private void cargarLicencias() {
        ArrayList<String> aux;
        for (int indice = 0; dirLicencias.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirLicencias.getAbsolutePath() + "\\" + dirLicencias.list()[indice], "Licencia");
            Licencia nuevo;
            nuevo = new Licencia(Integer.parseInt(aux.get(0)), Integer.parseInt(aux.get(1)), aux.get(2), aux.get(3));
            aux.clear();
            Licencias.add(nuevo);
        }
    }

    private void cargarChoferes() {
        ArrayList<String> aux;
        for (int indice = 0; dirChoferes.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirChoferes.getAbsolutePath() + "\\" + dirChoferes.list()[indice], "Chofer");
            Chofer nuevo;
            nuevo = new Chofer(Integer.parseInt(aux.get(0)),aux.get(1),filtradoLicencias(aux.get(2)),aux.get(3),Integer.parseInt(aux.get(4)));
            aux.clear();
            choferes.add(nuevo);
        }

    }
    
    private void cargarViajes() {
        ArrayList<String> aux;
        for (int indice = 0; dirViajes.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirViajes.getAbsolutePath() + "\\" + dirViajes.list()[indice], "Chofer");
            
            
            Viaje nuevo;
            
            nuevo = new Viaje(aux.get(0),aux.get());
            aux.clear();
            viajes.add(nuevo);
        }

    }
 
    public ArrayList<Direccion> filtradoDireciones(int Criterio, String Busqueda) {
        ArrayList<Direccion> auxDireccion = new ArrayList<>();
        for (int i = 0; Direcciones.size() > i; i++) {
            switch (Criterio) {
                case 0: {
                    if (0 == Direcciones.get(i).getID().compareTo(Busqueda)) {
                        auxDireccion.add(Direcciones.get(i));
                    }
                    break;
                }
                case 1: {
                    if (0 == Direcciones.get(i).getProvincia().compareTo(Busqueda)) {
                        auxDireccion.add(Direcciones.get(i));
                    }
                    break;
                }
                case 2: {
                    if (0 == Direcciones.get(i).getCanton().compareTo(Busqueda)) {
                        auxDireccion.add(Direcciones.get(i));
                    }
                    break;
                }
                case 3: {
                    if (0 == Direcciones.get(i).getDistrito().compareTo(Busqueda)) {
                        auxDireccion.add(Direcciones.get(i));
                    }
                    break;
                }
                case 4: {
                    if (0 == Direcciones.get(i).getSegnas().compareTo(Busqueda)) {
                        auxDireccion.add(Direcciones.get(i));
                    }
                    break;
                }
            }

        }
        return auxDireccion;
    }

    public ArrayList<Vehiculo> filtradoVehiculos(int Criterio, String Busqueda) {
        ArrayList<Vehiculo> auxVehiculos = new ArrayList<>();
        for (int i = 0; vehiculos.size() > i; i++) {
            switch (Criterio) {
                case 0: {
                    if (0 == vehiculos.get(i).getPlaca().compareTo(Busqueda)) {
                        auxVehiculos.add(vehiculos.get(i));
                    }
                    break;
                }
                case 1: {
                    if (0 == vehiculos.get(i).getColor().compareTo(Busqueda)) {
                        auxVehiculos.add(vehiculos.get(i));
                    }
                    break;
                }
                case 2: {
                    if (0 == vehiculos.get(i).getMarca().compareTo(Busqueda)) {
                        auxVehiculos.add(vehiculos.get(i));
                    }
                    break;
                }
                case 3: {
                    if (0 == String.valueOf(vehiculos.get(i).getCapacidad()).compareTo(Busqueda)) {
                        auxVehiculos.add(vehiculos.get(i));
                    }
                    break;
                }
                case 4: {
                    if (0 == vehiculos.get(i).getVin().compareTo(Busqueda)) {
                        auxVehiculos.add(vehiculos.get(i));
                    }
                    break;
                }
                case 5: {
                    if (0 == vehiculos.get(i).getSede().compareTo(Busqueda)) {
                        auxVehiculos.add(vehiculos.get(i));
                    }
                    break;
                }
                case 6: {
                    if (0 == String.valueOf(vehiculos.get(i).getEstado()).compareTo(Busqueda)) {
                        auxVehiculos.add(vehiculos.get(i));
                    }
                    break;
                }
            }

        }
        return auxVehiculos;
    }

    public ArrayList<Licencia> filtradoLicencias(String Busqueda) {
        ArrayList<Licencia> auxLicencias = new ArrayList<>();
        for (int i = 0; Licencias.size() > i; i++) {
            if (0 == Direcciones.get(i).getID().compareTo(Busqueda)) {
                auxLicencias.add(Licencias.get(i));
            }

        }
        return auxLicencias;
    }
    
    public ArrayList<Pasajero> filtradoPasajero(int Criterio, String Busqueda) {
        ArrayList<Pasajero> auxPasajero = new ArrayList<>();
        for (int i = 0; pasajeros.size() > i; i++) {
            switch (Criterio) {
                case 0: {
                    if (0 == pasajeros.get(i).getNombre().compareTo(Busqueda)) {
                        auxPasajero.add(pasajeros.get(i));
                    }
                    break;
                }
                case 1: {
                    if (0 == String.valueOf(pasajeros.get(i).getCedula()).compareTo(Busqueda)) {
                        auxPasajero.add(pasajeros.get(i));
                    }
                    break;
                }
                case 2: {
                    if (0 == pasajeros.get(i).getDireccion().compareTo(Busqueda)) {
                        auxPasajero.add(pasajeros.get(i));
                    }
                    break;
                }
                case 3: {
                    if (0 == pasajeros.get(i).getCorreo().compareTo(Busqueda)) {
                        auxPasajero.add(pasajeros.get(i));
                    }
                    break;
                }
                case 4: {
                    if (0 == String.valueOf(pasajeros.get(i).getTelefono()).compareTo(Busqueda)) {
                        auxPasajero.add(pasajeros.get(i));
                    }
                    break;
                }
            }

        }
        return auxPasajero;
    }


    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public ArrayList<String> getFicherosLicencias() {
        ArrayList<String> lista = new ArrayList<>();
        for (int indice = 0; dirVehiculos.list().length > indice; indice++) {
            lista.add("BaseDatos//Vehiculos//" + dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosDirecciones() {
        ArrayList<String> lista = new ArrayList<>();
        for (int indice = 0; dirVehiculos.list().length > indice; indice++) {
            lista.add("BaseDatos//Vehiculos//" + dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosMantenimientos() {
        ArrayList<String> lista = new ArrayList<>();
        for (int indice = 0; dirVehiculos.list().length > indice; indice++) {
            lista.add("BaseDatos//Vehiculos//" + dirVehiculos.list()[1]);
        }
        return lista;
    }

    public ArrayList<String> getFicherosEmpresas() {
        ArrayList<String> lista = new ArrayList<>();
        for (int indice = 0; dirVehiculos.list().length > indice; indice++) {
            lista.add("BaseDatos//Vehiculos//" + dirVehiculos.list()[1]);
        }
        return lista;
    }

}
