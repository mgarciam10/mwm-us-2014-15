package entities.exception;
/**
 *
 * @description Exception class for DemasiadoJoven
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class ExcepcionDemasiadoJoven extends Exception {
    public int edad;
    public ExcepcionDemasiadoJoven(int edad) {
        super("Eres demasiado joven");
        this.edad=edad;
        
    }
}
