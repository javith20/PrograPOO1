/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prograpoo1;

import java.awt.Choice;
import java.util.ArrayList;
/**
 *
 * @author Javith
 */
public class UnidadTrasportes {
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Chofer> listaChoferes;
    private final int usuario;

    public UnidadTrasportes(int usuario) {
        this.usuario = usuario;
        listaVehiculos = new ArrayList<>();
        listaChoferes = new ArrayList<>();
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
    public void AgregarVehiculo(Vehiculo vehiculo){
        this.listaVehiculos.add(vehiculo);
    }
    public void AgregarChofer(Chofer chofer){
        this.listaVehiculos.add(chofer);
    }
    
}
