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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AdministradorArchivos a =new AdministradorArchivos();
        LectorXML al =new LectorXML(a.getFicherosVehiculos().get(0),"Vehiculo");
        System.out.println(al.getListaElementos());
    }
    
}
