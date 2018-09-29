/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author curso
 */
public class Empresa {
    private String razonSocial;
    private int numCedulaJuridica;
    private int telefono;
    private Direccion direccion;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getNumCedulaJuridica() {
        return numCedulaJuridica;
    }

    public void setNumCedulaJuridica(int numCedulaJuridica) {
        this.numCedulaJuridica = numCedulaJuridica;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Empresa(String razonSocial, int numCedulaJuridica, int telefono, Direccion direccion) {
        this.razonSocial = razonSocial;
        this.numCedulaJuridica = numCedulaJuridica;
        this.telefono = telefono;
        this.direccion = direccion;
    }

}
