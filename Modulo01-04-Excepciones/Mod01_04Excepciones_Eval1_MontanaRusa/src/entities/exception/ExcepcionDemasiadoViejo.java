package entities.exception;
/**
 *
 * @description Exception class for DemasiadoViejo
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class ExcepcionDemasiadoViejo extends Exception {
    public int edad;
    public ExcepcionDemasiadoViejo(int edad) {
        super("Eres demasiado viej@");
        this.edad=edad;
    }
}
