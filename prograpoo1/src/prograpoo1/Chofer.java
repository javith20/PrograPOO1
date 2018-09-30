
import java.util.ArrayList;
import prograpoo1.Licencia;

public class Chofer{
  private int cedula;
  private String nombre;
  private ArrayList<Licencia> listaLicencias;
  private String correo;
  private int telefono;

    public Chofer(int cedula, String nombre, ArrayList<Licencia> listaLicencias, String correo, int telefono) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.listaLicencias = listaLicencias;
        this.correo = correo;
        this.telefono = telefono;
    }

    
    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Licencia> getListaLicencias() {
        return listaLicencias;
    }

    public void setListaLicencias(ArrayList<Licencia> listaLicencias) {
        this.listaLicencias = listaLicencias;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
  
  

}
