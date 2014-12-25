package ej3;

public class Aeropuerto {
    private String nombre;
    private String ubicacion;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }
    public String toString(){
        String aeropuertoFormato="\t Nombre: "+this.nombre+"\n\t Ubicación: "+this.ubicacion;
        return aeropuertoFormato;
    }
    public Aeropuerto(){
        
    }
    public Aeropuerto(String nombre,String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }
    
}
