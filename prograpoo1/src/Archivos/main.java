/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class main {

    public static void main(String[] args) throws ParseException {
        Date fecha = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         String fechaComoCadena = sdf.format(new Date());
        
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("20/03/1999");  
       
        
       
    }
}