package dao.transferobjects;
import carlos.utils.Validator;

/**
 * Clase Contacto. Clase Transfer Object que se utiliza para guardar los datos de un contacto en la agenda
 * @author: Carlos Rodriguez Lopez
 * @since: 2014
*/

public class Contacto {

    private String direccion;
    private String nombre;
    private String provincia;
    private String telefono;
    private int codigoPostal;

    public void setCodigoPostal(int codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTelefono() {
        return telefono;
    }

    public Contacto() {

    }

   

}
