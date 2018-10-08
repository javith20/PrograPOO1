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
import Roles.Usuario;
import com.sun.xml.internal.ws.api.pipe.Fiber;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

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
    private final File dirRoles = new File("BaseDatos//Roles//");

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
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public AdministradorArchivos() {
        lectorXML = new LectorXML();
        cargarLicencias();
        cargarChoferes();
        cargarDirecciones();
        cargarVehiculos();
        cargarPasajeros();
        cargarViajes();
        cargarUsuarios();
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
            nuevo = new Pasajero(aux.get(0), Integer.parseInt(aux.get(1)), filtradoDireciones(aux.get(1)), aux.get(2), Integer.parseInt(aux.get(3)));
            aux.clear();
            pasajeros.add(nuevo);
        }
    }

    private void cargarDirecciones() {
        ArrayList<String> aux;
        for (int indice = 0; dirDirecciones.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirDirecciones.getAbsolutePath() + "\\" + dirDirecciones.list()[indice], "Direccion");
            Direccion nuevo;
            nuevo = new Direccion(aux.get(0), aux.get(1), aux.get(2), aux.get(3), aux.get(4));
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
            ArrayList<Licencia> auxLicencias = new ArrayList<>();

            String[] lista = aux.get(2).split(";");

            for (int i = 0; lista.length - 1 >= i; i++) {
                auxLicencias.add(filtradoLicencias(lista[i]));
            }
            Chofer nuevo;
            nuevo = new Chofer(Integer.parseInt(aux.get(1)), aux.get(0), auxLicencias, aux.get(3), Integer.parseInt(aux.get(4)));
            aux.clear();
            choferes.add(nuevo);
        }

    }

    private void cargarViajes() {
        ArrayList<String> aux;

        for (int indice = 0; dirViajes.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirViajes.getAbsolutePath() + "\\" + dirViajes.list()[indice], "Viaje");
            String[] listaStringPasajeros = aux.get(1).split(";");
            ArrayList<Pasajero> pasajerosViaje = new ArrayList<>();
            for (int i = 0; listaStringPasajeros.length - 1 >= i; i++) {

                if (!(filtradoPasajero(1, listaStringPasajeros[i]).isEmpty())) {
                    pasajerosViaje.add(filtradoPasajero(1, listaStringPasajeros[i]).get(0));

                }

            }

            Date solicituDate = new Date();
            Date inicioDate = new Date();
            Date finDate = new Date();
            Vehiculo auxvehiculo = new Vehiculo();
            Chofer auxChofer = new Chofer();
            try {
                solicituDate = new SimpleDateFormat("dd/MM/yyyy").parse(aux.get(2));
                inicioDate = new SimpleDateFormat("dd/MM/yyyy").parse(aux.get(3));
                finDate = new SimpleDateFormat("dd/MM/yyyy").parse(aux.get(4));
                if (!"En Confeccion".equals(aux.get(7)) && !"Cancelado".equals(aux.get(7))) {
                    auxvehiculo = filtradoVehiculos(0, aux.get(5)).get(0);
                    auxChofer = filtradoChoferes(aux.get(6));
                }

            } catch (ParseException e) {
            }
            Viaje nuevo = new Viaje(aux.get(0), pasajerosViaje, solicituDate, inicioDate, finDate, auxvehiculo, auxChofer, aux.get(7), aux.get(8));
            aux.clear();

            viajes.add(nuevo);
        }

    }

    private void cargarUsuarios() {
        ArrayList<String> aux;
        for (int indice = 0; dirRoles.list().length > indice; indice++) {
            aux = lectorXML.getListaElementos(dirRoles.getAbsolutePath() + "\\" + dirRoles.list()[indice], "Usuario");
            ArrayList<Viaje> auxViajes = new ArrayList<>();
            
                String[] lista = aux.get(4).split(";");
               
                for (int i = 0; lista.length - 1 >= i; i++) {
                    if(!filtradoViajes(0, lista[i]).isEmpty()){
                    auxViajes.add(filtradoViajes(0, lista[i]).get(0));
                }
            }
            Usuario nuevo;
            nuevo = new Usuario(aux.get(0), aux.get(1), aux.get(2), aux.get(3));
            aux.clear();
            usuarios.add(nuevo);
        }
    }

    public Usuario filtradoUsuario(String Busqueda) {
        Usuario auxDireccion = new Usuario();
        for (int i = 0; usuarios.size() > i; i++) {
            if (0 == usuarios.get(i).getCorreo().compareTo(Busqueda)) {
                auxDireccion = usuarios.get(i);
            }
        }
        return auxDireccion;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public Direccion filtradoDireciones(String Busqueda) {
        Direccion auxDireccion = new Direccion();
        for (int i = 0; Direcciones.size() > i; i++) {
            if (0 == Direcciones.get(i).getID().compareTo(Busqueda)) {
                auxDireccion = Direcciones.get(i);
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

    public Licencia filtradoLicencias(String Busqueda) {
        Licencia auxLicencias = new Licencia();
        for (int i = 0; Licencias.size() > i; i++) {
            if (0 == String.valueOf(Licencias.get(i).getNumero()).compareTo(Busqueda)) {
                auxLicencias = (Licencias.get(i));
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
                    if (0 == pasajeros.get(i).getCorreo().compareTo(Busqueda)) {
                        auxPasajero.add(pasajeros.get(i));
                    }
                    break;
                }
                case 3: {
                    if (0 == String.valueOf(pasajeros.get(i).getTelefono()).compareTo(Busqueda)) {
                        auxPasajero.add(pasajeros.get(i));
                    }
                    break;
                }
            }

        }
        return auxPasajero;
    }

    public Chofer filtradoChoferes(String Busqueda) {
        Chofer auxChofer = new Chofer();
        for (int i = 0; choferes.size() > i; i++) {
            if (0 == Direcciones.get(i).getID().compareTo(Busqueda)) {
                auxChofer = (choferes.get(i));
            }

        }
        return auxChofer;
    }

    public ArrayList<Viaje> filtradoViajes(int Criterio, String Busqueda) {
        ArrayList<Viaje> auxViajes = new ArrayList<>();
        for (int i = 0; viajes.size() > i; i++) {
            switch (Criterio) {
                case 0: {
                    if (viajes.get(i).getID().equals(Busqueda)) {
                        auxViajes.add(viajes.get(i));
                    }
                    break;
                }
                case 1: {
                    ArrayList<Pasajero> auxpasajeros = new ArrayList<>();
                    for (int indice = 0; viajes.get(i).getListaPasajeros().size() > i; i++) {
                        if (String.valueOf(viajes.get(i).getListaPasajeros().get(i).getCedula()).equals(Busqueda)) {
                            auxpasajeros.add(viajes.get(i).getListaPasajeros().get(indice));
                        }
                    }
                    if (!auxpasajeros.isEmpty()) {
                        auxViajes.add(viajes.get(i));
                    }
                    break;
                }
                case 2: {
                    try {
                        Date fechabuscada = new SimpleDateFormat("dd/MM/yyyy").parse(Busqueda);
                        if ((viajes.get(i).getSolicitud().equals(fechabuscada))) {
                            auxViajes.add(viajes.get(i));
                        }
                        break;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error de Formato de la fecha");
                    }
                }
                case 3: {
                    try {
                        Date fechabuscada = new SimpleDateFormat("dd/MM/yyyy").parse(Busqueda);
                        if (viajes.get(i).getInicioDate().equals(fechabuscada)) {
                            auxViajes.add(viajes.get(i));
                        }
                        break;
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Error de Formato de la fecha");
                    }
                }
                case 4: {
                    try {
                        Date fechabuscada = new SimpleDateFormat("dd/MM/yyyy").parse(Busqueda);
                        if ((viajes.get(i).getFinDate()).equals(fechabuscada)) {
                            auxViajes.add(viajes.get(i));
                        }
                        break;
                    } catch (ParseException e) {
                        JOptionPane.showMessageDialog(null, "Error de Formato de la fecha");
                    }
                }
                case 5: {
                    if (String.valueOf(viajes.get(i).getChofer().getCedula()).equals(Busqueda)) {
                        auxViajes.add(viajes.get(i));
                    }
                    break;
                }
                case 6: {
                    if (String.valueOf(viajes.get(i).getVehiculo().getPlaca()).equalsIgnoreCase(Busqueda)) {
                        auxViajes.add(viajes.get(i));
                    }
                    break;
                }
                case 7: {
                    if (0 == viajes.get(i).getEstado().compareTo(Busqueda)) {
                        auxViajes.add(viajes.get(i));
                    }
                    break;
                }

            }

        }
        return auxViajes;
    }

    public ArrayList<Direccion> getDirecciones() {
        return Direcciones;
    }

    public ArrayList<Licencia> getLicencias() {
        return Licencias;
    }

    public ArrayList<Chofer> getChoferes() {
        return choferes;
    }

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public ArrayList<Mantenimiento> getMantenimientos() {
        return mantenimientos;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public ArrayList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

}
