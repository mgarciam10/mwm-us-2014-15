package entities;

import carlos.utils.Validator;

public class Contacto {

    private String direccion;
    private String email;
    private String nombre;
    private String provincia;
    private String telefono;
    private String tipoContacto;

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
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

    public void setTipoContacto(String tipoContacto) {
        this.tipoContacto = tipoContacto;
    }

    public String getTipoContacto() {
        return tipoContacto;
    }

    public Contacto() {

    }

    public boolean equals(Object o) {
        boolean res = false;
        if (this == o) {
            res = true;
        } else if ((o != null) && (getClass() == o.getClass())) {
            Contacto contacto = (Contacto) o;
            if (this.nombre.equals(contacto.getNombre())) {
                res = true;
            }
        }
        return res;
    }

}
