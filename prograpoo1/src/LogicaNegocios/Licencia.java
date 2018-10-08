/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocios;

import java.util.Date;

/**
 *
 * @author Javith
 */
public class Licencia {
   

    
    private final int numero;
    private final int tipo;
    private final String fechaEmision;
    private final String fechaExpiracion;

    public Licencia() {
        this.numero = 0;
        this.tipo = 0;
        this.fechaEmision = "Error";
        this.fechaExpiracion = "Error";
    }
    
    
    public int getNumero() {
        return numero;
    }

    public int getTipo() {
        return tipo;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public String getFechaExpiracion() {
        return fechaExpiracion;
    }

    public Licencia(int numero, int tipo, String fechaEmision, String fechaExpiracion) {
        this.numero = numero;
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.fechaExpiracion = fechaExpiracion;
    }

}
