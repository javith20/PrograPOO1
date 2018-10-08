package LogicaNegocios;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author curso
 */
public class Direccion {
    private String ID;
    private String provincia;
    private String canton;
    private String distrito;
    private String segnas;

    public Direccion() {
        this.provincia = "Error";
        this.canton = "Error";
        this.distrito = "Error";
        this.segnas = "Error";
        this.ID ="Error";
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getSegnas() {
        return segnas;
    }

    public void setSegnas(String segnas) {
        this.segnas = segnas;
    }
     public String getID() {
        return ID;
    }

    @Override
    public String toString() {
        return   (provincia+ ", " + canton + ", " + distrito + ", " + segnas );
    }
    
    public Direccion(String iD,String provincia, String canton, String distrito, String segnas) {
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.segnas = segnas;
        this.ID =iD;
        
    }
    
}
