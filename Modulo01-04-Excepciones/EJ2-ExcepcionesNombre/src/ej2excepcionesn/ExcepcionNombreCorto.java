package ej2excepcionesn;

public class ExcepcionNombreCorto extends Exception {
    public ExcepcionNombreCorto(){
        super("Nombre demasiado corto");
    }
}
