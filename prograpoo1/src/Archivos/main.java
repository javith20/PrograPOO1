/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Conexiones.Correo;
import Roles.InicioSecion;
import Roles.Usuario;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.mail.MessagingException;

public class main {
    
    public static AdministradorArchivos admin = new AdministradorArchivos();
    public static Usuario usuario = new Usuario();
    
    public static void Actualizar(){
     admin = new AdministradorArchivos();
    }
    
    
    public static void main(String[] args) throws MessagingException {
        java.awt.EventQueue.invokeLater(() -> {
            new InicioSecion().setVisible(true);
        });
        
    }
}
