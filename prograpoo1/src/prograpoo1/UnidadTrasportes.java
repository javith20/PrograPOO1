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
public class UnidadTrasportes {
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Chofer> listaChoferes;
    private int usuario;

    public UnidadTrasportes(ArrayList<Vehiculo> listaVehiculos, ArrayList<Chofer> listaChoferes, int usuario) {
        this.listaVehiculos = listaVehiculos;
        this.listaChoferes = listaChoferes;
        this.usuario = usuario;
    }
    
    
    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public ArrayList<Chofer> getListaChoferes() {
        return listaChoferes;
    }

    public int getUsuario() {
        return usuario;
    }
    
}
