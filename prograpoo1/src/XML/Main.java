/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XML;

import prograpoo1.Direccion;
import prograpoo1.Licencia;
import prograpoo1.Pasajero;
import prograpoo1.Vehiculo;

/**
 *
 * @author Javith
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Direccion d = new Direccion("San Jose", "Turrubares", "San Luis", "gsad");
       GestorXML x =new  GestorXML(d);
       System.out.println(x.getTitulo());
       x.guardaConFormato();
    }
    
}
