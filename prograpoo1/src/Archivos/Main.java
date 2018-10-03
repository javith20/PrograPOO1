/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import org.xml.sax.SAXException;
import prograpoo1.Direccion;
import prograpoo1.Licencia;
import prograpoo1.Pasajero;
import prograpoo1.Vehiculo;
import prograpoo1.Empresa;
import sun.awt.EmbeddedFrame;

/**
 *
 * @author Javith
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SAXException {
        Direccion a = new Direccion("San Jose", "Turru", "San Luis", "sas");
        Empresa n = new Empresa("1212", 12321, 8754, a);
        
        LectorXML x = new LectorXML("BaseDatos//Vehiculos//Vehiculo_1121.xml","Vehiculo");
        
         System.err.printf(x.getListaElementos().get(1));
        //x.CargarXML("BaseDatos\\Empresas\\Empresa_12321.xml");
        //System.out.println(x.getLista().get(0));  
///System.out.println((x.getTitulo()))
        
    }
    
}
