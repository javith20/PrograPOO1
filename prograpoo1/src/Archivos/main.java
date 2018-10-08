/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Roles.InicioSecion;
import Roles.Usuario;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

    public static AdministradorArchivos admin = new AdministradorArchivos();
    public static Usuario usuario = new Usuario();
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new InicioSecion().setVisible(true);
        });
    }
}
