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
    private final Date fechaEmision;
    private final Date fechaExpiracion;

    public int getNumero() {
        return numero;
    }

    public int getTipo() {
        return tipo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public Licencia(int numero, int tipo, Date fechaEmision, Date fechaExpiracion) {
        this.numero = numero;
        this.tipo = tipo;
        this.fechaEmision = fechaEmision;
        this.fechaExpiracion = fechaExpiracion;
    }

}
